package in.venkat.vallabhaneni;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import in.venkat.vallabhaneni.MyBlogApplication;

@SpringBootTest(classes = MyBlogApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@TestPropertySource(locations = "classpath:application-integrationtest.proprties")
public class MyBlogIntegrationTest {

}
