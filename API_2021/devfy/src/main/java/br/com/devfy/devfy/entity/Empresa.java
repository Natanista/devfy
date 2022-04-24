package br.com.devfy.devfy.entity;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


@Entity
@Table(name = "tbl_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    @NotEmpty
    @NotBlank
    @Column(name = "emp_nome")
    private String nome;

    @Email
    @Column(name = "emp_email")
    private String email;

    @Pattern(regexp = "\\d{11}", message = "O telefone deve conter 11 inteiros")
    @Column(name = "emp_telefone")
    private String telefone;

    @Column(name = "emp_pais")
    private String pais;

    @Pattern(regexp =  "\\d{5}-\\d{3}",
            message = "o cep deve conter 8 caracteres, sendo eles: 5 inteiros, seguido de traço e dos 3 inteiros restantes")
    @Column(name = "emp_cep")
    private String cep;


    @NotEmpty(message = "Nome do Representante nao pode estar vazio!")
    @NotBlank
    @Column(name = "emp_representante")
    private String representante;

    @Column(name = "emp_tel_representante")
    private String telefoneRepresentante;

    @Column(name = "emp_autenticado")
    private Boolean isAutenticado;

    @Column(name = "premium")
    private Boolean isPremium;

    @NotEmpty(message = "Usuario nao pode estar vazio!")
    @NotBlank
    @Column(name = "emp_usuario")
    private String usuario;

    @NotEmpty(message = "Senha nao pode estar vazio!")
    @NotBlank
    @Column(name = "emp_senha")
    private String senha;

    @NotEmpty(message = "CNPJ nao pode estar vazio!")
    @NotBlank
    @Column(name = "emp_cnpj")
    private String cnpj;

    @OneToMany(mappedBy = "empresa")
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

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public void contratarPremium() {
        this.isPremium = true;
    }

    public void cancelarPremium() {
        this.isPremium = false;
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

    public void login() {
        this.isAutenticado = true;
    }

}
