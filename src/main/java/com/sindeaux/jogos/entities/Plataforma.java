package com.sindeaux.jogos.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_PLATAFORMA")
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLATAFORMA")
    private Integer id;
    @Column(name = "NOME_PLATAFORMA")
    private String nome;

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
