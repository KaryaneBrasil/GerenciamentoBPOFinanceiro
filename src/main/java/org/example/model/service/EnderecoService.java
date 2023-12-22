package org.example.model.service;

import org.example.model.client.IEnderecoClient;
import org.example.model.domain.Endereco;
import org.example.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoClient enderecoClient;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco buscarCep(String cep) {
        return enderecoClient.buscarCep(cep);
    }

    public Endereco buscarEnderecoPorCep(String cep) {
        Endereco endereco = enderecoRepository.findByCep(cep);

        if (endereco == null) {
            endereco = enderecoClient.buscarCep(cep);

            if (endereco != null) {
                enderecoRepository.save(endereco);
            }
        }

        return endereco;
    }
}
