package br.com.devfy.devfy.model;

import javax.persistence.*;

@Entity
@Table(name = "tlb_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private int id;

    @Column(name = "emp_nome")
    private String nome;

    @Column(name = "emp_email")
    private String email;

    @Column(name = "emp_telefone")
    private String telefone;

    @Column(name = "emp_pais")
    private String  pais;

    @Column(name = "emp_cep")
    private String cep;

    @Column(name = "emp_representante")
    private String representante;

    @Column(name = "emp_tel_representante")
    private String telefoneRepresentante;

    @Column(name = "emp_autenticado")
    private Boolean isAutenticado;

    @Column(name = "emp_usuario")
    private String usuario;

    @Column(name = "emp_senha")
    private String senha;

    @Column(name = "emp_cnpj")
    private String cnpj;

}
