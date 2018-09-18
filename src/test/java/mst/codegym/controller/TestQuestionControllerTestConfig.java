package mst.codegym.controller;

import mst.codegym.service.TestQuestionService;
import mst.codegym.service.impl.TestQuestionServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("mst.codegym")
public class TestQuestionControllerTestConfig {
    @Bean
    public TestQuestionService testQuestionService() {
        return Mockito.mock(TestQuestionServiceImpl.class);
    }
}
