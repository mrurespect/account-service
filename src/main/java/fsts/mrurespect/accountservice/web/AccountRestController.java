package fsts.mrurespect.accountservice.web;

import fsts.mrurespect.accountservice.dto.AccountRequestDto;
import fsts.mrurespect.accountservice.dto.AccountResponseDto;
import fsts.mrurespect.accountservice.entity.Account;
import fsts.mrurespect.accountservice.exception.account.AccountNotFoundException;
import fsts.mrurespect.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id) throws AccountNotFoundException {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<AccountResponseDto> addAccount(@RequestBody AccountRequestDto account) {
        return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/accounts")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) throws AccountNotFoundException {
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id) throws AccountNotFoundException {
        accountService.deleteAccount(id);
        return new ResponseEntity<>("account deleted successfully", HttpStatus.OK);
    }
}