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





# 1/14(금)

Client가 웹 서비스에 요청을 보내면 Dispatcher Servlet이 매핑되는 Handler를 찾는다.

Controller가 요청을 처리한 후에 View를 Dispatcher Servlet에게 전달해주고 다시 사용자에게 응답이 되는 흐름.

Controller가 View를 반환하기 위해서는 ViewResolver가 사용되며, ViewResolver 설정에 맞게 View를 찾아 렌더링.

 

## @Controller

 

해당 자바 클래스가 Controller인지 알려주는 방법은 간단합니다.

@Controller 를 적어주면 spring에서 알아서 작업.

@RestController 라는 어노테이션도 있지만 View가 아닌 객체 자체를 반환할때 쓰임.

핸들러가 스캔할 수 있는 빈(Bean) 객체가 되어 서블릿용 컨테이너(임의로 정한 명칭)에 생성됩니다.

@Component를 붙여줘도 되지만 가시성이 떨어져서 잘 사용하지 않는다.

웹요청과 응답을 처리함

## @RequestMapping

```
@RestController
@RequestMapping("api")
public class GetController { 
// GET Method 로 통신 
// 경로는 api/getMethod 와 매핑됨 
@RequestMapping(method = RequestMethod.GET, path = "/getMethod") public String getRequest() { return "Hello Spring"; } }

출처: https://memostack.tistory.com/161 [MemoStack]
```

`@RequestMapping` 안에 `method` 값으로 `RequestMethod.GET`을 넣어주면, HTTP GET 요청이 왔을때 동작을 한다.

그리고, path 값을 URL에 매핑한다. (위에서는 `/api/getMethod`와 매핑됨)

출처: https://memostack.tistory.com/161 [MemoStack]



## @GetMapping

```
@RestController
@RequestMapping("api")
public class GetController { 
... 
// GET Method 통신
// 경로는 api/getParam과 매핑됨
@GetMapping("/getParam")
public String getParameter() { return "Hello Spring"; } }

출처: https://memostack.tistory.com/161 [MemoStack]
```

GET 요청 방식의 API를 만들때, `@RequestMapping(method = RequestMethod.GET ...)` 방식도 있지만, `@GetMapping`을 이용하는 방법도 있다. (개인적으로 `@GetMapping`을 더 많이 사용한다)

출처: https://memostack.tistory.com/161 [MemoStack]



## HashMap

HashMap은 키와 값으로 구성된 엔트리(Entry) 객체를 저장하는 자료구조로 키 객체의 해시코드를 이용해서 해시테이블을 탐색, 값을 가져오는 동작을 한다. HashMap에서는 동일한 키에 대응되는 값은 하나만 저장할 수 있다. 따라서 동일한 키에 대응되는 값을 여러번put()메소드로 추가하면, 기존의 값은 덮어쓰여지고 마지막에 추가한 값이 살아남게 된다.



## Entry 객체

Map 인터페이스의 내부 인터페이스 입니다.

Map에 저장되는 Key-Value쌍을 다루기 위해 내부적으로 Entry 인터페이스를 정의해 놓았다.



https://codedragon.tistory.com/6046

(사진확인 및 출처용)



## Model이란?

Model은 HashMap 형태를 갖고 있으며, key, value값을 가지고 있습니다. 또한 addAttribute()와 같은 기능을 통해 모델에 원하는 속성과 그것에 대한 값을 주어 전달할 뷰에 데이터를 전달할 수 있습니다.

 

Spring에서 Controller의 메서드를 작성할 때는 특별하게 Model이라는 타입을 파라미터로 지정할 수 있습니다. Model 객체는 JSP에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할을 하는 존재입니다. 이를 이용해서 JSP와 같은 뷰(View)로 전달해야 하는 데이터를 담아서 보낼 수 있습니다. 메서드의 파라미터에 Model 타입이 지정된 경우에는 스프링은 특별하게 Model 타입의 객체를 만들어서 메서드에 주입하게 됩니다.



https://nancording.tistory.com/90



## javaspring th(thymeleaf)temaplate역할



th:



변수:${}  <- th:text="${test}"

객체변수값:*{} 

메시지:#{} : 

링크:@{} <- th:href="@{/link}"



https://sidepower.tistory.com/145



## @RequestParam

@RequestParam("가져올 데이터의 이름") [데이터타입] [가져온데이터를 담을 변수]

출처: https://hongku.tistory.com/119 [IT에 취.하.개.]



추가)HttpServletRequest에 대한 자세한 내용 아래 링크

https://zester7.tistory.com/33



## Annotation(어노테이션)이란

1. @를 이용한 주석, 자바코드에 주석을 달아 특별한 의미를 부여한 것
    (참고로 클래스, 메소드, 변수 등 모든 요소에 선언이 가능)

   

2.  메타데이터(실제데이터가 아닌 Data를 위한 데이터) 라고도 불리고 JDK5부터 등장

   

3. 컴파일러가 특정 오류를 억제하도록 지시하는 것과 같이 프로그램 코드의 일부가 아닌
    프로그램에 관한 데이터를 제공, 코드에 정보를 추가하는 정형화된 방법.





## @ResponseBody

메소드에 @ResponseBody 로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은 View 를 통해서 

출력되지 않고 HTTP Response Body 에 직접 쓰여지게 됩니다.

이때 쓰여지기 전에 리턴되는 데이터 타입에 따라 MessageConverter 에서 변환이 이뤄진 후 쓰여지게 됩니다.



Http body부분에 직접 넣어주겠다.



출처: https://ismydream.tistory.com/140 [창조적고찰]



# 1/15(토)

## NPE(NullPointerException)

개발을 할 때 가장 많이 발생하는 예외 중 하나가 바로 NPE다. NPE를 피하기 이ㅜ해서는 null을 검사하는 로직을 추가해야 한는데, null검사를 해야하는 변수가 많은 경우 코드가 복잡해지고 로직이 상당히 번거롭다. 그렇기 때문에 null 대신 초기값을 사용하길 권장하기도 한다.

이 NPE를 보완하기 위해 Optional이라는 클래스가 java8에서부터 추가되었다.



## Optional< T >

Optional은 null이 올 수 있는 값을 감싸는 Wrapper클래스로, 참조하더라도 NPE가 발생하지 않도록 도와준다.Optional클래스는 아래와 같은 value값을 저장하기 때문에 null이더라도 바로 NPE가 발생하지 않으며, 클래스이기 때문에 각종 메소드를 제공해준다.

아래 사이트는 Optional 활용하는 법에 대해 나와있다.

https://mangkyu.tistory.com/70



## findById, findByName, findAll

데이터베이스에 있는 Id, Name 또는 전체적인 것들을 가져오는 것이다.



## extends, implements

extend는 상속을 구현해주는 키워드 입니다. 부모클래스가 가진 메소드나 변수를 자식 클래스가 물려받아서 사용할 수 있게합니다.

extends는 class가 class를 상속할 경우, interface가 interface를 상속할 경우가 있습니다.

class->interface는 안됨



implements는 부모객체에는 메소드나 변수를 선언만 하고 기능적인 구현은 하지 않고, 자식 클래스에서 선언만 된 메스드를 @Override로 구현해주는 것을 말합니다.

자식 클래스에 implements 키워드를 적어주는 것으로 상속받게 됩니다.

자식클래스에서 사용될 부모 클래스의 메소드는 반드시 @Override를 통해서 구현해야 합니다.



## @Override

오버라이딩: 슈퍼클래스에 존재하는 필드나 메소드를 서브 클래스에서 재정의하여 사용할 수 있다.

상속받은 메서드를 재정의할 때 메서드 이름이 틀리지 않게 쓰기 위한 어노테이션.



아래는 괜찮은 답변

```
상속받은 메서드를 재정의할 때 메서드 이름이 틀리지 않게 쓰기 위한 어노테이션입니다~

가령 부모 객체에 printerA 라는 메서드가 있고 상속을 받은 객체에서 printerA 를 재정의해서 쓰고 싶을 때 만약 printerAA 라고 오타를 입력하고 만들 수 있습니다.

이 경우 @Override 어노테이션이 붙어 있었다면 부모 객체엔 이런 메서드가 없어 하고 에러를 내 줍니다.

@Override 어노테이션이 붙어 있지 않았다면 상속 받은게 아니고 그냥 새로운 메서드를 만들어 쓴 것이기 때문에 컴파일러는 에러를 내지 않습니다.

결론적으로, 사람의 실수를 막아 주기 위한 어노테이션입니다 ^^
```



## sequence

시퀀스는 인덱스를 자동 증가시키기 위해 사용되며 꼭 인덱스가 아니더라도 0,1,2....순으로 연속된 숫자를 원할때 사용한다.



## 동시성, feat 프로세스, 쓰레드

참고 사이트 

https://velog.io/@dyllis/%EB%8F%99%EC%8B%9C%EC%84%B1%EC%9D%B4-%EB%AC%B4%EC%97%87%EC%9D%BC%EA%B9%8C



## 스트림(Stream)이란

스트림은 자바8부터 추가된 컬렉션의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자입니다. 람다식으로 요소처리 코드를 제공하여 코드가 좀더 간결하게 할 수 있다는 점과 내부 반복자를 사용함으로써 병렬처리가 쉽습니다.



## 람다식

람다식이란 함수를 하나의 식으로 표현한 것이다. 함수를 람다식으로 표현하면 메소드의 이름이 필요없기 때문에, 람다식은 익명함수의 한 종류라고 볼 수 있다.

```
// 기존의 방식 반환티입 메소드명 (매개변수, ...) { 실행문 } // 
예시 public String hello(){
	return "Hello World!";
}
```

```
// 람다 방식 (매개변수, ... ) -> { 실행문 ... } 
// 예시 () -> "Hello World!";
```

람다식 예시 및 추가정보

https://mangkyu.tistory.com/113





## Test관련 어노테이션

\- JUnit4때와 같이 **@Test** 어노테이션은 테스트를 만드는 모듈 역할을 한다. @Test가 붙어있는 메소드는 main 메소드처럼 IDE로 직접 실행할 수 있는 메소드이다.

\- **@Disabled** 어노테이션은 특정 메소드가 @Deprecated 되었거나 테스트에 확실히 passed되는 경우가 아닐때 실행되지 않도록 처리하는 부분이다. 에러를 수정하거나 테스트를 제거하는 등 확실한 처리가 더 중요하지 @Disabled를 그대로 두는 것은 좋지 않다고 한다.

\- **@BeforeAll, @AfterAll** 어노테이션은 이름만 봐도 알겠듯이 클래스에 존재하는 모든 메소드를 실행한다고 할때, 메소드 시작하기전, 끝난 후에 실행되는 단위들이다. 

\- **@BeforeEach, @AfterEach** 어노테이션들은 마찬가지로 각각의 Test 메소드가 실행될 때 호출되는 메소드이다. 각각의 메소드가 실행 전, 실행 후에 호출되어 처리되는 것들이다. @BeforeEach는 공통적인 Param 및 설정을 할때 호출되면 좋을 부분이다. **@AfterEach**는 사용되고 난 후 종료되어야할 리소스를 처리하는 부분으로 사용될 가능성이 높다.



## Assertion

불리언식을 포함하고 있는 문장으로서, 프로그래머는 그 문장이 실행될 경우 불리언 식이 참이라고 단언 할 수 있다. 즉 개발자가 자신이 개발한 프로그램에서 가정하고 있는 사실이 올바른지 검사 할 수 있도록 하기 위해 사용됨.



assertions.하면서 사용되는 기능들

```
assertArrayEquals(a, b); 

 - 배열 A와 B가 일치함을 확인한다.


assertEquals(a, b);

 - 객체 A와 B가 일치함을 확인한다.(두 값이 같으면)

assertEquals(a, b, c);


 - 객체 A와 B가 일치함을 확인한다.

 - a: 예상값, b:결과값, c: 오차범위


assertSame(a, b); 

 - 객체 A와 B가 같은 객임을 확인한다.(두 객체의 주소값이 같으면)


assertTrue(a); 

 - 조건 A가 참인가를 확인한다.


assertNotNull(a); 

 - 갹채 A가 null이 아님을 확인한다


출처: https://lee-mandu.tistory.com/398?category=633568 [개발/일상_Mr.lee]
```





## final

final은 오직 한번만 할당 할 수 있는 enitiy를 정의할 때 사용된다. final로 선언된 변수가 할당되면 항상 같은 값을 가진다. 만약 final변수가 객체를 참조하고 있다면, 그 객체의 상태가 바뀌어도 final변수는 매번 동일한 내용을 참조한다.



## @Autowired

필요한 의존 객체의 "타입"에 해당하는 빈을 찾아 주입한다.

총 3가지: 생성자, setter, 필드가 있으며 보통 생성자를 많이 사용한다.



Autowired는 기본값이 trueㅇ기 때문에 의존성 주입을 할 대상을 찾지 못한다면 애플리케이션 구동에 실패한다.



자세한 내용은 링크 참고: https://devlog-wjdrbs96.tistory.com/166



## @Service

서비스 레이어, 내부에서 자바 로직을 처리함



## @Repository

퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업을 처리함



## @Configuration

@Configuration이라고 하면 설정파일을 만들기 위한 애노테이션 or Bean을 등록하기 위한 애노테이션이다.

@Configuration 애노테이션을 사용하면 가시적으로 설정파일이야 ~ , Bean 등록할꺼야 ~ 라는건 알수있다.



Bean을 등록할 때 싱글톤(singelton)이 되도록 보장해준다.

스프링컨테이너에서 Bean을 관리 할 수 있게 됨.

https://castleone.tistory.com/2



## 싱글톤

Singleton(이하 싱글톤) 패턴은 자바에서 많이 사용한다.
먼저 싱글톤이란

어떤 클래스가 최초 한번만 메모리를 할당하고(Static) 그 메모리에 객체를 만들어 사용하는 디자인 패턴 을 의미한다.
즉 생성자의 호출이 반복적으로 이뤄져도 실제로 생성되는 객체는 최초 생성된 객체를 반환 해주는 것이다.



한번의 객체 생성으로 재 사용이 가능하기 때문에 메모리 낭비를 방지할 수 있다.
또한 싱글톤으로 생성된 객체는 무조건 한번 생성으로 전역성을 띄기에 다른 객체와 공유가 용이하다.
이렇게만 보면 싱글턴이 좋아보일 수 있지만 문제점도 존재한다.



일단 싱글톤으로 만든 객체의 역할이 간단한 것이 아닌 역할이 복잡한 경우라면 해당 싱글톤 객체를 사용하는 **다른 객체간의 결함도**가 높아져서 객체 지향 설계 원칙에 어긋나게 된다. (개방-폐쇄)
또한 해당 싱글톤 객체를 수정할 경우 싱글톤 객체를 사용하는 곳에서 **사이드 이팩트** 발생 확률이 생기게 되며, **멀티 쓰래드**환경에서 동기화 처리 문제등이 생기게 된다.



## redirect

**Redirect**는 Web Container로 명령이 들어오면, 웹 브라우저에게 다른 페이지로 이동하라고 명령을 내립니다.





