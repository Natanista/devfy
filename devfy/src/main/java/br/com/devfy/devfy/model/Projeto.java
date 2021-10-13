package br.com.devfy.devfy.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private int id;

    @Column(name = "proj_titulo")
    private String titulo;

    @Column(name = "proj_linguagem")
    private String linguagem;

    @Column(name = "proj_descricao")
    private String descricao;

    @Column(name = "proj_categoria")
    private String categoria;

    @Column(name = "proj_valor")
    private String valor;

    @ManyToOne
    @JoinColumn(name="dev_id", nullable=true)
    private Desenvolvedor desenvolvedor;

    @ManyToOne
    @JoinColumn(name="emp_id", nullable=true)
    private Empresa empresa;

    public String getDesenvolvedor() {
        return desenvolvedor.getUsuario();
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public String getEmpresa() {
        return empresa.getNome();
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
