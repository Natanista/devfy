package br.com.bandtec.devfy;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Usuario {
    private String nome;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public Usuario(String nome,
                   String email,
                   String senha,
                   Long telefone,
                   String nacionalidade,
                   Integer cep,
                   Boolean autenticado,
                   LocalDateTime autenticadoEm) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.nacionalidade = nacionalidade;
        this.cep = cep;
        this.autenticado = autenticado;
        this.autenticadoEm = autenticadoEm;
    }

    public String getEmail() {
        return email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public Integer getCep() {
        return cep;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public LocalDateTime getAutenticadoEm() {
        return autenticadoEm;
    }

    private Long telefone;
    private String nacionalidade;
    private Integer cep;
    private Boolean autenticado;
    private LocalDateTime autenticadoEm;

    public Boolean autenticar(String s, String e){
        if (s.equals(senha) && e.equals(email)){
            autenticado = true;
            autenticadoEm = LocalDateTime.now();
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean logoff(){
        if (autenticado){
            autenticadoEm = null;
            autenticado = false;
            return true;
        }
        else{
            return false;
        }

    }
}
