package org.example.model.service;

import org.example.model.domain.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteService {
    private static final Map<String, Cliente> clientesMap=new HashMap<>();

    public void incluirCliente(Cliente cliente) {
        clientesMap.put(cliente.getCpf(), cliente);
    }

    public List<Cliente> obterListaClientes() {
        return new ArrayList<>(clientesMap.values());
    }
}
