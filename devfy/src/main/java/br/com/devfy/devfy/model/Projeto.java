package br.com.devfy.devfy.model;

import javax.persistence.*;

@Entity
@Table(name = "tlb_projetoa")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private int id;
}
