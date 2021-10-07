package com.training.training.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "role")
@Data
public class Role {
    
    @Id
    private long id;
    private String roleName;
    private String permission;

    @OneToMany(mappedBy = "role")
    private List<Permission> permissionDesc;

}
