package tobyspring.helloboot;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {
    @Test
    void helloApi() {
        // http localhost:9090/app/hello?name=spring
        // restTemplate 보다 TestRestTemplate은 예외처리에서 테스트하기에 유리하다.
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> ret =
                rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");

        assertThat(ret.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(ret.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        assertThat(ret.getBody()).isEqualTo("*Hello Spring*");

    }

    @Test
    void failsHelloApi() {
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> ret =
                rest.getForEntity("http://localhost:9090/app/hello?name=", String.class);

        assertThat(ret.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
