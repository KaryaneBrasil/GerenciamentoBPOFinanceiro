package org.example.model.controller;

import org.example.model.domain.Cofre;
import org.example.model.service.CofreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cofre")
public class CofreController {

    @Autowired
    private CofreService cofreService;

    @GetMapping("/listar")
    public List<Cofre> listarCofres() {
        return cofreService.obterListaCofres();
    }

    @PostMapping("/incluir")
    public ResponseEntity<Cofre> incluirCofre(@RequestBody Cofre cofre) {
        cofreService.incluirCofre(cofre);
        return new ResponseEntity<>(cofre, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirCofre(@PathVariable Long id) {
        cofreService.excluirCofre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
