package br.com.seguranca.seguranca.modules.user.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seguranca.seguranca.modules.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DeleteUserService {
    
    @Autowired
    private UserRepository userRepository;

    public String execute(UUID id){
        if (this.userRepository.existsById(id)) {
            this.userRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException("User not found");
        }

        String message = "User deleted with success";

        return message;
    }
}
