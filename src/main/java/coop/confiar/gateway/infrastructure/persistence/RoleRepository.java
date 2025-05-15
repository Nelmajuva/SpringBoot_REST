package coop.confiar.gateway.infrastructure.persistence;

import coop.confiar.gateway.api.dtos.role.CreateRoleDto;
import coop.confiar.gateway.api.dtos.role.RoleDto;
import coop.confiar.gateway.api.dtos.role.UpdateRoleDto;
import coop.confiar.gateway.application.mappers.IRoleMapper;
import coop.confiar.gateway.domain.repositories.role.IRoleRepository;
import coop.confiar.gateway.domain.repositories.role.IRoleJpaRepository;

import coop.confiar.utilities.exceptions.EntityAlreadyExistsException;
import coop.confiar.utilities.exceptions.EntityNoExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleRepository implements IRoleRepository {
    @Autowired
    private final IRoleJpaRepository roleJpaRepository;

    @Autowired
    private final IRoleMapper roleMapper;

    public RoleRepository(IRoleJpaRepository roleJpaRepository, IRoleMapper roleMapper) {
        this.roleJpaRepository = roleJpaRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public Optional<RoleDto> save(CreateRoleDto createRoleDto) {
        var existRoleWithSameName = roleJpaRepository.findByNameIgnoreCase(createRoleDto.getName()).isPresent();

        if (existRoleWithSameName) throw new EntityAlreadyExistsException("A role with the same name already exists.");

        var role = this.roleMapper.toEntity(createRoleDto);

        this.roleJpaRepository.save(role);

        return Optional.of(this.roleMapper.toDto(role));
    }

    public Optional<RoleDto> update(int id, UpdateRoleDto updateRoleDto) {
        var existRole = this.roleJpaRepository.findById(id);

        if (existRole.isEmpty()) throw new EntityNoExistsException("A role with the same id does not exist.");

        var existRoleWithSameName = roleJpaRepository.findByNameIgnoreCase(updateRoleDto.getName());

        if (existRoleWithSameName.isPresent() && existRoleWithSameName.get().getId() != id) throw new EntityAlreadyExistsException("A role with the same name already exists.");

        var role = existRole.get();

        this.roleMapper.updateEntityFromDto(updateRoleDto, role);
        this.roleJpaRepository.save(role);

        return Optional.of(this.roleMapper.toDto(role));
    }

    @Override
    public List<RoleDto> findAll() {
        return this.roleJpaRepository.findAll().stream().map(roleMapper::toDto).toList();
    }
}
