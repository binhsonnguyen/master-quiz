package mst.codegym.repository;

import mst.codegym.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface TestQuestionRepository extends CrudRepository<Question, Long> {
}
