package org.example;

import org.example.model.domain.Cliente;
import org.example.model.domain.Empresa;
import org.example.model.service.ClienteService;
import org.example.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClienteLoader implements CommandLineRunner {

    private final EmpresaService empresaService;
    private final ClienteService clienteService;

    @Autowired
    public ClienteLoader(EmpresaService empresaService, ClienteService clienteService) {
        this.empresaService = empresaService;
        this.clienteService = clienteService;
    }

    @Override
    public void run(String... args) throws Exception {

        Empresa empresa = empresaService.obterListaEmpresas().get(0);

        Cliente cliente = new Cliente("Nome do Cliente", "CPF Cliente", "Endereço Cliente", "Email Cliente");
        cliente.setEmpresa(empresa);
        clienteService.incluirCliente(cliente);
    }
}
