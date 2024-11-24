package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.repositories.UserRepository;
import com.demo.services.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching users", e);
        }        
    }

    public User findById(Long id) {
        try {
            return userRepository.findById(id).orElseThrow(
            		() -> new ResourceNotFoundException("User not found with id " + id)
            );
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching user by id", e);
        }
        
    }

    public User insert(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting user", e);
        }    	
    }

    public void delete(Long id) {
        try {
            if (!userRepository.existsById(id)) {
                throw new ResourceNotFoundException("User not found with id " + id);
            }
            userRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user", e);
        }
        
    }

    public User update(User user) {
        try {
            if (userRepository.existsById(user.getId())) {
                return userRepository.save(user);
            } else {
                throw new ResourceNotFoundException("User not found for update with id " + user.getId());
            }
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error updating user", e);
        }        
    }

}