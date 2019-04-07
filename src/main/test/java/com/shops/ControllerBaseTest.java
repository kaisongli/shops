package com.shops;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by likaisong on 2019/4/7.
 */
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/spring-web.xml"})
public class ControllerBaseTest extends BaseTest {
    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
}