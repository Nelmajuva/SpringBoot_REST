package coop.confiar.gateway.infrastructure.config;

import coop.confiar.gateway.application.mappers.IRoleMapper;
import coop.confiar.gateway.application.services.RoleService;
import coop.confiar.gateway.domain.repositories.role.IRoleJpaRepository;
import coop.confiar.gateway.infrastructure.persistence.RoleRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public RoleService roleService(RoleRepository roleRepository) {
        return new RoleService(roleRepository);
    }

    @Bean
    public RoleRepository roleRepository(IRoleJpaRepository roleJpaRepository, IRoleMapper roleMapper) {
        return new RoleRepository(roleJpaRepository, roleMapper);
    }
}
