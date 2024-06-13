package br.com.blog.cursinho.api.account;

import br.com.blog.cursinho.shared.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, BigInteger> {
    Optional<Account> findByEmail(String email);
}
