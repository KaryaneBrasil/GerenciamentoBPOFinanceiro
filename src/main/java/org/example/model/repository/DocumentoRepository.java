package org.example.model.repository;

import org.example.model.domain.Documento;
import org.springframework.data.repository.CrudRepository;

public interface DocumentoRepository extends CrudRepository<Documento, Long> {

}