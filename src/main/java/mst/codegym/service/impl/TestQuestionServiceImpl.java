package mst.codegym.service.impl;

import mst.codegym.model.TestQuestion;
import mst.codegym.service.TestQuestionService;

import java.util.ArrayList;
import java.util.List;

public class TestQuestionServiceImpl implements TestQuestionService {
    private static long autoIncreasement = 0;

    List<TestQuestion> questions = new ArrayList<>();

    @Override
    public TestQuestion find(long id) {
        return questions.stream()
                .filter(question -> question.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public void save(TestQuestion question) {
        question.setId(autoIncreasement++);
        questions.add(question);
    }
}
