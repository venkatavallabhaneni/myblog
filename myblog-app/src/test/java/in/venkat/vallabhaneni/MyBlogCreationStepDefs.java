package in.venkat.vallabhaneni;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.venkat.vallabhaneni.domain.MyBlog;

public class MyBlogCreationStepDefs extends MyBlogIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	private ResponseEntity<MyBlog> response;

	private String content;

	@Given("^myblog content Orrange$")
	public void myblog_content_Orrange() throws Throwable {
		content = "Orrange";
	}

	@When("^I call the service create product$")
	public void i_call_the_service_create_product() throws Throwable {

		MyBlog p = new MyBlog();
		p.setContent(content);
		response = restTemplate.postForEntity("/products", p, MyBlog.class);
	}

	@Then("^I should get response with HTTP tatus code (\\d+)$")
	public void i_should_get_response_with_HTTP_tatus_code(int arg1) throws Throwable {

		HttpStatus currentStatusCode = response.getStatusCode();
		assertEquals(currentStatusCode.value(), arg1);

	}

	@Then("^the response should contain the Orrange$")
	public void the_response_should_contain_the_Orrange() throws Throwable {
		if (response != null && response.getStatusCode().is2xxSuccessful()) {
			MyBlog responseBody = response.getBody();
			assertEquals(responseBody.getContent(), "Orrange");

		}
	}
	
	@Given("^product name null$")
	public void product_name_null() throws Throwable {
		content = null;
	}

	@Then("^the response should contain the null$")
	public void the_response_should_contain_the_null() throws Throwable {
		if (response != null ) {
			MyBlog responseBody = response.getBody();
			assertEquals(responseBody.getContent(), null);

		}
	}


}
