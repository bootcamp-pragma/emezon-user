package com.emezon.user.app.handlers;

import com.emezon.user.app.dtos.role.RoleDTO;
import com.emezon.user.domain.utils.PaginatedResponse;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface IRoleHandler {

    RoleDTO getRolById(String id);

    RoleDTO getRolByName(String name);

    PaginatedResponse<RoleDTO> getAllRoles(MultiValueMap<String, String> queryParams);

}
