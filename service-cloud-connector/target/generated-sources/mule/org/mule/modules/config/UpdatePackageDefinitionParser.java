
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.AlertExpressionHolder;
import org.mule.LiquidPlanner.client.model.holders.LPPackageExpressionHolder;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.processors.UpdatePackageMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class UpdatePackageDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdatePackageMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        if (!parseObjectRef(element, builder, "lp-package", "lpPackage")) {
            BeanDefinitionBuilder lpPackageBuilder = BeanDefinitionBuilder.rootBeanDefinition(LPPackageExpressionHolder.class.getName());
            Element lpPackageChildElement = DomUtils.getChildElementByTagName(element, "lp-package");
            if (lpPackageChildElement!= null) {
                parseProperty(lpPackageBuilder, lpPackageChildElement, "work", "work");
                parseListAndSetProperty(lpPackageChildElement, lpPackageBuilder, "alerts", "alerts", "alert", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(lpPackageBuilder, lpPackageChildElement, "created_at", "created_at");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "created_by", "created_by");
                if (hasAttribute(lpPackageChildElement, "done_on-ref")) {
                    if (lpPackageChildElement.getAttribute("done_on-ref").startsWith("#")) {
                        lpPackageBuilder.addPropertyValue("done_on", lpPackageChildElement.getAttribute("done_on-ref"));
                    } else {
                        lpPackageBuilder.addPropertyValue("done_on", (("#[registry:"+ lpPackageChildElement.getAttribute("done_on-ref"))+"]"));
                    }
                }
                parseProperty(lpPackageBuilder, lpPackageChildElement, "started_on", "started_on");
                if (hasAttribute(lpPackageChildElement, "delay_until-ref")) {
                    if (lpPackageChildElement.getAttribute("delay_until-ref").startsWith("#")) {
                        lpPackageBuilder.addPropertyValue("delay_until", lpPackageChildElement.getAttribute("delay_until-ref"));
                    } else {
                        lpPackageBuilder.addPropertyValue("delay_until", (("#[registry:"+ lpPackageChildElement.getAttribute("delay_until-ref"))+"]"));
                    }
                }
                parseProperty(lpPackageBuilder, lpPackageChildElement, "description", "description");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "earliest_finish", "earliest_finish");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "earliest_start", "earliest_start");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "expected_finish", "expected_finish");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "expected_start", "expected_start");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "p98_finish", "p98_finish");
                parseListAndSetProperty(lpPackageChildElement, lpPackageBuilder, "global_priority", "global_priority", "global_priority", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(lpPackageBuilder, lpPackageChildElement, "has_note", "has_note");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "high_effort_remaining", "high_effort_remaining");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "is_done", "is_done");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "is_on_hold", "is_on_hold");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "latest_finish", "latest_finish");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "low_effort_remaining", "low_effort_remaining");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "manual_alert", "manual_alert");
                if (hasAttribute(lpPackageChildElement, "max_effort-ref")) {
                    if (lpPackageChildElement.getAttribute("max_effort-ref").startsWith("#")) {
                        lpPackageBuilder.addPropertyValue("max_effort", lpPackageChildElement.getAttribute("max_effort-ref"));
                    } else {
                        lpPackageBuilder.addPropertyValue("max_effort", (("#[registry:"+ lpPackageChildElement.getAttribute("max_effort-ref"))+"]"));
                    }
                }
                parseProperty(lpPackageBuilder, lpPackageChildElement, "name", "name");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "owner_id", "owner_id");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "parent_id", "parent_id");
                parseListAndSetProperty(lpPackageChildElement, lpPackageBuilder, "parent_ids", "parent_ids", "parent_id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(lpPackageChildElement, lpPackageBuilder, "parent_crumbs", "parent_crumbs", "parent_crumb", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                if (hasAttribute(lpPackageChildElement, "promise_by-ref")) {
                    if (lpPackageChildElement.getAttribute("promise_by-ref").startsWith("#")) {
                        lpPackageBuilder.addPropertyValue("promise_by", lpPackageChildElement.getAttribute("promise_by-ref"));
                    } else {
                        lpPackageBuilder.addPropertyValue("promise_by", (("#[registry:"+ lpPackageChildElement.getAttribute("promise_by-ref"))+"]"));
                    }
                }
                parseProperty(lpPackageBuilder, lpPackageChildElement, "external_reference", "external_reference");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "updated_at", "updated_at");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "updated_by", "updated_by");
                parseProperty(lpPackageBuilder, lpPackageChildElement, "id", "id");
                builder.addPropertyValue("lpPackage", lpPackageBuilder.getBeanDefinition());
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
