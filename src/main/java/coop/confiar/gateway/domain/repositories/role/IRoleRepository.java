package coop.confiar.gateway.domain.repositories.role;

import coop.confiar.gateway.api.dtos.role.CreateRoleDto;
import coop.confiar.gateway.api.dtos.role.RoleDto;

import java.util.List;
import java.util.Optional;

public interface IRoleRepository {
    Optional<RoleDto> save(CreateRoleDto createRoleDto);
    List<RoleDto> findAll();
}
