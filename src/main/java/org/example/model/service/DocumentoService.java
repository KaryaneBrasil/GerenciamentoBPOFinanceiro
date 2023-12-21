package org.example.model.service;

import org.example.model.domain.Documento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocumentoService {
    private static final Map<Long, Documento> documentosMap=new HashMap<>();

    public void incluirDocumento(Documento documento) {
        documentosMap.put(documento.getId(), documento);
    }

    public List<Documento> obterListaDocumentos() {
        return new ArrayList<>(documentosMap.values());
    }
}
