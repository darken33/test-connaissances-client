package com.sqli.workshop.ddd.connaissance.client.domain.models;

import org.junit.Assert;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

/**
 * Classe de test de l'objet métier Adresse
 */
public class AdresseTest {

  @Test
  public void constructor_with_all_field_will_return_ok() {
    Adresse adr = Adresse.of("lg1", "lg2", "33800", "Bordeaux");
    assertEquals("lg1", adr.getLigne1());
    assertEquals("lg2", adr.getLigne2().orElse(null));
    assertEquals("33800", adr.getCodePostal());
    assertEquals("Bordeaux", adr.getVille());
  }

  @Test
  public void constructor_without_ligne2_will_return_empty_field() {
    Adresse adr = Adresse.of("lg1", "33800", "Bordeaux");
    assertEquals("lg1", adr.getLigne1());
    assertFalse(adr.getLigne2().isPresent());
    assertEquals("33800", adr.getCodePostal());
    assertEquals("Bordeaux", adr.getVille());
  }

  @Test
  public void constructor_without_ligne1_will_throw_exception() {
    Exception exception = Assert.assertThrows(NullPointerException.class, () -> {
    Adresse adr = Adresse.of(null, "lg2", "33800", "Bordeaux");
    });
  }

  @Test
  public void constructor_without_codePostal_will_throw_exception() {
    Exception exception = Assert.assertThrows(NullPointerException.class, () -> {
      Adresse adr = Adresse.of("lg1", "lg2", null, "Bordeaux");
    });
  }

  @Test
  public void constructor_without_ville_will_throw_exception() {
    Exception exception = Assert.assertThrows(NullPointerException.class, () -> {
      Adresse adr = Adresse.of("lg1", "lg2", "33800", null);
    });
  }

}
