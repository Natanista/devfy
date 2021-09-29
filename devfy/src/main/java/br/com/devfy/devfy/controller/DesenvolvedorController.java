package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.model.Desenvolvedor;
import br.com.devfy.devfy.model.Projeto;
import br.com.devfy.devfy.repository.DesenvolvedorRepository;
import br.com.devfy.devfy.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devfy/desenvolvedores")
public class DesenvolvedorController {


    @Autowired
    private DesenvolvedorRepository repository;

    @GetMapping
    public List<Desenvolvedor> exibir() {
        return repository.findAll();
    }

    @PutMapping("/atualizar/{id}")
    public String atualizar(
            @PathVariable int id,
            @RequestBody Desenvolvedor desenvolvedor
    ) {
        desenvolvedor.setId(id);
        repository.save(desenvolvedor);
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
            @RequestBody Desenvolvedor desenvolvedor
    ) {
        repository.save(desenvolvedor);
        return "Projeto adicionado com sucesso!";
    }


}
