package com.sqli.workshop.ddd.connaissance.client.domain.models;

import com.sqli.workshop.ddd.connaissance.client.domain.enums.SituationFamiliale;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.UUID;

/**
 * Objet métier représentant une fiche Client
 */
@FieldDefaults(level= AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
@ToString
@EqualsAndHashCode
@Getter
public class ConnaissanceClient implements Serializable, Comparable {

    @NonNull
    final UUID id;

    @NonNull
    final String nom;

    @NonNull
    final String prenom;

    @NonNull
    @Setter
    Adresse adresse;

    @NonNull
    @Setter
    SituationFamiliale situationFamiliale;

    @NonNull
    @Setter
    Integer nombreEnfants;

    /**
     * Constructeur sans UUID
     */
    public static ConnaissanceClient of(String nom, String prenom, Adresse adresse, SituationFamiliale situationFamiliale, Integer nombreEnfants) {
        return new ConnaissanceClient(UUID.randomUUID(), nom, prenom, adresse, situationFamiliale, nombreEnfants);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof ConnaissanceClient)) return 1;
        var cc = (ConnaissanceClient) o;
        return this.nom.compareTo(cc.nom);
    }
}

