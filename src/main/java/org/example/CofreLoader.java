package org.example;

import org.example.model.domain.Cofre;
import org.example.model.domain.Cliente;
import org.example.model.domain.Empresa;
import org.example.model.service.ClienteService;
import org.example.model.service.CofreService;
import org.example.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CofreLoader implements CommandLineRunner {

    private final EmpresaService empresaService;
    private final ClienteService clienteService;
    private final CofreService cofreService;

    @Autowired
    public CofreLoader(EmpresaService empresaService, ClienteService clienteService, CofreService cofreService) {
        this.empresaService = empresaService;
        this.clienteService = clienteService;
        this.cofreService = cofreService;
    }

    @Override
    public void run(String... args) throws Exception {

        Empresa empresa = empresaService.obterListaEmpresas().get(0);
        Cliente cliente = clienteService.obterListaClientes().get(0);

        Cofre cofre = new Cofre(new Date(), "Responsável Cofre", "Observação Cofre", Cofre.TipoEnvio.FECHAMENTO_COFRE);
        cofre.setCliente(cliente);
        cofre.setEmpresa(empresa);
        cofreService.incluirCofre(cofre);
    }
}
