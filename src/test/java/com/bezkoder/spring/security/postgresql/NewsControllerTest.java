package com.bezkoder.spring.security.postgresql;

import com.bezkoder.spring.security.postgresql.dto.NewsCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class NewsControllerTest extends AbstractTestProfileTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/news/list")
                        .with(user("admin").password("pass").roles("USER","ADMIN"))
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        NewsCreateRequest request = new NewsCreateRequest();
        request.setHeader("header");
        request.setContent("content");

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/news/list")
                        .with(user("admin").password("pass").roles("USER","ADMIN"))
                        .content(asJsonString(request))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
