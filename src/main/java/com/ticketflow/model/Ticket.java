package com.ticketflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titulo é obrigatorio")
    @Column(nullable = false)
    private String titulo;

    private String descricao;

    // "ABERTO",pois esta ocorrendo error null
    private String status = "ABERTO";

    // "BAIXA", "MEDIA", "ALTA"
    private String prioridade;

    // JPA exige um construtor vazio - ele mesmo usa isso "por baixo dos panos"
    // quando reconstroi um Ticket a partir de uma linha do banco.
    public Ticket() {
    }

    public Ticket(String titulo, String descricao, String prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = "ABERTO"; // todo ticket novo comeca aberto
    }

    // Getters e setters - o Spring/JPA usa isso para ler e gravar os dados
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}
