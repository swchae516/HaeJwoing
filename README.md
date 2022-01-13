> swagger란 개발한 REST API를 문서화 해주고, 이를 통해 관리 및 사용자가 편리하게 API를 호출해보고 테스트할 수 있는 기능이 있다.

#### spring boot에서는 springfox-boot-starter를 dependencies에 추가함으로 사용할 수 있다.

#### Lombok
> Java 라이브러리로 반복되는 getter, setter, toString 등의 메서드 작성 코드를 줄여주는 코드 다이어트 라이브러리입니다.

lombok사용시 많은 getter와 setter를 줄여줘서 코드 가독성이 좋아지는 것 같다.

@Data Annotation을 사용하면 된다.

#### 1. lombok 미사용 시
```
package com.example.food.restaurant.dto;

import java.time.LocalDateTime;

public class WishListDto {

    private Integer index;
    private String title;
    private String category;
    private String address;
    private String roadAddress;
    private String link;
    private String imgLink;
    private boolean isVisited;
    private int visitCount;
    private LocalDateTime lastVisitTime;


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDateTime getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(LocalDateTime lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }
}

```


#### 2. lombok 사용시
```
package com.example.food.restaurant.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WishListDto {

    private Integer index;
    private String title;
    private String category;
    private String address;
    private String roadAddress;
    private String link;
    private String imgLink;
    private boolean isVisited;
    private int visitCount;
    private LocalDateTime lastVisitTime;


}
```




### swagger Annotation
1. @API		클래스를 스웨거의 리소스로 표시
2. @ApiOperation 특정 경로의 오퍼레이션 HTTP method 설명
3. @ApiParam 오퍼레이션 파라미터에 메타 데이터 설명
4. @ApiResponse 오퍼레이션의 응답 지정
5. @ApiModelProperty 모델의 속성 데이터 설명
6. @ApiImplicitParam 메소드 단위의 오퍼레이션 파라미터를 설명


#### spring Initializr를 통해 프로젝트 생성
<img src="https://images.velog.io/images/jjeom122/post/38adf161-0fd1-401d-aa2e-ef0965e03cf8/basci_api_swagger.PNG" width="600" height="400"/>


### controller

```
package Swagger.ApiController.controller;

import Swagger.dto.UserReq;
import Swagger.dto.UserRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @ApiOperation(value = "사용자의 이름과 나이를 반환하는 method")
    @GetMapping("/user")
    public UserRes user(UserReq userReq){
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost(@RequestBody UserReq req){
        return new UserRes(req.getName(), req.getAge());
    }
}
```
### dto
```
package Swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserReq {
    @ApiModelProperty(value = "사용자 이름", example = "jeong", required = true)
    private String name;

    @ApiModelProperty(value = "사용자 나이", example = "13", required = true)
    private int age;
}
```

## Naver Api를 활용해 나만의 리스트 만들기
> Vue, bootstrap, JS, CSS spring


네이버 검색 API 장소와 이미지 검색을 활용했다.
1. 요청에 대한 swaggerApi를 설계
2. 장소와 이미지 API에 따른 요청과 응답 dto를 만들고 naverClient를 연결.
3. 응답에 대한 정보를 담기위해 각각의 dto를 만들어준다.

<img src="https://images.velog.io/images/jjeom122/post/44a2be09-2d1a-40ea-83a9-2864fa3bc861/api.PNG" width="600" height="400"/>




### 네이버 소셜 로그인 구현

1. 기본 로그인 페이지
2. 콜백 페이지 필요

1,2 관련 소스들은 네이버 개발자 페이지에서 제공해준다.

> 콜백 페이지관련해서 callback url이 제공되야하는데 네이버 개발자 페이지에 등록된 callback url을 사용해야된다.

### 메인페이지에서
<img src="https://images.velog.io/images/jjeom122/post/1503fd2e-cb68-45c1-8402-8c216f6f3837/notLogin.PNG" width="600" height="400"/>


### 로그인창을 누르면 네이버 로그인 페이지가 뜬다. 하지만 토큰이나 db문제인가? 로그인이 완료되지 않아 일반적인 아이디와 비밀번호로 로그인진행 -> 주말동안 해결해볼 예정.

<img src="https://images.velog.io/images/jjeom122/post/bc557c78-9eb0-4a59-9163-48e48bc680ff/clickLogin.PNG" width="600" height="400"/>


### 로그인시 comment(카페/블로그 리뷰 개수 순)으로 검색된 아이템을 위시리스트에 추가할 수 있다.

<img src="https://images.velog.io/images/jjeom122/post/10994dd4-cf35-4749-9e3d-be211ac130ac/localhost_8080_page_main%20(1).png" width="600" height="800"/>


> API를 활용할 떄 가이드에 나와있는 요청변수나 출력결과 변수에 대해 오타가 날 확률이 상당히 높으므로 복사 붙여넣기를 사용하는 것이 좋겠다.
네이버 소셜로그인 시 spring security를 사용하거나 api정보를 갱신할 때 spring batch를 사용해보는 것을 목표로 공통프로젝트를 진행해 보겠습니다.

#### 오류
2022-01-14 00:19:05.346  INFO 53040 --- [nio-8080-exec-2] o.apache.coyote.http11.Http11Processor   : Error parsing HTTP request header
 Note: further occurrences of HTTP request parsing errors will be logged at DEBUG level.

 => https를 http로 변경해주면 해결

//브랜치 변경
git checkout branch명 

//원격 저장소 추가 
git remote add -t tami upstream URI

//branch 확인 
git remote -v



