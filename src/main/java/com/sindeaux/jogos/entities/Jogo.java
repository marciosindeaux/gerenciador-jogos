package com.sindeaux.jogos.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_JOGO")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_JOGO")
    private Long id;
    @Column(name = "NOME_JOGO")
    private String nome;
    @Column(name = "DT_LANCAMENTO_JOGO")
    private LocalDate dataLancamento;
    @Column(name = "DT_INICIO_JOGO")
    private LocalDate dataInicio;
    @Column(name = "DT_CONCLUSAO_JOGO")
    private LocalDate dataConclusao;
    @Column(name = "SINOPSE_JOGO")
    private String sinopse;
    @Column(name = "OPINIAO")
    private String opiniao;
    @Column(name = "NOTA_PESSOAL")
    private Double nota;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "ID_PLATAFORMA")
    private Plataforma plataforma;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "ID_DESENVOLVEDORA")
    private Desenvolvedora desenvolvedora;

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getOpiniao() {
        return opiniao;
    }

    public void setOpiniao(String opiniao) {
        this.opiniao = opiniao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Desenvolvedora getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }
}
