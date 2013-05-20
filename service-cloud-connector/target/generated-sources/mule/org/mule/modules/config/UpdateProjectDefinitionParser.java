
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.AlertExpressionHolder;
import org.mule.LiquidPlanner.client.model.holders.ProjectExpressionHolder;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.processors.UpdateProjectMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class UpdateProjectDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateProjectMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        if (!parseObjectRef(element, builder, "project", "project")) {
            BeanDefinitionBuilder projectBuilder = BeanDefinitionBuilder.rootBeanDefinition(ProjectExpressionHolder.class.getName());
            Element projectChildElement = DomUtils.getChildElementByTagName(element, "project");
            if (projectChildElement!= null) {
                parseListAndSetProperty(projectChildElement, projectBuilder, "alerts", "alerts", "alert", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(projectBuilder, projectChildElement, "clientId", "clientId");
                parseProperty(projectBuilder, projectChildElement, "createdAt", "createdAt");
                parseProperty(projectBuilder, projectChildElement, "createdBy", "createdBy");
                parseMapAndSetProperty(projectChildElement, projectBuilder, "customFieldValues", "custom-field-values", "custom-field-value", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(projectBuilder, projectChildElement, "delayUntil", "delayUntil");
                parseProperty(projectBuilder, projectChildElement, "description", "description");
                parseProperty(projectBuilder, projectChildElement, "doneOn", "doneOn");
                parseProperty(projectBuilder, projectChildElement, "earliestFinish", "earliestFinish");
                parseProperty(projectBuilder, projectChildElement, "earliestStart", "earliestStart");
                parseProperty(projectBuilder, projectChildElement, "expectedFinish", "expectedFinish");
                parseProperty(projectBuilder, projectChildElement, "expectedStart", "expectedStart");
                parseProperty(projectBuilder, projectChildElement, "externalReference", "externalReference");
                parseListAndSetProperty(projectChildElement, projectBuilder, "globalPriority", "global-priority", "global-priority", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(projectBuilder, projectChildElement, "hasNote", "hasNote");
                parseProperty(projectBuilder, projectChildElement, "highEffortRemaining", "highEffortRemaining");
                parseProperty(projectBuilder, projectChildElement, "id", "id");
                parseProperty(projectBuilder, projectChildElement, "isDone", "isDone");
                parseProperty(projectBuilder, projectChildElement, "isOnHold", "isOnHold");
                parseProperty(projectBuilder, projectChildElement, "latestFinish", "latestFinish");
                parseProperty(projectBuilder, projectChildElement, "lowEffortRemaining", "lowEffortRemaining");
                parseProperty(projectBuilder, projectChildElement, "manualAlert", "manualAlert");
                parseProperty(projectBuilder, projectChildElement, "maxEffort", "maxEffort");
                parseProperty(projectBuilder, projectChildElement, "name", "name");
                parseProperty(projectBuilder, projectChildElement, "ownerId", "ownerId");
                parseProperty(projectBuilder, projectChildElement, "p98Finish", "p98Finish");
                parseListAndSetProperty(projectChildElement, projectBuilder, "parentCrumbs", "parent-crumbs", "parent-crumb", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(projectBuilder, projectChildElement, "parentId", "parentId");
                parseListAndSetProperty(projectChildElement, projectBuilder, "parentIds", "parent-ids", "parent-id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(projectBuilder, projectChildElement, "promiseBy", "promiseBy");
                parseProperty(projectBuilder, projectChildElement, "startedOn", "startedOn");
                parseProperty(projectBuilder, projectChildElement, "updatedAt", "updatedAt");
                parseProperty(projectBuilder, projectChildElement, "updatedBy", "updatedBy");
                parseProperty(projectBuilder, projectChildElement, "work", "work");
                builder.addPropertyValue("project", projectBuilder.getBeanDefinition());
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
