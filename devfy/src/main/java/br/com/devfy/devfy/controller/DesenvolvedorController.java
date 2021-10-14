package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.helper.ModeloLogin;

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
        List<Desenvolvedor> desenvolvedores =  repository.findAll();
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
        if (repository.existsById(id)) {
            desenvolvedor.setId(id);
            repository.save(desenvolvedor);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(
            @PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
        }

    @PostMapping("/cadastrar")
    public ResponseEntity adicionar(
            @RequestBody Desenvolvedor desenvolvedor
    ) {
        desenvolvedor.logoff();
        repository.save(desenvolvedor);
            return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody ModeloLogin desenvolvedor) {
            Desenvolvedor devEncontrado = repository.findDesenvolvedorByUsuarioEqualsAndSenhaEquals(
                    desenvolvedor.getUsuario(), desenvolvedor.getSenha()
                    );

            if (devEncontrado.equals(null)){
                return ResponseEntity.status(404).build();
            }

        devEncontrado.login();
        repository.save(devEncontrado);
        return ResponseEntity.status(200).body(devEncontrado);
        }


    @PostMapping("/logoff/{id}")
    public ResponseEntity logoff(@PathVariable int id) {
        if (repository.existsById(id)) {
            Desenvolvedor desenvolvedor = repository.getById(id);
            desenvolvedor.logoff();
            repository.save(desenvolvedor);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
