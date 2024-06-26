package br.com.blog.cursinho.api.role;

import br.com.blog.cursinho.shared.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, BigInteger> {
    Optional<Role> findByName(String name);
}
