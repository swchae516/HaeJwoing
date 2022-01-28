# 공통PJT 1 ~ 2주차

**작성자 : 정정채**



## 0. 프로젝트 아이디어 회의

1. ~~개발자를 위한 강의 모음 사이트~~
2. ~~지도 기반 커뮤니티~~
3. ~~그룹을 만들 수 있는 사진 SNS~~
4. ✔**고민을 내 친구들과 다른 사람들에게 공유하여 결정할 수 있는 SNS사이트!**
   - 결정장애러들을 위한 SNS!
   - 나의 고민을 내 친구들과 다른 사람들에게 공유하여 결정을 떠넘기세요!
   - 투표기능, OX기능 등 여러 기능으로 선택에 도움을 드려요!





## 1. React.js 기본학습

>새로운 팀원 두 분이 오시면서 프론트엔드 3명, 백엔드 3명으로 나누어 진행하게 되었고, 나는 그중 프론트엔드를 맡게 되었다. 기술스택 또한 변화가 생겼다. 원래 프론트엔드 부분에 Vue.js를 쓰기로 했었는데, 협의 끝에 React를 쓰기로 했다. React는 처음 배우는 기술이다. 너무 어려우면 어떨지 걱정되기도 하지만, 힘 닿는 데까지 최대한 열심히 해야겠다. 



### 인프런(inflearn) 강의 학습

- **강의명 : 만들고 비교하며 학습하는 리액트(react)**

- **강사명 : 김정환**



#### 개발환경

- VScode
- Node.js
- git



#### 학습 방법

- 순수 JavaScript 로 검색창 만들어보기
- 이후 React를 적용하여 검색창 만들어보기
- 순수 JavaScript와 React 의 비교를 통해 React의 장점과 작동방식에 대해 이해한다



#### 폴더 구조

![화면 캡처 2022-01-13 191326](C:\Users\multicampus\Desktop\mypjt\pjt01\S06P11C103\README_jjc\화면 캡처 2022-01-13 191326.png)





#### 주요 이해 사항

- 이 강의는 순수 Java 스크립트로 화면을 만든 후 React로 다시 똑같은 화면을 만들며 어떤 차이가 있는지 확인할 수 있는 과제이다. 
- MVC 패턴을 구현하기 위한 함수 및 스켈레톤 코드가 있다. 
- js를 간단히 배우고 바로 Vue.js로 넘어갔기 때문에 순수 js로 이런게 가능한지 처음 알았다. 
- 후에 React와 비교하여 React의 장점이 무엇인지 정확히 알 수 있을듯 싶다.





## 2. JAVA 학습

> 우리 팀은 백엔드를 Spring Boot로 구현한다. 난 프론트엔드를 맡고 있지만, 백엔드 파트에 대한 기본적인 지식이 필요할 것 같다. 그래서 기본적인 코드 이해를 위한 JAVA언어 기본을 학습했다.



### Jump to Java 학습

- 교재명 : 점프 투 자바
- 지은이 : 박응용
- https://wikidocs.net/book/31



#### 개발 환경

- Intellij IDEA Community Edition
- maven
- MariaDB



#### 학습방법

![화면 캡처 2022-01-13 224350](C:\Users\multicampus\Desktop\mypjt\pjt01\S06P11C103\README_jjc\화면 캡처 2022-01-13 224350.png)



- Java 언어에 대한 기본적인 학습 실시
- Java 소스코드 구조, 자료형, 제어문(if, while, for ..) 공부
- 앞으로 상속, 생성자, 인터페이스 등의 객체지향 프로그래밍에 대해 더 공부할 것


# SNS 기본 기능 개발
**작성자 : 정정채**




## 0. 진행 사항
1. 명세서 및 우리 프로젝트에 필요한 화면 및 기술 숙지

2. 기술 학습

3. 화면 구현

   


## 1. 기술 학습
### **React 기본 학습**

   - **react 시작**
   
     ```
     $ npx create-react-app my-app
     ```
   
     - 이후 불필요한 파일 삭제해야함
     
       
   
   - **component 개념 숙지**
   
     - 컴포넌트는 프로젝트의 요소(네비게이션 바, 메인화면, 댓글 창 등 나눌 수 있는 것!)들을 구분하여 코드를 작성할 수 있음
     - react에서 컴포넌트를 형성하는 방법에는 class 컴포넌트, function 컴포넌트 두 가지 방법이 있음
     - class 컴포넌트는 내부에 state를 형성하여 데이터를 활용할 수 있으나 최근에는 잘 쓰이지 않음
   - function 컴포넌트는 내부에 state를 형성할 수는 없으나, hook을 이용하면 가능. 최근에 많이 쓰이는 형태임
     
     
     ```react
     // class 컴포넌트 
     
     export default class KeywordList extends React.Component {
       constructor() {
         super();
     
         this.state = {
           keywordList: [],
         };
       }
     
       render() {
         return <List hasIndex data={keywordList} onClick={onClick} />;
       }
   }
     ```
     
     ```react
     // function 컴포넌트
     
     const List = ({
       data = [],
       hasIndex = false,
       hasDate = false,
       onClick,
       onRemove,
     }) => {
     
       return (
         <ul className="list">
           ...중략...
         </ul>
       );
     };
     
     export default List;
     ```

   

### hook 학습

- **hook**

  - hook은 function 컴포넌트에서 쓸 수 있는 기능

  - hook을 이용하여 class 컴포넌트의 state나, componentDidMount 등을 구현할 수 있음

  - 현재까지 useState, useEffect, useRef 그리고 react_dom의 useHistory 를 숙지했음

    - useState : function 컴포넌트에서 상태관리를 가능하게 해줌

      ```react
      // useState 예시
      const [state, setState] = useState()
      
      // 1. 첫 번째 인자 'state'는 상태를 저장할 변수임
      // 2. 두 번째 인자는 setState(변경할 데이터) 와 같은 방법으로 상태변경 가능
      // 3. useState() 의 괄호 안에는 상태의 초기값을 정할 수 있음
      ```

    - useEffect : 컴포넌트가 렌더링 이후에 어떤 일을 수행할지 정할 수 있음

    - useRef : 특정 DOM을 선택할 수 있음

    - useHistory : 경로를 설정하여 화면이동을 가능하게 해줌



- **hook의 useState, useRef, useEffect를 이용하여 Navbar 만들기**

  - 요구사항
    - 정해진 기준 이하로 화면너비가 작아질 경우 menu 항목 사라지고, 대신 menu 버튼이 나타남
    - 메뉴 버튼을 누를 경우 하단에 extends contents가 뜨도록 함
    - <세부사항은 주석 참고>

  ```react
  import React, { useState, useEffect, useRef } from 'react';
  import { MenuItems } from "./MenuItems"
  import { Button } from "../Button"
  import './Navbar.css'
  
  const Navbar = () => {
      // DOM 선택
      const ref = useRef(null)
  
      // menu 버튼을 눌렀는지 여부 저장, 초기값은 false
      const [clicked, setClicked] = useState(false)
  
      // menu 버튼 누를 때마다 setClicked로 상태변경 (true <--> false)
      const handleClick = () => {
          setClicked(!clicked)
      }
  
      useEffect(() => {
          // Navbar 바깥을 클릭하면 extends contents가 닫아지게끔
          const handleClickOutside = (event) => {
              // menu 버튼이 눌러진 상태에서 선택한 돔이 Nav 바깥일 경우 setClicked로 상태 변경
              if (clicked && ref.current && !ref.current.contains(event.target)) {
                  setClicked(false)
              }
          }
  		
         // 마우스 클릭 감지
          document.addEventListener("mousedown", handleClickOutside)
  
          return () => {
              // 이벤트 초기화
              document.removeEventListener("mousedown", handleClickOutside)
          }
      }, [clicked]) // clicked 가 변경될 때마다 실행
  
      return(
          <nav className="NavbarItems" ref={ref}>
              <h1 className="navbar-logo">React<i className="fab fa-react"></i></h1>
              <div className="menu-icon" onClick={handleClick}>
                  <i className={clicked ? 'fas fa-times' : 'fas fa-bars'}></i>
              </div>
              {/* clicked가 true인 경우 하단에 extends contents 보이게 함 */}
              <ul className={clicked ? 'nav-menu active' : 'nav-menu'}>
                  {MenuItems.map((item, index) => {
                      return (
                          <li key={index}>
                              <a className={item.cName} href={item.url}>
                              {item.title}
                              </a>
                          </li>
                      )
                  })}
              </ul>
              <Button>Sign Up</Button>
          </nav>
      )
  }
  
  export default Navbar
  ```



### REDUX 학습

- Redux

  - props의 불편함을 해결하는 데에 매우 편리한 상태관리 라이브러리

  ```react
  import React from 'react';
  import ReactDOM from 'react-dom';
  import { BrowserRouter } from 'react-router-dom'
  import App from './app.jsx';
  import { Provider } from 'react-redux'
  import { createStore } from 'redux'
  
  
  // state 저장
  const initState = {
  	alarmData: [
      { id: 0,
        img: 'images/img_avatar.png', 
        userName: '정정채',
        content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare pharetra magna, sed ullamcorper magna finibus quis.'
      },
      { id: 1,
        img: 'images/img_avatar2.png', 
        userName: '정하나',
        content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare pharetra magna, sed ullamcorper magna finibus quis.'
      },
      { id: 2,
        img: 'images/img_avatar.png', 
        userName: '정두울',
        content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ornare pharetra magna, sed ullamcorper magna finibus quis.'
      },
    ] 
  }
  
  // 상태 변경 시 사용할 함수 설정
  function reducer(state=initState.alarmData, action){
    if (action.type === "delete") {
      state = state.filter((alarm) => alarm.id !== action.id)   
      return state
    } else {
      return state
    }
  }
  
  let store = createStore(reducer)
  
  ReactDOM.render(
      // Provider 태그 씌움
      <Provider store={store}>
        <BrowserRouter>
          <App />
        </BrowserRouter>
      </Provider>
    
  , document.getElementById('root')
  );
  ```

  



## 학습 예정



#### 1. redux thunk

#### 2. react axios

#### 3. MSW

