package fsts.mrurespect.accountservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import fsts.mrurespect.accountservice.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

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
   // @Setter
   // @Getter
   // @ManyToOne
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   // private Customer customer;

}
