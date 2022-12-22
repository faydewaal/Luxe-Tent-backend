package nl.novi.luxetent.controllers;

import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.services.TentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
class TentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TentService tentService;
    Tent tent;

    @BeforeEach
    void setUp() {
        tent = new Tent();
    }


    @Test
    void retrieveTent() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/tents/50"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}