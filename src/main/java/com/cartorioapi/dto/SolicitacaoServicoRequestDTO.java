package com.cartorioapi.dto;

import jakarta.validation.constraints.*;

public class SolicitacaoServicoRequestDTO {

    @NotNull(message = "ServicoId é obrigatório")
    @Positive(message = "ServicoId deve ser um ID válido (positivo)")
    private Long servicoId;
    @NotBlank(message = "requerente não pode estar em branco")
    private String requerente;
    @NotNull(message = "data entrada não pode ser nulo")
    private java.time.LocalDateTime dataEntrada;
    @NotNull(message = "data prazo não pode ser nulo")
    private java.time.LocalDateTime dataPrazo;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private java.math.BigDecimal valor;

    private String observacoes;

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
