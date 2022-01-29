package com.cos.jwtex01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class Test1 {

	@Test
	public void 컬렉션_테스트() {
			String[] str = {"ROLE_USER", "ROLE_ADMIN", "ROLE_MANAGER"};
			List<String> list = Arrays.asList(str);
			for (String s : list) {
				System.out.println(s);
			}
	}
}
