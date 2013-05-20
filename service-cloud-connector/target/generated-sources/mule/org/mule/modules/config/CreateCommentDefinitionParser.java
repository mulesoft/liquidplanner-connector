
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.CommentExpressionHolder;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.processors.CreateCommentMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class CreateCommentDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CreateCommentMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        if (!parseObjectRef(element, builder, "comment", "comment")) {
            BeanDefinitionBuilder commentBuilder = BeanDefinitionBuilder.rootBeanDefinition(CommentExpressionHolder.class.getName());
            Element commentChildElement = DomUtils.getChildElementByTagName(element, "comment");
            if (commentChildElement!= null) {
                parseListAndSetProperty(commentChildElement, commentBuilder, "atPersonIds", "at-person-ids", "at-person-id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(commentChildElement, commentBuilder, "atMemberIds", "at-member-ids", "at-member-id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(commentBuilder, commentChildElement, "comment", "comment");
                parseProperty(commentBuilder, commentChildElement, "createdAt", "createdAt");
                parseProperty(commentBuilder, commentChildElement, "createdBy", "createdBy");
                parseProperty(commentBuilder, commentChildElement, "personId", "personId");
                parseProperty(commentBuilder, commentChildElement, "memberId", "memberId");
                parseProperty(commentBuilder, commentChildElement, "plainText", "plainText");
                parseProperty(commentBuilder, commentChildElement, "itemId", "itemId");
                parseProperty(commentBuilder, commentChildElement, "updatedAt", "updatedAt");
                parseProperty(commentBuilder, commentChildElement, "updatedBy", "updatedBy");
                parseProperty(commentBuilder, commentChildElement, "id", "id");
                builder.addPropertyValue("comment", commentBuilder.getBeanDefinition());
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
