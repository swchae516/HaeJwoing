import React from 'react';
import styles from './login.module.css';
import { FcGoogle } from 'react-icons/fc';
import { SiNaver } from 'react-icons/si';
import { RiKakaoTalkFill } from 'react-icons/ri';

const Login = props => (
  <>
    <section className={styles.section}>
      <div className={styles.login}>
        <h1 className={styles.h1}>로그인</h1>
        <ul className={styles.list}>
          <li className={styles.item}>
            <button className={styles.google}>
              <FcGoogle className={styles.icon} />
              Google 계정으로 로그인
            </button>
          </li>
          <li className={styles.item}>
            <button className={styles.naver}>
              <SiNaver className={styles.icon} />
              Naver 계정으로 로그인
            </button>
          </li>
          <li className={styles.item}>
            <button className={styles.kakao}>
              <RiKakaoTalkFill className={styles.icon} />
              Kakao 계정으로 로그인
            </button>
          </li>
          <hr className={styles.hr} />
          <span>
            해줘잉이 처음이신가요? <a href="#">회원가입</a>
          </span>
        </ul>
      </div>
    </section>
  </>
);

export default Login;
