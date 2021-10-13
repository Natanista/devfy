package br.com.devfy.devfy.controller;

import java.util.List;

import br.com.devfy.devfy.model.Desenvolvedor;
import br.com.devfy.devfy.model.Empresa;
import br.com.devfy.devfy.model.Projeto;
import br.com.devfy.devfy.repository.DesenvolvedorRepository;
import br.com.devfy.devfy.repository.EmpresaRepository;
import br.com.devfy.devfy.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devfy/projetos")
public class ProjetoController {


    @Autowired
    private ProjetoRepository repository;

    @Autowired
    private DesenvolvedorRepository devRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public ResponseEntity exibir() {
        List<Projeto> projetos =  repository.findAll();

        if (projetos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(projetos);
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(
            @PathVariable int id,
            @RequestBody Projeto projeto
    ) {
        if (repository.existsById(id)){
        projeto.setId(id);
        repository.save(projeto);
        return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(
            @PathVariable int id) {
        if (repository.existsById(id)){
        repository.deleteById(id);
        return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity adicionar(
            @RequestBody Projeto projeto
    ) {
        repository.save(projeto);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/buscar-titulo-projeto/{tituloProjeto}")
    public ResponseEntity getProjetoByTitulo(@PathVariable String tituloProjeto){
        Projeto projetoEncontrado = repository.findProjetoByTituloEquals(tituloProjeto);
        if(projetoEncontrado.equals(null)){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(projetoEncontrado);
    }

    @PutMapping("/associar-dev/{devId}/{projId}")
    public ResponseEntity associarDev(
            @PathVariable int devId,
            @PathVariable int projId
    ){
        if(repository.existsById(projId) && devRepository.existsById(devId)){
            Projeto projeto = repository.getById(projId);
            Desenvolvedor dev = devRepository.getById(devId);
            projeto.setDesenvolvedor(dev);
            repository.save(projeto);

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();

    }

    @PutMapping("/associar-emp/{empId}/{projId}")
    public ResponseEntity associarEmpresa(
            @PathVariable int empId,
            @PathVariable int projId
    ){
        if(repository.existsById(projId) && empresaRepository.existsById(empId)){
            Projeto projeto = repository.getById(projId);
            Empresa empresa = empresaRepository.getById(empId);
            projeto.setEmpresa(empresa);
            repository.save(projeto);

            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();

    }



}
