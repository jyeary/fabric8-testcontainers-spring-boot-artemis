package com.example.spring.fabric8;

import java.util.concurrent.TimeUnit;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CamelSpringBootTest
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private CamelContext camelContext;

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldProduceMessages() throws Exception {
        NotifyBuilder notify = new NotifyBuilder(camelContext).whenDone(1).create();
        assertTrue(notify.matches(10, TimeUnit.SECONDS));
    }

}
