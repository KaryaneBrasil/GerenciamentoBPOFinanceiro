package org.example;

import org.example.model.domain.Cliente;
import org.example.model.domain.Documento;
import org.example.model.domain.Empresa;
import org.example.model.domain.Envio;
import org.example.model.service.ClienteService;
import org.example.model.service.DocumentoService;
import org.example.model.service.EmpresaService;
import org.example.model.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DocumentoLoader implements CommandLineRunner {

    private final EmpresaService empresaService;
    private final ClienteService clienteService;
    private final EnvioService envioService;
    private final DocumentoService documentoService;

    @Autowired
    public DocumentoLoader(EmpresaService empresaService, ClienteService clienteService,
                           EnvioService envioService, DocumentoService documentoService) {
        this.empresaService = empresaService;
        this.clienteService = clienteService;
        this.envioService = envioService;
        this.documentoService = documentoService;
    }

    @Override
    public void run(String... args) throws Exception {

        Empresa empresa = empresaService.obterListaEmpresas().get(0);
        Cliente cliente = clienteService.obterListaClientes().get(0);
        Envio envio = envioService.obterListaEnvios().get(0);

        Documento documento = new Documento("Tipo Documento", "Arquivo Documento", new Date(), "Observação Documento");
        documento.setCliente(cliente);
        documento.setEmpresa(empresa);
        documento.setEnvio(envio);
        documentoService.incluirDocumento(documento);
    }
}
