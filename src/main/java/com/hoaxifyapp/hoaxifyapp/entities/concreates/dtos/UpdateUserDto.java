package com.hoaxifyapp.hoaxifyapp.entities.concreates.dtos;

import lombok.Data;

@Data
public class UpdateUserDto {
    private String displayName;
    private String password;
}
