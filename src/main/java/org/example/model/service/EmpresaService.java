package org.example.model.service;

import org.example.model.domain.Empresa;
import org.example.model.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public void incluirEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    public List<Empresa> obterListaEmpresas() {
        return (List<Empresa>) empresaRepository.findAll();
    }

    public Optional<Empresa> obterEmpresaPorId(Long id) {
        return empresaRepository.findById(id);
    }

    public void atualizarEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    public void excluirEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
