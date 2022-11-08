package com.sqli.workshop.ddd.connaissance.client.db;

import com.sqli.workshop.ddd.connaissance.client.domain.enums.SituationFamiliale;
import com.sqli.workshop.ddd.connaissance.client.domain.models.Adresse;
import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.TestCase.*;

public class ConnaissanceClientDbMapperTest {

    private static ConnaissanceClientDbMapper mapper;

    @BeforeClass
    public static void init() {
        mapper = new ConnaissanceClientDbMapperImpl();
    }

    @Test
    public void mapFromDomain_without_ligne2() {
        ConnaissanceClient cc = ConnaissanceClient.of(
                "Bousquet",
                "Philippe",
                Adresse.of(
                        "48 rue bauducheu",
                        "33800",
                        "Bordeaux"
                ),
                SituationFamiliale.CELIBATAIRE,
                0
        );
        ConnaissanceClientDb ccdb = mapper.mapFromDomain(cc);
        assertEquals(cc.getId(), ccdb.getId());
        assertEquals(cc.getNom(), ccdb.getNom());
        assertEquals(cc.getPrenom(), ccdb.getPrenom());
        assertEquals(cc.getAdresse().getLigne1(), ccdb.getLigne1());
        assertNull(ccdb.getLigne2());
        assertEquals(cc.getAdresse().getCodePostal(), ccdb.getCodePostal());
        assertEquals(cc.getAdresse().getVille(), ccdb.getVille());
        assertEquals(cc.getSituationFamiliale().toString(), ccdb.getSituationFamiliale());
        assertEquals(cc.getNombreEnfants(), ccdb.getNombreEnfants());
    }

    @Test
    public void mapFromDomain_with_ligne2() {
        ConnaissanceClient cc = ConnaissanceClient.of(
                "Bousquet",
                "Philippe",
                Adresse.of(
                        "48 rue bauducheu",
                        "Ligne2",
                        "33800",
                        "Bordeaux"
                ),
                SituationFamiliale.CELIBATAIRE,
                0
        );
        ConnaissanceClientDb ccdb = mapper.mapFromDomain(cc);
        assertEquals(cc.getId(), ccdb.getId());
        assertEquals(cc.getNom(), ccdb.getNom());
        assertEquals(cc.getPrenom(), ccdb.getPrenom());
        assertEquals(cc.getAdresse().getLigne1(), ccdb.getLigne1());
        assertEquals(cc.getAdresse().getLigne2().orElseThrow(), ccdb.getLigne2());
        assertEquals(cc.getAdresse().getCodePostal(), ccdb.getCodePostal());
        assertEquals(cc.getAdresse().getVille(), ccdb.getVille());
        assertEquals(cc.getSituationFamiliale().toString(), ccdb.getSituationFamiliale());
        assertEquals(cc.getNombreEnfants(), ccdb.getNombreEnfants());
    }

    @Test
    public void mapToDomain_without_ligne2() {
        ConnaissanceClientDb ccdb = new ConnaissanceClientDb();
        ccdb.setId(UUID.randomUUID());
        ccdb.setNom("Bousquet");
        ccdb.setPrenom("Philippe");
        ccdb.setLigne1("48 rue bauducheu");
        ccdb.setCodePostal("33800");
        ccdb.setVille("Bordeaux");
        ccdb.setSituationFamiliale("CELIBATAIRE");
        ccdb.setNombreEnfants(0);
        ConnaissanceClient cc = mapper.mapToDomain(ccdb);
        assertEquals(ccdb.getId(), cc.getId());
        assertEquals(ccdb.getNom(), cc.getNom());
        assertEquals(ccdb.getPrenom(), cc.getPrenom());
        assertEquals(ccdb.getLigne1(), cc.getAdresse().getLigne1());
        assertTrue(cc.getAdresse().getLigne2().isEmpty());
        assertEquals(ccdb.getCodePostal(), cc.getAdresse().getCodePostal());
        assertEquals(ccdb.getVille(), cc.getAdresse().getVille());
        assertEquals(ccdb.getSituationFamiliale(), cc.getSituationFamiliale().toString());
        assertEquals(ccdb.getNombreEnfants(), cc.getNombreEnfants());
    }

    @Test
    public void mapToDomain_with_ligne2() {
        ConnaissanceClientDb ccdb = new ConnaissanceClientDb();
        ccdb.setId(UUID.randomUUID());
        ccdb.setNom("Bousquet");
        ccdb.setPrenom("Philippe");
        ccdb.setLigne1("48 rue bauducheu");
        ccdb.setLigne2("Ligne 2");
        ccdb.setCodePostal("33800");
        ccdb.setVille("Bordeaux");
        ccdb.setSituationFamiliale("CELIBATAIRE");
        ccdb.setNombreEnfants(0);
        ConnaissanceClient cc = mapper.mapToDomain(ccdb);
        assertEquals(ccdb.getId(), cc.getId());
        assertEquals(ccdb.getNom(), cc.getNom());
        assertEquals(ccdb.getPrenom(), cc.getPrenom());
        assertEquals(ccdb.getLigne1(), cc.getAdresse().getLigne1());
        assertEquals(ccdb.getLigne2(), cc.getAdresse().getLigne2().orElseThrow());
        assertEquals(ccdb.getCodePostal(), cc.getAdresse().getCodePostal());
        assertEquals(ccdb.getVille(), cc.getAdresse().getVille());
        assertEquals(ccdb.getSituationFamiliale(), cc.getSituationFamiliale().toString());
        assertEquals(ccdb.getNombreEnfants(), cc.getNombreEnfants());
    }

}