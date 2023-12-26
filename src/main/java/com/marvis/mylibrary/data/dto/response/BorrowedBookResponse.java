package com.marvis.mylibrary.data.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BorrowedBookResponse {
    private String subject;
    private String bookName;
    private String bookAuthor;
}
