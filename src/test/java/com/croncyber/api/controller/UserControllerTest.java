package com.croncyber.api.controller;

import com.croncyber.api.Application;
import com.croncyber.api.dao.InMemoryUserRepository;
import com.croncyber.api.model.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserControllerTest {

    //JsonPath jsonPath;
   // String value = jsonPath.getString("blogs[0].posts[0].author.name");

    @InjectMocks
    private UserController userController = new UserController(new InMemoryUserRepository());

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
       // jsonPath = new JsonPath(");
    }

    @Test
    public void testGetById() throws Exception {
    mockMvc.perform(get("/users/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));



    }

    @Ignore
    @Test
    public void testGetByIdPath() {
        userController.getByIdPath(1);
    }

    @Ignore
    @Test
    public void testGetByIdParam() {
        userController.getByIdParam(4);

    }

    @Test
    public void testAddUser() throws Exception {
        System.out.println("start");
        User user = new User(1, "Petro", "Bamper");
        userController.addUser(user);
//        String inputJson = "{\n" +
//                "  \"firstname\": \"Petro\",\n" +
//                "  \"lastname\": \"Bamper\"\n" +
//                "}";
//        mockMvc.perform(post("/users/2")
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson)).andReturn();
//        MvcResult mvcResult = mockMvc.perform(get("users/2"))
//                .
//mvcResult.getResponse().
//        assertEquals(, "User " + user.getLastName() + " has been saved");
    }
}