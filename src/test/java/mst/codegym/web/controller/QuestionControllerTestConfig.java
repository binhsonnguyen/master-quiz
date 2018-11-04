package mst.codegym.web.controller;

import mst.codegym.service.TestQuestionService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan("mst.codegym")
public class QuestionControllerTestConfig {
  @Bean
  public TestQuestionService testQuestionService() {
    return Mockito.mock(TestQuestionService.class);
  }

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .setName("master-quiz")
        .build();
  }
}
