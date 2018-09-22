package mst.codegym.web.thymeleaf.dialect.standard;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class StandardMarkDownElementTagProcessor extends AbstractElementTagProcessor {
    public StandardMarkDownElementTagProcessor(final TemplateMode templateMode,
                                               final String dialectPrefix,
                                               final String elementName,
                                               int precedence) {
        super(templateMode,
                dialectPrefix,
                elementName,
                dialectPrefix != null,
                null,
                false, precedence);
    }

    @Override
    protected void doProcess(ITemplateContext context,
                             IProcessableElementTag tag,
                             IElementTagStructureHandler structureHandler) {
        final IModelFactory modelFactory = context.getModelFactory();
        final String template = "<i>a very</i> <b>dummie</b> <code>content</code>";
        IModel model = modelFactory.parse(context.getTemplateData(), template);
        structureHandler.removeTags();
        structureHandler.insertImmediatelyAfter(model, false);
    }
}
