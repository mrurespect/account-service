package fsts.mrurespect.accountservice.exception.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountErrorResponce {
    private int status;
    private String message;
    private long timeStamp;
}