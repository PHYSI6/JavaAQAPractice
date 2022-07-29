package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserReg {
    private String email;
    private String password;
}
