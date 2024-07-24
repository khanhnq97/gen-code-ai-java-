/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.gen_code_ai.web;

import com.example.gen_code_ai.dto.EmployeeRequest;
import com.example.gen_code_ai.dto.EmployeeResponse;
import com.example.gen_code_ai.dto.UpdateEmployee404Response;
import com.example.gen_code_ai.dto.UpdateEmployee409Response;
import com.example.gen_code_ai.dto.UpdateMovie500Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-23T11:54:56.445739+07:00[Asia/Ho_Chi_Minh]")
@Validated
@Tag(name = "Employees", description = "the Employees API")
public interface EmployeesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /employees : Add a new employee
     *
     * @param employeeRequest  (required)
     * @return Created (status code 201)
     */
    @Operation(
        operationId = "createEmployee",
        summary = "Add a new employee",
        tags = { "Employees" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponse.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/employees",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<EmployeeResponse> createEmployee(
        @Parameter(name = "EmployeeRequest", description = "", required = true) @Valid @RequestBody EmployeeRequest employeeRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"phone\" : \"phone\", \"name\" : \"name\", \"employeeId\" : 0, \"position\" : \"position\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /employees/{id} : Delete an employee (only admin users can perform this action)
     *
     * @param id  (required)
     * @return No Content (status code 204)
     *         or The specified employee was not found (status code 404)
     *         or An internal server error occurred (status code 500)
     */
    @Operation(
        operationId = "deleteEmployee",
        summary = "Delete an employee (only admin users can perform this action)",
        tags = { "Employees" },
        responses = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "The specified employee was not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateEmployee404Response.class))
            }),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateMovie500Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/employees/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> deleteEmployee(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /employees/{id} : Get details of a specific employee
     *
     * @param id  (required)
     * @return OK (status code 200)
     *         or The specified employee was not found (status code 404)
     */
    @Operation(
        operationId = "getEmployeeById",
        summary = "Get details of a specific employee",
        tags = { "Employees" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "The specified employee was not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateEmployee404Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/employees/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<EmployeeResponse> getEmployeeById(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"phone\" : \"phone\", \"name\" : \"name\", \"employeeId\" : 0, \"position\" : \"position\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /employees : List all employees
     *
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "getEmployees",
        summary = "List all employees",
        tags = { "Employees" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EmployeeResponse.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/employees",
        produces = { "application/json" }
    )
    default ResponseEntity<List<EmployeeResponse>> getEmployees(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"password\" : \"password\", \"phone\" : \"phone\", \"name\" : \"name\", \"employeeId\" : 0, \"position\" : \"position\", \"email\" : \"email\" }, { \"password\" : \"password\", \"phone\" : \"phone\", \"name\" : \"name\", \"employeeId\" : 0, \"position\" : \"position\", \"email\" : \"email\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /employees : Update details of a specific employee
     *
     * @param employeeRequest  (required)
     * @return OK (status code 200)
     *         or The specified employee was not found (status code 404)
     *         or An employee with the same email already exists (status code 409)
     *         or An internal server error occurred (status code 500)
     */
    @Operation(
        operationId = "updateEmployee",
        summary = "Update details of a specific employee",
        tags = { "Employees" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "The specified employee was not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateEmployee404Response.class))
            }),
            @ApiResponse(responseCode = "409", description = "An employee with the same email already exists", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateEmployee409Response.class))
            }),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateMovie500Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/employees",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<EmployeeResponse> updateEmployee(
        @Parameter(name = "EmployeeRequest", description = "", required = true) @Valid @RequestBody EmployeeRequest employeeRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"password\" : \"password\", \"phone\" : \"phone\", \"name\" : \"name\", \"employeeId\" : 0, \"position\" : \"position\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
