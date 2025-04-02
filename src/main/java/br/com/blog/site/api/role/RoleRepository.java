package br.com.blog.site.api.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.site.shared.domain.Role;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, BigInteger> {
    Optional<Role> findByName(String name);
}
