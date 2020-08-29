package com.example.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
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
}
