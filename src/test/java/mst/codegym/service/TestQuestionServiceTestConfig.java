package mst.codegym.service;

import mst.codegym.repository.TestQuestionRepository;
import mst.codegym.service.impl.TestQuestionServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestQuestionServiceTestConfig {
  @Bean
  public TestQuestionService testQuestionService() {
    return new TestQuestionServiceImpl();
  }

  @Bean
  public TestQuestionRepository testQuestionRepository() {
    return Mockito.mock(TestQuestionRepository.class);
  }
}
