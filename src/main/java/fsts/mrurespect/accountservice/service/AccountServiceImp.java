package fsts.mrurespect.accountservice.service;


import fsts.mrurespect.accountservice.dto.AccountRequestDto;
import fsts.mrurespect.accountservice.dto.AccountResponseDto;
import fsts.mrurespect.accountservice.entity.Account;
import fsts.mrurespect.accountservice.exception.account.AccountNotFoundException;
import fsts.mrurespect.accountservice.mapper.AccountMapper;
import fsts.mrurespect.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    public Account getAccountById(String id) throws AccountNotFoundException {
        return accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException(String.format("Account with ID  %s not found",id)));
    }

    @Override
    public AccountResponseDto addAccount(AccountRequestDto accountDto) {
        Account account = AccountMapper.mapToEntity(accountDto);
        account.setId(UUID.randomUUID().toString());
        Account savedAccount = accountRepository.save(account);
          return AccountMapper.mapToDto(savedAccount);
    }

    @Override
    public Account updateAccount(Account account) throws AccountNotFoundException {
        if (accountRepository.findById(account.getId()).isEmpty())
            throw new AccountNotFoundException(String.format("Account with ID  %s not found",account.getId()));
        return accountRepository.save(account);
    }

    @Override
    public boolean deleteAccount(String id) throws AccountNotFoundException {
        try {
            accountRepository.deleteById(id);
        }catch (Exception e){
            throw new AccountNotFoundException(String.format("Account with ID  %s not found",id));
        }
        return true;
    }
}
