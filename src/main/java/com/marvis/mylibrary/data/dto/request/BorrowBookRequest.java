package com.marvis.mylibrary.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowBookRequest {

    @NotBlank(message = "book name field is required")
    private String bookName;

    @NotBlank(message = "author name field is required")
    private String bookAuthor;

    @NotBlank(message = "subject field is required")
    private String subject;

}
