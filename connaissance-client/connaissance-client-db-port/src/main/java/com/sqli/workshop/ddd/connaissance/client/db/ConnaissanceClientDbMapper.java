package com.sqli.workshop.ddd.connaissance.client.db;

import com.sqli.workshop.ddd.connaissance.client.domain.enums.SituationFamiliale;
import com.sqli.workshop.ddd.connaissance.client.domain.models.Adresse;
import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;
import org.mapstruct.*;

import java.util.Optional;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface ConnaissanceClientDbMapper {

    @Mapping(source = "adresse.ligne2", target = "ligne2", qualifiedByName = "map")
    @Mapping(source = "adresse.codePostal", target = "codePostal")
    ConnaissanceClientDb mapFromDomain(ConnaissanceClient cclient);

    @Named(value = "map")
    default String map(Optional<String> value) {
        return value.orElse(null);
    }

    default ConnaissanceClient mapToDomain(ConnaissanceClientDb connaissanceClientDb) {
        return ConnaissanceClient.of(
                connaissanceClientDb.getId(),
                connaissanceClientDb.getNom(),
                connaissanceClientDb.getPrenom(),
                Adresse.of(
                        connaissanceClientDb.getLigne1(),
                        connaissanceClientDb.getLigne2(),
                        connaissanceClientDb.getCodePostal(),
                        connaissanceClientDb.getVille()
                ),
                SituationFamiliale.valueOf(connaissanceClientDb.getSituationFamiliale()),
                connaissanceClientDb.getNombreEnfants()
        );
    }

}