package com.sqli.workshop.ddd.connaissance.client.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sqli.workshop.ddd.connaissance.client.domain.models.Adresse;
import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;
import com.sqli.workshop.ddd.connaissance.client.domain.enums.SituationFamiliale;

/**
 * Uses Cases métier de la fiche Connaissance Client
 */
public interface ConnaissanceClientService {

    default ConnaissanceClient nouveauClient(ConnaissanceClient connaissanceClient) {
        return null;
    }

    default List<ConnaissanceClient> listerClients() {
        return List.of();
    }

    default Optional<ConnaissanceClient> informationsClient(UUID id) {
        return Optional.empty();
    }

    default Optional<ConnaissanceClient> changementAdresse(UUID id, Adresse adresse) {
        return Optional.empty();
    }

    default Optional<ConnaissanceClient> changementSituation(UUID id, SituationFamiliale situationFamiliale, Integer nombreEnfants) {
        return Optional.empty();
    }

    default void supprimerClient(UUID id) {
    }
}
