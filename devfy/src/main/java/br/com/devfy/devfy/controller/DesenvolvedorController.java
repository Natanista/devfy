package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.helper.ListaObj;
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
        ListaObj<Desenvolvedor> desenvolvedores = (ListaObj<Desenvolvedor>) repository.findAll();
        if (desenvolvedores.getTamanho()==0) {
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
        repository.save(desenvolvedor);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody Desenvolvedor desenvolvedor) {
        List<Desenvolvedor> desenvolvedores = repository.findAll();
        for (Desenvolvedor desenvolvedor1 : desenvolvedores){
            if (desenvolvedor1.login(desenvolvedor)){
                desenvolvedor1.setIsAutenticado(true);
                repository.save(desenvolvedor1);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/logoff/{id}")
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
