package mst.codegym.service;

import mst.codegym.model.TestQuestion;
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
public class TestQuestionServiceTest {
    @Autowired
    private TestQuestionService testQuestionService;

    @Autowired
    private TestQuestionRepository testQuestionRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindTestQuestionById() {
        TestQuestion question = TestQuestion.builder()
                .id(1)
                .content("a sample content")
                .descriptions("a sample description")
                .hint("a sample description")
                .build();

        when(testQuestionRepository.findOne((long) 1)).thenReturn(question);
        assertEquals(question, testQuestionService.find(1));
        verify(testQuestionRepository).findOne((long) 1);
    }
}
