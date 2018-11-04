package mst.codegym.web.view.thymeleaf.processor;

import mst.codegym.web.view.thymeleaf.dialect.MarkdownDialect;
import mst.codegym.web.view.thymeleaf.util.TestExecutorFactory;
import org.junit.jupiter.api.Test;
import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarkDownProcessorTest {
  @Test
  void testMarkDownProcessor() {
    final List<IProcessorDialect> neededDialects =
        Arrays.asList(new StandardDialect(), new MarkdownDialect());
    final TestExecutor executor = TestExecutorFactory.createInstance(neededDialects);
    executor.execute("classpath:thymeleaf-tests/markdown.thtest");
    assertTrue(executor.isAllOK());

  }
}
