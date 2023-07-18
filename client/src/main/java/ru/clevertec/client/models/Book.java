package ru.clevertec.client.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    private long id;
    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;
    @NotBlank
    @Column(name = "author", nullable = false)
    private String author;
}
