package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.helper.ListaObj;

import java.util.List;

import br.com.devfy.devfy.model.Projeto;
import br.com.devfy.devfy.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devfy/projetos")
public class ProjetoController {


    @Autowired
    private ProjetoRepository repository;

    @GetMapping
    public List<Projeto> exibir() {
        return repository.findAll();
    }

    @PutMapping("/atualizar/{id}")
    public String atualizar(
            @PathVariable int id,
            @RequestBody Projeto projeto
    ) {
        projeto.setId(id);
        repository.save(projeto);
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
            @RequestBody Projeto projeto
    ) {
        repository.save(projeto);
        return "Projeto adicionado com sucesso!";
    }

}
