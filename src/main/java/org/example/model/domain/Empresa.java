package org.example.model.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String sigla;
    private String cnpj;
    private String email;
    @OneToMany(mappedBy = "empresa")
    private List<Cliente> clientes;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;


    public Empresa(Endereco endereco) {
        this.endereco=endereco;
    }

    public Empresa(String razaoSocial, String nomeFantasia, String sigla, String cnpj, String endereco, String email) {
        this.razaoSocial=razaoSocial;
        this.nomeFantasia=nomeFantasia;
        this.sigla=sigla;
        this.cnpj=cnpj;
        this.email=email;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial=razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia=nomeFantasia;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla=sigla;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj=cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }


    @OneToMany(mappedBy = "empresa")
    private Collection<Envio> envio;

    public Collection<Envio> getEnvio() {
        return envio;
    }

    public void setEnvio(Collection<Envio> envio) {
        this.envio=envio;
    }

    public void setEndereco(Endereco enderecoEmpresa) {
    }
}
