package ua.galkin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    @NotNull(message = "name is required.")
    @Size(min = 5, message = "name-surename must be not less than 5 symbols.")
    private String name;

    @NotNull(message = "login is required.")
    @Size(min = 3, message = "login must be not less than 5 symbols.")
    @Pattern(regexp = "[a-zA-z]+", message = "Login must include only english symbols.")
    private String login;

    @NotNull(message = "password is required.")
    @Size(min = 5, message = "password must be not less than 5 symbols.")
    private String password;
}
