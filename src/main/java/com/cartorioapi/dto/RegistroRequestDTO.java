package com.cartorioapi.dto;

import jakarta.validation.constraints.*;

public class RegistroRequestDTO {

    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "livro não pode estar em branco")
    private String livro;
    @NotBlank(message = "folha não pode estar em branco")
    private String folha;
    @NotBlank(message = "numero não pode estar em branco")
    private String numero;
    @NotNull(message = "data lancamento não pode ser nulo")
    private java.time.LocalDateTime dataLancamento;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotNull(message = "partes não pode ser nulo")
    private Integer partes;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getLivro() { return livro; }
    public void setLivro(String livro) { this.livro = livro; }
    public String getFolha() { return folha; }
    public void setFolha(String folha) { this.folha = folha; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public java.time.LocalDateTime getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(java.time.LocalDateTime dataLancamento) { this.dataLancamento = dataLancamento; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getPartes() { return partes; }
    public void setPartes(Integer partes) { this.partes = partes; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
