package com.marvis.mylibrary.data.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "users")/*, uniqueConstraints = {@UniqueConstraint(columnNames = "email")})*/
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;


    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String LastName;


    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;


    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

}
