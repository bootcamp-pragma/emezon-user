package com.emezon.user.app.dtos.user;

import com.emezon.user.domain.constants.UserConstraints;
import com.emezon.user.domain.constants.UserErrorMessages;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuxBodegaDTO {

    @NotNull(message = UserErrorMessages.USER_NAME_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_NAME_NOT_BLANK)
    private String name;

    @NotNull(message = UserErrorMessages.USER_LASTNAME_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_LASTNAME_NOT_BLANK)
    private String lastName;

    @NotNull(message = UserErrorMessages.USER_DOC_NUMBER_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_DOC_NUMBER_NOT_BLANK)
    @Pattern(regexp = UserConstraints.CELLPHONE_REGEX, message = UserErrorMessages.USER_DOC_NUMBER_INVALID)
    private String docNumber;

    @NotNull(message = UserErrorMessages.USER_CELLPHONE_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_CELLPHONE_NOT_BLANK)
    private String cellphone;

    @NotNull(message = UserErrorMessages.USER_BIRTHDATE_REQUIRED)
    @Pattern(regexp = UserConstraints.DATE_REGEX, message = UserErrorMessages.USER_BIRTHDATE_INVALID)
    @JsonFormat(pattern = UserConstraints.DATE_PATTERN, shape = JsonFormat.Shape.STRING)
    private LocalDate birthdate;

    @NotNull(message = UserErrorMessages.USER_EMAIL_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_EMAIL_NOT_BLANK)
    @Pattern(regexp = UserConstraints.EMAIL_REGEX, message = UserErrorMessages.USER_EMAIL_INVALID)
    private String email;

    @NotNull(message = UserErrorMessages.USER_PASSWORD_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_PASSWORD_NOT_BLANK)
    @Min(value = UserConstraints.PASSWORD_MIN_LENGTH, message = UserErrorMessages.USER_PASSWORD_TOO_SHORT)
    private String password;

}
