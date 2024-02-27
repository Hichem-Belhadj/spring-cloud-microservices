package com.hbtheme.accountservice.models;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
