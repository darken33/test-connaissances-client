package com.sqli.workshop.ddd.connaissance.client.domain.models;

import com.sqli.workshop.ddd.connaissance.client.domain.enums.SituationFamiliale;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.*;

public class ConnaissanceClientTest {

  @Test
  public void allargsconstructor_will_return_ok() {
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
    assertNotNull(cc.getId());
    assertNotNull(cc.getNom());
    assertNotNull(cc.getPrenom());
    assertNotNull(cc.getAdresse());
    assertNotNull(cc.getSituationFamiliale());
    assertNotNull(cc.getNom());
  }

  @Test
  public void sort_connaissanceclient_on_fields_nom_prenom() {
    ConnaissanceClient cc0 = ConnaissanceClient.of(
            "Bousquet",
            "Thierry",
            Adresse.of(
                    "Adresse 1",
                    "33600",
                    "Pessac"
            ),
            SituationFamiliale.MARIE,
            2
    );
    ConnaissanceClient cc1 = ConnaissanceClient.of(
            "Cesar Ceballos",
            "Dulce",
            Adresse.of(
                    "Adresse 2",
                    "33680",
                    "Lacanau"
            ),
            SituationFamiliale.MARIE,
            1
    );
    ConnaissanceClient cc2 = ConnaissanceClient.of(
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
    List<ConnaissanceClient> connaissanceClientList = new ArrayList<>();
    connaissanceClientList.add(cc0);
    connaissanceClientList.add(cc1);
    connaissanceClientList.add(cc2);
    var liste = connaissanceClientList.stream().sorted().collect(Collectors.toList());
    assertEquals(3, liste.size());
    assertEquals("Philippe", liste.get(0).getPrenom());
    assertEquals("Thierry", liste.get(1).getPrenom());
    assertEquals("Dulce", liste.get(2).getPrenom());
  }

}
