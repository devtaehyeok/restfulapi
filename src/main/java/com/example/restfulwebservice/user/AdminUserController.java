package com.example.restfulwebservice.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
//  @GetMapping("/admin/users") <==  @GetMapping("/users") 자동 변환
public class AdminUserController {
    private final UserDaoService service;
    private UserV2 userV2;

    // 관리자 관련 API
    @GetMapping("/users")
    public MappingJacksonValue retriveAllUsers() {
        // ctrl + alt + v
        List<User> users = service.findAll();
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "password");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filters);
        return mapping;
    }

    // 자동으로 문자로 바꿔서 전해줌~
    // GET /admin/users/1 -> /admin/v1/users/1
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv1+json")
    public MappingJacksonValue retriveUserByIdV1(@PathVariable int id) {
        // ctl + alt + v
        User user = service.findOne(id);
        if (user == null) throw new UserNotFoundException(String.format("ID[%s] not found", id));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);
        return mapping;
    }
    // GET /admin/users/1 -> /admin/v2/users/1
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv2+json")
    public MappingJacksonValue retriveUserByIdV2(@PathVariable int id) {
        // ctl + alt + v
        User user = service.findOne(id);
        if (user == null) throw new UserNotFoundException(String.format("ID[%s] not found", id));
        // User -> UserV2
        UserV2 userV2 = new UserV2();
        // 빈들간 동일한 prpoerties 값 복사해줌
        BeanUtils.copyProperties(user, userV2); // id, name. joinDate, password, ssn
        userV2.setGrade("VIP");
        if (user == null) throw new UserNotFoundException(String.format("ID[%s] not found", id));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "grade");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(userV2);
        mapping.setFilters(filters);
        return mapping;
    }
}
