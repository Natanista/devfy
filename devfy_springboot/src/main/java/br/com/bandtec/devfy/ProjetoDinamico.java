package br.com.bandtec.devfy;

import java.time.LocalDateTime;

public class ProjetoDinamico extends Projeto{
    private Double valorHora;
    private Integer horasTrabalhadas;

    public ProjetoDinamico(String titulo,
                           String empresa,
                           String linguyagem,
                           String descricao,
                           String categoria,
                           String tipoDeProjeto,
                           LocalDateTime dataDePublicacao,
                           Double valorHora,
                           Integer horasTrabalhadas) {
        super(titulo,
                empresa,
                linguyagem,
                descricao,
                categoria,
                tipoDeProjeto,
                dataDePublicacao);
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public Double getCalculoValor() {
        return valorHora*horasTrabalhadas;
    }
}
