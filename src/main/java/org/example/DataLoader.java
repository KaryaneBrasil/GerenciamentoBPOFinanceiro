package org.example;

import org.example.model.domain.Empresa;
import org.example.model.domain.Endereco;
import org.example.model.service.ClienteService;
import org.example.model.service.EmpresaService;
import org.example.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    @PostConstruct
    public void loadData() {

        Empresa empresa = new Empresa("Razao Social", "Nome Fantasia", "SIG", "12345678901234", "Rua Empresa, 123", "empresa@example.com");
        empresaService.incluirEmpresa(empresa);


        Endereco enderecoEmpresa = enderecoService.buscarEnderecoPorCep("12345678");


        empresa.setEndereco(enderecoEmpresa);
        empresaService.incluirEmpresa(empresa);


    }
}
