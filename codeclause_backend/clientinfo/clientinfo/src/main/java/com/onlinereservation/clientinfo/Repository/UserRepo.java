package com.onlinereservation.clientinfo.Repository;

import com.onlinereservation.clientinfo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    @Query("from User where username = ?1 and userpassword=?2")
    Optional<User> findUser(String username, String userpassword);

    // Optional<User> findOneByusernameAndPassword(String username, String userpassword);
    // User findByusername(String username);
}