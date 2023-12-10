package com.marvis.mylibrary.data.dto.request;


import com.marvis.mylibrary.data.model.Author;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @NotBlank(message = "title field is required")
    private String title;

    @NotBlank(message = "subject field is required")
    private String subject;

    private Author author;

    @Pattern(regexp = "^ISBN:\\s?978[ -]?\\d{1,5}[ -]?\\d{1,7}[ -]?\\d{1,7}[ -]?\\d{1,7}[ -]?\\d{1,8}$")
    @NotBlank(message = "isbn field is required")
    private String isbn;

    @NotBlank(message = "publication year field is required")
    private LocalDate yearOfPublication;
}
