package mst.codegym.service.impl;

import mst.codegym.model.TestQuestion;
import mst.codegym.repository.TestQuestionRepository;
import mst.codegym.service.TestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;

public class TestQuestionServiceImpl implements TestQuestionService {

    @Autowired
    private TestQuestionRepository testQuestionRepository;

    @Override
    public TestQuestion find(long id) {
        return testQuestionRepository.findOne(id);
    }

    @Override
    public void save(TestQuestion question) {
        testQuestionRepository.save(question);
    }
}
