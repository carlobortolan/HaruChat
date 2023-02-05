package com.example.haruchat.repository;

import com.example.haruchat.entity.BasicUser;
import com.example.haruchat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE 'u.user_type' = '0'")
    public Iterable<BasicUser> findAllBasicUsers();


}
