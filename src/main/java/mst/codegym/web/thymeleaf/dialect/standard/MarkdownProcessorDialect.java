package mst.codegym.web.thymeleaf.dialect.standard;

import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.Collections;
import java.util.Set;

public class MarkdownProcessorDialect implements IProcessorDialect {
    private static final String DIALECT_NAME = "markdown";

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
        StandardMarkDownElementTagProcessor processor =
                new StandardMarkDownElementTagProcessor(TemplateMode.HTML,
                        getPrefix(),
                        getName(),
                        getDialectProcessorPrecedence()
                );
        return Collections.singleton(processor);
    }

}
