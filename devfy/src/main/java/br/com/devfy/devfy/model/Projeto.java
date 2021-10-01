package br.com.devfy.devfy.model;

import br.com.devfy.devfy.helper.ListaObj;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.websocket.ClientEndpoint;

@Entity
@Table(name = "tbl_projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private int id;

    @Column(name = "proj_titulo" )
    private String titulo;

    @Column(name = "proj_linguagem")
    private String linguagem;

    @Column(name = "proj_descricao")
    private String descricao;

    @Column(name = "proj_categoria")
    private String categoria;

    @Column(name = "proj_tipo")
    private String tipo;

//    @OneToOne
//    private Empresa fkEmpresa;
//
//    @OneToOne
//    private Desenvolvedor desenvolvedor;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

//    public Empresa getEmpresa() {
//        return empresa;
//    }
//
//    public void setEmpresa(Empresa empresa) {
//        this.empresa = empresa;
//    }
//
//    public Desenvolvedor getDesenvolvedor() {
//        return desenvolvedor;
//    }
//
//    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
//        this.desenvolvedor = desenvolvedor;
//    }
}
