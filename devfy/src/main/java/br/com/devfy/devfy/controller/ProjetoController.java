package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.helper.ListaObj;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.com.devfy.devfy.model.Desenvolvedor;
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
        ListaObj<Projeto> projetos = (ListaObj<Projeto>) repository.findAll();

        if (projetos.getTamanho()==0) {
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

    @GetMapping("/procurar/{nomeProjeto}")
    public ResponseEntity getProjetoByNome(@PathVariable String nomeProjeto){
        List<Projeto> projetos = repository.findAll();
        for (Projeto projeto : projetos){
            if (nomeProjeto.equals(projeto.getTitulo())){
                return ResponseEntity.status(200).body(projeto);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/associarDev/{idDev}/{idProj}")
    public ResponseEntity associarDev(@PathVariable int idDev, @PathVariable int idProj){
            if (repository.existsById(idProj)){
                Projeto projeto = repository.getById(idProj);
                projeto.setFkDev(idDev);
                repository.save(projeto);
                return ResponseEntity.status(200).build();
            }
            return ResponseEntity.status(404).build();
    }


}
