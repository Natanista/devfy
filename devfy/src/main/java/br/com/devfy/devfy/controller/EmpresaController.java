package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.helper.ModeloLogin;
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
        empresa.cancelarPremium();
        empresa.logoff();
        repository.save(empresa);
        return ResponseEntity.status(201).build();
    }

    @PostMapping ("/login")
    public ResponseEntity login(@RequestBody ModeloLogin empresa) {
        Empresa empresaEncontrada = repository.findEmpresaByUsuarioEqualsAndSenhaEquals(
                empresa.getUsuario(), empresa.getSenha()
        );

        if(empresaEncontrada.equals(null)){
            return ResponseEntity.status(404).build();
        }

        empresaEncontrada.login();
        repository.save(empresaEncontrada);
        return ResponseEntity.status(200).body(empresaEncontrada);
    }

//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody ModeloLogin desenvolvedor) {
//        Desenvolvedor devEncontrado = repository.findDesenvolvedorByUsuarioEqualsAndSenhaEquals(
//                desenvolvedor.getUsuario(), desenvolvedor.getSenha()
//        );
//
//        if (devEncontrado.equals(null)){
//            return ResponseEntity.status(404).build();
//        }
//
//        devEncontrado.login();
//        repository.save(devEncontrado);
//        return ResponseEntity.status(200).body(devEncontrado);
//    }



    @PostMapping("/logoff/{id}")
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
