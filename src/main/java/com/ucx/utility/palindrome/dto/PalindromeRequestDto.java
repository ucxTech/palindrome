package com.ucx.utility.palindrome.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PalindromeRequestDto {
    @NotBlank
    private String text;
}
