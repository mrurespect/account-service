package fsts.mrurespect.accountservice;

import fsts.mrurespect.accountservice.entity.Account;
import fsts.mrurespect.accountservice.enums.AccountType;
import fsts.mrurespect.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
  @Bean
  CommandLineRunner run(@Autowired AccountRepository accountRepository) {
      return args -> {
              for (int i = 0; i < 10; i++) {
                  Account account=Account.builder()
                          .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVINGS_ACCOUNT)
                          .balance(Math.random()*1000+1000)
                          .currency("USD")
                          .id(UUID.randomUUID().toString())
                          .createDate(new java.util.Date())
                          .build();
                  accountRepository.save(account);
              }
                } ;
    }
}
