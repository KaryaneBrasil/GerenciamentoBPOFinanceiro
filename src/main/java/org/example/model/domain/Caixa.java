package org.example.model.domain;

import java.util.Date;

public class Caixa {
    private Date dataFechamento;
    private String responsavelFechamento;
    private String relatorioFechamento;
    private String observacoes;
    private Empresa empresa;
    private Long id;

    public Caixa() {
    }

    public Caixa(Date dataFechamento, String responsavelFechamento, String relatorioFechamento, String observacoes) {
        this.dataFechamento=dataFechamento;
        this.responsavelFechamento=responsavelFechamento;
        this.relatorioFechamento=relatorioFechamento;
        this.observacoes=observacoes;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento=dataFechamento;
    }

    public String getResponsavelFechamento() {
        return responsavelFechamento;
    }

    public void setResponsavelFechamento(String responsavelFechamento) {
        this.responsavelFechamento=responsavelFechamento;
    }

    public String getRelatorioFechamento() {
        return relatorioFechamento;
    }

    public void setRelatorioFechamento(String relatorioFechamento) {
        this.relatorioFechamento=relatorioFechamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes=observacoes;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }
}
