package com.exyna.pos_api.module.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<List<Users>> find() {
        List<Users> users = userRepository.findAll();
        return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Users> create(@RequestBody Users data) {
        Users user = new Users();
        user.setFullName(data.getFullName());
        user.setPassword(data.getPassword());
        user.setUsername(data.getUsername());
        Users save = userRepository.save(user);
        return new ResponseEntity<Users>(save, HttpStatus.CREATED);
    }

}
