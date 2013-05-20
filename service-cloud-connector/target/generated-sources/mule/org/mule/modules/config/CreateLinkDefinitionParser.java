
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.LinkExpressionHolder;
import org.mule.modules.processors.CreateLinkMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class CreateLinkDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CreateLinkMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        if (!parseObjectRef(element, builder, "link", "link")) {
            BeanDefinitionBuilder linkBuilder = BeanDefinitionBuilder.rootBeanDefinition(LinkExpressionHolder.class.getName());
            Element linkChildElement = DomUtils.getChildElementByTagName(element, "link");
            if (linkChildElement!= null) {
                parseProperty(linkBuilder, linkChildElement, "created_at", "created_at");
                parseProperty(linkBuilder, linkChildElement, "created_by", "created_by");
                parseProperty(linkBuilder, linkChildElement, "description", "description");
                parseProperty(linkBuilder, linkChildElement, "item_id", "item_id");
                parseProperty(linkBuilder, linkChildElement, "updated_at", "updated_at");
                parseProperty(linkBuilder, linkChildElement, "updated_by", "updated_by");
                parseProperty(linkBuilder, linkChildElement, "url", "url");
                parseProperty(linkBuilder, linkChildElement, "id", "id");
                builder.addPropertyValue("link", linkBuilder.getBeanDefinition());
            }
        }
        parseProperty(builder, element, "username", "username");
        parseProperty(builder, element, "password", "password");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
