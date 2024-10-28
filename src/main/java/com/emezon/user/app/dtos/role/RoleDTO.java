package com.emezon.user.app.dtos.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RoleDTO {
    private String id;
    private String name;
    private String description;
}
