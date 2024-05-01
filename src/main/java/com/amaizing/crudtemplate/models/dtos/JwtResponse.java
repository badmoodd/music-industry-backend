package com.amaizing.crudtemplate.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {

    private String accessToken;
    private Date expirationTime;
}