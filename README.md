# 개발환경 설정(2022-01-10 ~ 2022-01-11)
### 인텔리제이 사용 (backend + frontend)
![개발환경 프로젝트 구조](https://lab.ssafy.com/s06-webmobile2-sub1/S06P11C103/-/raw/develop_seongwon/img/%EC%BA%A1%EC%B2%986.PNG)
### 실행화면 (메인화면)
![메인화면](https://lab.ssafy.com/s06-webmobile2-sub1/S06P11C103/-/raw/develop_seongwon/img/%EC%BA%A1%EC%B2%987.PNG)
### 실행화면 (방 상세화면)
![방 상세화면](https://lab.ssafy.com/s06-webmobile2-sub1/S06P11C103/-/raw/develop_seongwon/img/%EC%BA%A1%EC%B2%988.PNG)
### 실행화면 (로그인 - 토큰 생성)
![로그인 - 토큰 생성](https://lab.ssafy.com/s06-webmobile2-sub1/S06P11C103/-/raw/develop_seongwon/img/%EC%BA%A1%EC%B2%989.PNG)

# React Basic Course Study Plan
![React](https://lab.ssafy.com/s06-webmobile1-sub1/S06P11C108/-/raw/swchae516/img/react-logo.png)
[React](https://ko.reactjs.org/)<br>
[Create React App](https://create-react-app.dev/docs/getting-started/)

## 2022-01-12
* 필요한 툴 설치
  - node (14.18.0)
  - npm (6.14.15)
  - yarn (1.22.17)
* 중요한 툴들 설명
  - node.js : 어느 곳에서나 자바스크립트로 프로그래밍이 가능하게 하는 프레임워크입니다.
  - npm : 패키지 매니저입니다. 외부 라이브러리를 쉽게 관리할 수 있습니다.
  - npx : 원하는 라이브러리를 실행할 수 있게 하는 툴입니다.
  - yarn : npm의 단점을 보완하기 위해 페이스북에서 만든 새로운 패키지 매니저입니다.
* 리액트 test 프로젝트
  - create-react-app
  ![test 프로젝트](https://lab.ssafy.com/s06-webmobile1-sub1/S06P11C108/-/raw/swchae516/img/%EC%BA%A1%EC%B2%981.PNG)
* 리액트 컴포넌트
  - 리액트는 컴포넌트들이다.
  - 클래스 컴포넌트 VS 함수 컴포넌트
  - 클래스 컴포넌트 : 상태, 데이터를 담을 수 있는 스테이트라는 오브젝가 들어있다. 
  - 함수 컴포넌트 : 한 가지 기능을 수행하는 단위, 스테이나 라이프 사이클 메서드가 없었지만, React Hook이 도입되면서 스테이트와 라이프 사이클 메서드를 사용가능
  - 함수 컴포넌트가 도입된 이유는 클래스 컴포넌트가 어렵기 때문!!!(바인딩 이슈)
* JSX
  - HTMl과 JSX의 차이점 : class VS className / onclick VS onClick / HTML은 마크업 언어이고 JSX는 자바스크립트 코드(비즈니스 로직)
  - JSX는 한가지의 태그로 감싸주어야 한다.(<React.Fragment></React.Fragment>)
  - JSX에서는 자바스크립트 코드를 작성할 수 있다.
  ![JSX 기초](https://lab.ssafy.com/s06-webmobile1-sub1/S06P11C108/-/raw/swchae516/img/%EC%BA%A1%EC%B2%982.PNG)
  
  ## 2022-01-13
  ### 리액트 컴포넌트
   리액트에서 컴포넌트란 웹어플리케이션, 웹페이지에서 독립적이고 재사용이 가능한 단위로(박스 단위로) 나뉘어진 블럭을 말한다.
   최대한 독립적이고 재사용이 가능한 작은 단위로 만들어 나가는게 좋다.
  ### 클래스 컴포넌트
  ![클래스 컴포넌트](https://lab.ssafy.com/s06-webmobile1-sub1/S06P11C108/-/raw/swchae516/img/%EC%BA%A1%EC%B2%983.PNG)<br>
   리액트에서 제공하는 React.Component 클래스를 상속하는 클래스를 만들면 되고, UI가 어떻게 표기 될 것인지 정의하는 rander()함수를 구현해 주면된다.
   컴포넌트 자체에 계속 기억이 되어져야 하는, UI를 표기 하기 위한 데이터가 있다면 this.state 멤버 변수에 오브젝트 형태로 데이터를 저장할 수 있다.
   클래스 특성상, 클래스의 멤버 변수를 직접적으로 수정하지 않는 한 멤버 변수는 한번 만들어 지면 계속 그 값이 유지가 된다.
   그래서 rander 함수가 아무리 많이 호출이 되어져도 this.state 에 들어 있는 데이터는 변하지 않기 때문에, 컴포넌트에서 가지고 있던 데이터를 잃어 버리지 않고
   일정하게 데이터를 사용자에게 보여줄 수 있다.
  ### 함수형 컴포넌트
  ![함수형 컴포넌트](https://lab.ssafy.com/s06-webmobile1-sub1/S06P11C108/-/raw/swchae516/img/%EC%BA%A1%EC%B2%984.PNG)<br>
   리액트에서 컴포넌트를 만들 수 있는 또 다른 방법으로는 JSX를 리턴하는 함수를 정의하면 된다.
   컴포넌트 자체에 데이터(State)가 없는 경우, 외부에서 전달받은 데이터(Props)만 보여주면 되거나, 아니면 State, Props 둘다 없는 아주 정적인 컴포넌트인 경우
   굳이 클래스를 정의 하지 않고 함수 만으로 리액트 컴포넌트를 만들 수 있다.
  ### 리액트 훅 (React Hooks)
  훅(갈고리) 이라고 이름 지어진 이 리액트 훅은 함수형 컴포넌트에서 클래스 컴포넌트에서만 이용이 가능했던 State와 라이프 싸이클 메소드들을 이용할 수 있도록
  도와주는, 함수형 컴포넌트에 리액트의 다른 기능들을 갈고리처럼 연결해준다.
  리액트에서 기본적으로 제공되는 훅들은 use로 시작하는 함수이다. 그리고 여러 컴포넌트에서 재사용 될 수 있는 로직들 이라면 우리가 스스로 정의해서도 만들 수 
  있다. (Custom Hooks)
  ### Ref
  Ref는 render 메서드에서 생성된 DOM 노드나 React 엘리먼트에 접근하는 방법을 제공한다.
   - 포커스, 텍스트 선택영역, 혹은 미디어의 재생을 관리할 때
   - 애니메이션을 직접적으로 실행시킬 때
   - 서드파티 DOM 라이브러리를 React와 같이 사용할 때
  ### Habit Tracker
  기본적인 리액트 개념을 공부하고, 공부한 내용을 바탕으로 Habit Tracker라는 리액트 프로젝트를 진행했습니다. 자신의 습관을 정리해서 관리할 수 있는 어플리케이션
  입니다. 
  이 프로젝트를 통해 리액트 컴포넌트에 대한 개념을 이해했으며, JSX 문법과 Props와 State의 개념과 차이에 대해서 이해할 수 있었습니다.
  특히, 클래스형 컴포넌트와 함수형 컴포넌트를 이해하기 위해서 2개의 프로젝트(class, function)로 진행했습니다.
  
  ![Habit Tracker](https://lab.ssafy.com/s06-webmobile1-sub1/S06P11C108/-/raw/swchae516/img/%EC%BA%A1%EC%B2%985.PNG)<br>
