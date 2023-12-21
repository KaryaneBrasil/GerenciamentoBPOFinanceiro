package org.example.model.domain;

import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private List<Envio> enviosCaixa;
    private List<Envio> enviosCofre;
    private List<Envio> enviosDocumentos;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String endereco, String email) {
        this.nome=nome;
        this.cpf=cpf;
        this.endereco=endereco;
        this.email=email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome=nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf=cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco=endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }
}
