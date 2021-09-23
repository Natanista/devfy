package br.com.bandtec.devfy;

import java.time.LocalDateTime;

public class UsuarioDev extends Usuario implements Remuneravel{
    private String competencia;
    private Integer anosExperiencia;
    private String cpf;
    private String linguagem;
    private Double valorHora;

    public UsuarioDev(String nome,
                      String email,
                      String senha,
                      Long telefone,
                      String nacionalidade,
                      Integer cep,
                      Boolean autenticado,
                      LocalDateTime autenticadoEm,
                      String competencia,
                      Integer anosExperiencia,
                      String cpf,
                      String linguagem,
                      Double valorHora) {
        super(nome, email, senha, telefone, nacionalidade, cep, autenticado, autenticadoEm);
        this.competencia = competencia;
        this.anosExperiencia = anosExperiencia;
        this.cpf = cpf;
        this.linguagem = linguagem;
        this.valorHora = valorHora;
    }

    @Override
    public Double getCalculoValor() {
        return valorHora;
    }
}
