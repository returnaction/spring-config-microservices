package com.nikita.lab.userservice.repository;

import com.nikita.lab.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
