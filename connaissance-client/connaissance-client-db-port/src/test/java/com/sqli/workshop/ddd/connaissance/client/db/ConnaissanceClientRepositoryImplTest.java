package com.sqli.workshop.ddd.connaissance.client.db;

import com.sqli.workshop.ddd.connaissance.client.domain.enums.SituationFamiliale;
import com.sqli.workshop.ddd.connaissance.client.domain.models.Adresse;
import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;
import com.sqli.workshop.ddd.connaissance.client.domain.ports.ConnaissanceClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static junit.framework.TestCase.*;

public class ConnaissanceClientRepositoryImplTest {

    private ConnaissanceClientDbRepository repository;
    private ConnaissanceClientRepository service;

  private static Object answer(InvocationOnMock invocationOnMock) {
    return invocationOnMock.getArgument(0);
  }

    @Before
    public void init() {
        repository = mock(ConnaissanceClientDbRepository.class);
        service = new ConnaissanceClientRepositoryImpl(
            repository,
            new ConnaissanceClientDbMapperImpl()
        );
    }

    @Test
    public void given_repository_findById_return_data_should_return_data() {
        // GIVEN
        UUID ccUuid = UUID.randomUUID();
        ConnaissanceClientDb ccdb = new ConnaissanceClientDb();
        ccdb.setId(ccUuid);
        ccdb.setNom("Bousquet");
        ccdb.setPrenom("Philippe");
        ccdb.setLigne1("48 rue bauducheu");
        ccdb.setCodePostal("33800");
        ccdb.setVille("Bordeaux");
        ccdb.setSituationFamiliale("CELIBATAIRE");
        ccdb.setNombreEnfants(0);
        when(repository.findById(ccUuid)).thenReturn(Optional.of(ccdb));
        // WHEN
        Optional<ConnaissanceClient> ccOpt = service.findById(ccUuid);
        // THEN
        assertTrue(ccOpt.isPresent());
        var cc = ccOpt.get();
        assertEquals(ccdb.getId(), cc.getId());
        assertEquals(ccdb.getNom(), cc.getNom());
        assertEquals(ccdb.getPrenom(), cc.getPrenom());
        assertEquals(ccdb.getLigne1(), cc.getAdresse().getLigne1());
        assertTrue(cc.getAdresse().getLigne2().isEmpty());
        assertEquals(ccdb.getCodePostal(), cc.getAdresse().getCodePostal());
        assertEquals(ccdb.getVille(), cc.getAdresse().getVille());
        assertEquals(ccdb.getSituationFamiliale(), cc.getSituationFamiliale().toString());
        assertEquals(ccdb.getNombreEnfants(), cc.getNombreEnfants());
        verify(repository).findById(ccUuid);
    }

    @Test
    public void given_repository_findById_return_empty_should_return_empty() {
        // GIVEN
        UUID ccUuid = UUID.randomUUID();
        when(repository.findById(ccUuid)).thenReturn(Optional.empty());
        // WHEN
        Optional<ConnaissanceClient> ccOpt = service.findById(ccUuid);
        // THEN
        assertTrue(ccOpt.isEmpty());
        verify(repository).findById(ccUuid);
    }

    @Test
    public void given_repository_findAll_return_data_should_return_data() {
        // GIVEN
        UUID ccUuid = UUID.randomUUID();
        ConnaissanceClientDb ccdb = new ConnaissanceClientDb();
        ccdb.setId(ccUuid);
        ccdb.setNom("Bousquet");
        ccdb.setPrenom("Philippe");
        ccdb.setLigne1("48 rue bauducheu");
        ccdb.setCodePostal("33800");
        ccdb.setVille("Bordeaux");
        ccdb.setSituationFamiliale("CELIBATAIRE");
        ccdb.setNombreEnfants(0);
        List<ConnaissanceClientDb> ccdbList = new ArrayList<>();
        ccdbList.add(ccdb);
        when(repository.findAll()).thenReturn(ccdbList);
        // WHEN
        List<ConnaissanceClient> ccList = service.findAll();
        // THEN
        assertEquals(1, ccList.size());
        var cc = ccList.get(0);
        assertEquals(ccdb.getId(), cc.getId());
        assertEquals(ccdb.getNom(), cc.getNom());
        assertEquals(ccdb.getPrenom(), cc.getPrenom());
        assertEquals(ccdb.getLigne1(), cc.getAdresse().getLigne1());
        assertTrue(cc.getAdresse().getLigne2().isEmpty());
        assertEquals(ccdb.getCodePostal(), cc.getAdresse().getCodePostal());
        assertEquals(ccdb.getVille(), cc.getAdresse().getVille());
        assertEquals(ccdb.getSituationFamiliale(), cc.getSituationFamiliale().toString());
        assertEquals(ccdb.getNombreEnfants(), cc.getNombreEnfants());
        verify(repository).findAll();
    }

    @Test
    public void given_repository_findAll_return_empty_should_return_empty() {
        // GIVEN
        when(repository.findAll()).thenReturn(new ArrayList<>());
        // WHEN
        var ccList = service.findAll();
        // THEN
        assertTrue(ccList.isEmpty());
        verify(repository).findAll();
    }

    @Test
    public void given_repository_save_triggered_should_return_data() {
        // GIVEN
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
        when(repository.save(any())).thenAnswer(ConnaissanceClientRepositoryImplTest::answer);
        // WHEN
        var cc2 = service.save(cc);
        // THEN
        assertEquals(cc.getId(),cc2.getId());
        verify(repository).save(any());
    }

    @Test
    public void given_repository_delete_triggered() {
        // WHEN
        service.delete(UUID.randomUUID());
        // THEN
        verify(repository).deleteById(any());
    }

}