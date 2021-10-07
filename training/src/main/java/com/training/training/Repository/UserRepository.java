package com.training.training.Repository;

import com.training.training.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNama(String nama);

    List<User> findByEmail(String email);
    List<User> findByEmailAndNama(String email, String nama);
}
