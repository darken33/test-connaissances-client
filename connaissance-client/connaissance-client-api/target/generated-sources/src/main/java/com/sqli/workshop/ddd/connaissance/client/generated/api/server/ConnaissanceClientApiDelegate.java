package com.sqli.workshop.ddd.connaissance.client.generated.api.server;

import com.sqli.workshop.ddd.connaissance.client.generated.api.model.AdresseDto;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.ApiErrorResponseDto;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.ConnaissanceClientDto;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.ConnaissanceClientInDto;
import com.sqli.workshop.ddd.connaissance.client.generated.api.model.SituationDto;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link ConnaissanceClientApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface ConnaissanceClientApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
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
     * @see ConnaissanceClientApi#changerAdresse
     */
    default ResponseEntity<ConnaissanceClientDto> changerAdresse(UUID id,
        AdresseDto adresseDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ligne2\" : \"48 rue bauducheu\", \"ville\" : \"Test Abc\", \"ligne1\" : \"48 rue bauducheu\", \"id\" : \"8a9204f5-aa42-47bc-9f04-17caab5deeee\", \"codePostal\" : \"33800\", \"nom\" : \"Test Abc\", \"prenom\" : \"Test Abc\", \"nombreEnfants\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see ConnaissanceClientApi#changerSituation
     */
    default ResponseEntity<ConnaissanceClientDto> changerSituation(UUID id,
        SituationDto situationDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ligne2\" : \"48 rue bauducheu\", \"ville\" : \"Test Abc\", \"ligne1\" : \"48 rue bauducheu\", \"id\" : \"8a9204f5-aa42-47bc-9f04-17caab5deeee\", \"codePostal\" : \"33800\", \"nom\" : \"Test Abc\", \"prenom\" : \"Test Abc\", \"nombreEnfants\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see ConnaissanceClientApi#deleteConnaissanceClient
     */
    default ResponseEntity<Void> deleteConnaissanceClient(UUID id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see ConnaissanceClientApi#getConnaissanceClient
     */
    default ResponseEntity<ConnaissanceClientDto> getConnaissanceClient(UUID id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ligne2\" : \"48 rue bauducheu\", \"ville\" : \"Test Abc\", \"ligne1\" : \"48 rue bauducheu\", \"id\" : \"8a9204f5-aa42-47bc-9f04-17caab5deeee\", \"codePostal\" : \"33800\", \"nom\" : \"Test Abc\", \"prenom\" : \"Test Abc\", \"nombreEnfants\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see ConnaissanceClientApi#getConnaissanceClients
     */
    default ResponseEntity<List<ConnaissanceClientDto>> getConnaissanceClients() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ligne2\" : \"48 rue bauducheu\", \"ville\" : \"Test Abc\", \"ligne1\" : \"48 rue bauducheu\", \"id\" : \"8a9204f5-aa42-47bc-9f04-17caab5deeee\", \"codePostal\" : \"33800\", \"nom\" : \"Test Abc\", \"prenom\" : \"Test Abc\", \"nombreEnfants\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see ConnaissanceClientApi#saveConnaissanceClient
     */
    default ResponseEntity<ConnaissanceClientDto> saveConnaissanceClient(ConnaissanceClientInDto connaissanceClientInDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"ligne2\" : \"48 rue bauducheu\", \"ville\" : \"Test Abc\", \"ligne1\" : \"48 rue bauducheu\", \"id\" : \"8a9204f5-aa42-47bc-9f04-17caab5deeee\", \"codePostal\" : \"33800\", \"nom\" : \"Test Abc\", \"prenom\" : \"Test Abc\", \"nombreEnfants\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
