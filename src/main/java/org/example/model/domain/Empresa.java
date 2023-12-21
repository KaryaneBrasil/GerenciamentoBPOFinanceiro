package org.example.model;

import java.util.List;

public class Empresa {
    private String razaoSocial;
    private String nomeFantasia;
    private String sigla;
    private String cnpj;
    private String endereco;
    private String email;
    private List<Cliente> clientes;
    private List<Envio> enviosCaixa;
    private List<Envio> enviosCofre;
    private List<Envio> enviosDocumentos;

    public Empresa() {
    }

    public Empresa(String razaoSocial, String nomeFantasia, String sigla, String cnpj, String endereco, String email) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.sigla = sigla;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
