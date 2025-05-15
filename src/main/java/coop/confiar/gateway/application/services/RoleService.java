package coop.confiar.gateway.application.services;

import coop.confiar.gateway.api.dtos.role.CreateRoleDto;
import coop.confiar.gateway.api.dtos.role.RoleDto;
import coop.confiar.gateway.api.dtos.role.UpdateRoleDto;
import coop.confiar.gateway.domain.services.IRoleService;
import coop.confiar.gateway.infrastructure.persistence.RoleRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<RoleDto> save(CreateRoleDto createRoleDto) {
        return this.roleRepository.save(createRoleDto);
    }

    public Optional<RoleDto> update(int id, UpdateRoleDto updateRoleDto) {
        return this.roleRepository.update(id, updateRoleDto);
    }

    public List<RoleDto> findAll() {
        return this.roleRepository.findAll();
    }
}
