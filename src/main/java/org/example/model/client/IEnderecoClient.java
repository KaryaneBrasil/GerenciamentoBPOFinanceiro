package org.example.model.client;

import org.example.model.domain.Endereco;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IEnderecoClient {

    @GetMapping(value = "/{cep}/json/")
    Endereco buscarCep(@PathVariable String cep);
}
