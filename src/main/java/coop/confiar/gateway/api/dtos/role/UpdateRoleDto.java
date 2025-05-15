package coop.confiar.gateway.api.dtos.role;

import coop.confiar.utilities.helpers.RegexHelper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleDto {
    @NotBlank(message = "The 'Name' field isn't blank.")
    @Size(min = 3, max = 16, message = "The size of 'Name' field must be between 3 and 16 characters.")
    @Pattern(regexp = RegexHelper.LETTERS_WITH_ACCENTS_PATTERN, message = "The 'Name' field must contain only letters and spaces (accents allowed).")
    private String Name;

    @NotNull(message = "The 'Status' field isn't nullable.")
    private Boolean Status;
}
