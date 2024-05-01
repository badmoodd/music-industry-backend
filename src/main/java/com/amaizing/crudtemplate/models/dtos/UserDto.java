package com.amaizing.crudtemplate.models.dtos;

import com.amaizing.crudtemplate.models.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String email;
    private String username;
    private UserRole role;
}
