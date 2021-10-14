package br.com.devfy.devfy.model;

import br.com.devfy.devfy.helper.ListaObj;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_desenvolvedor")
public class Desenvolvedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private int id;

    @Column(name = "dev_nome")
    private String nome;

    @Column(name = "dev_email")
    private String email;

    @Column(name = "dev_telefone")
    private String telefone;

    @Column(name = "dev_nacionalidade")
    private String nacionalidade;

    @Column(name = "dev_cep")
    private String cep;

    @Column(name = "dev_cpf")
    private String cpf;

    @Column(name = "dev_descricao")
    private String descricao;

    @Column(name = "dev_autenticado")
    private Boolean isAutenticado = false;

    @Column(name = "dev_valor_hora")
    private Double valorHora;

    @Column(name = "linguagem_dev")
    private String linguagem;

    @Column(name = "dev_anos_exp")
    private int anoSExperiencia;

    @Column(name = "dev_usuario")
    private String usuario;

    @Column(name = "dev_senha")
    private String senha;

    @OneToMany(mappedBy = "desenvolvedor")
    private List<Projeto> projetos;

    public List<String> getProjetos() {
        List<String> projs = new ArrayList<>();

        for (Projeto projeto : projetos) {
            projs.add(projeto.getTitulo());
        }

        return projs;
    }


    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getIsAutenticado() {
        return isAutenticado;
    }

    public void setIsAutenticado(Boolean autenticado) {
        this.isAutenticado = autenticado;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public int getAnoSExperiencia() {
        return anoSExperiencia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagemDev) {
        this.linguagem = linguagemDev;
    }

    public void logoff() {
        this.isAutenticado = false;
    }

    public void login() {
        this.isAutenticado = true;
    }

}
