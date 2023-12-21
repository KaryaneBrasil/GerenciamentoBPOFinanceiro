package org.example.model.service;

import org.example.model.domain.Caixa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CaixaService {
    private static final Map<Long, Caixa> caixasMap=new HashMap<>();

    public void incluirCaixa(Caixa caixa) {
        caixasMap.put(caixa.getId(), caixa);
    }

    public List<Caixa> obterListaCaixas() {
        return new ArrayList<>(caixasMap.values());
    }
}
