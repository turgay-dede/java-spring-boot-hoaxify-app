package com.hoaxifyapp.hoaxifyapp.entities.concreates;

import com.hoaxifyapp.hoaxifyapp.business.utilities.annotations.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Column(name = "username")
    @UniqueUsername
    private String username;

    @NotBlank
    @Column(name = "display_name")
    private String displayName;

    @NotBlank
    @Size(min = 6, max = 20)
    @Column(name = "password")
    private String password;
}
