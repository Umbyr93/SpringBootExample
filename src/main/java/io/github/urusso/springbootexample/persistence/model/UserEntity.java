package io.github.urusso.springbootexample.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
}
