# Spring_MasterJavaUnitTestingWithSpringBootAndMockito

## Infos
 - lecture github: https://github.com/in28minutes/spring-unit-testing-with-junit-and-mockito

## Junit5 annotation change
Spring Boot projects with versions >= 2.2.0 use JUnit 5 by default.

|Description|JUnit 4| JUnit 5|
|--|--|--|
|Test Annotation Changes|`@Before`<BR/>`@After`<BR/>`@BeforeClass`<BR/>`@AfterClass`<BR/>`@Ignore`|`@BeforeEach`<BR/>`@AfterEach`<BR/>`@BeforeAll`<BR/>`@AfterAll`<BR/>`@Disabled`|
|Use `@ExtendWith` instead of `@RunWith`|`@RunWith(SpringJUnit4ClassRunner.class)`<BR/>`@RunWith(MockitoJUnitRunner.class)`|`@ExtendWith(SpringExtension.class)` <BR/>`@ExtendWith(MockitoExtension.class)`|
|Package changes to `org.junit.jupiter` |`org.junit.Test;` <BR/> `org.junit.Assert.*;`|`org.junit.jupiter.api.Test;` <BR/>`org.junit.jupiter.api.Assertions.*;`|
|`@RunWith` is NOT needed with `@SpringBootTest`, `@WebMvcTest`, `@DataJpaTest`|`@RunWith(SpringRunner.class)`<BR/>`@SpringBootTest(classes = DemoApplication.class)`|`@SpringBootTest(classes = DemoApplication.class)`|


### Unit Testing을 위하여 data.sql을 사용 할 때에,
 - /test/resources/data.sql을 넣어두면 정상적으로 데이터가 추가되어 동작한다

### @WebMvcTest
 - 단일 클래스를 테스트 할때에 사용

### @SpringBootTest
 - Integration Test를 사용할 때에 사용. 
 - 스프링 부트 어플리케이션이 메모리에 탑재되어 모든 데이터 사용 가능


## 특정 application.properties를 사용하는 방법
### 1. /test/resources/application.properties 파일을 생서하고 거기에 오버라이딩해서 내용을 적는다
### 2. 클래스 위에 @TestPropertySource를 적는다
```
package com.neighborpil.unittesting.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = {"classpath:test-configuration.properties"})
class UnitTestingApplicationTests {

	@Test
	void contextLoads() {
	}

}
```


