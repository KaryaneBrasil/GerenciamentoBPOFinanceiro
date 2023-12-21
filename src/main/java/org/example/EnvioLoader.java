package org.example;

import org.example.model.domain.Cliente;
import org.example.model.domain.Empresa;
import org.example.model.domain.Envio;
import org.example.model.service.ClienteService;
import org.example.model.service.EmpresaService;
import org.example.model.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EnvioLoader implements CommandLineRunner {

    private final EmpresaService empresaService;
    private final ClienteService clienteService;
    private final EnvioService envioService;

    @Autowired
    public EnvioLoader(EmpresaService empresaService, ClienteService clienteService, EnvioService envioService) {
        this.empresaService = empresaService;
        this.clienteService = clienteService;
        this.envioService = envioService;
    }

    @Override
    public void run(String... args) throws Exception {
        Empresa empresa = empresaService.obterListaEmpresas().get(0);
        Cliente cliente = clienteService.obterListaClientes().get(0);

        Envio envio = new Envio(new Date(), "Responsável Envio", "Observação Envio", Envio.TipoEnvio.FECHAMENTO_CAIXA);
        envio.setCliente(cliente);
        envio.setEmpresa(empresa);
        envioService.incluirEnvio(envio);
    }
}
