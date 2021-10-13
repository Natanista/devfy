package br.com.devfy.devfy.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
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

    public Boolean getAutenticado() {
        return isAutenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        isAutenticado = autenticado;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefoneRepresentante() {
        return telefoneRepresentante;
    }

    public void setTelefoneRepresentante(String telefoneRepresentante) {
        this.telefoneRepresentante = telefoneRepresentante;
    }

    public Boolean getIsAutenticado() {
        return isAutenticado;
    }

    public void setIsAutenticado(Boolean autenticado) {
        isAutenticado = autenticado;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void logoff() {
        this.isAutenticado = false;
    }

    public void login(){
        this.isAutenticado = true;
    }
}
