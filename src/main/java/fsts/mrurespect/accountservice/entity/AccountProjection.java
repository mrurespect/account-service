package fsts.mrurespect.accountservice.entity;

import fsts.mrurespect.accountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Account.class},name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getAccountType();
}
