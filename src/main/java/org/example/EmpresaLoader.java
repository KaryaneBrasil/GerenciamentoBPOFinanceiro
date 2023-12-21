package org.example;

import org.example.model.domain.Empresa;
import org.example.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmpresaLoader implements CommandLineRunner {

    private final EmpresaService empresaService;

    @Autowired
    public EmpresaLoader(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @Override
    public void run(String... args) throws Exception {
        Empresa empresa = new Empresa("Razão Social", "Nome Fantasia", "SIGLA", "CNPJ", "Endereço", "Email");
        empresaService.incluirEmpresa(empresa);
    }
}
