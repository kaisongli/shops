package com.shops.controller;

import com.shops.ControllerBaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by likaisong on 2019/4/7.
 */
public class AreaControllerTest extends ControllerBaseTest {

    @Test
    public void testGetAreaList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/superadmin/listarea")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(2))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
