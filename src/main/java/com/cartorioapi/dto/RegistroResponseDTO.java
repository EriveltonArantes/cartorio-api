package com.cartorioapi.dto;

public class RegistroResponseDTO {

    private Long id;
    private String tipo;
    private String livro;
    private String folha;
    private String numero;
    private java.time.LocalDateTime dataLancamento;
    private String descricao;
    private Integer partes;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
