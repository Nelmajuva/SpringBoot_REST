package coop.confiar.gateway.application.mappers;

import coop.confiar.gateway.api.dtos.role.CreateRoleDto;
import coop.confiar.gateway.api.dtos.role.RoleDto;
import coop.confiar.gateway.api.dtos.role.UpdateRoleDto;
import coop.confiar.gateway.domain.entities.Role;

import org.mapstruct.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface IRoleMapper {
    default void updateEntityFromDto(UpdateRoleDto updateRoleDto, Role role) {
        role.setName(updateRoleDto.getName());
        role.setStatus(updateRoleDto.getStatus());
        role.setUpdatedAt(LocalDateTime.now());
    }

    default RoleDto toDto(Role role) {
        var roleDto = new RoleDto();

        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        roleDto.setStatus(role.isStatus());

        return roleDto;
    }

    default Role toEntity(CreateRoleDto createRoleDto) {
        var role = new Role();
        var localDateTime = LocalDateTime.now();

        role.setName(createRoleDto.getName());
        role.setCreatedAt(localDateTime);
        role.setUpdatedAt(localDateTime);
        role.setStatus(true);

        return role;
    }
}
