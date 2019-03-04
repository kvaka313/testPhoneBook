package ua.galkin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneBookRecordDto {

    private String recordId;

    @NotNull(message = "name is required.")
    @Size(min = 4, message = "name-surename must be not less than 4 symbols.")
    private String name;

    @NotNull(message = "middleName is required.")
    @Size(min = 4, message = "middleName must be not less than 4 symbols.")
    private String middleName;

    @NotNull(message = "surename is required.")
    @Size(min = 4, message = "surename must be not less than 4 symbols.")
    private String surename;

    @NotNull(message = "mobilePhone is required.")
    @Pattern(regexp = "\\+380\\(\\d{2}\\)\\d{7}", message = "mobilePhone must have format +380(XX)XXXXXXX.")
    private String mobilePhone;

    @Pattern(regexp = "\\+380\\(\\d{2}\\)\\d{7}", message = "mobilePhone must have format +380(XX)XXXXXXX.")
    private String home_phone;

    private String address;

    @Email(message = "email does not satisfy the standard for electronic addresses.")
    private String email;

}
