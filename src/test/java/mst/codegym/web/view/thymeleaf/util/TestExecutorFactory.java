package mst.codegym.web.view.thymeleaf.util;

import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;
import org.thymeleaf.testing.templateengine.report.ConsoleTestReporter;
import org.thymeleaf.testing.templateengine.report.ITestReporter;

import java.util.List;

public final class TestExecutorFactory {

    private static final ITestReporter TEST_REPORTER = new ConsoleTestReporter();

    private TestExecutorFactory() {
        super();
    }

    public static TestExecutor createInstance() {
        final TestExecutor testExecutor = new TestExecutor();
        testExecutor.setReporter(TEST_REPORTER);
        return testExecutor;
    }

    public static TestExecutor createInstance(final List<? extends IDialect> dialects) {
        final TestExecutor testExecutor = createInstance();
        testExecutor.setDialects(dialects);
        return testExecutor;
    }
}
