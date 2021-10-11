package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.model.Desenvolvedor;
import br.com.devfy.devfy.model.Empresa;
import br.com.devfy.devfy.repository.EmpresaRepository;
import org.apache.coyote.Response;
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
        if (repository.existsById(id)) {
            empresa.setId(id);
            repository.save(empresa);
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
            @RequestBody Empresa empresa
    ) {
        repository.save(empresa);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody Empresa empresa) {
        List<Empresa> empresas = repository.findAll();
        for (Empresa empresa1 : empresas){
            if (empresa1.login(empresa)){
                repository.save(empresa1);
                return ResponseEntity.status(200).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/logoff/{id}")
    public ResponseEntity logoff(@PathVariable int id) {
        if (repository.existsById(id)) {
            Empresa empresa = repository.getById(id);
            empresa.logoff();
            repository.save(empresa);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
