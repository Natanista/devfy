package br.com.bandtec.devfy;

import java.time.LocalDateTime;

public abstract class Projeto implements Remuneravel{
    private String titulo;
    private String empresa;
    private String linguyagem;
    private String descricao;
    private String categoria;
    private String tipoDeProjeto;
    private LocalDateTime dataDePublicacao;

    public Projeto(String titulo,
                   String empresa,
                   String linguyagem,
                   String descricao,
                   String categoria,
                   String tipoDeProjeto,
                   LocalDateTime dataDePublicacao) {
        this.titulo = titulo;
        this.empresa = empresa;
        this.linguyagem = linguyagem;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tipoDeProjeto = tipoDeProjeto;
        this.dataDePublicacao = dataDePublicacao;
    }
}
