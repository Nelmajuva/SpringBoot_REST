package coop.confiar.gateway.domain.services;

import coop.confiar.gateway.api.dtos.role.CreateRoleDto;
import coop.confiar.gateway.api.dtos.role.RoleDto;
import coop.confiar.gateway.api.dtos.role.UpdateRoleDto;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Optional<RoleDto> save(CreateRoleDto createRoleDto);
    Optional<RoleDto> update(int id, UpdateRoleDto updateRoleDto);
    List<RoleDto> findAll();
}
