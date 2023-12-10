package com.marvis.mylibrary.data.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @NotBlank(message = "title field is required")
    private String title;

    @NotBlank(message = "subject field is required")
    private String subject;

    @NotBlank(message = "author full name field is required")
    private String authorFullName;

    @Pattern(regexp = "^ISBN:\\s?978[ -]?\\d{1,5}[ -]?\\d{1,7}[ -]?\\d{1,7}[ -]?\\d{1,7}[ -]?\\d{1,8}$")
    @NotBlank(message = "isbn field is required")
    private String isbn;

    private LocalDate yearOfPublication;
}
