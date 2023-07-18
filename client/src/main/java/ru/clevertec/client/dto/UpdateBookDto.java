package ru.clevertec.client.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateBookDto {
    @NotBlank
    private String title;
    @NotBlank
    private String author;
}
