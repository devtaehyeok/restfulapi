package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value={"password"})
// 부모에 default 생성자 만들어줘야 에러 없어짐
@JsonFilter("UserInfoV2")
public class UserV2 extends User {
    // 새로운 성적 필드 추가
    private String grade;

    public UserV2() {
        
    }
}
