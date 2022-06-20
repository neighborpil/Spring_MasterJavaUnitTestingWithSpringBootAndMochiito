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
