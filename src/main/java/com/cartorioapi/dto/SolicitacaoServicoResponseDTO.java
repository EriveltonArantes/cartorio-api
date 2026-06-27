package com.cartorioapi.dto;

public class SolicitacaoServicoResponseDTO {

    private Long id;
    private Long servicoId;
    private String requerente;
    private java.time.LocalDateTime dataEntrada;
    private java.time.LocalDateTime dataPrazo;
    private String status;
    private java.math.BigDecimal valor;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getServicoId() { return servicoId; }
    public void setServicoId(Long servicoId) { this.servicoId = servicoId; }
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
