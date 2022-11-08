/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.sqli.workshop.ddd.connaissance.client.generated.api.server;

import com.sqli.workshop.ddd.connaissance.client.generated.api.model.AdresseDto;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.ApiErrorResponseDto;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.ConnaissanceClientDto;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.ConnaissanceClientInDto;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.SituationDto;
import java.util.UUID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "ConnaissanceClient", description = "the ConnaissanceClient API")
public interface ConnaissanceClientApi {

    default ConnaissanceClientApiDelegate getDelegate() {
        return new ConnaissanceClientApiDelegate() {};
    }

    /**
     * PUT /v1/connaissance-clients/{id}/adresse : Changement d&#39;addresse du client
     * Changement d&#39;addresse du client 
     *
     * @param id identifiant (required)
     * @param adresseDto  (required)
     * @return Réponse pour une requête valide (retour d&#39;une fiche de connaissance client) (status code 200)
     *         or Invalid Request (status code 400)
     *         or Not Found (status code 404)
     *         or Unexpected server error (status code 500)
     */
    @Operation(
        operationId = "changerAdresse",
        summary = "Changement d'addresse du client",
        tags = { "ConnaissanceClient" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Réponse pour une requête valide (retour d'une fiche de connaissance client)", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConnaissanceClientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            })
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/v1/connaissance-clients/{id}/adresse",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ConnaissanceClientDto> changerAdresse(
        @Parameter(name = "id", description = "identifiant", required = true) @PathVariable("id") UUID id,
        @Parameter(name = "AdresseDto", description = "", required = true) @Valid @RequestBody AdresseDto adresseDto
    ) {
        return getDelegate().changerAdresse(id, adresseDto);
    }


    /**
     * PUT /v1/connaissance-clients/{id}/situation : Changement de situation du client
     * Changement de situation du client 
     *
     * @param id identifiant (required)
     * @param situationDto  (required)
     * @return Réponse pour une requête valide (retour d&#39;une fiche de connaissance client) (status code 200)
     *         or Invalid Request (status code 400)
     *         or Not Found (status code 404)
     *         or Unexpected server error (status code 500)
     */
    @Operation(
        operationId = "changerSituation",
        summary = "Changement de situation du client",
        tags = { "ConnaissanceClient" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Réponse pour une requête valide (retour d'une fiche de connaissance client)", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConnaissanceClientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            })
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/v1/connaissance-clients/{id}/situation",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ConnaissanceClientDto> changerSituation(
        @Parameter(name = "id", description = "identifiant", required = true) @PathVariable("id") UUID id,
        @Parameter(name = "SituationDto", description = "", required = true) @Valid @RequestBody SituationDto situationDto
    ) {
        return getDelegate().changerSituation(id, situationDto);
    }


    /**
     * DELETE /v1/connaissance-clients/{id} : Suppression d&#39;une fiche de connaissance client
     * Suppression d&#39;une fiche de connaissance client via son id 
     *
     * @param id identifiant (required)
     * @return Suppression de la fiche effectuée (status code 200)
     *         or Invalid Request (status code 400)
     *         or Not Found (status code 404)
     *         or Unexpected server error (status code 500)
     */
    @Operation(
        operationId = "deleteConnaissanceClient",
        summary = "Suppression d'une fiche de connaissance client",
        tags = { "ConnaissanceClient" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Suppression de la fiche effectuée"),
            @ApiResponse(responseCode = "400", description = "Invalid Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            })
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/v1/connaissance-clients/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> deleteConnaissanceClient(
        @Parameter(name = "id", description = "identifiant", required = true) @PathVariable("id") UUID id
    ) {
        return getDelegate().deleteConnaissanceClient(id);
    }


    /**
     * GET /v1/connaissance-clients/{id} : Accès en lecture à une fiche de connaissance client
     * Accès à une fiche de connaissance client via son id 
     *
     * @param id identifiant (required)
     * @return Réponse pour une requête valide (retour d&#39;une fiche de connaissance client) (status code 200)
     *         or Invalid Request (status code 400)
     *         or Not Found (status code 404)
     *         or Unexpected server error (status code 500)
     */
    @Operation(
        operationId = "getConnaissanceClient",
        summary = "Accès en lecture à une fiche de connaissance client",
        tags = { "ConnaissanceClient" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Réponse pour une requête valide (retour d'une fiche de connaissance client)", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConnaissanceClientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Unexpected server error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            })
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/v1/connaissance-clients/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<ConnaissanceClientDto> getConnaissanceClient(
        @Parameter(name = "id", description = "identifiant", required = true) @PathVariable("id") UUID id
    ) {
        return getDelegate().getConnaissanceClient(id);
    }


    /**
     * GET /v1/connaissance-clients : Liste des fiches de connaissance client
     * liste des fiches de connaissance client 
     *
     * @return Réponse pour une requête valide (status code 200)
     *         or Invalid Request (status code 400)
     *         or Access forbidden (status code 401)
     *         or Access denied (status code 403)
     *         or Conflict (status code 409)
     */
    @Operation(
        operationId = "getConnaissanceClients",
        summary = "Liste des fiches de connaissance client",
        tags = { "ConnaissanceClient" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Réponse pour une requête valide", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConnaissanceClientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Access forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "403", description = "Access denied", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "409", description = "Conflict", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/v1/connaissance-clients",
        produces = { "application/json" }
    )
    default ResponseEntity<List<ConnaissanceClientDto>> getConnaissanceClients(
        
    ) {
        return getDelegate().getConnaissanceClients();
    }


    /**
     * POST /v1/connaissance-clients : Accès en écriture à une fiche de connaissance client
     * Ecriture d&#39;une fiche de connaissance client (création ou mise à jour). 
     *
     * @param connaissanceClientInDto La fiche de connaissance client à enregister (required)
     * @return Réponse pour une requête valide (création ou mise à jour d&#39;une fiche de connaissance client) (status code 201)
     *         or Invalid Request (status code 400)
     *         or Access forbidden (status code 401)
     *         or Access denied (status code 403)
     *         or Conflict (status code 409)
     */
    @Operation(
        operationId = "saveConnaissanceClient",
        summary = "Accès en écriture à une fiche de connaissance client",
        tags = { "ConnaissanceClient" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Réponse pour une requête valide (création ou mise à jour d'une fiche de connaissance client)", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConnaissanceClientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "401", description = "Access forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "403", description = "Access denied", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            }),
            @ApiResponse(responseCode = "409", description = "Conflict", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            })
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/v1/connaissance-clients",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ConnaissanceClientDto> saveConnaissanceClient(
        @Parameter(name = "ConnaissanceClientInDto", description = "La fiche de connaissance client à enregister", required = true) @Valid @RequestBody ConnaissanceClientInDto connaissanceClientInDto
    ) {
        return getDelegate().saveConnaissanceClient(connaissanceClientInDto);
    }

}