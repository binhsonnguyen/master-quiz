package mst.codegym.web.view.thymeleaf.dialect;

import mst.codegym.web.view.thymeleaf.processor.MarkDownProcessor;
import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.Collections;
import java.util.Set;

public class MarkdownDialect implements IProcessorDialect {
    private static final String DIALECT_NAME = "markdown";
    private static final String ATTR_VALUE_NAME = "value";

    @Override
    public int getDialectProcessorPrecedence() {
        return StandardDialect.PROCESSOR_PRECEDENCE;
    }

    @Override
    public String getPrefix() {
        return StandardDialect.PREFIX;
    }

    @Override
    public String getName() {
        return DIALECT_NAME;
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        MarkDownProcessor processor =
                new MarkDownProcessor(TemplateMode.HTML,
                        dialectPrefix,
                        ATTR_VALUE_NAME,
                        getDialectProcessorPrecedence()
                );
        return Collections.singleton(processor);
    }

}
