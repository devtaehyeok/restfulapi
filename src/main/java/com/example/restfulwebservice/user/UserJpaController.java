package com.example.restfulwebservice.user;


import com.example.restfulwebservice.post.Post;
import com.example.restfulwebservice.post.PostRepository;
import lombok.RequiredArgsConstructor;
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
    private final PostRepository postRepository;

    // http://localhost:8088/jpa/users
    // 진짜 대박... 개쉽다 정말
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }
    // pagind and sorting Repository > CRUD REPOSITORY

    @GetMapping("/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        user.orElseThrow(() -> new UserNotFoundException(String.format("ID[%s] not found", id)));
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
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    // RequestBody 사용자로부터 요청을 JSON 형태로 받기 위함.
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    ;

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
        // 사용자 정보 조회 후 없으면 에러 처리
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(String.format("ID[%s] not found",id)));
        // 사용자 정보 지정.
        post.setUser(user);
        Post savedUser = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    ;

    // jpa/users/{id}/posts
    @GetMapping("users/{id}/posts")
    public List<Post> retrieveAllPostsByUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        user.orElseThrow(() -> new UserNotFoundException(String.format("ID[%s] not found", id)));
        return user.get().getPosts();
    }
}
