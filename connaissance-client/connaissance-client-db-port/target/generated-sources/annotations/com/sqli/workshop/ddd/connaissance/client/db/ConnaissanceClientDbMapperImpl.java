package com.sqli.workshop.ddd.connaissance.client.db;

import com.sqli.workshop.ddd.connaissance.client.domain.models.Adresse;
import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;
import java.util.Optional;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-05T11:49:46+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Amazon.com Inc.)"
)
@Component
public class ConnaissanceClientDbMapperImpl implements ConnaissanceClientDbMapper {

    @Override
    public ConnaissanceClientDb mapFromDomain(ConnaissanceClient cclient) {

        ConnaissanceClientDb connaissanceClientDb = new ConnaissanceClientDb();

        if ( cclient != null ) {
            connaissanceClientDb.setLigne2( map( cclientAdresseLigne2( cclient ) ) );
            connaissanceClientDb.setCodePostal( cclientAdresseCodePostal( cclient ) );
            connaissanceClientDb.setId( cclient.getId() );
            connaissanceClientDb.setNom( cclient.getNom() );
            connaissanceClientDb.setPrenom( cclient.getPrenom() );
            if ( cclient.getSituationFamiliale() != null ) {
                connaissanceClientDb.setSituationFamiliale( cclient.getSituationFamiliale().name() );
            }
            connaissanceClientDb.setNombreEnfants( cclient.getNombreEnfants() );
        }

        return connaissanceClientDb;
    }

    private Optional<String> cclientAdresseLigne2(ConnaissanceClient connaissanceClient) {
        if ( connaissanceClient == null ) {
            return null;
        }
        Adresse adresse = connaissanceClient.getAdresse();
        if ( adresse == null ) {
            return null;
        }
        Optional<String> ligne2 = adresse.getLigne2();
        if ( ligne2 == null ) {
            return null;
        }
        return ligne2;
    }

    private String cclientAdresseCodePostal(ConnaissanceClient connaissanceClient) {
        if ( connaissanceClient == null ) {
            return null;
        }
        Adresse adresse = connaissanceClient.getAdresse();
        if ( adresse == null ) {
            return null;
        }
        String codePostal = adresse.getCodePostal();
        if ( codePostal == null ) {
            return null;
        }
        return codePostal;
    }
}
