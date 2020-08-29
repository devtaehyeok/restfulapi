package com.example.restfulwebservice.user;


import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
@RequiredArgsConstructor
public class UserJpaController {
    @Autowired
    private final UserRepository userRepository;
    // http://localhost:8088/jpa/users
    // 진짜 대박... 개쉽다 정말
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }
    // pagind and sorting Repository > CRUD REPOSITORY

    @GetMapping("/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        user.orElseThrow(()-> new UserNotFoundException(String.format("ID[%s] not found",id)));
        Resource<User> resource = new Resource<>(user.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        // return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("사용자 정보가 없습니다."));
        // optional 반환함.
        return resource;
    }

//    @DeleteMapping("/users/{id}")
//    public User deleteUser(@PathVariable int id){
//        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(String.format("ID[%s] not found",id)));
//        userRepository.delete(user);
//        // 삭제된 유저
//        return user;
//    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }
    // RequestBody 사용자로부터 요청을 JSON 형태로 받기 위함.
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser =  userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    };
}
