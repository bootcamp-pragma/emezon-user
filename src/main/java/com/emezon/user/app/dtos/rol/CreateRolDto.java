package com.emezon.user.app.dtos.rol;

import com.emezon.user.domain.constants.RolConstraints;
import com.emezon.user.domain.constants.RolErrorMessages;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRolDto {

    @NotNull(message = RolErrorMessages.ROL_NAME_REQUIRED)
    @Length(max = RolConstraints.ROL_NAME_MAX_LENGTH, message = RolErrorMessages.ROL_NAME_TOO_LONG)
    private String name;

    @NotNull(message = RolErrorMessages.ROL_DESCRIPTION_REQUIRED)
    @Length(max = RolConstraints.ROL_DESCRIPTION_MAX_LENGTH, message = RolErrorMessages.ROL_DESCRIPTION_TOO_LONG)
    private String description;

}
