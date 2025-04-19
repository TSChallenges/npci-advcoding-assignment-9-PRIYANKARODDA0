package com.mystore.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mystore.app.entity.MynameUsers;

public interface UserRepository extends JpaRepository<MynameUsers, Integer> {
    MynameUsers findByUsername(String username);
}
