package br.com.bandtec.devfy;

import java.time.LocalDateTime;

public class UsuarioEmpresa extends Usuario {
    private String representante;
    private Long telefoneRepresentante;
    private Long cnpj;
    public UsuarioEmpresa(String nome,
                          String email,
                          String senha,
                          Long telefone,
                          String nacionalidade,
                          Integer cep,
                          Boolean autenticado,
                          LocalDateTime autenticadoEm,
                          String representante,
                          Long telefoneRepresentante,
                          Long cnpj) {
        super(nome, email, senha, telefone, nacionalidade, cep, autenticado, autenticadoEm);
        this.representante = representante;
        this.telefoneRepresentante = telefoneRepresentante;
        this.cnpj = cnpj;
    }
    public String getRepresentante() {
        return representante;
    }

    public Long getTelefoneRepresentante() {
        return telefoneRepresentante;
    }

    public Long getCnpj() {
        return cnpj;
    }
}
