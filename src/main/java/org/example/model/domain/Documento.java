package org.example.model.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("DOCUMENTO")
public class Documento extends Envio{

    private Long id;
    private String tipoDocumento;
    private String arquivo;
    private Date dataEnvio;
    private String observacoes;


    public Documento() {
    }

    public Documento(String tipoDocumento, String arquivo, Date dataEnvio, String observacoes) {
        this.tipoDocumento=tipoDocumento;
        this.arquivo=arquivo;
        this.dataEnvio=dataEnvio;
        this.observacoes=observacoes;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento=tipoDocumento;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo=arquivo;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio=dataEnvio;
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

    public void setEnvio(Envio envio) {
    }
}
