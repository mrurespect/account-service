package fsts.mrurespect.accountservice.web;

import fsts.mrurespect.accountservice.dto.AccountRequestDto;
import fsts.mrurespect.accountservice.dto.AccountResponseDto;
import fsts.mrurespect.accountservice.entity.Account;
import fsts.mrurespect.accountservice.exception.account.AccountNotFoundException;
import fsts.mrurespect.accountservice.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQlController {
    private final AccountService accountService;

    public AccountGraphQlController(AccountService accountService) {
        this.accountService = accountService;
    }

    @QueryMapping
    public List<Account> accountList() {
        return accountService.getAllAccounts();
    }
    @QueryMapping
    public Account account(@Argument  String  id) throws AccountNotFoundException {
        return accountService.getAccountById(id);
    }

    @MutationMapping
    public AccountResponseDto addAccount(@Argument AccountRequestDto account){
        return accountService.addAccount(account);
    }
    @MutationMapping
    public Account updateAccount(@Argument Account account) throws AccountNotFoundException {
        return accountService.updateAccount(account);
    }
    @MutationMapping
    public boolean deleteAccount(@Argument String id) throws AccountNotFoundException {
        return accountService.deleteAccount(id);
    }

}
