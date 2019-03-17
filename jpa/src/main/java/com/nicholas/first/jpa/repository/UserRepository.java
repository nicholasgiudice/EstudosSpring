package com.nicholas.first.jpa.repository;

import com.nicholas.first.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
