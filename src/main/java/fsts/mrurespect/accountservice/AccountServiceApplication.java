package fsts.mrurespect.accountservice;

import fsts.mrurespect.accountservice.clients.CustomerRestClient;
import fsts.mrurespect.accountservice.entity.Account;
import fsts.mrurespect.accountservice.enums.AccountType;
import fsts.mrurespect.accountservice.model.Customer;
import fsts.mrurespect.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
  @Bean
  CommandLineRunner run(@Autowired AccountRepository accountRepository,@Autowired CustomerRestClient customerRestClient){

      return args -> {
          List<Customer> customers=customerRestClient.allCustomers().getContent().stream().toList();
          customers.forEach(customer -> {
              // we create two accounts for each customer
              Account account1=Account.builder()
                      .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVINGS_ACCOUNT)
                      .balance(Math.random()*1000+1000)
                      .currency("USD")
                      .id(UUID.randomUUID().toString())
                      .createDate(new java.util.Date())
                      .customerId(customer.getId())
                      .build();

              Account account2=Account.builder()
                      .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVINGS_ACCOUNT)
                      .balance(Math.random()*1000+1000)
                      .currency("USD")
                      .id(UUID.randomUUID().toString())
                      .createDate(new java.util.Date())
                      .customerId(customer.getId())
                      .build();
              accountRepository.saveAll(List.of(account1,account2));
          });
      };
    }
}
