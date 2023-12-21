package org.example.model.service;

import org.example.model.domain.Cliente;
import org.example.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void incluirCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> obterListaClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Optional<Cliente> obterClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void atualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
