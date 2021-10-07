package com.training.training.Entity;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.Data;

@Entity
@Data
@SqlResultSetMapping(name = "CustomUserQueryMap", entities = {
    @EntityResult(entityClass = CustomUser.class, fields = {
        @FieldResult(name = "id", column = "id"),
        @FieldResult(name = "nama", column = "nama"),
        @FieldResult(name = "email", column = "email"),
        @FieldResult(name = "roleName", column = "role_name")
        
    })
})
public class CustomUser {
    
    @Id
    private String id;
    private String nama;
    private String email;
    private String roleName;

}
