package com.example.restfulwebservice.user;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

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

}
