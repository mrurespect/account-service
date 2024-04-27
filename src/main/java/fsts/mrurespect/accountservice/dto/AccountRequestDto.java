package fsts.mrurespect.accountservice.dto;

import fsts.mrurespect.accountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AccountRequestDto {
    private String currency;
    private AccountType accountType ;
    private Double balance;
}
