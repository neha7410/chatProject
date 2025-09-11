package com.myPersonalChatProject.chatProject.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length=100)
    private String username;
    private String firstName;
    private String lastName;

    @Column(nullable = false, length = 100)
    private String password;
    private String email;
}
