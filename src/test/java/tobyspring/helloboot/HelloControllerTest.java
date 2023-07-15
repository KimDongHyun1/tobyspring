package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelloControllerTest {

    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Spring");

        assertThat(ret).isEqualTo("Spring");
    }

    @Test
    void helloControllerExcept() {
        HelloController helloController = new HelloController(name -> name);

        assertThrows(IllegalArgumentException.class, () -> {
            helloController.hello(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            helloController.hello("");
        });
    }

}
