package com.marvis.mylibrary.data.dto.response;

import com.marvis.mylibrary.data.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String fullName;
    private Gender gender;
    private String email;

}
