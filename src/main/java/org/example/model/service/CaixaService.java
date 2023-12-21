package org.example.model.service;

import org.example.model.domain.Caixa;
import org.example.model.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaixaService {

    private final CaixaRepository caixaRepository;

    @Autowired
    public CaixaService(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    public void incluirCaixa(Caixa caixa) {
        caixaRepository.save(caixa);
    }

    public List<Caixa> obterListaCaixas() {
        return (List<Caixa>) caixaRepository.findAll();
    }

    public Optional<Caixa> obterCaixaPorId(Long id) {
        return caixaRepository.findById(id);
    }

    public void atualizarCaixa(Caixa caixa) {
        caixaRepository.save(caixa);
    }

    public void excluirCaixa(Long id) {
        caixaRepository.deleteById(id);
    }
}
