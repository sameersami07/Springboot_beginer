package com.samishaik.WebProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samishaik.WebProject.model.User;
import com.samishaik.WebProject.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/random")
    public ResponseEntity<User> getRandomUser() {
        User randomUser = userService.getRandomUser();
        return ResponseEntity.ok(randomUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody User u) {
        User updated = userService.updateUser(id, u);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User u) {
        User cu = userService.createUser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(cu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
