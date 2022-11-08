package com.sqli.workshop.ddd.connaissance.client.generated.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * AdresseDto
 */

@JsonTypeName("Adresse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AdresseDto {

  @JsonProperty("ligne1")
  private String ligne1;

  @JsonProperty("ligne2")
  private String ligne2;

  @JsonProperty("codePostal")
  private String codePostal;

  @JsonProperty("ville")
  private String ville;

  public AdresseDto ligne1(String ligne1) {
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

  public AdresseDto ligne2(String ligne2) {
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

  public AdresseDto codePostal(String codePostal) {
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

  public AdresseDto ville(String ville) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdresseDto adresse = (AdresseDto) o;
    return Objects.equals(this.ligne1, adresse.ligne1) &&
        Objects.equals(this.ligne2, adresse.ligne2) &&
        Objects.equals(this.codePostal, adresse.codePostal) &&
        Objects.equals(this.ville, adresse.ville);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ligne1, ligne2, codePostal, ville);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdresseDto {\n");
    sb.append("    ligne1: ").append(toIndentedString(ligne1)).append("\n");
    sb.append("    ligne2: ").append(toIndentedString(ligne2)).append("\n");
    sb.append("    codePostal: ").append(toIndentedString(codePostal)).append("\n");
    sb.append("    ville: ").append(toIndentedString(ville)).append("\n");
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

