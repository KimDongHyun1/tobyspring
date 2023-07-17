package tobyspring.config.autoconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import tobyspring.config.MyConfigurationProperties;

@Getter
@Setter
@Component
@MyConfigurationProperties(prefix = "server")
public class ServerProperties {
    private String contextPath;
    private int port;

}
