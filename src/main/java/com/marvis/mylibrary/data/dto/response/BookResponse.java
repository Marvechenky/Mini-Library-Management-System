package com.marvis.mylibrary.data.dto.response;

import com.marvis.mylibrary.data.model.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String title;
    private String subject;
    private String authorFullName;
    private LocalDate yearOfPublication;
}
