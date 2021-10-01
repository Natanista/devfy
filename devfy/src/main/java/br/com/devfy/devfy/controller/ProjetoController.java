package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.helper.ListaObj;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.com.devfy.devfy.model.Projeto;
import br.com.devfy.devfy.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devfy/projetos")
public class ProjetoController {


    @Autowired
    private ProjetoRepository repository;

    @GetMapping
    public ResponseEntity exibir() {
        List<Projeto> projetos = repository.findAll();

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
        projeto.setId(id);
        repository.save(projeto);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(
            @PathVariable int id) {
        repository.deleteById(id);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity adicionar(
            @RequestBody Projeto projeto
    ) {
        repository.save(projeto);
        return ResponseEntity.status(201).build();
    }

}
