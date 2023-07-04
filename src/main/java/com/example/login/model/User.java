package com.example.login.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class User {
    @Id   //Primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    private String username;
    private String password;
    private String email;
    private String role; //ROLE_USER, ROME_ADMIN
    //@CreationTimestamp
    //private Timestamp createDate;
}
