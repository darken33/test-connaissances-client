package com.sqli.workshop.ddd.connaissance.client.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sqli.workshop.ddd.connaissance.client.domain.models.Adresse;
import com.sqli.workshop.ddd.connaissance.client.domain.enums.SituationFamiliale;
import lombok.AllArgsConstructor;

import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;
import com.sqli.workshop.ddd.connaissance.client.domain.ports.ConnaissanceClientRepository;

@AllArgsConstructor
public class ConnaissanceClientServiceImpl implements ConnaissanceClientService {

    private final ConnaissanceClientRepository repository;

    @Override
    public List<ConnaissanceClient> listerClients() {
        return null;
    }

    @Override
    public ConnaissanceClient nouveauClient(ConnaissanceClient connaissanceClient) {
        return null;
    }

    @Override
    public Optional<ConnaissanceClient> informationsClient(UUID id) {
        return null;
    }

    @Override
    public Optional<ConnaissanceClient> changementAdresse(UUID id, Adresse adresse) {
        ConnaissanceClient result = null;
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<ConnaissanceClient> changementSituation(UUID id, SituationFamiliale situationFamiliale, Integer nombreEnfants) {
        ConnaissanceClient result = null;
        return Optional.ofNullable(result);
    }

    @Override
    public void supprimerClient(UUID id) {
    }

}
