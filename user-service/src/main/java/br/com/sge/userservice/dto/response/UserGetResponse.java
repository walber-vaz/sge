package br.com.sge.userservice.dto.response;

import java.util.UUID;

public record UserGetResponse(
    UUID id,
    String firstName,
    String lastName,
    String email,
    String phone
) {

}
