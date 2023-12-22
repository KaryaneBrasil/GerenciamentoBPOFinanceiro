package org.example.model.repository;

import org.example.model.domain.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

    Endereco findByCep(String cep);
}