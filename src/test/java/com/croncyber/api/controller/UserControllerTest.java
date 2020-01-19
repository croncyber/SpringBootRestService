/*
package com.croncyber.api.controller;

import com.croncyber.api.repository.UserRepository;
import com.croncyber.api.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserRepository userRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldGetByAllWhenNoUsersInRepository() {
        //given
        //initial state of the application
        List<User> expectedResult = new ArrayList<>();
        User user1 = new User(1, "Yura", "Lyavinec");
        expectedResult.add(user1);

        when(userRepository.getAll())
                .thenReturn(expectedResult);
        //when
        //execution of the tested method and retrieving result
        Collection<User> actualUsers = getAllUsers();

        //then
        //assert result
        assertThat(actualUsers).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    private Collection<User> getAllUsers() {
        try {
            String contentAsString = mockMvc.perform(get("/users")
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            return objectMapper.readValue(contentAsString, new TypeReference<List<User>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    public void testGetByIdPath() {
    }
//
//    @Ignore
//    @Test
//    public void testGetByIdParam() {
//        userController.getByIdParam(4);
//
//    }
//
//    @Test
//    public void testAddUser() throws Exception {
//        System.out.println("start");
//        User user = new User(1, "Petro", "Bamper");
//        userController.addUser(user);
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

}*/
