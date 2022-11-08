package com.sqli.workshop.ddd.connaissance.client.generated.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.SituationFamilialleDto;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SituationDto
 */

@JsonTypeName("Situation")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class SituationDto {

  @JsonProperty("situationFamilialle")
  private SituationFamilialleDto situationFamilialle;

  @JsonProperty("nombreEnfants")
  private Integer nombreEnfants;

  public SituationDto situationFamilialle(SituationFamilialleDto situationFamilialle) {
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

  public SituationDto nombreEnfants(Integer nombreEnfants) {
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
    SituationDto situation = (SituationDto) o;
    return Objects.equals(this.situationFamilialle, situation.situationFamilialle) &&
        Objects.equals(this.nombreEnfants, situation.nombreEnfants);
  }

  @Override
  public int hashCode() {
    return Objects.hash(situationFamilialle, nombreEnfants);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SituationDto {\n");
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

