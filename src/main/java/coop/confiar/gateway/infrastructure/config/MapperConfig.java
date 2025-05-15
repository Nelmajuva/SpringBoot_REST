package coop.confiar.gateway.infrastructure.config;

import coop.confiar.gateway.application.mappers.IRoleMapper;

import org.mapstruct.factory.Mappers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public IRoleMapper roleMapper() {
        return Mappers.getMapper(IRoleMapper.class);
    }
}
