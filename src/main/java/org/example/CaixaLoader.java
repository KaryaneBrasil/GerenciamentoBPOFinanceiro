package org.example;

import org.example.model.domain.Caixa;
import org.example.model.domain.Cliente;
import org.example.model.domain.Empresa;
import org.example.model.service.CaixaService;
import org.example.model.service.ClienteService;
import org.example.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CaixaLoader implements CommandLineRunner {

    private final EmpresaService empresaService;
    private final ClienteService clienteService;
    private final CaixaService caixaService;

    @Autowired
    public CaixaLoader(EmpresaService empresaService, ClienteService clienteService, CaixaService caixaService) {
        this.empresaService = empresaService;
        this.clienteService = clienteService;
        this.caixaService = caixaService;
    }

    @Override
    public void run(String... args) throws Exception {

        Empresa empresa = empresaService.obterListaEmpresas().get(0);
        Cliente cliente = clienteService.obterListaClientes().get(0);


        Caixa caixa = new Caixa(new Date(), "Responsável Caixa", "Observação Caixa", Caixa.TipoEnvio.FECHAMENTO_CAIXA);
        caixa.setCliente(cliente);
        caixa.setEmpresa(empresa);
        caixaService.incluirCaixa(caixa);
    }
}
