package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.model.Desenvolvedor;
import br.com.devfy.devfy.model.Empresa;
import br.com.devfy.devfy.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devfy/empresas")
public class EmpresaController {


    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public ResponseEntity exibir() {

        List<Empresa> empresas = repository.findAll();

        if (empresas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(empresas);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(
            @PathVariable int id,
            @RequestBody Empresa empresa
    ) {
        empresa.setId(id);
        repository.save(empresa);
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
            @RequestBody Empresa empresa
    ) {
        repository.save(empresa);
        return ResponseEntity.status(201).build();
    }

}
