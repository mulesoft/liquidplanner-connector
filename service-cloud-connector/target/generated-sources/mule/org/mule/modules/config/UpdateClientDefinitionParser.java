
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.ClientExpressionHolder;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.processors.UpdateClientMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class UpdateClientDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateClientMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        if (!parseObjectRef(element, builder, "client", "client")) {
            BeanDefinitionBuilder clientBuilder = BeanDefinitionBuilder.rootBeanDefinition(ClientExpressionHolder.class.getName());
            Element clientChildElement = DomUtils.getChildElementByTagName(element, "client");
            if (clientChildElement!= null) {
                parseProperty(clientBuilder, clientChildElement, "work", "work");
                parseListAndSetProperty(clientChildElement, clientBuilder, "alerts", "alerts", "alert", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(clientBuilder, clientChildElement, "created_at", "created_at");
                parseProperty(clientBuilder, clientChildElement, "created_by", "created_by");
                if (hasAttribute(clientChildElement, "done_on-ref")) {
                    if (clientChildElement.getAttribute("done_on-ref").startsWith("#")) {
                        clientBuilder.addPropertyValue("done_on", clientChildElement.getAttribute("done_on-ref"));
                    } else {
                        clientBuilder.addPropertyValue("done_on", (("#[registry:"+ clientChildElement.getAttribute("done_on-ref"))+"]"));
                    }
                }
                if (hasAttribute(clientChildElement, "started_on-ref")) {
                    if (clientChildElement.getAttribute("started_on-ref").startsWith("#")) {
                        clientBuilder.addPropertyValue("started_on", clientChildElement.getAttribute("started_on-ref"));
                    } else {
                        clientBuilder.addPropertyValue("started_on", (("#[registry:"+ clientChildElement.getAttribute("started_on-ref"))+"]"));
                    }
                }
                parseProperty(clientBuilder, clientChildElement, "description", "description");
                parseProperty(clientBuilder, clientChildElement, "earliest_finish", "earliest_finish");
                parseProperty(clientBuilder, clientChildElement, "earliest_start", "earliest_start");
                parseProperty(clientBuilder, clientChildElement, "expected_finish", "expected_finish");
                parseProperty(clientBuilder, clientChildElement, "expected_start", "expected_start");
                parseProperty(clientBuilder, clientChildElement, "p98_finish", "p98_finish");
                parseProperty(clientBuilder, clientChildElement, "has_note", "has_note");
                parseProperty(clientBuilder, clientChildElement, "high_effort_remaining", "high_effort_remaining");
                parseProperty(clientBuilder, clientChildElement, "is_done", "is_done");
                parseProperty(clientBuilder, clientChildElement, "is_on_hold", "is_on_hold");
                parseProperty(clientBuilder, clientChildElement, "latest_finish", "latest_finish");
                parseProperty(clientBuilder, clientChildElement, "low_effort_remaining", "low_effort_remaining");
                parseProperty(clientBuilder, clientChildElement, "manual_alert", "manual_alert");
                parseProperty(clientBuilder, clientChildElement, "name", "name");
                parseProperty(clientBuilder, clientChildElement, "owner_id", "owner_id");
                if (hasAttribute(clientChildElement, "external_reference-ref")) {
                    if (clientChildElement.getAttribute("external_reference-ref").startsWith("#")) {
                        clientBuilder.addPropertyValue("external_reference", clientChildElement.getAttribute("external_reference-ref"));
                    } else {
                        clientBuilder.addPropertyValue("external_reference", (("#[registry:"+ clientChildElement.getAttribute("external_reference-ref"))+"]"));
                    }
                }
                parseProperty(clientBuilder, clientChildElement, "updated_at", "updated_at");
                parseProperty(clientBuilder, clientChildElement, "updated_by", "updated_by");
                parseProperty(clientBuilder, clientChildElement, "id", "id");
                builder.addPropertyValue("client", clientBuilder.getBeanDefinition());
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
