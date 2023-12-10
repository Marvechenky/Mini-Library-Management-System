package com.marvis.mylibrary.data.dto.request;

import com.marvis.mylibrary.data.model.Gender;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {

    private String title;
    private String firstName;
    private String lastName;
    private Gender gender;

}
