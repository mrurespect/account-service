package fsts.mrurespect.accountservice.dto;


import fsts.mrurespect.accountservice.enums.AccountType;
import lombok.Builder;

import java.util.Date;

@Builder
public record AccountResponseDto(String id, Date createDate, String currency, AccountType accountType, Double balance) {
}

