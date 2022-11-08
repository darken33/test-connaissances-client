package com.sqli.workshop.ddd.connaissance.client.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;
import com.sqli.workshop.ddd.connaissance.client.domain.ports.ConnaissanceClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConnaissanceClientRepositoryImpl implements ConnaissanceClientRepository {

    private final ConnaissanceClientDbRepository dbRepository;
    private final ConnaissanceClientDbMapper mapper;

    @Override
    public ConnaissanceClient save(ConnaissanceClient connaissanceClient) {
        ConnaissanceClientDb connaissanceClientDb = mapper.mapFromDomain(connaissanceClient);
        return mapper.mapToDomain(connaissanceClientDb);
    }

    @Override
    public Optional<ConnaissanceClient> findById(UUID id) {
        Optional<ConnaissanceClientDb> connaissanceClientDb = dbRepository.findById(id);
        return connaissanceClientDb.map(mapper::mapToDomain);
    }

    @Override
    public List<ConnaissanceClient> findAll() {
        List<ConnaissanceClientDb> connaissanceClientDbs = new ArrayList<>();
        return connaissanceClientDbs.stream().map(mapper::mapToDomain).collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        dbRepository.deleteById(id);
    }
}
