
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.AlertExpressionHolder;
import org.mule.LiquidPlanner.client.model.holders.LPPackageExpressionHolder;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.processors.CreatePackageMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class CreatePackageDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CreatePackageMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        if (!parseObjectRef(element, builder, "a-package", "aPackage")) {
            BeanDefinitionBuilder aPackageBuilder = BeanDefinitionBuilder.rootBeanDefinition(LPPackageExpressionHolder.class.getName());
            Element aPackageChildElement = DomUtils.getChildElementByTagName(element, "a-package");
            if (aPackageChildElement!= null) {
                parseProperty(aPackageBuilder, aPackageChildElement, "work", "work");
                parseListAndSetProperty(aPackageChildElement, aPackageBuilder, "alerts", "alerts", "alert", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(AlertExpressionHolder.class);
                        parseProperty(builder, element, "description", "description");
                        parseProperty(builder, element, "flag", "flag");
                        parseProperty(builder, element, "key", "key");
                        parseProperty(builder, element, "name", "name");
                        parseProperty(builder, element, "id", "id");
                        return builder.getBeanDefinition();
                    }

                }
                );
                parseProperty(aPackageBuilder, aPackageChildElement, "created_at", "created_at");
                parseProperty(aPackageBuilder, aPackageChildElement, "created_by", "created_by");
                if (hasAttribute(aPackageChildElement, "done_on-ref")) {
                    if (aPackageChildElement.getAttribute("done_on-ref").startsWith("#")) {
                        aPackageBuilder.addPropertyValue("done_on", aPackageChildElement.getAttribute("done_on-ref"));
                    } else {
                        aPackageBuilder.addPropertyValue("done_on", (("#[registry:"+ aPackageChildElement.getAttribute("done_on-ref"))+"]"));
                    }
                }
                parseProperty(aPackageBuilder, aPackageChildElement, "started_on", "started_on");
                if (hasAttribute(aPackageChildElement, "delay_until-ref")) {
                    if (aPackageChildElement.getAttribute("delay_until-ref").startsWith("#")) {
                        aPackageBuilder.addPropertyValue("delay_until", aPackageChildElement.getAttribute("delay_until-ref"));
                    } else {
                        aPackageBuilder.addPropertyValue("delay_until", (("#[registry:"+ aPackageChildElement.getAttribute("delay_until-ref"))+"]"));
                    }
                }
                parseProperty(aPackageBuilder, aPackageChildElement, "description", "description");
                parseProperty(aPackageBuilder, aPackageChildElement, "earliest_finish", "earliest_finish");
                parseProperty(aPackageBuilder, aPackageChildElement, "earliest_start", "earliest_start");
                parseProperty(aPackageBuilder, aPackageChildElement, "expected_finish", "expected_finish");
                parseProperty(aPackageBuilder, aPackageChildElement, "expected_start", "expected_start");
                parseProperty(aPackageBuilder, aPackageChildElement, "p98_finish", "p98_finish");
                parseListAndSetProperty(aPackageChildElement, aPackageBuilder, "global_priority", "global_priority", "global_priority", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(aPackageBuilder, aPackageChildElement, "has_note", "has_note");
                parseProperty(aPackageBuilder, aPackageChildElement, "high_effort_remaining", "high_effort_remaining");
                parseProperty(aPackageBuilder, aPackageChildElement, "is_done", "is_done");
                parseProperty(aPackageBuilder, aPackageChildElement, "is_on_hold", "is_on_hold");
                parseProperty(aPackageBuilder, aPackageChildElement, "latest_finish", "latest_finish");
                parseProperty(aPackageBuilder, aPackageChildElement, "low_effort_remaining", "low_effort_remaining");
                parseProperty(aPackageBuilder, aPackageChildElement, "manual_alert", "manual_alert");
                if (hasAttribute(aPackageChildElement, "max_effort-ref")) {
                    if (aPackageChildElement.getAttribute("max_effort-ref").startsWith("#")) {
                        aPackageBuilder.addPropertyValue("max_effort", aPackageChildElement.getAttribute("max_effort-ref"));
                    } else {
                        aPackageBuilder.addPropertyValue("max_effort", (("#[registry:"+ aPackageChildElement.getAttribute("max_effort-ref"))+"]"));
                    }
                }
                parseProperty(aPackageBuilder, aPackageChildElement, "name", "name");
                parseProperty(aPackageBuilder, aPackageChildElement, "owner_id", "owner_id");
                parseProperty(aPackageBuilder, aPackageChildElement, "parent_id", "parent_id");
                parseListAndSetProperty(aPackageChildElement, aPackageBuilder, "parent_ids", "parent_ids", "parent_id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(aPackageChildElement, aPackageBuilder, "parent_crumbs", "parent_crumbs", "parent_crumb", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                if (hasAttribute(aPackageChildElement, "promise_by-ref")) {
                    if (aPackageChildElement.getAttribute("promise_by-ref").startsWith("#")) {
                        aPackageBuilder.addPropertyValue("promise_by", aPackageChildElement.getAttribute("promise_by-ref"));
                    } else {
                        aPackageBuilder.addPropertyValue("promise_by", (("#[registry:"+ aPackageChildElement.getAttribute("promise_by-ref"))+"]"));
                    }
                }
                parseProperty(aPackageBuilder, aPackageChildElement, "external_reference", "external_reference");
                parseProperty(aPackageBuilder, aPackageChildElement, "updated_at", "updated_at");
                parseProperty(aPackageBuilder, aPackageChildElement, "updated_by", "updated_by");
                parseProperty(aPackageBuilder, aPackageChildElement, "id", "id");
                builder.addPropertyValue("aPackage", aPackageBuilder.getBeanDefinition());
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
