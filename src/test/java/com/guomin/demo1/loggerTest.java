package com.guomin.demo1;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Demo1Application.class)//希望和正式环境的配置类用一样的
public class loggerTest {

    private static final Logger logger = LoggerFactory.getLogger(loggerTest.class);

    @Test
    public void testLogger(){
        System.out.println(logger.getName());

        logger.debug("debig log");
        logger.info("info log");
        logger.error("error log");

    }
}
