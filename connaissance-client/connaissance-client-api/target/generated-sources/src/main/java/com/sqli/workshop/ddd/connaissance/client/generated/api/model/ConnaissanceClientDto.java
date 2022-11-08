package com.sqli.workshop.ddd.connaissance.client.generated.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.SituationFamilialleDto;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ConnaissanceClientDto
 */

@JsonTypeName("ConnaissanceClient")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ConnaissanceClientDto {

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("nom")
  private String nom;

  @JsonProperty("prenom")
  private String prenom;

  @JsonProperty("ligne1")
  private String ligne1;

  @JsonProperty("ligne2")
  private String ligne2;

  @JsonProperty("codePostal")
  private String codePostal;

  @JsonProperty("ville")
  private String ville;

  @JsonProperty("situationFamilialle")
  private SituationFamilialleDto situationFamilialle;

  @JsonProperty("nombreEnfants")
  private Integer nombreEnfants;

  public ConnaissanceClientDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Valid 
  @Schema(name = "id", example = "8a9204f5-aa42-47bc-9f04-17caab5deeee", required = false)
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ConnaissanceClientDto nom(String nom) {
    this.nom = nom;
    return this;
  }

  /**
   * Get nom
   * @return nom
  */
  @NotNull @Pattern(regexp = "^[a-zA-Z ,.'-]+$") @Size(min = 2, max = 50) 
  @Schema(name = "nom", example = "Test Abc", required = true)
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public ConnaissanceClientDto prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

  /**
   * Get prenom
   * @return prenom
  */
  @NotNull @Pattern(regexp = "^[a-zA-Z ,.'-]+$") @Size(min = 2, max = 50) 
  @Schema(name = "prenom", example = "Test Abc", required = true)
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public ConnaissanceClientDto ligne1(String ligne1) {
    this.ligne1 = ligne1;
    return this;
  }

  /**
   * Get ligne1
   * @return ligne1
  */
  @NotNull @Pattern(regexp = "^[a-zA-Z0-9 ,.'-]+$") @Size(min = 2, max = 50) 
  @Schema(name = "ligne1", example = "48 rue bauducheu", required = true)
  public String getLigne1() {
    return ligne1;
  }

  public void setLigne1(String ligne1) {
    this.ligne1 = ligne1;
  }

  public ConnaissanceClientDto ligne2(String ligne2) {
    this.ligne2 = ligne2;
    return this;
  }

  /**
   * Get ligne2
   * @return ligne2
  */
  @Pattern(regexp = "^[a-zA-Z0-9 ,.'-]+$") @Size(min = 2, max = 50) 
  @Schema(name = "ligne2", example = "48 rue bauducheu", required = false)
  public String getLigne2() {
    return ligne2;
  }

  public void setLigne2(String ligne2) {
    this.ligne2 = ligne2;
  }

  public ConnaissanceClientDto codePostal(String codePostal) {
    this.codePostal = codePostal;
    return this;
  }

  /**
   * Get codePostal
   * @return codePostal
  */
  @NotNull @Pattern(regexp = "^[A-Z0-9]+$") @Size(min = 5, max = 5) 
  @Schema(name = "codePostal", example = "33800", required = true)
  public String getCodePostal() {
    return codePostal;
  }

  public void setCodePostal(String codePostal) {
    this.codePostal = codePostal;
  }

  public ConnaissanceClientDto ville(String ville) {
    this.ville = ville;
    return this;
  }

  /**
   * Get ville
   * @return ville
  */
  @NotNull @Pattern(regexp = "^[a-zA-Z ,.'-]+$") @Size(min = 2, max = 50) 
  @Schema(name = "ville", example = "Test Abc", required = true)
  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public ConnaissanceClientDto situationFamilialle(SituationFamilialleDto situationFamilialle) {
    this.situationFamilialle = situationFamilialle;
    return this;
  }

  /**
   * Get situationFamilialle
   * @return situationFamilialle
  */
  @NotNull @Valid 
  @Schema(name = "situationFamilialle", required = true)
  public SituationFamilialleDto getSituationFamilialle() {
    return situationFamilialle;
  }

  public void setSituationFamilialle(SituationFamilialleDto situationFamilialle) {
    this.situationFamilialle = situationFamilialle;
  }

  public ConnaissanceClientDto nombreEnfants(Integer nombreEnfants) {
    this.nombreEnfants = nombreEnfants;
    return this;
  }

  /**
   * Get nombreEnfants
   * minimum: 0
   * maximum: 20
   * @return nombreEnfants
  */
  @NotNull @Min(0) @Max(20) 
  @Schema(name = "nombreEnfants", example = "1", required = true)
  public Integer getNombreEnfants() {
    return nombreEnfants;
  }

  public void setNombreEnfants(Integer nombreEnfants) {
    this.nombreEnfants = nombreEnfants;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnaissanceClientDto connaissanceClient = (ConnaissanceClientDto) o;
    return Objects.equals(this.id, connaissanceClient.id) &&
        Objects.equals(this.nom, connaissanceClient.nom) &&
        Objects.equals(this.prenom, connaissanceClient.prenom) &&
        Objects.equals(this.ligne1, connaissanceClient.ligne1) &&
        Objects.equals(this.ligne2, connaissanceClient.ligne2) &&
        Objects.equals(this.codePostal, connaissanceClient.codePostal) &&
        Objects.equals(this.ville, connaissanceClient.ville) &&
        Objects.equals(this.situationFamilialle, connaissanceClient.situationFamilialle) &&
        Objects.equals(this.nombreEnfants, connaissanceClient.nombreEnfants);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, prenom, ligne1, ligne2, codePostal, ville, situationFamilialle, nombreEnfants);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnaissanceClientDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    ligne1: ").append(toIndentedString(ligne1)).append("\n");
    sb.append("    ligne2: ").append(toIndentedString(ligne2)).append("\n");
    sb.append("    codePostal: ").append(toIndentedString(codePostal)).append("\n");
    sb.append("    ville: ").append(toIndentedString(ville)).append("\n");
    sb.append("    situationFamilialle: ").append(toIndentedString(situationFamilialle)).append("\n");
    sb.append("    nombreEnfants: ").append(toIndentedString(nombreEnfants)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

