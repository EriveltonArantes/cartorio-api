package com.cartorioapi.dto;

import jakarta.validation.constraints.*;

public class CertidaoRequestDTO {

    @NotNull(message = "RegistroId é obrigatório")
    @Positive(message = "RegistroId deve ser um ID válido (positivo)")
    private Long registroId;
    @NotBlank(message = "tipo certidao não pode estar em branco")
    private String tipoCertidao;
    @NotBlank(message = "solicitante não pode estar em branco")
    private String solicitante;
    @NotNull(message = "data emissao não pode ser nulo")
    private java.time.LocalDateTime dataEmissao;
    @NotNull(message = "data validade não pode ser nulo")
    private java.time.LocalDateTime dataValidade;
    @NotBlank(message = "finalidade não pode estar em branco")
    private String finalidade;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private java.math.BigDecimal valor;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getRegistroId() { return registroId; }
    public void setRegistroId(Long registroId) { this.registroId = registroId; }
    public String getTipoCertidao() { return tipoCertidao; }
    public void setTipoCertidao(String tipoCertidao) { this.tipoCertidao = tipoCertidao; }
    public String getSolicitante() { return solicitante; }
    public void setSolicitante(String solicitante) { this.solicitante = solicitante; }
    public java.time.LocalDateTime getDataEmissao() { return dataEmissao; }
    public void setDataEmissao(java.time.LocalDateTime dataEmissao) { this.dataEmissao = dataEmissao; }
    public java.time.LocalDateTime getDataValidade() { return dataValidade; }
    public void setDataValidade(java.time.LocalDateTime dataValidade) { this.dataValidade = dataValidade; }
    public String getFinalidade() { return finalidade; }
    public void setFinalidade(String finalidade) { this.finalidade = finalidade; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
