package br.com.devfy.devfy.controller;

import java.util.List;
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
