package br.com.blog.site.api.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.site.shared.domain.Account;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, BigInteger> {
    Optional<Account> findByEmail(String email);
}
