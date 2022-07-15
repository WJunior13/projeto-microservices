package com.wjtc;

public class Transacao {

    private String id;
    private String contaId;
    private String descricao;
    private String tipo;
    private Double valor;

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", contaId='" + getContaId() + "'" +
                ", descricao='" + getDescricao() + "'" +
                ", tipo='" + getTipo() + "'" +
                ", valor='" + getValor() + "'" +
                "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContaId() {
        return contaId;
    }

    public void setContaId(String contaId) {
        this.contaId = contaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isIncome() {
        return tipo.equals("INCOME");
    }
}
