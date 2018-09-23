package mst.codegym.web.view.thymeleaf.processor;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.processor.AbstractStandardExpressionAttributeTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

public class MarkDownProcessor extends AbstractStandardExpressionAttributeTagProcessor {

    private static final Parser PARSER = Parser.builder().build();
    private static final HtmlRenderer RENDERER = HtmlRenderer.builder().build();

    public MarkDownProcessor(TemplateMode templateMode,
                             String dialectPrefix,
                             String attributeName,
                             int precedence) {
        super(templateMode,
                dialectPrefix,
                attributeName,
                precedence,
                false);
    }

    @Override
    protected void doProcess(ITemplateContext context,
                             IProcessableElementTag tag,
                             AttributeName attributeName,
                             String attributeValue,
                             Object expressionResult,
                             IElementTagStructureHandler structureHandler) {
        final IModelFactory modelFactory = context.getModelFactory();
        final String template = render(expressionResult);
        IModel model = modelFactory.parse(context.getTemplateData(), template);
        structureHandler.removeTags();
        structureHandler.insertImmediatelyAfter(model, false);

    }

    private String render(Object expression) {
        Node document = PARSER.parse(expression.toString());
        return RENDERER.render(document);
    }
}
