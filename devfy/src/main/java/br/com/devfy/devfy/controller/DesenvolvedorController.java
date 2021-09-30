package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.model.Desenvolvedor;
import br.com.devfy.devfy.model.Projeto;
import br.com.devfy.devfy.repository.DesenvolvedorRepository;
import br.com.devfy.devfy.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devfy/desenvolvedores")
public class DesenvolvedorController {


    @Autowired
    private DesenvolvedorRepository repository;

    @GetMapping
    public List<Desenvolvedor> exibir() {
        return repository.findAll();
    }

    @PutMapping("/atualizar/{id}")
    public String atualizar(
            @PathVariable int id,
            @RequestBody Desenvolvedor desenvolvedor
    ) {
        desenvolvedor.setId(id);
        repository.save(desenvolvedor);
        return "Projeto atualizado com sucesso!";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(
            @PathVariable int id) {
        repository.deleteById(id);
        return "Projeto deletado com sucesso!";
    }

    @PostMapping("/cadastrar")
    public String adicionar(
            @RequestBody Desenvolvedor desenvolvedor
    ) {
        repository.save(desenvolvedor);
        return "Projeto adicionado com sucesso!";
    }

    @GetMapping("/login/{id}")
    public String login(@PathVariable int id){
        Desenvolvedor desenvolvedor = repository.getById(id);
        desenvolvedor.login();
        repository.save(desenvolvedor);
        return "Login efetuado com sucesso!";
    }

    @GetMapping("/logoff/{id}")
    public String logoff(@PathVariable int id){
        Desenvolvedor desenvolvedor = repository.getById(id);
        desenvolvedor.logoff();
        repository.save(desenvolvedor);
        return "Logoff efetuado com sucesso!";
    }
    /*
    @PatchMapping("/login/{id}")
    public String login(@PathVariable int id, @RequestBody Boolean autenticado){
        Desenvolvedor desenvolvedor = repository.getById(id);
        desenvolvedor.setAutenticado(true);
        repository.save(desenvolvedor);
        return "Login efetuado com sucesso!";
    }

    @PatchMapping("/login/{id}")
    public String logoff(@PathVariable int id, @RequestBody Boolean autenticado){
        Desenvolvedor desenvolvedor = repository.getById(id);
        desenvolvedor.setAutenticado(autenticado);
        repository.save(desenvolvedor);
        return "";
    }
    */
}
