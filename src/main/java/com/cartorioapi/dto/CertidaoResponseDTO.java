package com.cartorioapi.dto;

public class CertidaoResponseDTO {

    private Long id;
    private Long registroId;
    private String tipoCertidao;
    private String solicitante;
    private java.time.LocalDateTime dataEmissao;
    private java.time.LocalDateTime dataValidade;
    private String finalidade;
    private java.math.BigDecimal valor;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
