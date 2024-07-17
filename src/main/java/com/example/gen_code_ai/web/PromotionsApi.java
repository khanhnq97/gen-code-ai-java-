/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.gen_code_ai.web;

import com.example.gen_code_ai.dto.Promotion;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-17T10:31:45.710274+07:00[Asia/Ho_Chi_Minh]")
@Validated
@Tag(name = "Promotions", description = "the Promotions API")
public interface PromotionsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /promotions : List all promotions
     *
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "promotionsGet",
        summary = "List all promotions",
        tags = { "Promotions" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Promotion.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/promotions",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Promotion>> promotionsGet(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"discountPercent\" : 0.2, \"endDate\" : \"2024-08-31T23:59:59Z\", \"name\" : \"Summer Sale\", \"description\" : \"Get 20% off all items!\", \"promotionId\" : 1, \"startDate\" : \"2024-07-15T00:00:00Z\" }, { \"discountPercent\" : 0.2, \"endDate\" : \"2024-08-31T23:59:59Z\", \"name\" : \"Summer Sale\", \"description\" : \"Get 20% off all items!\", \"promotionId\" : 1, \"startDate\" : \"2024-07-15T00:00:00Z\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /promotions/{id} : Delete a promotion
     *
     * @param id  (required)
     * @return No Content (status code 204)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "promotionsIdDelete",
        summary = "Delete a promotion",
        tags = { "Promotions" },
        responses = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Not Found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/promotions/{id}"
    )
    default ResponseEntity<Void> promotionsIdDelete(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /promotions/{id} : Get details of a specific promotion
     *
     * @param id  (required)
     * @return OK (status code 200)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "promotionsIdGet",
        summary = "Get details of a specific promotion",
        tags = { "Promotions" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Promotion.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/promotions/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Promotion> promotionsIdGet(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"discountPercent\" : 0.2, \"endDate\" : \"2024-08-31T23:59:59Z\", \"name\" : \"Summer Sale\", \"description\" : \"Get 20% off all items!\", \"promotionId\" : 1, \"startDate\" : \"2024-07-15T00:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /promotions/{id} : Update an existing promotion
     *
     * @param id  (required)
     * @param promotion  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "promotionsIdPut",
        summary = "Update an existing promotion",
        tags = { "Promotions" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Promotion.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/promotions/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Promotion> promotionsIdPut(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
        @Parameter(name = "Promotion", description = "", required = true) @Valid @RequestBody Promotion promotion
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"discountPercent\" : 0.2, \"endDate\" : \"2024-08-31T23:59:59Z\", \"name\" : \"Summer Sale\", \"description\" : \"Get 20% off all items!\", \"promotionId\" : 1, \"startDate\" : \"2024-07-15T00:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /promotions : Create a new promotion
     *
     * @param promotion  (required)
     * @return Created (status code 201)
     */
    @Operation(
        operationId = "promotionsPost",
        summary = "Create a new promotion",
        tags = { "Promotions" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Promotion.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/promotions",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Promotion> promotionsPost(
        @Parameter(name = "Promotion", description = "", required = true) @Valid @RequestBody Promotion promotion
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"discountPercent\" : 0.2, \"endDate\" : \"2024-08-31T23:59:59Z\", \"name\" : \"Summer Sale\", \"description\" : \"Get 20% off all items!\", \"promotionId\" : 1, \"startDate\" : \"2024-07-15T00:00:00Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
