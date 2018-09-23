package mst.codegym.web.view.thymeleaf.processor;

import mst.codegym.web.view.thymeleaf.dialect.MarkdownDialect;
import org.junit.jupiter.api.Test;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;
import org.thymeleaf.testing.templateengine.report.ConsoleTestReporter;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarkDownProcessorTest {
    @Test
    void testMarkDownProcessor() {
        final TestExecutor executor = new TestExecutor();
        executor.setDialects(Arrays.asList(new StandardDialect(), new MarkdownDialect()));
        executor.setReporter(new ConsoleTestReporter());
        executor.execute("classpath:thymeleaf-tests/markdown.thtest");
        assertTrue(executor.isAllOK());

    }
}
