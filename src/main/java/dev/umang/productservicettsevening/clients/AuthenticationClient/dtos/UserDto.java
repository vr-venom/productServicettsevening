package dev.umang.productservicettsevening.clients.AuthenticationClient.dtos;


import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class UserDto {
    private String email;
    private Set<Role> roles = new HashSet<>();
}
