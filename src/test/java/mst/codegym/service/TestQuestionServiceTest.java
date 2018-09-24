package mst.codegym.service;

import mst.codegym.model.Question;
import mst.codegym.repository.TestQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringJUnitJupiterConfig(TestQuestionServiceTestConfig.class)
class TestQuestionServiceTest {
    private static long sampleId;
    private static Question sampleQuestion;

    static {
        sampleId = 1;
        sampleQuestion = Question.builder()
                .id(sampleId)
                .content("Sample Content")
                .descriptions("Sample Descriptions")
                .hint("Sample Hint")
                .build();
    }

    @Autowired
    private TestQuestionService testQuestionService;

    @Autowired
    private TestQuestionRepository testQuestionRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindTestQuestionById() {
        when(testQuestionRepository.findOne(sampleId)).thenReturn(sampleQuestion);
        assertEquals(sampleQuestion, testQuestionService.find(1));
        verify(testQuestionRepository).findOne(sampleId);
    }
}
