package com.cartorioapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "solicitacaoservicos")
public class SolicitacaoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
    @Column(nullable = false)
    private String requerente;
    private java.time.LocalDateTime dataEntrada;
    private java.time.LocalDateTime dataPrazo;
    @Column(nullable = false)
    private String status;
    private java.math.BigDecimal valor;
    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }
    public String getRequerente() { return requerente; }
    public void setRequerente(String requerente) { this.requerente = requerente; }
    public java.time.LocalDateTime getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(java.time.LocalDateTime dataEntrada) { this.dataEntrada = dataEntrada; }
    public java.time.LocalDateTime getDataPrazo() { return dataPrazo; }
    public void setDataPrazo(java.time.LocalDateTime dataPrazo) { this.dataPrazo = dataPrazo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
