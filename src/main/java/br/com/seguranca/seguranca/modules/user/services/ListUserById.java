package br.com.seguranca.seguranca.modules.user.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seguranca.seguranca.modules.user.UserEntity;
import br.com.seguranca.seguranca.modules.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ListUserById {
    
    @Autowired
    private UserRepository userRepository;

    public UserEntity execute(UUID id){
        return this.userRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("User not found")
        );
    }
}
