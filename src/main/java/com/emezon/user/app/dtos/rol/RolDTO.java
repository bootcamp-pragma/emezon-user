package com.emezon.user.app.dtos.rol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RolDTO {
    private String id;
    private String name;
    private String description;
}
