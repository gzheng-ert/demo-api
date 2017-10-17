package com.gz.demoapi;

import com.gz.demoapi.model.Thing;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoapiApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testGetAllThings() throws JSONException {
		ResponseEntity<String> entity = this.testRestTemplate.getForEntity("/things", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		String expected = "[{\"id\":2,\"name\":\"thing2\"},{\"id\":1,\"name\":\"thing1\"},{\"id\":3,\"name\":\"thing3\"},{\"id\":4,\"name\":\"thing4\"},{\"id\":5,\"name\":\"thing5\"}]";
		JSONAssert.assertEquals(expected, entity.getBody(), false);
	}

	@Test
	public void testGetOneThing() {
		ResponseEntity<Thing> entity = this.testRestTemplate.getForEntity("/things/2", Thing.class);
		Thing thing2 = entity.getBody();
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(thing2.getId()).isEqualTo(2);
		assertThat(thing2.getName()).isEqualTo("thing2");
	}

	@Test
	public void testGetNonExistentThing() {
		ResponseEntity<String> entity = this.testRestTemplate.getForEntity("/things/88", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}
