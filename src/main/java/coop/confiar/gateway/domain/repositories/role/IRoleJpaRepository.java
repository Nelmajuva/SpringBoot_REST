package coop.confiar.gateway.domain.repositories.role;

import coop.confiar.gateway.domain.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface IRoleJpaRepository extends JpaRepository<Role, Integer> {
    @Query("SELECT r FROM Role r WHERE LOWER(r.Name) = LOWER(:name)")
    Optional<Role> findByNameIgnoreCase(@Param("name") String name);
}
