
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.FilterExpressionHolder;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.processors.GetTasksMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class GetTasksDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(GetTasksMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        parseListAndSetProperty(element, builder, "filters", "filters", "filter", new ParseDelegate<BeanDefinition>() {


            public BeanDefinition parse(Element element) {
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(FilterExpressionHolder.class);
                parseProperty(builder, element, "filterType", "filterType");
                parseProperty(builder, element, "operator", "operator");
                parseProperty(builder, element, "value", "value");
                return builder.getBeanDefinition();
            }

        }
        );
        parseProperty(builder, element, "username", "username");
        parseProperty(builder, element, "password", "password");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
