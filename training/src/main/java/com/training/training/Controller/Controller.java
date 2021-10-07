package com.training.training.Controller;
import com.training.training.Entity.CustomUser;
import com.training.training.Entity.User;
import java.util.List;

import com.training.training.Repository.CustomUserDAO;
import com.training.training.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class Controller {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDAO customUserDAO;

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/getUserData")
    public ResponseEntity<List<User>> getUserData(){
        List<User> result = userRepository.findAll();
        if (result == null || result.isEmpty()){
            return new ResponseEntity<>(null ,HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(result ,HttpStatus.OK);
        
    }

    @PostMapping("/saveUserData")
    public ResponseEntity<User> saveUserData(@RequestBody User user){
        try {
            User u = userRepository.save(user);
            return new ResponseEntity<>(u ,HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error Saving{}",e.getMessage()); 
            return new ResponseEntity<>(null ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteUserData")
    public ResponseEntity<String> deleteUser(@RequestParam String userId){
        try {
        userRepository.deleteById(Long.valueOf(userId));
        return new ResponseEntity<>("Deleted",HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error Deleting User{}",e.getMessage()); 
            return new ResponseEntity<>(null ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUserChoose")
    public ResponseEntity<List<User>> getUserChoose(@RequestParam String email,String nama){
        List<User> result = userRepository.findByEmailAndNama(email, nama);
        if (result == null || result.isEmpty()){
            return new ResponseEntity<>(null ,HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(result ,HttpStatus.OK);
        
    }
    
    @GetMapping("/getCustomUser")
    public ResponseEntity<List<CustomUser>> getCustomUser(@RequestParam String role){
        List<CustomUser> result = customUserDAO.getCustomUser(role);
        if (result == null || result.isEmpty()){
            return new ResponseEntity<>(null ,HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(result ,HttpStatus.OK);
        
}
}
