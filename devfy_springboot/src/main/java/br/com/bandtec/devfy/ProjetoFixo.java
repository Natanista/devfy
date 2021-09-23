package br.com.bandtec.devfy;

import java.time.LocalDateTime;

public class ProjetoFixo extends Projeto{
    private Double valorProjeto;

    public ProjetoFixo(String titulo,
                       String empresa,
                       String linguagem,
                       String descricao,
                       String categoria,
                       String tipoDeProjeto,
                       LocalDateTime dataDePublicacao,
                       Double valorProjeto) {
        super(titulo,
                empresa,
                linguagem,
                descricao,
                categoria,
                tipoDeProjeto,
                dataDePublicacao);
        this.valorProjeto = valorProjeto;
    }

    @Override
    public Double getCalculoValor() {
        return valorProjeto;
    }
}
