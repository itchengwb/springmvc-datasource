package org.bobo.mvc.servicetest;

import org.bobo.mvc.BaseTest;
import org.bobo.score.service.HelloService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;


public class HellowServiceTests  extends BaseTest {

    @Autowired
    private HelloService helloService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;


    @Test
    public void sayHello() throws Exception {
            helloService.sayHello();
    }
}
