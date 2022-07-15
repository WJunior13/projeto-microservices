package com.wjtc;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "balancos")
public class Balanco {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "transacao_id")
    private String transacaoId;

    @Column(name = "conta_id")
    private String contaId;

    private Double valor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransacaoId() {
        return transacaoId;
    }

    public void setTransacaoId(String transacaoId) {
        this.transacaoId = transacaoId;
    }

    public String getContaId() {
        return contaId;
    }

    public void setContaId(String contaId) {
        this.contaId = contaId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ",  transacaoId='" + getTransacaoId() + "'" +
                ",contaId='" + getContaId() + "'" +
                ", valor='" + getValor() + "'" +
                "}";
    }


    public Balanco(String transacaoId, String contaId, Double valor) {
        this.transacaoId = transacaoId;
        this.contaId = contaId;
        this.valor = valor;
    }

    public Balanco() {
    }
}
