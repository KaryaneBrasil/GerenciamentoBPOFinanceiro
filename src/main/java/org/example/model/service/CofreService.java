package org.example.model.service;

import org.example.model.domain.Cofre;
import org.example.model.repository.CofreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CofreService {

    private final CofreRepository cofreRepository;

    @Autowired
    public CofreService(CofreRepository cofreRepository) {
        this.cofreRepository = cofreRepository;
    }

    public void incluirCofre(Cofre cofre) {
        cofreRepository.save(cofre);
    }

    public List<Cofre> obterListaCofres() {
        return (List<Cofre>) cofreRepository.findAll();
    }

    public Optional<Cofre> obterCofrePorId(Long id) {
        return cofreRepository.findById(id);
    }

    public void atualizarCofre(Cofre cofre) {
        cofreRepository.save(cofre);
    }

    public void excluirCofre(Long id) {
        cofreRepository.deleteById(id);
    }
}
