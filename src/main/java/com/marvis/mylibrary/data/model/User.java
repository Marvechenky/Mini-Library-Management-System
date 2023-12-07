package com.marvis.mylibrary.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z\\d_+&*-]+(?:\\.[a-zA-Z\\d_+&*-]+)*@(?:[a-zA-Z\\d-]+\\.)+[a-zA-Z]{2,7}$", message = "Invalid email address")
    @Email(message = "Email field is required")
    private String email;

    @NotBlank(message = "First name field is required")
    @Column(name = "first_name")
    @Min(6)
    private String firstName;

    @NotBlank(message = "Last name field is required")
    @Column(name = "last_name")
    @Min(value = 15)
    private String LastName;

    @NotBlank(message = "Gender field is required")
    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "age")
    @Min(value = 18, message = "Must be 18 or older")
    @Max(value = 70, message = "Cannot be more than 70 years old")
    private int age;

    @NotBlank(message = "Address field is required")
    @Column(name = "address")
    private String address;
}
