package com.sqli.workshop.ddd.connaissance.client.api;

import com.sqli.workshop.ddd.connaissance.client.domain.ConnaissanceClientService;
import com.sqli.workshop.ddd.connaissance.client.domain.enums.SituationFamiliale;
import com.sqli.workshop.ddd.connaissance.client.domain.models.Adresse;
import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.*;
import com.sqli.workshop.ddd.connaissance.client.generated.api.server.ConnaissanceClientApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ConnaissanceClientDelegate implements ConnaissanceClientApiDelegate {

    private final ConnaissanceClientService service;

    @Autowired
    public ConnaissanceClientDelegate(ConnaissanceClientService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<ConnaissanceClientDto>> getConnaissanceClients() {
        return ResponseEntity.ok(
                service.listerClients().stream()
                        .map(this::mapToDto).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<ConnaissanceClientDto> getConnaissanceClient(UUID id) {
        var connaissanceClient = service.informationsClient(id);
        if (connaissanceClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapToDto(connaissanceClient.get()));
    }

    @Override
    public ResponseEntity<ConnaissanceClientDto> saveConnaissanceClient(ConnaissanceClientInDto connaissanceClientDto) {
        var connaissanceClient = service.nouveauClient(mapToDomain(connaissanceClientDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDto(connaissanceClient));
    }

    @Override
    public ResponseEntity<ConnaissanceClientDto> changerSituation(UUID id, SituationDto situationDto) {
        Optional<ConnaissanceClient> connaissanceClient = service.changementSituation(id, SituationFamiliale.valueOf(situationDto.getSituationFamilialle().getValue()), situationDto.getNombreEnfants());
        if (connaissanceClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapToDto(connaissanceClient.get()));
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<ConnaissanceClientDto> changerAdresse(UUID id, AdresseDto adresseDto) {
        Optional<ConnaissanceClient> connaissanceClient = service.changementAdresse(id, mapToDomain(adresseDto));
        if (connaissanceClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapToDto(connaissanceClient.get()));
    }

    private ConnaissanceClientDto mapToDto(ConnaissanceClient connaissanceClient) {
        ConnaissanceClientDto connaissanceClientDto = new ConnaissanceClientDto();
        connaissanceClientDto.setId(connaissanceClient.getId());
        connaissanceClientDto.setPrenom(connaissanceClient.getPrenom());
        connaissanceClientDto.setLigne1(connaissanceClient.getAdresse().getLigne1());
        connaissanceClientDto.setSituationFamilialle(SituationFamilialleDto.fromValue(connaissanceClient.getSituationFamiliale().toString()));
        connaissanceClientDto.setNombreEnfants(connaissanceClient.getNombreEnfants());
        return connaissanceClientDto;
    }

    @Override
    public ResponseEntity<Void> deleteConnaissanceClient(UUID id) {
        service.supprimerClient(id);
        return ResponseEntity.ok().build();
    }

    private ConnaissanceClient mapToDomain(ConnaissanceClientInDto connaissanceClientDto) {
        return ConnaissanceClient.of(
                connaissanceClientDto.getNom(),
                connaissanceClientDto.getPrenom(),
                Adresse.of(
                        null,
                        null,
                        null,
                        null
                ),
                SituationFamiliale.valueOf(connaissanceClientDto.getSituationFamilialle().getValue()),
                connaissanceClientDto.getNombreEnfants()
        );
    }

    private Adresse mapToDomain(AdresseDto adresseDto) {
        return Adresse.of(
                adresseDto.getLigne1(),
                adresseDto.getLigne2(),
                adresseDto.getCodePostal(),
                adresseDto.getVille()
        );
    }
}
