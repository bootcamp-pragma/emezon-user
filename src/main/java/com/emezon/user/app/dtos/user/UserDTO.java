package com.emezon.user.app.dtos.user;

import com.emezon.user.app.dtos.role.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String lastName;
    private String docNumber;
    private String cellphone;
    private LocalDate birthdate;
    private String email;
    private RoleDTO role;
}
