package com.sqli.workshop.ddd.connaissance.client.domain;


import com.sqli.workshop.ddd.connaissance.client.domain.enums.SituationFamiliale;
import com.sqli.workshop.ddd.connaissance.client.domain.models.Adresse;
import com.sqli.workshop.ddd.connaissance.client.domain.models.ConnaissanceClient;
import com.sqli.workshop.ddd.connaissance.client.domain.ports.ConnaissanceClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;

import java.util.*;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

public class ConnaissanceClientServiceImplTest {

 private ConnaissanceClientService service;

 private ConnaissanceClientRepository repository;

  private static Object answer(InvocationOnMock invocationOnMock) {
    return invocationOnMock.getArgument(0);
  }

  @Before
 public void init() {
   this.repository = mock(ConnaissanceClientRepository.class);
   this.service = new ConnaissanceClientServiceImpl(repository);
 }

 @Test
 public void given_connaissance_client_not_null_get_should_return_data() {
   // GIVEN
   ConnaissanceClient cc = ConnaissanceClient.of("Bousquet", "Philippe", Adresse.of("48 rue bauducheu", "33800", "Bordeaux"), SituationFamiliale.CELIBATAIRE, 0);
   UUID id = cc.getId();
   when(repository.findById(id)).thenReturn(Optional.of(cc));
   // WHEN
   Optional<ConnaissanceClient> result = service.informationsClient(id);
   // THEN
   assertTrue(result.isPresent());
   assertEquals(id, result.get().getId());
   assertEquals("Bousquet", result.get().getNom());
   verify(repository).findById(id);
 }


  @Test
  public void given_connaissance_client_null_get_should_return_empty() {
    // GIVEN
    UUID id = UUID.randomUUID();
    when(repository.findById(id)).thenReturn(Optional.empty());
    // WHEN
    Optional<ConnaissanceClient> result = service.informationsClient(id);
    // THEN
    assertTrue(result.isEmpty());
    verify(repository).findById(id);
  }


  @Test
  public void given_connaissance_client_save_return_id() {
    // GIVEN
    ConnaissanceClient ccToSave = ConnaissanceClient.of(
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
    when(repository.save(any())).thenReturn(ccToSave);
    // WHEN
    ConnaissanceClient result = service.nouveauClient(ccToSave);
    // THEN
    verify(repository).save(any(ConnaissanceClient.class));
    assertNotNull(result.getId());
    assertEquals("Bousquet", result.getNom());
    assertEquals("Philippe", result.getPrenom());
    assertEquals("48 rue bauducheu", result.getAdresse().getLigne1());
    assertTrue(result.getAdresse().getLigne2().isEmpty());
    assertEquals("33800", result.getAdresse().getCodePostal());
    assertEquals("Bordeaux", result.getAdresse().getVille());
    assertEquals(SituationFamiliale.CELIBATAIRE, result.getSituationFamiliale());
    assertEquals(Integer.valueOf(0), result.getNombreEnfants());
  }

  @Test
  public void given_adresse_save_return_ok() {
    // GIVEN
    Adresse adresse = Adresse.of("lg1", "lg2","33000", "Bordeaux");
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
    UUID id = cc.getId();
    when(repository.findById(id)).thenReturn(Optional.of(cc));
    when(repository.save(any())).thenAnswer(ConnaissanceClientServiceImplTest::answer);
    // WHEN
    Optional<ConnaissanceClient> result = service.changementAdresse(id, adresse);
    // THEN
    assertEquals("lg1", result.get().getAdresse().getLigne1());
    verify(repository).findById(id);
    verify(repository).save(any(ConnaissanceClient.class));
  }

  @Test
  public void given_situation_save_return_ok() {
    // GIVEN
    ConnaissanceClient cc = ConnaissanceClient.of(
            "Bousquet",
            "Philippe",
            Adresse.of(
                    "48 rue bauducheu",
                    null,
                    "33800",
                    "Bordeaux"
            ),
            SituationFamiliale.CELIBATAIRE,
            0
    );
    UUID id = cc.getId();
    when(repository.findById(any())).thenReturn(Optional.of(cc));
    when(repository.save(any())).thenAnswer(ConnaissanceClientServiceImplTest::answer);
    // WHEN
    Optional<ConnaissanceClient> result = service.changementSituation(id, SituationFamiliale.MARIE, 1);
    // THEN
    assertEquals(SituationFamiliale.MARIE, result.get().getSituationFamiliale());
    assertEquals(Integer.valueOf(1), result.get().getNombreEnfants());
    verify(repository).findById(any());
    verify(repository).save(any(ConnaissanceClient.class));
  }

  @Test
  public void given_situation_no_client_save_return_ok() {
    // GIVEN
    when(repository.findById(any())).thenReturn(Optional.empty());
    // WHEN
    Optional<ConnaissanceClient> result = service.changementSituation(UUID.randomUUID(), SituationFamiliale.MARIE, 0);
    // THEN
    assertTrue(result.isEmpty());
    verify(repository).findById(any());
    verifyNoMoreInteractions(repository);
  }

  @Test
  public void given_connaissanceclient_findall_return_list() {
    // GIVEN
    Adresse adresse = Adresse.of("lg1","lg2","33000", "Bordeaux");
    ConnaissanceClient cc = ConnaissanceClient.of("Bousquet", "Philippe", Adresse.of("48 rue bauducheu","33800", "Bordeaux"), SituationFamiliale.CELIBATAIRE, 0);
    List<ConnaissanceClient> list = new ArrayList();
    list.add(cc);
    when(repository.findAll()).thenReturn(list);
    // WHEN
    List<ConnaissanceClient> result = service.listerClients();
    // THEN
    assertEquals(1, result.size());
    verify(repository).findAll();
  }

    @Test
    public void delete_client_return_ok() {
      // WHEN
      service.supprimerClient(UUID.randomUUID());
      // THEN
      verify(repository).delete(any());
    }
}
