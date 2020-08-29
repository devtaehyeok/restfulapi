package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1,"thLim",new Date()));
        users.add(new User(2,"ejLee",new Date()));
        users.add(new User(3,"ejMang",new Date()));
    }
    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if (user.getId() == null){
            user.setId(users.size()+1);
        }
        users.add(user);
        return user;

    }
    public User findOne(int id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    // post put에서 form데이터가 아닌 xml, json을 받으려면
    // @RequestBody 붙여준다.

    public User deleteOne(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
      return null;
    }

}
