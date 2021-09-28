package br.com.devfy.devfy.model;

import br.com.caelum.stella.bean.validation.CNPJ;

import javax.persistence.*;

@Entity
@Table(name = "tlb_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private int id;

    @CNPJ
    @Column(name = "cnpj", length = 14)
    private String cnpj;

}
