package br.com.seguranca.seguranca.modules.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seguranca.seguranca.modules.user.UserEntity;
import br.com.seguranca.seguranca.modules.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ListAllUserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> execute(UserEntity userEntity){
        var allUsers = this.userRepository.findAll();
        if (allUsers.isEmpty()) {
            throw new EntityNotFoundException("User not register");
        }
        return allUsers;
    }
}
