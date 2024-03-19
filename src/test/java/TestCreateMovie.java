import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.accessingdatamysql.entity.Movie;

class TestCreateMovie {

	@Test
	void test() {
		Movie mynewMovie = new Movie();
		mynewMovie.setName("Interestellar");
		mynewMovie.setUrl("http://example.com");
		assertEquals("Interestellar",mynewMovie.getName() );
		assertEquals("http://example.com",mynewMovie.getUrl());
	}

}
