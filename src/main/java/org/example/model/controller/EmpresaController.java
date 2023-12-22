package org.example.model.controller;

import org.example.model.domain.Empresa;
import org.example.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listar")
    public List<Empresa> listarEmpresas() {
        return empresaService.obterListaEmpresas();
    }

    @PostMapping("/incluir")
    public ResponseEntity<Empresa> incluirEmpresa(@RequestBody Empresa empresa) {
        empresaService.incluirEmpresa(empresa);
        return new ResponseEntity<>(empresa, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirEmpresa(@PathVariable Long id) {
        empresaService.excluirEmpresa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
