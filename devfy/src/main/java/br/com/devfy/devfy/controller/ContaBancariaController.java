package br.com.devfy.devfy.controller;

import br.com.devfy.devfy.dto.ValorContaDTO;
import br.com.devfy.devfy.repository.ContaBancariaRepository;
import br.com.devfy.devfy.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/devfy/conta-bancaria")
public class ContaBancariaController {


    @Autowired
    ContaBancariaService contaBancariaService;

    @GetMapping("/{id}")
    public ResponseEntity getContaById(
            @PathVariable int id
    ){
        return contaBancariaService.getContaById(id);
    }

    @PatchMapping("/debitar/{id}")
    public ResponseEntity debitar(
            @PathVariable int id,
            @RequestBody ValorContaDTO valor
    ){
        return  contaBancariaService.debitar(valor, id);
    }

    @PatchMapping("/depositar/{id}")
    public ResponseEntity depositar(
            @PathVariable int id,
            @RequestBody ValorContaDTO valor
    ){
        return contaBancariaService.depositar(valor, id);
    }

    @PutMapping("/desfazer-operacao")
    public  ResponseEntity desfazer(){
        return contaBancariaService.desfazer();
    }


    @PostMapping("/debito-agendado")
    public ResponseEntity debitoAgendado(
            @PathVariable int id,
            @RequestBody ValorContaDTO valorDTO
    ){
        return contaBancariaService.debitoAgendado(id, valorDTO);
    }


    @PostMapping("/deposito-agendado")
    public ResponseEntity depositoAgendado(
            @PathVariable int id,
            @RequestBody ValorContaDTO valorDTO
    ){
        return contaBancariaService.depositoAgendado(id, valorDTO);
    }

    @PostMapping("/executar-operacao")
    public ResponseEntity executarOperacao(){
        return contaBancariaService.executarOperacao();
    }




}
