package br.com.devfy.devfy.usuario;

public class Usuario {
   private String nome;
   private String email;
   private String senha;
   private Boolean isLogged;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isLogged = false;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }
z
    public Boolean isUserValid(String email, String senha){
        Boolean usuarioExiste = false;
        if(this.senha.equals(senha) && this.email.equals(email)){
            usuarioExiste = true;
        }
        return usuarioExiste;
    }

    public void logarUsuario(){
        this.isLogged = true;
    }

    public void deslogarUsuario(){
        this.isLogged = false;
    }

}
