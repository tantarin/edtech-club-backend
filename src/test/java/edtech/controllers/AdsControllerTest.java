package edtech.controllers;

import edtech.AbstractTestProfileTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class AdsControllerTest extends AbstractTestProfileTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    void create() throws Exception {
//        AdsCreateRequest request = new AdsCreateRequest();
//        request.setHeader("header");
//        request.setContent("content");
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post(PATH_ADS)
//                        .with(user("test").password("pass").roles("USER","ADMIN"))
//                        .content(asJsonString(request))
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
}

