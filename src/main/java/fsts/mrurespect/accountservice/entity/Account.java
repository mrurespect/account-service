package fsts.mrurespect.accountservice.entity;

import fsts.mrurespect.accountservice.enums.AccountType;
import fsts.mrurespect.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
    @Id
    private  String id ;
    private Date createDate;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType ;
    private Double balance;

    @Transient
    private Customer customer;

    private Long customerId;

}
