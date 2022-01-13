# 1/10(월) 프로젝트 준비의 시작

그 전에도 프론트와 백엔드를 어떤 프로그램 사용할지에 대해 고민을 했었으며 1/10에 front는 Vue, back은 JavaSpring을 사용하기로 결정. 비전공자여도 JavaSpring을 선택한 이유는 현업에서 많이 사용 하기 때문.

JavaSpring을 하기 위해서는 Java기본 개념을 알아야 하기 때문에 저번주부터 Java책 구입 및 Java간단한 코딩문제를 백준을 통해서 풀어봄.

일과시간에는 명세서를 따라 프로그램 설치 및 정리했으며, Visual Code에 문제가 있어 Backend프로그램을 인텔리제이로 하기로 결정.

대부분의 시간들을 공통프로젝트때 사용할 아이디어 정리에 할애함.

팀장이 좋은 JavaSpring 강의사이트를 알려줌으로써(인프런) 1/11 시작할 예정.



# 1/11(화) JavaSpring 배우기 및 프로젝트 정리

1. 프로젝트 부분

   프로젝트가 너무 추상화하다는 피드백을 통해 기존 코딩의정석 프로그램을 접고 바로 새로운 프로젝트를 하기로 결정. 새로운 아이디어 구상 및 정리를 위해 약 6시간(9~12, 3~6)를 사용.



2. JavaSpring 시간

   그 이외의 시간에는 추천한 JavaSpring강의를 시청.

   기본적인 Hello문을 화면에 띄우는 것.



## JavaSpring으로 만든 간단한 Hello

## src/main/java/hello.hellospring.controller

```
package hello.hellospring.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
```

## src/main/resources/static/index.html

```
<!DOCTYPE HTML>
<html>
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
Hello
<a href="/hello">hello</a>
</body>
</html>
```

## src/main/resources/static/hello-static.html

```
<!DOCTYPE HTML> <html>
<head>
    <title>static content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> </head>
<body>
정적 컨텐츠 입니다. </body>
</html>
```

## src/main/resources/templates/hello.html

```
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text="'안녕하세요. ' + ${data}" >안녕하세요. 손님</p>
</body>
</html>
```





# 1/12(수) ~1/13(목)

강의 내용이 너무 어려워서 SSAFY Java-Spring 부분을 보기로함.

MVC내용부터 시청 시작.

중간에 어려운 부분은 유튜브나 블로그 등으로 이해하려고 노력



## 시청 및 정리내용

Data 발생 -> 요청(request) -> Servelet(1.data get, 2. logic call or 처리)

< -> Service(Business Logic 처리, 계산같은 로직적인 처리) <-> Dao(Database Logic 처리, 데이터 중심 처리)



DTO(data transfer object)=Entity(값을가지고있는 객체), VO(value object)

JSP로 응답(response)을 함.



Servlet = Controller로 표현한다.

Sevice, Dao, DTO=로직을 처리할수 있는 모델(Model)

JSP로 보여준다= View



front프로그램 Vue로 옮길때는 cvs, xml, json형태로 바꿔서 넘겨준다.



REST API대표적인 예시 data.go.kr(공공데이터)



## 그 외

Getter/Setter



데이터 무결성을 지키기 위함(무결성은 데이터베이스에 저장된 데이터 값과 그것이 표현하는 현실세계의 실제값이 일치하는 정확성을 의미)



무결성 제약 조건

데이터 베이스에 저장된 데이터의 정확성을 보장하기 위해 정확하지 않은 데이터가 데이터 베이스내에 저장되는 것을 방지하기 위한 제약 조건



생성자

1. 클래스 이름과 동일한 이름을 가진 메소드
2. 반환형이 선언되어 있지 않으면서, 반환하지 않는 메소드



즉, 메소드 이름이 클래스명과 똑같고, void나 int처럼 반환형이 선언되어있지도 않고, 리턴값을 반환하지도 않는다. 입력만 있을뿐 출력은 없다. 초기화만 해주는 작업을한다.



생성자는 안쓸경우 디폴트 생성자로 클래스내에서 존재한다.

생성자 여러개있을 경우 디폴트를 하나 넣어줘야 다른 class에서 설정없이(()안에 값안넣어도) 설정가능.

생성자간의 인자가 같으면 안된다.



생성자, getter & setter는 alt+insert 키로 만들수 있다.
