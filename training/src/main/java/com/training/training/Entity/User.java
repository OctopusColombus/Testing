package com.training.training.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "user")
@Data
public class User {

    @Id
    private Long id;
    private String nama;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
    

    

}
