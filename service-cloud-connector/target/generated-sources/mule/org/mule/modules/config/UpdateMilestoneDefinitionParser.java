
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.AlertExpressionHolder;
import org.mule.LiquidPlanner.client.model.holders.MilestoneExpressionHolder;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.processors.UpdateMilestoneMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class UpdateMilestoneDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateMilestoneMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        if (!parseObjectRef(element, builder, "milestone", "milestone")) {
            BeanDefinitionBuilder milestoneBuilder = BeanDefinitionBuilder.rootBeanDefinition(MilestoneExpressionHolder.class.getName());
            Element milestoneChildElement = DomUtils.getChildElementByTagName(element, "milestone");
            if (milestoneChildElement!= null) {
                parseProperty(milestoneBuilder, milestoneChildElement, "activityId", "activityId");
                parseProperty(milestoneBuilder, milestoneChildElement, "work", "work");
                parseListAndSetProperty(milestoneChildElement, milestoneBuilder, "alerts", "alerts", "alert", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(milestoneBuilder, milestoneChildElement, "projectId", "projectId");
                parseProperty(milestoneBuilder, milestoneChildElement, "clientId", "clientId");
                parseProperty(milestoneBuilder, milestoneChildElement, "createdAt", "createdAt");
                parseProperty(milestoneBuilder, milestoneChildElement, "createdBy", "createdBy");
                if (hasAttribute(milestoneChildElement, "doneOn-ref")) {
                    if (milestoneChildElement.getAttribute("doneOn-ref").startsWith("#")) {
                        milestoneBuilder.addPropertyValue("doneOn", milestoneChildElement.getAttribute("doneOn-ref"));
                    } else {
                        milestoneBuilder.addPropertyValue("doneOn", (("#[registry:"+ milestoneChildElement.getAttribute("doneOn-ref"))+"]"));
                    }
                }
                if (hasAttribute(milestoneChildElement, "startedOn-ref")) {
                    if (milestoneChildElement.getAttribute("startedOn-ref").startsWith("#")) {
                        milestoneBuilder.addPropertyValue("startedOn", milestoneChildElement.getAttribute("startedOn-ref"));
                    } else {
                        milestoneBuilder.addPropertyValue("startedOn", (("#[registry:"+ milestoneChildElement.getAttribute("startedOn-ref"))+"]"));
                    }
                }
                parseProperty(milestoneBuilder, milestoneChildElement, "description", "description");
                parseProperty(milestoneBuilder, milestoneChildElement, "earliestFinish", "earliestFinish");
                parseProperty(milestoneBuilder, milestoneChildElement, "earliestStart", "earliestStart");
                parseProperty(milestoneBuilder, milestoneChildElement, "expectedFinish", "expectedFinish");
                parseProperty(milestoneBuilder, milestoneChildElement, "expectedStart", "expectedStart");
                parseProperty(milestoneBuilder, milestoneChildElement, "p98Finish", "p98Finish");
                parseListAndSetProperty(milestoneChildElement, milestoneBuilder, "globalPriority", "global-priority", "global-priority", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                if (hasAttribute(milestoneChildElement, "globalPackagePriority-ref")) {
                    if (milestoneChildElement.getAttribute("globalPackagePriority-ref").startsWith("#")) {
                        milestoneBuilder.addPropertyValue("globalPackagePriority", milestoneChildElement.getAttribute("globalPackagePriority-ref"));
                    } else {
                        milestoneBuilder.addPropertyValue("globalPackagePriority", (("#[registry:"+ milestoneChildElement.getAttribute("globalPackagePriority-ref"))+"]"));
                    }
                }
                parseProperty(milestoneBuilder, milestoneChildElement, "hasNote", "hasNote");
                parseProperty(milestoneBuilder, milestoneChildElement, "highEffortRemaining", "highEffortRemaining");
                parseProperty(milestoneBuilder, milestoneChildElement, "isDone", "isDone");
                parseProperty(milestoneBuilder, milestoneChildElement, "isOnHold", "isOnHold");
                parseProperty(milestoneBuilder, milestoneChildElement, "isPackagedVersion", "isPackagedVersion");
                parseProperty(milestoneBuilder, milestoneChildElement, "isShared", "isShared");
                parseProperty(milestoneBuilder, milestoneChildElement, "latestFinish", "latestFinish");
                parseProperty(milestoneBuilder, milestoneChildElement, "lowEffortRemaining", "lowEffortRemaining");
                parseProperty(milestoneBuilder, milestoneChildElement, "manualAlert", "manualAlert");
                if (hasAttribute(milestoneChildElement, "maxEffort-ref")) {
                    if (milestoneChildElement.getAttribute("maxEffort-ref").startsWith("#")) {
                        milestoneBuilder.addPropertyValue("maxEffort", milestoneChildElement.getAttribute("maxEffort-ref"));
                    } else {
                        milestoneBuilder.addPropertyValue("maxEffort", (("#[registry:"+ milestoneChildElement.getAttribute("maxEffort-ref"))+"]"));
                    }
                }
                parseProperty(milestoneBuilder, milestoneChildElement, "name", "name");
                parseProperty(milestoneBuilder, milestoneChildElement, "ownerId", "ownerId");
                parseProperty(milestoneBuilder, milestoneChildElement, "parentId", "parentId");
                parseProperty(milestoneBuilder, milestoneChildElement, "date", "date");
                parseProperty(milestoneBuilder, milestoneChildElement, "externalReference", "externalReference");
                if (hasAttribute(milestoneChildElement, "packageId-ref")) {
                    if (milestoneChildElement.getAttribute("packageId-ref").startsWith("#")) {
                        milestoneBuilder.addPropertyValue("packageId", milestoneChildElement.getAttribute("packageId-ref"));
                    } else {
                        milestoneBuilder.addPropertyValue("packageId", (("#[registry:"+ milestoneChildElement.getAttribute("packageId-ref"))+"]"));
                    }
                }
                parseListAndSetProperty(milestoneChildElement, milestoneBuilder, "parentIds", "parent-ids", "parent-id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(milestoneChildElement, milestoneBuilder, "parentCrumbs", "parent-crumbs", "parent-crumb", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(milestoneChildElement, milestoneBuilder, "packageIds", "package-ids", "package-id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(milestoneChildElement, milestoneBuilder, "packageCrumbs", "package-crumbs", "package-crumb", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(milestoneBuilder, milestoneChildElement, "updatedAt", "updatedAt");
                parseProperty(milestoneBuilder, milestoneChildElement, "updatedBy", "updatedBy");
                parseProperty(milestoneBuilder, milestoneChildElement, "id", "id");
                builder.addPropertyValue("milestone", milestoneBuilder.getBeanDefinition());
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
