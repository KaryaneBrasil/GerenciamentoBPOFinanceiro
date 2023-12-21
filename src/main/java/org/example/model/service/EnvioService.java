package org.example.model.service;

import org.example.model.domain.Envio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EnvioService {
    private static final Map<Long, Envio> enviosMap=new HashMap<>();

    public void incluirEnvio(Envio envio) {
        enviosMap.put(envio.getId(), envio);
    }

    public List<Envio> obterListaEnvios() {
        return new ArrayList<>(enviosMap.values());
    }
}
