package org.example.model.service;

import org.example.model.domain.Empresa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpresaService {
    private static final Map<String, Empresa> empresasMap=new HashMap<>();

    public void incluirEmpresa(Empresa empresa) {
        empresasMap.put(empresa.getCnpj(), empresa);
    }

    public List<Empresa> obterListaEmpresas() {
        return new ArrayList<>(empresasMap.values());
    }
}
