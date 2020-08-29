# Web Service와 Web APplication의 개요

2018년 SW 워크샵

모놀리틱 -> MSA
개발 효율성, CICD
큰 단위 개발 > 쪼개서
각 서비스 독립 배포, 폴리글랏 각 서비스별 디비,언어
서비스별 통신 RESTFUL API

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_053022.png)
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_053131.png)

```
네트워크 상에서 서로 다른 종류의 컴퓨터 간 상호 작용을 위한 소프트웨어 시스템
```

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_053243.png)
웹 애플리케이션 : SNS, 옥션 등 서버에 저장되어 브라우저를 통해 서비스를 제공하는 프로그램
웹 서버 : HTTP 요청을 받아서 정적 문서 처리 (html, css, javascript, image)
프로그램 동작 db 접속 등은 WAS로 처리해야 함.

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_053446.png)

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_053507.png)
SOAP : XML 기반 메세지 전달. (기본 웹서비스) HTTP, HTTPS

반드시 감싸야 되어 오버해드가 좀 있음.

최근은 RESTful!
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_053717.png)
컴퓨터가 갖고 있는 자원의 상태
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_053831.png)
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_053919.png)

# 스프링 부트란?

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_054532.png)

스프링 부트 :
단독 실행 가능한 상용 가능 앱을 매우 빠르게 개발 위한 프레임워크
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_054619.png)

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_054730.png)

1. 설정 자동화
2. 1. 에서 사용해서 설정을 불러줌
3. 각종 컴포넌트를 스프링 컨테이너에 메모리로 불러와서 빈으로 등록 및 관리
4. 직접 개발자가 클래스 인스턴스 생성 X 클래스 인스턴스가 컨테이너에 의해 관리 -> IOC

# 3 REST API 설계

Group 어플리케이션 만든 회사 이름.
Artifact 프로젝트, 앱 이름
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_055229.png)

시나리오 :
USER-> POSTS
1 대 다
사용자 관리
사용자 작성 블로그 글
{} 가변 변수

# 스프링 부트 프로젝트 제작

1. 포스트맨 설치
   get, post + put, delete를 매소드 서비스 위함.

2. 인텔리제이 프로젝트 생성

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_055852.png)
file -> new project

war > 다른 서버 배포
jar > 앱 독립 배포
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_062144.png)
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_062402.png)
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_062424.png)
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_062647.png)

# 스프링부트 프로젝트 구조

메이븐은 test / main
각각 resource 포함
동일한 구조.
test에는 테스트 파일 존재
pom.xml에 메이븐 설정

라이프 사이클

- Default(Build) : 일반적인 빌드 프로세스를 위한 모델이다.
- Clean : 빌드 시 생성되었던 파일들을 삭제하는 단계
- Validate : 프로젝트가 올바른지 확인하고 필요한 모든 정보를 사용할 수 있는지 확인하는 단계
- Compile : 프로젝트의 소스코드를 컴파일 하는 단계
- Test : 유닛(단위) 테스트를 수행 하는 단계(테스트 실패시 빌드 실패로 처리, 스킵 가능)
- Pacakge : 실제 컴파일된 소스 코드와 리소스들을 배포위한 jar(단일앱), war(다른서버에) 패키지화 
- Verify : 통합 테스트 결과에 대한 검사를 실행하여 품질 기준을 충족하는지 확인하는 단계
- Install : 패키지를 로컬 저장소에 설치하는 단계
- Site : 프로젝트 문서와 사이트 작성, 생성하는 단계
- Deploy : 만들어진 package를 원격 저장소에 release 하는 단계

출처: https://goddaehee.tistory.com/199 [갓대희의 작은공간]

structure : 현재 파일 내부 구조. (메소드 필드 생성자.)

Rombok annotation processor

포스트맨 사용
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_080605.png)

// alt + enter 빠른 작업
// GET
// /hello-world (endpoint) 엔드포인트 호출 시 클라이언트에서 요청한 정보를
// 서버가 적절히 처리하여 결과 메세지, HTTP STATUS CODE로 응답.
// @RequestMapping (method=RequestMethod.GET,path="/hello-world")
// lombok - annotation processor를 Enable 해줘야 사용 가능. 마켓플레이스 플러그인 설치
// getter seter constructor toString equals 자동 만들어줌
빈으로 리턴하면 자동으로 json으로 바꿔줌.
레스트컨트롤러를 사용하면
반환 값이 responsbody에 포함하지 않더라도
자바 포조 형태 배열 컬렉션 들도 자동 json으로 바뀌어서 반환

롬복 DATA 해서 스트럭처 보면
자동으로 생성되는 함수 확인할 수 있음.

스프링 부트 프로젝트 설정 파일
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_082531.png)
자바 설정 파일(autoconfiguration)
or
application.yml(properties)

```
설정이름 = 값
설정이름 : 값
```

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_082558.png)

yaml파일 : 마크업 언어로 시작되었으나, 현재는 환경 설정 혹은 데이터 전송으로 사용함

```yml
//application.yml
server:
  port: 8088
spring:
  devtools:
    restart:
      enabled: true
logging:
  level:
    org.springframework: DEBUG
// 더 많은 정보가 출력될 것.
```

1. DispatcherServletAutoCnofiguration

- 사용자 요청 처리 후 결과 값을 API 호출 쪽으로 전달 (요청 처리 게이트웨이)

2. HttpMessageConvertersAutoConfiguration

- 사용자 결과값 반환을 위한 설정. json 포맷으로 변환하여 사용자에게 반환.

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_083350.png)

서블릿 컨테이너에서 HTTP 모든 요청 처리 위해
presentation 레이어 맨 앞에서 중앙 집중식 요청 처리를 위한 프론트 컨트롤러
모든 요청은 여기서 시작해 여기서 끝남

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_083507.png)

SpringMVC 프로젝트에서는 컨트롤러 클래스를 xml 설정에 등록했으나
4버전 부터는 어노테이션으로 사용 가능

RestApi 서비스 (by RestController)는
사용자에게 뷰를 보여주는 서비스가 아니라
XML 혹은 JSON을 전달 위한 서비스임.

> 이전에는 RESPONSE BODY로 변환해서 전달해야 했음.

## URL에 가변 변수 사용

`Path Variable`
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_084109.png)
그림에서 위 아래 이름이 다르면 따로 매핑 작업 필요함 (name)

```java
    @GetMapping(path = "/hello-world-bean/path-variable/{id}")
    public HelloWorldBean HelloWorldBean(@PathVariable(value="id") String name) {
        return new HelloWorldBean(String.format("hello world, %s", name));
    }

```

하나의 /books/라는 전체 책 목록 URI
하나의 가변 데이터를 갖고 있는 URI를 이용해 여러 요청 처리

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_085356.png)

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_085414.png)

도메인 : 특정 영역 업무 지식
서비스 : 비즈니스 로직
컨트롤러 : 사용자 요청 처리



```java
static class Student {

    static String name = "홍길동"; // 변수 선언에 값을 초기화시키는 문장을 포함할 수 있다.

    int age = 20;
    static {
      System.out.println("static {...}");
    }
    { // 인스턴스 블록
      System.out.println("{인스턴스 블록 실행...1}");
    }

    // 이렇게 파라미터가 없는 생성자를 기본 생성자(default constructor)라고 한다.
    Student() {
      System.out.println("Student()... 호출");
    }
  }
```

```java
public static void main(String[] args) {

    new Student();
    System.out.println("---------------------------");
    new Student();
  }

```

```text
- 실행 결과
static {...}
{인스턴스 블록 실행...1}
Student()... 호출
---------------------------
{인스턴스 블록 실행...1}
Student()... 호출
```
# 잠깐? 이상한 블록?

- 실행 순서 :

  1. 클래스가 로딩된다.

  2. 클래스 변수가 있으면 메모리를 생성한다..

  3. static 블록이 선언된 순서대로 실행된다.

`static block (스태틱 블록)`

- 클래스가 로딩되고 클래스 변수가 준비된 후 자동으로 실행되는 블록

- 한 클래스 안에 여러 개의 static 블록을 넣을 수 있다.

- 용도 : 주로 클래스 변수를 초기화시키는 코드를 둔다.

1.  JRE 라이브러리 폴더에서 클래스를 찾는다.

2.  없으면, CLASSPATH 환경 변수에 지정된 폴더에서 클래스를 찾는다.

3.  찾았으면, 그 클래스 파일이 올바른 바이트코드인지 검증한다.

4.  올바른 바이트코드라면, Method Area 영역으로 파일을 로딩한다.

5.  클래스 블록이 있으면 순서대로 그 블록을 실행한다.

6.  클래스 안에 static block (스태틱 블록)들이 있으면 순서대로 그 블록을 실행한다.

`인스턴스 블록` 2. instance block (인스턴스 블록)

- 인스턴스가 생성된 후 자동으로 실행하는 블록

- 한 클래스 안에 여러 개의 인스턴스 블록을 넣을 수 있다.

- 용도 :

  인스턴스 변수를 초기화시키는 코드를 둔다.

  어떤 생성자가 호출되든 그 전에 공통으로 초기화시키고 싶은 작업이 있다면

  인스턴스 블록에서 처리하면 된다.

- 실행 순서 :

  1. 인스턴스를 생성한다.

  2. 생성자가 호출되기 전에 인스턴스 블록이 선언된 순서대로 실행된다.

3. 생성자 (constructor)

- 인스턴스를 생성한 후 자동으로 호출되는 특별한 메서드

- 인스턴스 변수와의 차이점 :

  파라미터를 받아서 인스턴스 변수를 특정 값으로 초기화 시킬 수 있다.

- 여러 개의 생성자를 가질 수 있다. 다만, 그 중에서 한 개만 호출된다.

  호출되는 생성자를

- (1) 문법 :

  클래스명(파라미터선언) {...}

  => 리턴타입 x

  (2) 문법

  new 클래스명(아규먼트, ...)

* 주의!

  클래스를 작성할 때 생성자를 만들지 않으면,

  컴파일러가 자동으로 기본 생성자를 만든다.

  => 이 말인 즉슨, 모든 클래스는 생성자를 한 개 이상 갖게 된다는 의미이다.

  new 명령으로 인스턴스를 생성할 때 반드시 어떤 생성자를 호출할 것인지 지정해

  야 한다.

- 실행 순서 :

  인스턴스 생성 --> 인스턴스 블록 싱행 --> 생성자 호출

# GET HTTP METHOD 구현

```java
// User domain
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Date joinDate;
}

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

}


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserDaoService service;

    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return service.findAll();
    }
    // 자동으로 문자로 바꿔서 전해줌~
    @GetMapping("/users/{id}")
    public User retriveUserById(@PathVariable int id){
        return service.findOne(id);
    }


}


```

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_093517.png)

# POST HTTP Method 구현

```java
// post put에서 form데이터가 아닌 xml, json을 받으려면
// @RequestBody 붙여준다.
// 웹브라우저에서 하려면 폼데이터 처리 HTML 작업
// 제이쿼리. 자바스크립트 작업 필요.
@PostMapping("/users")
public void createUser(@RequestBody User user){
    User savedUser = service.save(user);
}


```

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_094400.png)

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_094514.png)

같은 URL을 쓰지만 get, post 응답이 다르다!

# HTTP Status Code 제어

get post 응답 스테이터스 코드를 바꿔보자
post 결과를 어떻게 확인하는지 url 정보도 주자.
servleturicomponentbuilder
```java
// 현재 요청에서
// 패스를 가져온다.
// id 가변변수에
// 새로 저장된 유저의 id를 입력 후
// uri로 만든다.
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

```
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_095931.png)

201 created
responseEntitiy의 Location!!
생성된 ID는 서버가 만들어서 사용자가 알 수 없다. 이를 Response에 전달하면 트래픽 감소 가능.

제일 안좋은 REST API 설계
모든 요청 post로
응답 코드는 200번

예외 핸들링 조합해서 사용!
생성 응답코드 201번 좋음.

# HTTP Status Code 제어를 위한 Exception Handling

HTTP METHOD로 RESOURCE 처리 위한 아키텍처


```java
// 자동으로 문자로 바꿔서 전해줌~
@GetMapping("/users/{id}")
public User retriveUserById(@PathVariable int id){
    // ctl + alt + v
    User user = service.findOne(id);
    if(user == null) throw new UserNotFoundException(String.format("ID[%s] not found",id));
    return user;
    }

```

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_102203.png)
HTTP STATUS CODE
2xx -> ok
4xx -> client
5xx -> server
리소스가 존재하지 않은 것이니
404 not found로 변경하자.

```java
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
```

@Controller, @Service, @Repository
프레젠테이션 서비스 퍼시스턴스

# Spring의 AOP를 이용한 Exception Handling

일반화된 예외 클래스

```java
@RestController
@ControllerAdvice // 모든 컨트롤러가 실행될 때 해당 빈이 실행됨.
public final class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String detail;
}

```

위에 것만 있으면
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_104311.png)

아래것 추가해주면
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_104559.png)

# DELETE METHOD 추가



```java

// userController
@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable int id){
    User user = service.deleteOne(id);
    if (user==null){
        throw new UserNotFoundException(String.format("ID[%s] not found",id));
    }
}
// UserDaoService

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
```
![](/images/SPRING_RESTFUL/SPRING_RESTFUL_173633.png)

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_173657.png)

현재 지원하는건
GET POST PUT DELETE
같은 users url로 처리하는 것을 보자
put은 수정


# RESTful Service 기능 확장

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_174227.png)

# Validation

![](/images/SPRING_RESTFUL/SPRING_RESTFUL_174603.png)

하이버네이트의 validation api 사용
```java
// UserController

@PostMapping("/users")
public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
    User savedUser = service.save(user);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
    return ResponseEntity.created(location).build();
}

//User

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    @Size(min=2)
    private String name;
    @Past
    private Date joinDate;
}

// CustomizedResponseEntityExceptionHandler

@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    // getBindingResult : Return the results of the failed validation.
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),ex.getBindingResult().toString());
    return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
}
```

![](/images/README/README_182042.png)

# 다국어 처리를 위한 Internationalization 구현 방법


![](/images/README/README_182430.png)
하나의 출력 값 여러 언어로
지역 코드에 따라 적절한 언어로 표현
프로토콜 전반적으로 걸쳐서 사용
다국어 처리 빈을 SpringBootApplication에 등록해서 사용.
![](/images/README/README_185310.png)
코드는 앞으로 commit으로 확인하기.


# Response 데이터 형식 변환 - XML format

![](/images/README/README_194426.png)

406 Not Acceptable 
400번은 클라이언트 잘못
서버측에서 준비되지 않은 자료 형식

jackson 디펜던시 추가.
![](/images/README/README_194701.png)
Accept value 변경해서 다시 json으로
![](/images/README/README_194735.png)

# Response 데이터 제어 위한 Filtering

![](/images/README/README_194804.png)
사용자 정보에 비밀번호, 주민번호 같은
중요 정보 추가 시 어떻게 처리할 것인가?
(보안 문제)