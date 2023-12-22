package org.example.model.controller;

import org.example.model.domain.Envio;
import org.example.model.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envio")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping("/listar")
    public List<Envio> listarEnvios() {
        return envioService.obterListaEnvios();
    }

    @PostMapping("/incluir")
    public ResponseEntity<Envio> incluirEnvio(@RequestBody Envio envio) {
        envioService.incluirEnvio(envio);
        return new ResponseEntity<>(envio, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirEnvio(@PathVariable Long id) {
        envioService.excluirEnvio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
