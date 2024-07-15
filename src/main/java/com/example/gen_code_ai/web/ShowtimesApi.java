/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.gen_code_ai.web;

import com.example.gen_code_ai.dto.MoviesIdPut500Response;
import com.example.gen_code_ai.dto.Showtime;
import com.example.gen_code_ai.dto.ShowtimesIdGet404Response;
import com.example.gen_code_ai.dto.ShowtimesIdPut409Response;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-15T11:36:25.960018+07:00[Asia/Ho_Chi_Minh]")
@Validated
@Tag(name = "Showtimes", description = "the Showtimes API")
public interface ShowtimesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /showtimes : List all showtimes
     *
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "showtimesGet",
        summary = "List all showtimes",
        tags = { "Showtimes" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Showtime.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/showtimes",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Showtime>> showtimesGet(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"theaterId\" : 1, \"price\" : 5.962133916683182, \"showtimeId\" : 0, \"movieId\" : 6, \"startTime\" : \"2000-01-23T04:56:07.000+00:00\", \"endTime\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"theaterId\" : 1, \"price\" : 5.962133916683182, \"showtimeId\" : 0, \"movieId\" : 6, \"startTime\" : \"2000-01-23T04:56:07.000+00:00\", \"endTime\" : \"2000-01-23T04:56:07.000+00:00\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /showtimes/{id} : Delete a specific showtime
     *
     * @param id  (required)
     * @return No Content (status code 204)
     *         or The specified showtime was not found (status code 404)
     *         or An internal server error occurred (status code 500)
     */
    @Operation(
        operationId = "showtimesIdDelete",
        summary = "Delete a specific showtime",
        tags = { "Showtimes" },
        responses = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "The specified showtime was not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ShowtimesIdGet404Response.class))
            }),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = MoviesIdPut500Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/showtimes/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> showtimesIdDelete(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /showtimes/{id} : Get details of a specific showtime
     *
     * @param id  (required)
     * @return OK (status code 200)
     *         or The specified showtime was not found (status code 404)
     */
    @Operation(
        operationId = "showtimesIdGet",
        summary = "Get details of a specific showtime",
        tags = { "Showtimes" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Showtime.class))
            }),
            @ApiResponse(responseCode = "404", description = "The specified showtime was not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ShowtimesIdGet404Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/showtimes/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Showtime> showtimesIdGet(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"theaterId\" : 1, \"price\" : 5.962133916683182, \"showtimeId\" : 0, \"movieId\" : 6, \"startTime\" : \"2000-01-23T04:56:07.000+00:00\", \"endTime\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /showtimes/{id} : Update details of a specific showtime
     *
     * @param id  (required)
     * @param showtime  (required)
     * @return OK (status code 200)
     *         or The specified showtime was not found (status code 404)
     *         or A showtime with the same ID already exists (status code 409)
     *         or An internal server error occurred (status code 500)
     */
    @Operation(
        operationId = "showtimesIdPut",
        summary = "Update details of a specific showtime",
        tags = { "Showtimes" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Showtime.class))
            }),
            @ApiResponse(responseCode = "404", description = "The specified showtime was not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ShowtimesIdGet404Response.class))
            }),
            @ApiResponse(responseCode = "409", description = "A showtime with the same ID already exists", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ShowtimesIdPut409Response.class))
            }),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = MoviesIdPut500Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/showtimes/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Showtime> showtimesIdPut(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "Showtime", description = "", required = true) @Valid @RequestBody Showtime showtime
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"theaterId\" : 1, \"price\" : 5.962133916683182, \"showtimeId\" : 0, \"movieId\" : 6, \"startTime\" : \"2000-01-23T04:56:07.000+00:00\", \"endTime\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /showtimes : Create a new showtime
     *
     * @param showtime  (required)
     * @return Created (status code 201)
     */
    @Operation(
        operationId = "showtimesPost",
        summary = "Create a new showtime",
        tags = { "Showtimes" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Showtime.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/showtimes",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Showtime> showtimesPost(
        @Parameter(name = "Showtime", description = "", required = true) @Valid @RequestBody Showtime showtime
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"theaterId\" : 1, \"price\" : 5.962133916683182, \"showtimeId\" : 0, \"movieId\" : 6, \"startTime\" : \"2000-01-23T04:56:07.000+00:00\", \"endTime\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
