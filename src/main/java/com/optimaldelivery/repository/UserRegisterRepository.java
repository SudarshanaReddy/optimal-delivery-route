package com.optimaldelivery.repository;

import com.optimaldelivery.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegisterRepository extends JpaRepository<Users, Long> {
}
