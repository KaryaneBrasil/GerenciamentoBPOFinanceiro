package org.example.model.domain;

import java.util.Date;

public class Envio {
    private Date data;
    private String responsavel;
    private String observacao;
    private TipoEnvio tipoEnvio;
    private Empresa empresa;
    private Cliente cliente;
    private Long id;

    public Envio() {
    }

    public Envio(Date data, String responsavel, String observacao, TipoEnvio tipoEnvio) {
        this.data=data;
        this.responsavel=responsavel;
        this.observacao=observacao;
        this.tipoEnvio=tipoEnvio;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data=data;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel=responsavel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao=observacao;
    }

    public TipoEnvio getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(TipoEnvio tipoEnvio) {
        this.tipoEnvio=tipoEnvio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }


    // Enumeração para representar os tipos de envio
    public enum TipoEnvio {
        FECHAMENTO_CAIXA,
        FECHAMENTO_COFRE,
        CONTAS_PAGAS,
        CONTAS_A_PAGAR
    }

}
