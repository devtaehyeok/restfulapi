package com.example.restfulwebservice.post;

import com.example.restfulwebservice.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    // 외부 데이터 노출 X
    // User : Post -> : (0~N), Main : Sub -> parent -> child
    // 포스트가 여러개 올 수 있고 하나의 값과 매칭
    //
    /*
    FetchType.LAZY는 조인된 녀석을 사용할 시에만 쿼리 날림.
    사용자 조회 시 POST는 필요 시에만 조회함. 사실 부모에만 OneToMany 해줘도 됨.
     */
    // 자동으로 USER_ID로 바꿔줌.
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
