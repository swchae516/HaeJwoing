# ssafy 6기 2학기 공통PJT(22/01/3 ~ 22/02/18)

## 광주 1반 3팀 워라벨팀(C103)

### 프로젝트 주제

![image](https://user-images.githubusercontent.com/45279249/173012084-6526581a-fd41-472e-b206-bed98b7e62df.png)

### 팀원 및 역할

#### Front

> 기술 스택
> 
> > React, node.js

- 채성원

- 허영민

- 정정채

#### Back

> 기술 스택
> 
> > Spring boot, docker

- 정재현

- 한윤희

- 이은성

## 프로젝트 기획

<ul>
  <li>기획 배경</li>
  <p align="center">
    <img width="600px", src="https://user-images.githubusercontent.com/45279249/173015663-f578b6b4-0888-45db-b32c-0bbd40fa14d2.png" />
  </P>
  <li>E-R Diagram</li>
  <p align="center">
    <img width="600px", src="https://user-images.githubusercontent.com/45279249/173012512-54c9f1dc-68c7-477b-a1a1-660713eb586f.png" />
  </P>
  <li>Wireframe</li>
  <p align="center">
    <img width="600px", src="https://user-images.githubusercontent.com/45279249/173013521-e42dfdf9-bf40-4503-9541-2b220a8e982a.png" />
  </p>
</ul>

## 시연 시나리오
<ul>
  <li>서비스 접속 시 로그인 화면</li>
  <p align="center">
    <img width="300px", src="https://user-images.githubusercontent.com/45279249/173014046-eea6ffdf-15a3-4122-b299-5d840a07097c.png" />
  </P>
  <li>최초 로그인 시 추가 정보 입력</li>
  <p align="center">
    <img width="300px", src="https://user-images.githubusercontent.com/45279249/173014178-f2f7a4e6-a0e6-4d12-9a62-b81e111a74bc.png" />
  </P>
  <li>로그인 완료 시 메인 피드 화면으로 넘어감</li>
  <p align="center">
    <img width="300px", src="https://user-images.githubusercontent.com/45279249/173014344-57822d12-fb48-4799-9bc2-6dfd92e26a14.png" />
  </P>
  <li>피드 작성하는 페이지</li>
  <p align="center">
    <img width="300px", src="https://user-images.githubusercontent.com/45279249/173014487-87a3baf9-b5aa-495d-b6c2-ca397367256d.png" />
  </P>
  <li>프로필 화면</li>
  <p align="center">
    <img width="300px", src="https://user-images.githubusercontent.com/45279249/173014610-c42950d8-6b22-415c-ae64-e71c9766c6f6.png" />
  </P>
  <li>태그, 친구 검색</li>
  <p align="center">
    <img width="400px", src="https://user-images.githubusercontent.com/45279249/173014754-88342fab-a8d6-463f-b854-f78243c7812f.png" />
  </P>
  <li>프로필 화면에서 각각의 목록 화면</li>
  <p align="center">
    <img width="400px", src="https://user-images.githubusercontent.com/45279249/173015113-a7df3206-b775-452e-85c9-5df1f65589e1.png" />
  </P>
</ul>

## React 기반 개발

- CSS module 과 Styled Component를 사용하여 각자 스타일대로 CSS 컴포넌트 구성
  
  ![image-20220128104703524](./README.assets/image-20220128104703524.png)
  
  ![image-20220128104732468](./README.assets/image-20220128104732468.png)

- React-redux 를 사용하여 Alarm 데이터를 저장 및 사용을하고 추후에 더 다양한 곳에 사용할 예정

![image-20220128104853468](./README.assets/image-20220128104853468.png)

![image-20220128104953731](./README.assets/image-20220128104953731.png)

- Component 간에 Props 를 이용하여 Component 재사용성을 늘림

![image-20220128105118271](./README.assets/image-20220128105118271.png)

- React-router-dom 으로 페이지를 구성. 추후에 Next.js 를 학습하면 적용할 수도 있음

![image-20220128105142115](./README.assets/image-20220128105142115.png)

- React Hook 을 이용하여 CRUD, Infinite Scroll등 다양한 기능들을 구현

![image-20220128105202459](./README.assets/image-20220128105202459.png)

![image-20220128105235485](./README.assets/image-20220128105235485.png)

- 소셜로그인 라이브러리를 이용하여 OAuth를 통한 소셜로그인 구현
  
  ![image-20220128105300669](./README.assets/image-20220128105300669.png)
  
  ![image-20220128105318231](./README.assets/image-20220128105318231.png)
  
  ![image-20220128105331270](./README.assets/image-20220128105331270.png)

![image-20220128105344039](./README.assets/image-20220128105344039.png)

# Back-End

- Spring boot 기반 개발

## 프로젝트 구조

```tex
src
    -main/java/come.haejwoing.back
        -config
            -jwt
                -JwtAuthorizationFilter
                -JwtProperties
                -PrincipalDetails
                -PrincipalDetailsService
            -CorsConfig
            -SecurityConfig
        -controller
            -*Controller
        -model
            -dto
            -mapper
            -service
        BackApplication
    -resource
        -mappers
            -*.xml
        -application.yml
```

## JWT

```java
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private UserService userService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserService userService) {
        super(authenticationManager);
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String header = request.getHeader(JwtProperties.HEADER_STRING);
        System.out.println("header Authorization : " + header);

        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        String token = request.getHeader(JwtProperties.HEADER_STRING).replace(JwtProperties.TOKEN_PREFIX, "");

        // 토큰 검증 (이게 인증이기 때문에 AuthenticationManager도 필요 없음)
        // 내가 SecurityContext에 집적접근해서 세션을 만들때 자동으로 UserDetailsService에 있는
        // loadByUsername이 호출됨.
        String nickname = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token)
                .getClaim("nickname").asString();
        System.out.println("token : "+nickname);
```

## Controller

```java
@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/google")
    public ResponseEntity<Map<String, Object>> isGoogleUser(@RequestBody Map<String, Object> data){
        GoogleUser googleUser = new GoogleUser((Map<String, Object>) data.get("profileObj"));
        log.info("data : {}", data);
        log.info("profileObj : {}", data.get("profileObj"));
        User userEntity = userServiceImpl.searchByEmail(googleUser.getEmail());

        if(userEntity == null) {
            log.info("구글 로그인 첫 방문");
            Map<String, Object> map = new HashMap<>();
            map.put("check", false);
            map.put("email", googleUser.getEmail());
            log.info(map.toString());
            return new ResponseEntity<>(map, HttpStatus.OK);

        } else if(userEntity.getUserStatus() == 0){ // 회원 탈퇴한 기록이 있는 위저가 들어오면 다시 회원가입해줘야함
            log.info("구글 탈퇴 했던 회원");
            Map<String, Object> map = new HashMap<>();
            map.put("check", false);
            map.put("email", googleUser.getEmail());
            log.info(map.toString());
            return new ResponseEntity<>(map, HttpStatus.OK);

        } else if(userEntity.getUserStatus() == 1) {
            log.info("구글 회원가입 완료 회원 ");
            User userRequest = User.builder()
                    .email(userEntity.getEmail())
                    .nickname(userEntity.getNickname())
                    .role("ROLE_USER")
                    .image(userEntity.getImage())
                    .userStatus(1)
                    .build();

            String jwtToken = new JwtProvider().createJwtToken(userRequest);
            Map<String, Object> map = new HashMap<>();
            map.put("check", true);
            map.put("id", userServiceImpl.getUserId(userEntity.getEmail()));
            map.put("jwtToken", jwtToken);
            log.info("id : {}", map.get("jwtToken"));

            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
```

## Model

### Dto

```java
@Data
@Builder
public class User {

    private int id;
    private String email;
    private String nickname;
    private int gender;
    private String birth;
    private String image;
    private String role;
    private int userStatus;
    private double point;

    public List<String> getRoleList(){
        if(this.role.length() > 0){
            return Arrays.asList(this.role.split(","));
        }
        return new ArrayList<>();
    }
}
```

### Mapper

```java
@Mapper
public interface UserMapper {

    void insertUser(User user);
    User searchByEmail(String email);
    List<User> listAllUser();
    void withdrawUser(int id);
    void setPoint(Map<String, Object> map);
    List<User> listFollower(int id);
    List<User> listFollow(int id);
    int getUserId(String email);
    User userInfo(int id);
    void updateProfile(User user);
    int checkNickname(String nickname);
    int addFollow(int id, int toUser);
    int checkFollow(int id, int loginedId);
    int unFollow(int toUser, int fromUser);
    List<User> findByNickname(String nickname);
    List<Map<String, Object>> getFollowerId(int id);
    double getPercentage(int id);
    User getUserByNickname(String nickname);
    void updateByEmail(Map<String, Object> userMap);
}
```

### Service

```java
public interface UserService {

    void insertUser(User user);
    List<User> listAllUser();
    User searchByEmail(String email);
    void withdrawUser(int id);
    void setPoint(Map<String, Object> map);
    List<User> listFollower(int id);
    List<User> listFollow(int id);
    int getUserId(String email);
    User searchById(int id);
    void updateProfile(User user);
    Boolean checkNickname(String nickname);
    Boolean addFollow(int id, int toUser);
    Boolean checkFollow(int id, int loginedId);
    Boolean unFollow(int toUser, int fromUser);
    List<User> findByNickname(String nickname);
    List<Map<String, Object>> getfollowerId(int id);
    double getPercentage(int id);
    User getUserByNickname(String nickname);
    void updateByEmail(Map<String, Object> userMap);
}
```

## Resources

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.haejwoing.back.model.mapper.UserMapper">

    <insert id="insertUser" parameterType="User">
        insert into user(nickname, email, gender, role, birth, user_status, point, image)
        values (#{nickname}, #{email}, #{gender}, #{role}, #{birth}, #{userStatus}, #{point}, #{image})
    </insert>

    <update id="setPoint" parameterType="map">
        update user
        set point= point + #{score}
        where id=#{userId}
    </update>

    <select id="searchByEmail" parameterType="String" resultType="User">
        select * from user
        where email = #{email}
    </select>

    <select id="listAllUser" resultType="map">
        select nickname, email, gender, birth, image, role
        from user
    </select>

    <update id="withdrawUser" parameterType="int">
        update user
        set user_status = 0
        where id=#{id}

    </update>
```

### Properties

- application.yml

```properties
server:
  port: 8080

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis:
  type-aliases-package: com.haejwoing.back.model.dto
  mapper-locations: classpath:mappers/*.xml
```
