package br.com.seguranca.seguranca.modules.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seguranca.seguranca.modules.user.services.CreateUserService;
import br.com.seguranca.seguranca.modules.user.services.DeleteUserService;
import br.com.seguranca.seguranca.modules.user.services.ListAllUserService;
import br.com.seguranca.seguranca.modules.user.services.ListUserById;
import br.com.seguranca.seguranca.modules.user.services.UpdateUserService;

@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private CreateUserService createUserService;

    @Autowired
    private ListAllUserService listAllUserService;

    @Autowired
    private ListUserById listUserById;

    @Autowired
    private UpdateUserService updateUserService;

    @Autowired
    private DeleteUserService deleteUserService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody UserEntity userEntity){
        try {
            var user = this.createUserService.execute(userEntity);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> list(@RequestBody UserEntity userEntity){
        try {
            var allUsers = this.listAllUserService.execute(userEntity);
            return ResponseEntity.ok().body(allUsers);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listById(@PathVariable UUID id){
        try{
            var user = this.listUserById.execute(id);
            return ResponseEntity.ok().body(user);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody UserEntity userEntity){
        try{
            var updateUser = this.updateUserService.execute(id, userEntity);
            return ResponseEntity.ok().body(updateUser);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id){
        try {
            var deleted = this.deleteUserService.execute(id);
            return ResponseEntity.ok().body(deleted);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
