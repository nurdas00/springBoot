package com.example.first_spring_boot.repository;

import com.example.first_spring_boot.model.Role;
import com.example.first_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select role from Role role where role.id = ?1")
    Role getRole(Long id);

    @Modifying
    @Query("update User set name = ?1, age = ?2, email = ?3, password = ?4 where id = ?5")
    void update(String name, int age, String email, String password, Long id);

    User getUserByName(String name);
}
