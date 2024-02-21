package com.exyna.pos_api.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exyna.pos_api.users.internal.Users;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<Users>> find() {
        List<Users> users = userService.findAll();
        return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Users> create(@RequestBody Users data) {
        Users save = userService.save(data);
        return new ResponseEntity<Users>(save, HttpStatus.CREATED);
    }

}
