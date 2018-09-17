package mst.codegym.service;

import mst.codegym.model.TestQuestion;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface TestQuestionService {
    @Transactional
    TestQuestion find(long id);

    @Transactional
    void save(TestQuestion question);
}
