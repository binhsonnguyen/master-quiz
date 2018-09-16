package mst.codegym.service.impl;

import mst.codegym.model.TestQuestion;
import mst.codegym.service.TestQuestionService;

public class TestQuestionServiceImpl implements TestQuestionService {
    private static long autoIncreasement = 0;

    @Override
    public void save(TestQuestion question) {
        question.setId(autoIncreasement++);
    }
}
