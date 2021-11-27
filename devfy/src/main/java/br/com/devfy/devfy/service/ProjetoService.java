package br.com.devfy.devfy.service;

import br.com.devfy.devfy.entity.Desenvolvedor;
import br.com.devfy.devfy.entity.Empresa;
import br.com.devfy.devfy.entity.Notificacao;
import br.com.devfy.devfy.entity.Projeto;
import br.com.devfy.devfy.helper.EmailService;
import br.com.devfy.devfy.helper.ListaObj;
import br.com.devfy.devfy.helper.SlackService;
import br.com.devfy.devfy.repository.DesenvolvedorRepository;
import br.com.devfy.devfy.repository.EmpresaRepository;
import br.com.devfy.devfy.repository.ProjetoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.com.devfy.devfy.helper.CsvGenerator.gravaArquivoCsv;
import static br.com.devfy.devfy.helper.CsvGenerator.leArquivoCsv;

@Slf4j
@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private DesenvolvedorRepository desenvolvedorRepository;

    @Autowired
    private EmpresaRepository empresaRepository;


    List<Notificacao> notificacoes = Arrays.asList(new EmailService(), new SlackService());

    public ResponseEntity importProj(MultipartFile csv){
        EmpresaService empServ = new EmpresaService();
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String titulo, linguagem, descricao,categoria,publicadoEm;
        Double valor;
        int id, idEmp;
        try {
            entrada = new BufferedReader(new FileReader(String.valueOf(csv.getBytes())));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        try{
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);

                if (tipoRegistro.equals("02")) {
                    id = Integer.valueOf(registro.substring(3,4));
                    titulo = registro.substring(5,34).trim();
                    linguagem = registro.substring(35,54).trim();
                    descricao = registro.substring(55,154).trim();
                    categoria = registro.substring(155,174).trim();
                    valor = Double.valueOf(registro.substring(175,181).replace(',','.'));
                    idEmp = Integer.valueOf(registro.substring(201,202));
                    Projeto p = new Projeto();
                    p.setId(id);
                    p.setTitulo(titulo);
                    p.setLinguagem(linguagem);
                    p.setDescricao(descricao);
                    p.setValor(valor);
                    p.setPublicadoEm(LocalDateTime.now());
                    p.setCategoria(categoria);
                    p.setEmpresa(empServ.getById(idEmp));
                    projetoRepository.save(p);
                }
                else {
                    System.out.println("Tipo de registro inválido!");
                }
                registro = entrada.readLine();

            }
            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
        }
        return ResponseEntity.status(200).build();
    }

    public ResponseEntity getAll() {
        log.info("getAll em ProjetoService");
        List<Projeto> projetos = projetoRepository.findAll();

        if (projetos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(projetos);
    }

    public ResponseEntity update(int id, Projeto projeto) {
        log.info("update em ProjetoService");
        if (projetoRepository.existsById(id)) {
            projeto.setId(id);
            projetoRepository.save(projeto);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity delete(int id) {
        log.info("delete em ProjetoService");
        if (projetoRepository.existsById(id)) {
            projetoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity save(Projeto projeto) {
        log.info("save em ProjetoService");
        projeto.setPublicadoEm(LocalDateTime.now());
        projetoRepository.save(projeto);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity getProjetoByTitulo(String tituloProjeto) {
        log.info("getProjetoByTitulo em ProjetoService");
        Projeto projetoEncontrado = projetoRepository.findProjetoByTituloEquals(tituloProjeto);
        if (projetoEncontrado.equals(null)) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(projetoEncontrado);
    }

    public ResponseEntity gerarRelatorioCsv(int id) {
        log.info("gerarRelatorioCsv em ProjetoService");
        List<Projeto> projects = List.of(projetoRepository.findById(id).get());

        gravaArquivoCsv(projects, "projetos");
        String file = leArquivoCsv("projetos");


        return ResponseEntity
                .status(200)
                .header("content-type", "text/csv")
                .body(file);

    }

    public ResponseEntity associarDev(int devId, int projId) {
        if (projetoRepository.existsById(projId) && desenvolvedorRepository.existsById(devId)) {
            Projeto projeto = projetoRepository.getById(projId);
            Desenvolvedor dev = desenvolvedorRepository.getById(devId);
            projeto.setDesenvolvedor(dev);
            projetoRepository.save(projeto);
            notificacoes.forEach(not -> not.notificarCliente());

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    public ResponseEntity associarEmp(int empId, int projId) {
        if (projetoRepository.existsById(projId) && empresaRepository.existsById(empId)) {
            Projeto projeto = projetoRepository.getById(projId);
            Empresa empresa = empresaRepository.getById(empId);
            projeto.setEmpresa(empresa);
            projetoRepository.save(projeto);
            notificacoes.forEach(not -> not.notificarEmpresa());

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }


    public ResponseEntity getById(int id) {
        if(projetoRepository.existsById(id)){
            return ResponseEntity.status(200).body(projetoRepository.findById(id).get()) ;
        }

        return ResponseEntity.status(404).build();
    }
}
