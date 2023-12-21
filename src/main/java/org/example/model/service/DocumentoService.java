package org.example.model.service;

import org.example.model.domain.Documento;
import org.example.model.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    @Autowired
    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public void incluirDocumento(Documento documento) {
        documentoRepository.save(documento);
    }

    public List<Documento> obterListaDocumentos() {
        return (List<Documento>) documentoRepository.findAll();
    }

    public Optional<Documento> obterDocumentoPorId(Long id) {
        return documentoRepository.findById(id);
    }

    public void atualizarDocumento(Documento documento) {
        documentoRepository.save(documento);
    }

    public void excluirDocumento(Long id) {
        documentoRepository.deleteById(id);
    }
}
