package dev.umang.productservicettsevening.clients.AuthenticationClient.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenResponseDtos {
    private UserDto userDto;
    private SessionStatus sessionStatus;

}
