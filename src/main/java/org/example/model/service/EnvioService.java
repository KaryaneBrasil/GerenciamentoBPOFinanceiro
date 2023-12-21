package org.example.model.service;

import org.example.model.domain.Envio;
import org.example.model.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {

    private final EnvioRepository envioRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    public void incluirEnvio(Envio envio) {
        envioRepository.save(envio);
    }

    public List<Envio> obterListaEnvios() {
        return (List<Envio>) envioRepository.findAll();
    }

    public Optional<Envio> obterEnvioPorId(Long id) {
        return envioRepository.findById(id);
    }

    public void atualizarEnvio(Envio envio) {
        envioRepository.save(envio);
    }

    public void excluirEnvio(Long id) {
        envioRepository.deleteById(id);
    }
}
