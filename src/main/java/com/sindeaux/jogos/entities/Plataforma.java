package com.sindeaux.jogos.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_PLATAFORMA")
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLATAFORMA")
    private Integer id;
    @Column(name = "NOME_PLATAFORMA")
    private String nome;
    @OneToMany(mappedBy = "plataforma", fetch = FetchType.LAZY)
    private List<Jogo> jogos;

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
