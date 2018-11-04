package mst.codegym.web.controller;

import mst.codegym.model.Question;
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
@SpringJUnitJupiterConfig(QuestionControllerTestConfig.class)
class QuestionControllerTest {
  private static long sampleId;
  private static String sampleContent;
  private static String sampleDescriptions;
  private static String sampleHint;
  private static Question emptyQuestion;
  private static Question sampleQuestion;

  static {
    sampleId = 1;
    sampleContent = "Sample Content";
    sampleDescriptions = "Sample Descriptions";
    sampleHint = "Sample Hint";
    emptyQuestion = Question.builder()
        .build();
    sampleQuestion = Question.builder()
        .id(sampleId)
        .content(sampleContent)
        .descriptions(sampleDescriptions)
        .hint(sampleHint)
        .build();
  }

  @InjectMocks
  private QuestionController questionController;

  @Autowired
  private TestQuestionService testQuestionService;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(questionController).build();
  }

  @Test
  void testAccessCreateTestQuestionPage() throws Exception {
    mockMvc
        .perform(get("/question"))
        .andExpect(status().isOk())
        .andExpect(view().name("question/create"))
        .andExpect(model().attribute("question", emptyQuestion));
  }

  @Test
  void testCreateTestQuestion() throws Exception {
    doNothing()
        .when(testQuestionService)
        .save(isA(Question.class));

    mockMvc
        .perform(post("/question")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("content", sampleContent)
            .param("descriptions", sampleDescriptions)
            .param("hint", sampleHint))
        .andExpect(status().isFound())
        .andExpect(redirectedUrlPattern("/question/details/*"));
  }

  @Test
  void testAccessTestQuestionDetailsPage() throws Exception {
    when(testQuestionService.find(sampleId))
        .thenReturn(sampleQuestion);

    mockMvc
        .perform(get("/question/details/" + sampleId))
        .andExpect(status().isOk())
        .andExpect(view().name("question/details"))
        .andExpect(model().attribute("question", sampleQuestion));
  }
}
