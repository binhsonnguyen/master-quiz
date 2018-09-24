package mst.codegym.web.view.thymeleaf.dialect;

import mst.codegym.web.view.thymeleaf.processor.MarkDownProcessor;
import org.junit.jupiter.api.Test;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MarkdownDialectTest {
    private static boolean isInstanceOfMarkdownProcessor(IProcessor iProcessor) {
        return iProcessor instanceof MarkDownProcessor;
    }

    @Test
    void testInitMarkdownDialectObject() {
        MarkdownDialect dialect = new MarkdownDialect();
        assertEquals(dialect.getDialectProcessorPrecedence(), StandardDialect.PROCESSOR_PRECEDENCE);
        assertEquals(dialect.getName(), "markdown");
        assertEquals(dialect.getPrefix(), StandardDialect.PREFIX);

        Set<IProcessor> processors = dialect.getProcessors(dialect.getPrefix());
        assertTrue(processors
                .stream()
                .anyMatch(MarkdownDialectTest::isInstanceOfMarkdownProcessor));
    }
}
