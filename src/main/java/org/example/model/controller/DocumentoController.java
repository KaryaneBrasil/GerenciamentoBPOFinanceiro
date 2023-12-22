package org.example.model.controller;

import org.example.model.domain.Documento;
import org.example.model.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/listar")
    public List<Documento> listarDocumentos() {
        return documentoService.obterListaDocumentos();
    }

    @PostMapping("/incluir")
    public ResponseEntity<Documento> incluirDocumento(@RequestBody Documento documento) {
        documentoService.incluirDocumento(documento);
        return new ResponseEntity<>(documento, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirDocumento(@PathVariable Long id) {
        documentoService.excluirDocumento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
