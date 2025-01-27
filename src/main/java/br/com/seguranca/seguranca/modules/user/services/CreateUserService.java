package br.com.seguranca.seguranca.modules.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seguranca.seguranca.modules.user.UserEntity;
import br.com.seguranca.seguranca.modules.user.UserRepository;

@Service
public class CreateUserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserEntity execute(UserEntity userEntity){
        return this.userRepository.save(userEntity);
    }
}
