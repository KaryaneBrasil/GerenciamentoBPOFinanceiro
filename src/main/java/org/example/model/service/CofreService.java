package org.example.model.service;

import org.example.model.domain.Cofre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CofreService {
    private static final Map<Long, Cofre> cofresMap=new HashMap<>();

    public void incluirCofre(Cofre cofre) {
        cofresMap.put(cofre.getId(), cofre);
    }

    public List<Cofre> obterListaCofres() {
        return new ArrayList<>(cofresMap.values());
    }
}
