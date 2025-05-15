package coop.confiar.gateway.api.controllers;

import coop.confiar.gateway.api.dtos.role.CreateRoleDto;
import coop.confiar.gateway.api.dtos.role.UpdateRoleDto;
import coop.confiar.gateway.domain.services.IRoleService;
import coop.confiar.utilities.classes.GenericResponse;
import coop.confiar.gateway.api.dtos.role.RoleDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Role")
@Tag(name = "Roles", description = "List of roles available.")
@Validated
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @PostMapping("/")
    @Operation(summary = "Store a new Role.", tags = { "Roles" })
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Role created successfully.") })
    public GenericResponse<Optional<RoleDto>> save(@Valid @RequestBody CreateRoleDto createRoleDto) {
        var role = this.roleService.save(createRoleDto);

        return new GenericResponse<>(201, role);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a role specific.", tags = { "Roles" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Role updated successfully.") })
    public GenericResponse<Optional<RoleDto>> update(@PathVariable int id, @Valid @RequestBody UpdateRoleDto updateRoleDto) {
        var role = this.roleService.update(id, updateRoleDto);

        return new GenericResponse<>(200, role);
    }

    @GetMapping("/")
    @Operation(summary = "Return a list of Role object.", tags = { "Roles" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "The list of Role object.") })
    public GenericResponse<List<RoleDto>> findAll() {
        List<RoleDto> data = this.roleService.findAll();

        return new GenericResponse<>(200, data);
    }
}
