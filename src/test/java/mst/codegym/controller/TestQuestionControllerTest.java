package mst.codegym.controller;

import mst.codegym.model.TestQuestion;
import mst.codegym.service.TestQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@SpringJUnitJupiterConfig(TestQuestionControllerTestConfig.class)
public class TestQuestionControllerTest {
    @InjectMocks
    private TestQuestionController testQuestionController;

    @Autowired
    private TestQuestionService testQuestionService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(testQuestionController)
                .build();
    }

    @Test
    public void testAccessCreateTestQuestionPage() throws Exception {
        TestQuestion question = TestQuestion.builder()
                .build();

        mockMvc.perform(get("/question"))
                .andExpect(status().isOk())
                .andExpect(view().name("question/create"))
                .andExpect(model().attribute("question", question));
    }

    @Test
    public void testCreateTestQuestion() throws Exception {
        doNothing().when(testQuestionService).save(isA(TestQuestion.class));

        mockMvc.perform(post("/question")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", "a sample content")
                .param("descriptions", "a sample description")
                .param("hint", "a sample description")
        )
                .andExpect(status().isFound())
                .andExpect(redirectedUrlPattern("/question/details/*"));
    }

    @Test
    public void testAccessTestQuestionDetailsPage() throws Exception {
        TestQuestion question = TestQuestion.builder()
                .id(1)
                .content("a sample content")
                .descriptions("a sample description")
                .hint("a sample description")
                .build();

        when(testQuestionService.find(1)).thenReturn(question);

        mockMvc.perform(get("/question/details/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("question/details"))
                .andExpect(model().attribute("question", question));
    }
}
