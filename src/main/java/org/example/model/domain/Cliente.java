package org.example.model.domain;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;


    public Cliente(Empresa empresa) {
        this.empresa=empresa;
    }

    public Cliente(String nome, String cpf, String endereco, String email) {
        this.nome=nome;
        this.cpf=cpf;
        this.endereco=endereco;
        this.email=email;
    }

    public Cliente() {

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

    public void setEmpresa(Empresa empresa) {
    }
}
