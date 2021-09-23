package br.com.bandtec.devfy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/devfy")
public class DevfyController {
    List<Usuario> usuariosCadastrados= new ArrayList<>();
    List<Remuneravel> projetosCadastrados = new ArrayList<>();

    @GetMapping("/cadastrar-desenvolvedor/{nome}/{email}/" +
            "{senha}/{telefone}/{nacionalidade}/{cep}/{competencia}/" +
            "{anosExperiencia}/{cpf}/{linguagem}/{valorHora}")
    public String cadastrarUsuario(@PathVariable String nome,
                                   @PathVariable String email,
                                   @PathVariable String senha,
                                   @PathVariable Long telefone,
                                   @PathVariable String nacionalidade,
                                   @PathVariable Integer cep,
                                   @PathVariable String competencia,
                                   @PathVariable Integer anosEsperiencia,
                                   @PathVariable String cpf,
                                   @PathVariable String linguagem,
                                   @PathVariable Double valorHora){
        Usuario desenvolvedor = new UsuarioDev(nome,
                email,
                senha,
                telefone,
                nacionalidade,
                cep,
                false,
                null,
                competencia,
                anosEsperiencia,
                cpf,
                linguagem,
                valorHora);
        usuariosCadastrados.add(desenvolvedor);
        return String.format("Desenvolvedor %s cadastrado com sucesso.", nome);
    }
    @GetMapping("/cadastrar-empresa/{nome}/{email}/" +
            "{senha}/{telefone}/{nacionalidade}/{cep}/{representante}/" +
            "{telefoneRpresntante}/{cnpj}")
    public String cadastrarUsuario(@PathVariable String nome,
                                   @PathVariable String email,
                                   @PathVariable String senha,
                                   @PathVariable Long telefone,
                                   @PathVariable String nacionalidade,
                                   @PathVariable Integer cep,
                                   @PathVariable String representante,
                                   @PathVariable Long telefoneRepresentante,
                                   @PathVariable Long cnpj){
        Usuario empresa = new UsuarioEmpresa(nome,
                email,
                senha,
                telefone,
                nacionalidade,
                cep,
                false,
                null,
                representante,
                telefoneRepresentante,
                cnpj);
        usuariosCadastrados.add(empresa);
        return String.format("Desencvolvedor %s cadastrado com sucesso.", nome);
    }
    @GetMapping ("/todos-usuarios")
    public List<Usuario> exibirUsuarios(){
        return usuariosCadastrados;
    }

    @GetMapping ("/todas-empresas")
    public  List<Usuario> exibirEmpresas(){
        return usuariosCadastrados.stream().filter(usuario -> usuario instanceof UsuarioEmpresa).collect(Collectors.toList());
    }

    @GetMapping ("/todos-desenvolvedores")
    public  List<Usuario> exibirDesenvolvedores(){
        return usuariosCadastrados.stream().filter(usuario -> usuario instanceof UsuarioDev).collect(Collectors.toList());
    }

    @GetMapping("/login/{email}/{senha}")
    public String login(@PathVariable String email,
                        @PathVariable String senha){
        String resposta = "";
        for (Usuario usuario: usuariosCadastrados){
            if (usuario.autenticar(email,senha)){
                resposta = String.format("Usuário %s logado com sucesso"+ usuario.getNome());
            }
            else {
                resposta = String.format("Usuário %s não encontrado",email);
            }
        }
        return resposta;
    }
    @GetMapping ("/logoff/{email}")
    public String logoff(@PathVariable String email){
        String resposta = "";
        if (usuariosCadastrados.stream().filter(usuario -> usuario.getEmail().equals(email) && usuario.logoff()).count()==1){
            resposta = String.format("Usuário %s foi deslogado com sucesso", email);
        }
        else {
            resposta = String.format("Usuário %s não se encontra logado", email);
        }
        return resposta;
    }

    @GetMapping ("/cadastrar-projeto-fixo/{titulo}" +
            "/{empresa}" +
            "/{linguagem}" +
            "/{descricao}" +
            "/{categoria}" +
            "/{tipoDeProjeto}" +
            "/{valorProjeto}")
    public String cadastrarProjetoFixo(@PathVariable String titulo,
                                       @PathVariable String empresa,
                                       @PathVariable String linguagem,
                                       @PathVariable String descricao,
                                       @PathVariable String categoria,
                                       @PathVariable String tipoDeProjeto,
                                       @PathVariable Double valorProjeto){

        ProjetoFixo projetoFixo = new ProjetoFixo(titulo,
                empresa,
                linguagem,
                descricao,
                categoria,
                tipoDeProjeto,
                LocalDateTime.now(),
                valorProjeto);
        projetosCadastrados.add(projetoFixo);
        return String.format("Projeto %s foi cadastrado com sucesso.", titulo);
    }
    @GetMapping ("/cadastrar-projeto-dinamico/{titulo}" +
            "/{empresa}" +
            "/{linguagem}" +
            "/{descricao}" +
            "/{categoria}" +
            "/{tipoDeProjeto}" +
            "/{valorHora}" +
            "/horasTrabalhadas")
    public String cadastrarProjetoDinamico(@PathVariable String titulo,
                                       @PathVariable String empresa,
                                       @PathVariable String linguagem,
                                       @PathVariable String descricao,
                                       @PathVariable String categoria,
                                       @PathVariable String tipoDeProjeto,
                                       @PathVariable Double valorHora,
                                           @PathVariable Integer horasTrabalhadas){

        ProjetoDinamico projetoDinamico = new ProjetoDinamico(titulo,
                empresa,
                linguagem,
                descricao,
                categoria,
                tipoDeProjeto,
                LocalDateTime.now(),
                valorHora,
                horasTrabalhadas);
        projetosCadastrados.add(projetoDinamico);
        return String.format("Projeto %s foi cadastrado com sucesso.", titulo);


    }
    @GetMapping ("/todos-projetos")
    public List<Remuneravel> exibirProjetos(){
        return projetosCadastrados;
    }
    @GetMapping ("/todos-projetos-fixos")
    public List<Remuneravel> exibirProjetosFixos(){
        return projetosCadastrados.stream().filter(remuneravel -> remuneravel instanceof  ProjetoFixo).collect(Collectors.toList());
    }

    @GetMapping ("/todos-projetos-dinamicos")
    public List<Remuneravel> exibirProjetosDinamicos(){
        return projetosCadastrados.stream().filter(remuneravel -> remuneravel instanceof  ProjetoDinamico).collect(Collectors.toList());
    }

}
