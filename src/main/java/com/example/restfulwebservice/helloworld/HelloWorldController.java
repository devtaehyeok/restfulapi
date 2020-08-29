package com.example.restfulwebservice.helloworld;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {
    private final MessageSource messageSource;

    // GET
    // /hello-world (endpoint) 엔드포인트 호출 시 클라이언트에서 요청한 정보를
    // 서버가 적절히 처리하여 결과 메세지, HTTP STATUS CODE로 응답.
    // @RequestMapping (method=RequestMethod.GET,path="/hello-world")
    @GetMapping(path = "/hello-world")
    public String HelloWorld() {
        return "hello world";
    }

    // alt + enter 빠른 작업
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean HelloWorldBean() {

        return new HelloWorldBean("hello world");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{id}")
    public HelloWorldBean HelloWorldBean(@PathVariable(value="id") String name) {
        return new HelloWorldBean(String.format("hello world, %s", name));
    }

    @GetMapping(path="/hello-world-internationalized")
    // RequestHeader에 의해 전달.
    // 없으면 우리가 설정한 기본값(KOR로 설정됨.)
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required = false) Locale locale){
        // 1. 어떤 키값을 가져올 것인지, 2. 1 키값이 가변변수 문자열이면 문자열 채우기 위한 파라미터, 3. locale
        return messageSource.getMessage("greeting.message",null,locale);
    }
}
