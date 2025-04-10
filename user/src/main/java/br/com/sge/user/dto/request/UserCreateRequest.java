package br.com.sge.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
    @NotBlank(message = "O primeiro nome é obrigatório")
    @Size(min = 2, max = 80, message = "O primeiro nome deve ter entre 2 e 80 caracteres")
    String firstName,
    @NotBlank(message = "O sobrenome é obrigatório")
    @Size(min = 2, max = 80, message = "O sobrenome deve ter entre 2 e 80 caracteres")
    String lastName,
    @NotBlank(message = "E-mail é obrigatório")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
        message = "Email inválido")
    String email,
    @NotBlank(message = "Telefone não pode ser vazio")
    @Pattern(regexp = "^[1-9]{2}9?\\d{8}$",
        message = "Formato de telefone inválido")
    @Size(min = 12, max = 15, message = "O telefone deve ter entre 12 e 15 caracteres")
    String phone,
    @NotBlank(message = "Senha não pode ser vazia")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,24}$",
        message = "Senha deve ter entre 8 e 24 caracteres, incluindo pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial")
    @Size(min = 8, max = 24, message = "A senha deve ter entre 8 e 24 caracteres")
    String password
) {

}
