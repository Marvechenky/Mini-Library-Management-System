package com.marvis.mylibrary.data.dto.request;


import com.marvis.mylibrary.data.model.Author;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private Long id;

    @NotBlank(message = "title field is required")
    private String title;

    private Author author;

    @NotBlank(message = "isbn field is required")
    private String isbn;

    @NotBlank(message = "publication year field is required")
    private LocalDate yearOfPublication;
}
