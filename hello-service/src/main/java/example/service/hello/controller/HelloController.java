package example.service.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @MessageMapping("hello")
    public Mono<String> hello() {
        return null;
    }

    @MessageMapping("helloSecure")
    public Mono<String> helloSecure() {
        return null;
    }
}
