package com.emezon.user.app.dtos.role;

import com.emezon.user.domain.constants.RoleConstraints;
import com.emezon.user.domain.constants.RoleErrorMessages;
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
public class CreateRoleDto {

    @NotNull(message = RoleErrorMessages.ROL_NAME_REQUIRED)
    @Length(max = RoleConstraints.ROL_NAME_MAX_LENGTH, message = RoleErrorMessages.ROL_NAME_TOO_LONG)
    private String name;

    @NotNull(message = RoleErrorMessages.ROL_DESCRIPTION_REQUIRED)
    @Length(max = RoleConstraints.ROL_DESCRIPTION_MAX_LENGTH, message = RoleErrorMessages.ROL_DESCRIPTION_TOO_LONG)
    private String description;

}
