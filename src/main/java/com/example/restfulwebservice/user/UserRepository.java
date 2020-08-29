package com.example.restfulwebservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// 타입 지정 필요. domain 객체와 id 자료형
public interface UserRepository extends JpaRepository<User,Integer> {
    // 사용 가능한 메소드를 확인해보자!

}
