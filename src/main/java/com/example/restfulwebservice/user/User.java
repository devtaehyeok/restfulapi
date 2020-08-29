package com.example.restfulwebservice.user;

import com.example.restfulwebservice.post.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
//@JsonIgnoreProperties(value={"password"})
// @JsonFilter("UserInfo")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    // message 없으면 default message
    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요")
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요")
    private String name;
    @Past
    @ApiModelProperty(notes = "사용자 등록일을 입력해 주세요")
    private Date joinDate;
    //    @JsonIgnore
    @ApiModelProperty(notes = "사용자 비밀번호를 입력해 주세요")
    private String password;
    //    @JsonIgnore
    @ApiModelProperty(notes = "사용자 주빈번호를 입력해 주세요")
    private String ssn;
    @OneToMany(mappedBy = "user") // post의 user.
    private List<Post> posts;


    public User(int i, String thLim, Date date, String pass1, String s) {
        this.id = id;
        this.name = name;
        this.joinDate = date;
        this.password  = pass1;
        this.ssn = s;
    }
}
