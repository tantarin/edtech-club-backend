package edtech;

import edtech.dto.AdsCreateRequest;
import edtech.dto.NewsCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static edtech.config.Routes.PATH_ADS;
import static edtech.config.Routes.PATH_NEWS;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

