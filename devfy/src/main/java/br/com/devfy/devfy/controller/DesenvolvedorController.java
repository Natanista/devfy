package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.model.Desenvolvedor;
import br.com.devfy.devfy.repository.DesenvolvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devfy/desenvolvedores")
public class DesenvolvedorController {


    @Autowired
    private DesenvolvedorRepository repository;

    @GetMapping
    public ResponseEntity exibir() {
        List<Desenvolvedor> desenvolvedores = repository.findAll();
        if (desenvolvedores.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(desenvolvedores);

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(
            @PathVariable int id,
            @RequestBody Desenvolvedor desenvolvedor
    ) {
        desenvolvedor.setId(id);
        repository.save(desenvolvedor);
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
            @RequestBody Desenvolvedor desenvolvedor
    ) {
        repository.save(desenvolvedor);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/login/{id}")
    public ResponseEntity login(@PathVariable int id) {
        Desenvolvedor desenvolvedor = repository.getById(id);
        desenvolvedor.login();
        repository.save(desenvolvedor);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/logoff/{id}")
    public ResponseEntity logoff(@PathVariable int id) {
        Desenvolvedor desenvolvedor = repository.getById(id);
        desenvolvedor.logoff();
        repository.save(desenvolvedor);
        return ResponseEntity.status(200).build();
    }

}
