package com.sqli.workshop.ddd.connaissance.client.domain.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;

/**
 * Port pour la sauvegarde de l'objet métier ConnaissanceClient
 */
public interface ConnaissanceClientRepository {

    ConnaissanceClient save(ConnaissanceClient connaissanceClient);

    Optional<ConnaissanceClient> findById(UUID id);

    List<ConnaissanceClient> findAll();

    void delete(UUID id);

}
