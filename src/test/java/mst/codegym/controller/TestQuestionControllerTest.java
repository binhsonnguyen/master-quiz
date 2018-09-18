package mst.codegym.controller;

import mst.codegym.model.TestQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
public class TestQuestionControllerTest {
    @InjectMocks
    private TestQuestionController testQuestionController;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(testQuestionController)
                .setCustomArgumentResolvers(pageableHandlerMethodArgumentResolver)
                .build();
    }

    @Test
    public void accessCreateTestQuestionPage() throws Exception {
        TestQuestion question = TestQuestion.builder()
                .build();

        mockMvc.perform(get("/question"))
                .andExpect(status().isOk())
                .andExpect(view().name("question/create"))
                .andExpect(model().attribute("question", question));
    }
}
