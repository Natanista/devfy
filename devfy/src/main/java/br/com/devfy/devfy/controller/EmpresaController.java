package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.model.Desenvolvedor;
import br.com.devfy.devfy.model.Empresa;
import br.com.devfy.devfy.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devfy/empresas")
public class EmpresaController {


    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public List<Empresa> exibir() {
        return repository.findAll();
    }

    @PutMapping("/atualizar/{id}")
    public String atualizar(
            @PathVariable int id,
            @RequestBody Empresa empresa
    ) {
        empresa.setId(id);
        repository.save(empresa);
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
            @RequestBody Empresa empresa
    ) {
        repository.save(empresa);
        return "Projeto adicionado com sucesso!";
    }

}
