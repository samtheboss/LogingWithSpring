package com.smartapps.loginwithspring.repository;

import com.smartapps.loginwithspring.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into users (first_name,last_name, email,password)" +
            " values  (:first_name,:last_name,:email,:password)", nativeQuery = true)
    int registerNewUser(@Param("first_name") String first_name,
                        @Param("last_name") String last_name,
                        @Param("email") String email,
                        @Param("password") String password);


}
