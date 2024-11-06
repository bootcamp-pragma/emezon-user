package com.emezon.user.infra.inbound.rest.controllers;

import com.emezon.user.app.dtos.role.RoleDTO;
import com.emezon.user.app.handlers.IRoleHandler;
import com.emezon.user.domain.utils.PaginatedResponse;
import com.emezon.user.infra.inbound.rest.utils.ValidPageableRequest;
import com.emezon.user.infra.inbound.rest.constants.PaginatedConstants;
import com.emezon.user.infra.inbound.rest.constants.RestApiConstants;
import com.emezon.user.infra.outbound.mysql.jpa.entities.RoleEntity;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestApiConstants.API_ROLE)
@RequiredArgsConstructor
public class RolController {

    private final IRoleHandler rolHandler;

    @GetMapping()
    @Parameters({
            @Parameter(name = PaginatedConstants.PARAM_PAGE, description = PaginatedConstants.PARAM_PAGE_DESC, example = PaginatedConstants.PARAM_PAGE_EXAMPLE),
            @Parameter(name = PaginatedConstants.PARAM_SIZE, description = PaginatedConstants.PARAM_SIZE_DESC, example = PaginatedConstants.PARAM_SIZE_EXAMPLE),
            @Parameter(name = PaginatedConstants.PARAM_SORT, description = PaginatedConstants.PARAM_SORT_DESC,
                    array = @ArraySchema(schema = @Schema(type = "string", example = PaginatedConstants.PARAM_SORT_EXAMPLE)))
    })
    public ResponseEntity<PaginatedResponse<RoleDTO>> getRoles(
            @Parameter(hidden = true) @RequestParam @ValidPageableRequest(target = RoleEntity.class) @Valid
            MultiValueMap<String, String> queryParams
    ) {
        return ResponseEntity.ok(rolHandler.getAllRoles(queryParams));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRolById(@PathVariable String id) {
        return ResponseEntity.ok(rolHandler.getRolById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RoleDTO> getRolByName(@PathVariable String name) {
        return ResponseEntity.ok(rolHandler.getRolByName(name));
    }

}
