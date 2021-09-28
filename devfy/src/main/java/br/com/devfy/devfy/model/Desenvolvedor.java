package br.com.devfy.devfy.model;

import br.com.caelum.stella.bean.validation.CPF;

import javax.persistence.*;

@Entity
@Table(name = "tlb_desenvolvedor")
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desenvolvedor")
    private int id;

    @CPF
    @Column(name = "cpf", length = 11)
    private String cpf;
}
