package com.marvis.mylibrary.data.dto.request;

import com.marvis.mylibrary.data.model.Gender;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Long id;

    @Pattern(regexp = "^[a-zA-Z\\d_+&*-]+(?:\\.[a-zA-Z\\d_+&*-]+)*@(?:[a-zA-Z\\d-]+\\.)+[a-zA-Z]{2,7}$",
            message = "Invalid email address")
    @Email(message = "Email field is required")
    private String email;

    @NotBlank(message = "First name field is required")
    @Length(min = 6)
    private String firstName;

    @NotBlank(message = "Last name field is required")
    @Length(min = 6)
    private String LastName;

    private Gender gender;

    @Min(value = 18, message = "Must be 18 or older")
    @Max(value = 70, message = "Cannot be more than 70 years old")
    private int age;

    @NotBlank(message = "Address field is required")
    private String address;


    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }
}
