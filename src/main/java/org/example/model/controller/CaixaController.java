package org.example.model.controller;

import org.example.model.domain.Caixa;
import org.example.model.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caixa")
public class CaixaController {

    @Autowired
    private CaixaService caixaService;

    @GetMapping("/listar")
    public List<Caixa> listarCaixas() {
        return caixaService.obterListaCaixas();
    }

    @PostMapping("/incluir")
    public ResponseEntity<Caixa> incluirCaixa(@RequestBody Caixa caixa) {
        caixaService.incluirCaixa(caixa);
        return new ResponseEntity<>(caixa, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirCaixa(@PathVariable Long id) {
        caixaService.excluirCaixa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
