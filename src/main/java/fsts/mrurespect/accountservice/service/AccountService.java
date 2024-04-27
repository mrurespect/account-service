package fsts.mrurespect.accountservice.service;

import fsts.mrurespect.accountservice.dto.AccountRequestDto;
import fsts.mrurespect.accountservice.dto.AccountResponseDto;
import fsts.mrurespect.accountservice.entity.Account;
import fsts.mrurespect.accountservice.exception.account.AccountNotFoundException;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(String id) throws AccountNotFoundException;
    AccountResponseDto addAccount(AccountRequestDto account);
    Account updateAccount(Account account) throws AccountNotFoundException;
    boolean deleteAccount(String id) throws AccountNotFoundException;
}
