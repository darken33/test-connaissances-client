package com.sqli.workshop.ddd.connaissance.client.api;

import com.sqli.workshop.ddd.connaissance.client.domain.ConnaissanceClientService;
import com.sqli.workshop.ddd.connaissance.client.domain.enums.SituationFamiliale;
import com.sqli.workshop.ddd.connaissance.client.domain.models.Adresse;
import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.*;
import com.sqli.workshop.ddd.connaissance.client.generated.api.server.ConnaissanceClientApiDelegate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static junit.framework.TestCase.*;

public class ConnaissanceClientDelegateTest {

  private ConnaissanceClientService service;
  private ConnaissanceClientApiDelegate controller;

  private static Object answerNouveauClient(InvocationOnMock invocationOnMock) {
    return invocationOnMock.getArgument(0);
  }

  private static Object answerChangerAdresse(InvocationOnMock invocationOnMock) {
     ConnaissanceClient cc = ConnaissanceClient.of(
                invocationOnMock.getArgument(0),
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
    cc.setAdresse(invocationOnMock.getArgument(1));
    return Optional.of(cc);
  }

  private static Object answerChangerSituation(InvocationOnMock invocationOnMock) {
     ConnaissanceClient cc = ConnaissanceClient.of(
                invocationOnMock.getArgument(0),
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
    cc.setSituationFamiliale(invocationOnMock.getArgument(1));
    cc.setNombreEnfants(invocationOnMock.getArgument(2));
    return Optional.of(cc);
  }

    @Before
    public void init() {
        service = mock(ConnaissanceClientService.class);
        controller = new ConnaissanceClientDelegate(service);
    }

    @Test
    public void given_listerClients_return_data_should_return_data() {
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
        List<ConnaissanceClient> ccList = new ArrayList<>();
        ccList.add(cc);
        when(service.listerClients()).thenReturn(ccList);
        // WHEN
        ResponseEntity<List<ConnaissanceClientDto>> result = controller.getConnaissanceClients();
        // THEN
        assertEquals(HttpStatus.OK, result.getStatusCode());
        List<ConnaissanceClientDto> ccDtoList = result.getBody();
        assertNotNull(ccDtoList);
        assertEquals(1, ccDtoList.size());
        ConnaissanceClientDto ccDto = ccDtoList.get(0);
        assertNotNull(ccDto.getId());
        assertEquals("Bousquet", ccDto.getNom());
        assertEquals("Philippe", ccDto.getPrenom());
        assertEquals("48 rue bauducheu", ccDto.getLigne1());
        assertNull(ccDto.getLigne2());
        assertEquals("33800", ccDto.getCodePostal());
        assertEquals("Bordeaux", ccDto.getVille());
        assertEquals(SituationFamilialleDto.CELIBATAIRE, ccDto.getSituationFamilialle());
        assertEquals(0, ccDto.getNombreEnfants().intValue());
        verify(service).listerClients();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void given_listerClients_return_nodata_should_return_nodata() {
        // GIVEN
        List<ConnaissanceClient> ccList = new ArrayList<>();
        when(service.listerClients()).thenReturn(ccList);
        // WHEN
        ResponseEntity<List<ConnaissanceClientDto>> result = controller.getConnaissanceClients();
        // THEN
        assertEquals(HttpStatus.OK, result.getStatusCode());
        List<ConnaissanceClientDto> ccDtoList = result.getBody();
        assertNotNull(ccDtoList);
        assertEquals(0, ccDtoList.size());
        verify(service).listerClients();
        verifyNoMoreInteractions(service);
    }

    @Test
    public void given_informationsClient_return_data_should_return_data() {
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
        when(service.informationsClient(any())).thenReturn(Optional.of(cc));
        // WHEN
        ResponseEntity<ConnaissanceClientDto> result = controller.getConnaissanceClient(UUID.randomUUID());
        // THEN
        assertEquals(HttpStatus.OK, result.getStatusCode());
        ConnaissanceClientDto ccDto = result.getBody();
        assertNotNull(ccDto);
        assertNotNull(ccDto.getId());
        assertEquals("Bousquet", ccDto.getNom());
        assertEquals("Philippe", ccDto.getPrenom());
        assertEquals("48 rue bauducheu", ccDto.getLigne1());
        assertNull(ccDto.getLigne2());
        assertEquals("33800", ccDto.getCodePostal());
        assertEquals("Bordeaux", ccDto.getVille());
        assertEquals(SituationFamilialleDto.CELIBATAIRE, ccDto.getSituationFamilialle());
        assertEquals(0, ccDto.getNombreEnfants().intValue());
        verify(service).informationsClient(any());
        verifyNoMoreInteractions(service);
    }

    @Test
    public void given_informationsClient_return_nodata_should_return_not_found() {
        // GIVEN
        when(service.informationsClient(any())).thenReturn(Optional.empty());
        // WHEN
        ResponseEntity<ConnaissanceClientDto> result = controller.getConnaissanceClient(UUID.randomUUID());
        // THEN
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        ConnaissanceClientDto ccDto = result.getBody();
        assertNull(ccDto);
        verify(service).informationsClient(any());
        verifyNoMoreInteractions(service);
    }

    @Test
    public void given_nouveauClient_return_data_should_return_not_found() {
        // GIVEN
        ConnaissanceClientInDto ccDto = new ConnaissanceClientInDto();
        ccDto.setNom("Bousquet");
        ccDto.setPrenom("Philippe");
        ccDto.setLigne1("48 rue bauducheu");
        ccDto.setCodePostal("33800");
        ccDto.setVille("Bordeaux");
        ccDto.setSituationFamilialle(SituationFamilialleDto.CELIBATAIRE);
        ccDto.setNombreEnfants(0);
        when(service.nouveauClient(any())).thenAnswer(ConnaissanceClientDelegateTest::answerNouveauClient);
        // WHEN
        ResponseEntity<ConnaissanceClientDto> result = controller.saveConnaissanceClient(ccDto);
        // THEN
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        ConnaissanceClientDto ccDtoR = result.getBody();
        assertNotNull(ccDtoR);
        assertNotNull(ccDtoR.getId());
        verify(service).nouveauClient(any());
        verifyNoMoreInteractions(service);
    }

    @Test
    public void when_deleteConnaissanceClient_should_trigger_supprimerClient() {
        // WHEN
        ResponseEntity<Void> result = controller.deleteConnaissanceClient(UUID.randomUUID());
        // THEN
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(service).supprimerClient(any());
        verifyNoMoreInteractions(service);
    }

    @Test
    public void when_changerAdresse_should_trigger_changerAdresse() {
      AdresseDto adr = new AdresseDto();
      adr.setLigne1("48 rue bauducheu");
      adr.setLigne2("Ligne 2");
      adr.setCodePostal("33800");
      adr.setVille("Bordeaux");
      when(service.changementAdresse(any(), any())).thenAnswer(ConnaissanceClientDelegateTest::answerChangerAdresse);
        // WHEN
        ResponseEntity<ConnaissanceClientDto> result = controller.changerAdresse(UUID.randomUUID(), adr);
        // THEN
        assertEquals(HttpStatus.OK, result.getStatusCode());
        var ccDto = result.getBody();
        assertNotNull(ccDto);
        assertEquals("Ligne 2", ccDto.getLigne2());
        verify(service).changementAdresse(any(), any());
        verifyNoMoreInteractions(service);
    }

    @Test
    public void when_changerSituation_should_trigger_changerSituation() {
      SituationDto sit = new SituationDto();
      sit.setSituationFamilialle(SituationFamilialleDto.MARIE);
      sit.setNombreEnfants(1);
      when(service.changementSituation(any(), any(), anyInt())).thenAnswer(ConnaissanceClientDelegateTest::answerChangerSituation);
        // WHEN
        ResponseEntity<ConnaissanceClientDto> result = controller.changerSituation(UUID.randomUUID(), sit);
        // THEN
        assertEquals(HttpStatus.OK, result.getStatusCode());
        var ccDto = result.getBody();
        assertNotNull(ccDto);
        assertEquals(SituationFamilialleDto.MARIE, ccDto.getSituationFamilialle());
        assertEquals(1, ccDto.getNombreEnfants().intValue());
        verify(service).changementSituation(any(), any(), anyInt());
        verifyNoMoreInteractions(service);
    }
}
