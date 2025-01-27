package br.com.seguranca.seguranca.modules.user.services;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seguranca.seguranca.modules.user.UserEntity;
import br.com.seguranca.seguranca.modules.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UpdateUserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserEntity execute(UUID id, UserEntity userEntity){
        UserEntity updatedUser = this.userRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("User not found")
        );

        BeanUtils.copyProperties(userEntity, updatedUser, getNullPropertyNames(userEntity));

        return this.userRepository.save(updatedUser);
    }

    private String[] getNullPropertyNames(UserEntity source) {
        return Arrays.stream(source.getClass().getDeclaredFields())
            .filter(field -> {
                try {
                    field.setAccessible(true);
                    return field.get(source) == null;
                } catch (IllegalAccessException e) {
                    return false;
                }
            })
            .map(field -> field.getName())
            .toArray(String[]::new);
    }
}
