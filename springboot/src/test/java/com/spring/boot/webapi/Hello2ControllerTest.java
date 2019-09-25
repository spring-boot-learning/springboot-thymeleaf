package com.spring.boot.webapi;

import com.spring.boot.App;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Locale;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class Hello2ControllerTest {

    @Autowired
    private Hello2Controller helloController;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void testHelloChn() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/hello2/name/lidawei")
                .locale(Locale.SIMPLIFIED_CHINESE)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8);

        MvcResult result = mvc.perform(builder).andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testHelloEng() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/hello2/name/lidawei").locale(Locale.US);
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mvc.perform(builder).andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        System.out.println(result.getResponse().getContentAsString());
    }
}
