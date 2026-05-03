package com.joao.apifilmes.model;

import jakarta.persistence.*;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private Double nota;

    public Filme() {
        // construtor vazio obrigatório pro JPA
    }

    public Filme(Long id, String titulo, String genero, Double nota) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.nota = nota;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public Double getNota() { return nota; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setNota(Double nota) { this.nota = nota; }
}