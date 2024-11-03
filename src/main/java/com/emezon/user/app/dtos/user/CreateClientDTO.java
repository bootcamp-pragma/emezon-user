package com.emezon.user.app.dtos.user;

import com.emezon.user.domain.constants.UserConstraints;
import com.emezon.user.domain.constants.UserErrorMessages;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientDTO {

    @NotNull(message = UserErrorMessages.USER_NAME_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_NAME_NOT_BLANK)
    private String name;

    @NotNull(message = UserErrorMessages.USER_LASTNAME_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_LASTNAME_NOT_BLANK)
    private String lastName;

    @NotNull(message = UserErrorMessages.USER_DOC_NUMBER_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_DOC_NUMBER_NOT_BLANK)
    @Pattern(regexp = UserConstraints.DOC_NUMBER_REGEX, message = UserErrorMessages.USER_DOC_NUMBER_INVALID)
    @Schema(example = "1234567890")
    private String docNumber;

    @NotNull(message = UserErrorMessages.USER_CELLPHONE_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_CELLPHONE_NOT_BLANK)
    @Pattern(regexp = UserConstraints.CELLPHONE_REGEX, message = UserErrorMessages.USER_CELLPHONE_INVALID)
    @Schema(example = "+5712345678")
    private String cellphone;

    @NotNull(message = UserErrorMessages.USER_BIRTHDATE_REQUIRED)
    @JsonFormat(pattern = UserConstraints.DATE_PATTERN, shape = JsonFormat.Shape.STRING)
    private LocalDate birthdate;

    @NotNull(message = UserErrorMessages.USER_EMAIL_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_EMAIL_NOT_BLANK)
    @Pattern(regexp = UserConstraints.EMAIL_REGEX, message = UserErrorMessages.USER_EMAIL_INVALID)
    @Schema(example = "example@mail.com")
    private String email;

    @NotNull(message = UserErrorMessages.USER_PASSWORD_REQUIRED)
    @NotBlank(message = UserErrorMessages.USER_PASSWORD_NOT_BLANK)
    @Size(min = UserConstraints.PASSWORD_MIN_LENGTH, message = UserErrorMessages.USER_PASSWORD_TOO_SHORT)
    private String password;

}
