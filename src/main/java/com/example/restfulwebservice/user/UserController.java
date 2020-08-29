package com.example.restfulwebservice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserDaoService service;

//    @GetMapping("/users/{id}")
//    public EntityModel<User> retrieveUser(@PathVariable int id){
//        User user = service.findOne(id);
//        if(user == null) throw new UserNotFoundException(String.format("ID[%s] not found",id));
//        // user 객체를 리소스로
//        EntityModel<User> model = new EntityModel<>(user);
//        // 하이퍼미디어 링크 빌더 - 해당 메소드를 호출 가능한 링크를 연결
//        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
//        model.add(linkTo.withRel("all-users"));
//        return model;
//    }

    @GetMapping("/users")
    public List<User> retriveAllUsers() {
        return service.findAll();
    }

    // 자동으로 문자로 바꿔서 전해줌~
    @GetMapping("/users/{id}")
    public User retriveUserById(@PathVariable int id) {
        // ctl + alt + v
        User user = service.findOne(id);
        if (user == null) throw new UserNotFoundException(String.format("ID[%s] not found", id));
        return user;
    }

    // post put에서 form데이터가 아닌 xml, json을 받으려면
    // @RequestBody 붙여준다.
    // 웹브라우저에서 하려면 폼데이터 처리 HTML 작업
    // 제이쿼리. 자바스크립트 작업 필요.
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteOne(id);
        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }

}
