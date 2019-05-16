package edu.mum.waa.service;

import edu.mum.waa.entity.UserEntity;
import edu.mum.waa.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private Logger logger = LogManager.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity findById(Integer id) {
        return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
    }

    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserEntity saveUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
