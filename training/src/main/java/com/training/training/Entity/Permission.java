package com.training.training.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "permission")
@Data
public class Permission {
    
    @Id
    private Long id;
    private String url;

    @ManyToOne
    @JoinColumn(name="role_id")
    @JsonBackReference
    private Role role;
}
