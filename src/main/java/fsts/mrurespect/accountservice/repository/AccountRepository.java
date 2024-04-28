package fsts.mrurespect.accountservice.repository;
import fsts.mrurespect.accountservice.entity.Account;
import fsts.mrurespect.accountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, String> {
    @RestResource
    List<Account> findByAccountType(AccountType accountType);
}
