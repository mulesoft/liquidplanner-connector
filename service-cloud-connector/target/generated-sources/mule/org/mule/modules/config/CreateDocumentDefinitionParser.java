
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.modules.processors.CreateDocumentMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class CreateDocumentDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CreateDocumentMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        parseProperty(builder, element, "entity", "entity");
        parseProperty(builder, element, "entityId", "entityId");
        parseProperty(builder, element, "fileName", "fileName");
        parseProperty(builder, element, "fileDescription", "fileDescription");
        if (hasAttribute(element, "fileInputStream-ref")) {
            if (element.getAttribute("fileInputStream-ref").startsWith("#")) {
                builder.addPropertyValue("fileInputStream", element.getAttribute("fileInputStream-ref"));
            } else {
                builder.addPropertyValue("fileInputStream", (("#[registry:"+ element.getAttribute("fileInputStream-ref"))+"]"));
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
