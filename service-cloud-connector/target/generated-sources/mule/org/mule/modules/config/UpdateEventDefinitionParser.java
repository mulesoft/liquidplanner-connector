
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.AlertExpressionHolder;
import org.mule.LiquidPlanner.client.model.holders.EventExpressionHolder;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.processors.UpdateEventMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class UpdateEventDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateEventMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        if (!parseObjectRef(element, builder, "event", "event")) {
            BeanDefinitionBuilder eventBuilder = BeanDefinitionBuilder.rootBeanDefinition(EventExpressionHolder.class.getName());
            Element eventChildElement = DomUtils.getChildElementByTagName(element, "event");
            if (eventChildElement!= null) {
                parseProperty(eventBuilder, eventChildElement, "activity_id", "activity_id");
                parseProperty(eventBuilder, eventChildElement, "work", "work");
                parseListAndSetProperty(eventChildElement, eventBuilder, "alerts", "alerts", "alert", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(eventBuilder, eventChildElement, "project_id", "project_id");
                parseProperty(eventBuilder, eventChildElement, "client_id", "client_id");
                parseProperty(eventBuilder, eventChildElement, "created_at", "created_at");
                parseProperty(eventBuilder, eventChildElement, "created_by", "created_by");
                if (hasAttribute(eventChildElement, "done_on-ref")) {
                    if (eventChildElement.getAttribute("done_on-ref").startsWith("#")) {
                        eventBuilder.addPropertyValue("done_on", eventChildElement.getAttribute("done_on-ref"));
                    } else {
                        eventBuilder.addPropertyValue("done_on", (("#[registry:"+ eventChildElement.getAttribute("done_on-ref"))+"]"));
                    }
                }
                if (hasAttribute(eventChildElement, "started_on-ref")) {
                    if (eventChildElement.getAttribute("started_on-ref").startsWith("#")) {
                        eventBuilder.addPropertyValue("started_on", eventChildElement.getAttribute("started_on-ref"));
                    } else {
                        eventBuilder.addPropertyValue("started_on", (("#[registry:"+ eventChildElement.getAttribute("started_on-ref"))+"]"));
                    }
                }
                parseProperty(eventBuilder, eventChildElement, "description", "description");
                parseProperty(eventBuilder, eventChildElement, "earliest_finish", "earliest_finish");
                parseProperty(eventBuilder, eventChildElement, "earliest_start", "earliest_start");
                parseProperty(eventBuilder, eventChildElement, "expected_finish", "expected_finish");
                parseProperty(eventBuilder, eventChildElement, "expected_start", "expected_start");
                parseProperty(eventBuilder, eventChildElement, "p98_finish", "p98_finish");
                parseListAndSetProperty(eventChildElement, eventBuilder, "global_priority", "global_priority", "global_priority", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                if (hasAttribute(eventChildElement, "global_package_priority-ref")) {
                    if (eventChildElement.getAttribute("global_package_priority-ref").startsWith("#")) {
                        eventBuilder.addPropertyValue("global_package_priority", eventChildElement.getAttribute("global_package_priority-ref"));
                    } else {
                        eventBuilder.addPropertyValue("global_package_priority", (("#[registry:"+ eventChildElement.getAttribute("global_package_priority-ref"))+"]"));
                    }
                }
                parseProperty(eventBuilder, eventChildElement, "has_note", "has_note");
                parseProperty(eventBuilder, eventChildElement, "high_effort_remaining", "high_effort_remaining");
                parseProperty(eventBuilder, eventChildElement, "is_done", "is_done");
                parseProperty(eventBuilder, eventChildElement, "is_on_hold", "is_on_hold");
                parseProperty(eventBuilder, eventChildElement, "is_packaged_version", "is_packaged_version");
                parseProperty(eventBuilder, eventChildElement, "is_shared", "is_shared");
                parseProperty(eventBuilder, eventChildElement, "latest_finish", "latest_finish");
                parseProperty(eventBuilder, eventChildElement, "low_effort_remaining", "low_effort_remaining");
                parseProperty(eventBuilder, eventChildElement, "manual_alert", "manual_alert");
                if (hasAttribute(eventChildElement, "max_effort-ref")) {
                    if (eventChildElement.getAttribute("max_effort-ref").startsWith("#")) {
                        eventBuilder.addPropertyValue("max_effort", eventChildElement.getAttribute("max_effort-ref"));
                    } else {
                        eventBuilder.addPropertyValue("max_effort", (("#[registry:"+ eventChildElement.getAttribute("max_effort-ref"))+"]"));
                    }
                }
                parseProperty(eventBuilder, eventChildElement, "name", "name");
                parseProperty(eventBuilder, eventChildElement, "owner_id", "owner_id");
                parseProperty(eventBuilder, eventChildElement, "parent_id", "parent_id");
                parseProperty(eventBuilder, eventChildElement, "date", "date");
                parseProperty(eventBuilder, eventChildElement, "external_reference", "external_reference");
                if (hasAttribute(eventChildElement, "package_id-ref")) {
                    if (eventChildElement.getAttribute("package_id-ref").startsWith("#")) {
                        eventBuilder.addPropertyValue("package_id", eventChildElement.getAttribute("package_id-ref"));
                    } else {
                        eventBuilder.addPropertyValue("package_id", (("#[registry:"+ eventChildElement.getAttribute("package_id-ref"))+"]"));
                    }
                }
                parseListAndSetProperty(eventChildElement, eventBuilder, "parent_ids", "parent_ids", "parent_id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(eventChildElement, eventBuilder, "parent_crumbs", "parent_crumbs", "parent_crumb", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(eventChildElement, eventBuilder, "package_ids", "package_ids", "package_id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(eventChildElement, eventBuilder, "package_crumbs", "package_crumbs", "package_crumb", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(eventBuilder, eventChildElement, "updated_at", "updated_at");
                parseProperty(eventBuilder, eventChildElement, "updated_by", "updated_by");
                parseProperty(eventBuilder, eventChildElement, "id", "id");
                builder.addPropertyValue("event", eventBuilder.getBeanDefinition());
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
