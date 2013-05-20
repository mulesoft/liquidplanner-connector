
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.AlertExpressionHolder;
import org.mule.LiquidPlanner.client.model.holders.TaskExpressionHolder;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.processors.UpdateTaskMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class UpdateTaskDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateTaskMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        if (!parseObjectRef(element, builder, "task", "task")) {
            BeanDefinitionBuilder taskBuilder = BeanDefinitionBuilder.rootBeanDefinition(TaskExpressionHolder.class.getName());
            Element taskChildElement = DomUtils.getChildElementByTagName(element, "task");
            if (taskChildElement!= null) {
                parseProperty(taskBuilder, taskChildElement, "activityid", "activityid");
                parseProperty(taskBuilder, taskChildElement, "work", "work");
                parseListAndSetProperty(taskChildElement, taskBuilder, "alerts", "alerts", "alert", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(taskBuilder, taskChildElement, "projectId", "projectId");
                parseProperty(taskBuilder, taskChildElement, "clientId", "clientId");
                parseProperty(taskBuilder, taskChildElement, "createdAt", "createdAt");
                parseProperty(taskBuilder, taskChildElement, "createdBy", "createdBy");
                parseMapAndSetProperty(taskChildElement, taskBuilder, "customFieldValues", "custom-field-values", "custom-field-value", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                if (hasAttribute(taskChildElement, "doneOn-ref")) {
                    if (taskChildElement.getAttribute("doneOn-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("doneOn", taskChildElement.getAttribute("doneOn-ref"));
                    } else {
                        taskBuilder.addPropertyValue("doneOn", (("#[registry:"+ taskChildElement.getAttribute("doneOn-ref"))+"]"));
                    }
                }
                if (hasAttribute(taskChildElement, "startedOn-ref")) {
                    if (taskChildElement.getAttribute("startedOn-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("startedOn", taskChildElement.getAttribute("startedOn-ref"));
                    } else {
                        taskBuilder.addPropertyValue("startedOn", (("#[registry:"+ taskChildElement.getAttribute("startedOn-ref"))+"]"));
                    }
                }
                if (hasAttribute(taskChildElement, "delayUntil-ref")) {
                    if (taskChildElement.getAttribute("delayUntil-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("delayUntil", taskChildElement.getAttribute("delayUntil-ref"));
                    } else {
                        taskBuilder.addPropertyValue("delayUntil", (("#[registry:"+ taskChildElement.getAttribute("delayUntil-ref"))+"]"));
                    }
                }
                parseProperty(taskBuilder, taskChildElement, "description", "description");
                parseProperty(taskBuilder, taskChildElement, "earliestFinish", "earliestFinish");
                parseProperty(taskBuilder, taskChildElement, "earliestStart", "earliestStart");
                parseProperty(taskBuilder, taskChildElement, "expectedFinish", "expectedFinish");
                parseProperty(taskBuilder, taskChildElement, "expectedStart", "expectedStart");
                parseProperty(taskBuilder, taskChildElement, "p98Finish", "p98Finish");
                parseListAndSetProperty(taskChildElement, taskBuilder, "globalPriority", "global-priority", "global-priority", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                if (hasAttribute(taskChildElement, "globalPackagePriority-ref")) {
                    if (taskChildElement.getAttribute("globalPackagePriority-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("globalPackagePriority", taskChildElement.getAttribute("globalPackagePriority-ref"));
                    } else {
                        taskBuilder.addPropertyValue("globalPackagePriority", (("#[registry:"+ taskChildElement.getAttribute("globalPackagePriority-ref"))+"]"));
                    }
                }
                parseProperty(taskBuilder, taskChildElement, "hasNote", "hasNote");
                parseProperty(taskBuilder, taskChildElement, "highEffortRemaining", "highEffortRemaining");
                parseProperty(taskBuilder, taskChildElement, "isDone", "isDone");
                parseProperty(taskBuilder, taskChildElement, "isOnHold", "isOnHold");
                parseProperty(taskBuilder, taskChildElement, "isPackagedVersion", "isPackagedVersion");
                parseProperty(taskBuilder, taskChildElement, "isShared", "isShared");
                parseProperty(taskBuilder, taskChildElement, "latestFinish", "latestFinish");
                parseProperty(taskBuilder, taskChildElement, "lowEffortRemaining", "lowEffortRemaining");
                parseProperty(taskBuilder, taskChildElement, "manualAlert", "manualAlert");
                if (hasAttribute(taskChildElement, "maxEffort-ref")) {
                    if (taskChildElement.getAttribute("maxEffort-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("maxEffort", taskChildElement.getAttribute("maxEffort-ref"));
                    } else {
                        taskBuilder.addPropertyValue("maxEffort", (("#[registry:"+ taskChildElement.getAttribute("maxEffort-ref"))+"]"));
                    }
                }
                parseProperty(taskBuilder, taskChildElement, "name", "name");
                parseProperty(taskBuilder, taskChildElement, "ownerId", "ownerId");
                parseProperty(taskBuilder, taskChildElement, "parentId", "parentId");
                if (hasAttribute(taskChildElement, "promiseBy-ref")) {
                    if (taskChildElement.getAttribute("promiseBy-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("promiseBy", taskChildElement.getAttribute("promiseBy-ref"));
                    } else {
                        taskBuilder.addPropertyValue("promiseBy", (("#[registry:"+ taskChildElement.getAttribute("promiseBy-ref"))+"]"));
                    }
                }
                parseProperty(taskBuilder, taskChildElement, "externalReference", "externalReference");
                if (hasAttribute(taskChildElement, "packageId-ref")) {
                    if (taskChildElement.getAttribute("packageId-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("packageId", taskChildElement.getAttribute("packageId-ref"));
                    } else {
                        taskBuilder.addPropertyValue("packageId", (("#[registry:"+ taskChildElement.getAttribute("packageId-ref"))+"]"));
                    }
                }
                parseListAndSetProperty(taskChildElement, taskBuilder, "parentIds", "parent-ids", "parent-id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(taskChildElement, taskBuilder, "parentCrumbs", "parent-crumbs", "parent-crumb", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(taskChildElement, taskBuilder, "packageIds", "package-ids", "package-id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(taskChildElement, taskBuilder, "packageCrumbs", "package-crumbs", "package-crumb", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(taskBuilder, taskChildElement, "updatedAt", "updatedAt");
                parseProperty(taskBuilder, taskChildElement, "updatedBy", "updatedBy");
                parseProperty(taskBuilder, taskChildElement, "id", "id");
                if (hasAttribute(taskChildElement, "date-ref")) {
                    if (taskChildElement.getAttribute("date-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("date", taskChildElement.getAttribute("date-ref"));
                    } else {
                        taskBuilder.addPropertyValue("date", (("#[registry:"+ taskChildElement.getAttribute("date-ref"))+"]"));
                    }
                }
                if (hasAttribute(taskChildElement, "startDate-ref")) {
                    if (taskChildElement.getAttribute("startDate-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("startDate", taskChildElement.getAttribute("startDate-ref"));
                    } else {
                        taskBuilder.addPropertyValue("startDate", (("#[registry:"+ taskChildElement.getAttribute("startDate-ref"))+"]"));
                    }
                }
                if (hasAttribute(taskChildElement, "finishDate-ref")) {
                    if (taskChildElement.getAttribute("finishDate-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("finishDate", taskChildElement.getAttribute("finishDate-ref"));
                    } else {
                        taskBuilder.addPropertyValue("finishDate", (("#[registry:"+ taskChildElement.getAttribute("finishDate-ref"))+"]"));
                    }
                }
                builder.addPropertyValue("task", taskBuilder.getBeanDefinition());
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
