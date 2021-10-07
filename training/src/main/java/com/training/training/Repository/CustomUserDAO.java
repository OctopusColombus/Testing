package com.training.training.Repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import com.training.training.Entity.CustomUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDAO {
    
    @Autowired
    private EntityManager cm;

    public List<CustomUser> getCustomUser(String role){
        String nativeQuery = "SELECT RAND(100) AS id, u.nama,u.email,r.role_name \n"
        + "FROM user u \n"
        + "INNER JOIN role r ON r.id = u.role_id \n"
        + "WHERE r.role_name= :role";
                                
        Query q = cm.createNativeQuery(nativeQuery, "CustomUserQueryMap").setParameter("role", role);  
        return q.getResultList();          
    }

    

}
