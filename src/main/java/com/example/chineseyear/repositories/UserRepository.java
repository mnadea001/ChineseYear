package com.example.chineseyear.repositories;

import com.example.chineseyear.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameContaining(String name);
    Optional<User> findById(String name);

//    @Query("UPDATE User u SET u.sign = :sign WHERE u.id = :id")
//    @Modifying
//    public void calculateChineseSign(Integer id, boolean published);
}
