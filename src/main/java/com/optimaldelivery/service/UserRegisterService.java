package com.optimaldelivery.service;

import com.optimaldelivery.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.optimaldelivery.repository.UserRegisterRepository;

import java.util.List;

@Service
public class UserRegisterService {

    private final UserRegisterRepository userRegisterRepository;

    @Autowired
    public UserRegisterService(final UserRegisterRepository userRegisterRepository) {
        this.userRegisterRepository = userRegisterRepository;
    }

    public Users registerUser(final Users user) {
        return this.userRegisterRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return this.userRegisterRepository.findAll();
    }
}
