package mst.codegym.service;

import mst.codegym.model.Question;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface TestQuestionService {
  @Transactional
  Question find(long id);

  @Transactional
  void save(Question question);
}
