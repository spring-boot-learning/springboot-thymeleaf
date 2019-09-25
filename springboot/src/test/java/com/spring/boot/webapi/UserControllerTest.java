package com.spring.boot.webapi;

import com.google.gson.Gson;
import com.spring.boot.App;
import com.spring.boot.entity.User;
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
public class UserControllerTest {

    @Autowired
    private UserController userController;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setName("测试用户1");
        user.setLoginName("user1");
        user.setPassword("admin");
        Gson gosn = new Gson();
        RequestBuilder builder = MockMvcRequestBuilders
                .post("/user")
                .locale(Locale.SIMPLIFIED_CHINESE)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gosn.toJson(user));

        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setName("测试用户11");
        user.setLoginName("user11");
        user.setPassword("admin");
        Gson gosn = new Gson();
        RequestBuilder builder = MockMvcRequestBuilders
                .put("/user/7")
                .locale(Locale.US)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gosn.toJson(user));
        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testDeleteUser() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .delete("/user/7")
                .locale(Locale.JAPAN)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testGetUserById() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/user/3")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println("查询结果：" + result.getResponse().getContentAsString());
    }

    @Test
    public void testGetUsers() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/user")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println("查询结果：" + result.getResponse().getContentAsString());
    }
}
