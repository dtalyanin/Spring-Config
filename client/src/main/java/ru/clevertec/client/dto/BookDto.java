package ru.clevertec.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookDto {
    @JsonIgnore
    private long id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
}
