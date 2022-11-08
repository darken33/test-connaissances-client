package com.sqli.workshop.ddd.connaissance.client.domain.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Optional;

/**
 * Objet Métier representant une adresse postale
 */
@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
@ToString
@Getter
public class Adresse implements Serializable {

  @NonNull
  final String ligne1;

  String ligne2;

  @NonNull
  final String codePostal;

  @NonNull
  final String ville;

  /**
   * Surcharge du getter pour renvoyer un optional
   */
  public Optional<String> getLigne2() {
    return Optional.ofNullable(ligne2);
  }
}
