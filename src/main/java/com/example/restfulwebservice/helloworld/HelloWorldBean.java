package com.example.restfulwebservice.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

// lombok - annotation processor를 Enable 해줘야 사용 가능. 마켓플레이스 플러그인 설치
// getter seter constructor toString equals 자동 만들어줌
@Getter
@Setter
@AllArgsConstructor
public class HelloWorldBean {
    private String message;

}
