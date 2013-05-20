
package org.mule.modules.config;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.holders.FolderExpressionHolder;
import org.mule.modules.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.processors.CreateFolderMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class CreateFolderDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CreateFolderMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "workSpaceId", "workSpaceId");
        if (!parseObjectRef(element, builder, "folder", "folder")) {
            BeanDefinitionBuilder folderBuilder = BeanDefinitionBuilder.rootBeanDefinition(FolderExpressionHolder.class.getName());
            Element folderChildElement = DomUtils.getChildElementByTagName(element, "folder");
            if (folderChildElement!= null) {
                parseProperty(folderBuilder, folderChildElement, "work", "work");
                parseListAndSetProperty(folderChildElement, folderBuilder, "alerts", "alerts", "alert", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(folderBuilder, folderChildElement, "projectId", "projectId");
                parseProperty(folderBuilder, folderChildElement, "clientId", "clientId");
                parseProperty(folderBuilder, folderChildElement, "createdAt", "createdAt");
                parseProperty(folderBuilder, folderChildElement, "createdBy", "createdBy");
                if (hasAttribute(folderChildElement, "doneOn-ref")) {
                    if (folderChildElement.getAttribute("doneOn-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("doneOn", folderChildElement.getAttribute("doneOn-ref"));
                    } else {
                        folderBuilder.addPropertyValue("doneOn", (("#[registry:"+ folderChildElement.getAttribute("doneOn-ref"))+"]"));
                    }
                }
                if (hasAttribute(folderChildElement, "startedOn-ref")) {
                    if (folderChildElement.getAttribute("startedOn-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("startedOn", folderChildElement.getAttribute("startedOn-ref"));
                    } else {
                        folderBuilder.addPropertyValue("startedOn", (("#[registry:"+ folderChildElement.getAttribute("startedOn-ref"))+"]"));
                    }
                }
                if (hasAttribute(folderChildElement, "delayUntil-ref")) {
                    if (folderChildElement.getAttribute("delayUntil-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("delayUntil", folderChildElement.getAttribute("delayUntil-ref"));
                    } else {
                        folderBuilder.addPropertyValue("delayUntil", (("#[registry:"+ folderChildElement.getAttribute("delayUntil-ref"))+"]"));
                    }
                }
                parseProperty(folderBuilder, folderChildElement, "description", "description");
                if (hasAttribute(folderChildElement, "earliestFinish-ref")) {
                    if (folderChildElement.getAttribute("earliestFinish-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("earliestFinish", folderChildElement.getAttribute("earliestFinish-ref"));
                    } else {
                        folderBuilder.addPropertyValue("earliestFinish", (("#[registry:"+ folderChildElement.getAttribute("earliestFinish-ref"))+"]"));
                    }
                }
                if (hasAttribute(folderChildElement, "earliestStart-ref")) {
                    if (folderChildElement.getAttribute("earliestStart-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("earliestStart", folderChildElement.getAttribute("earliestStart-ref"));
                    } else {
                        folderBuilder.addPropertyValue("earliestStart", (("#[registry:"+ folderChildElement.getAttribute("earliestStart-ref"))+"]"));
                    }
                }
                if (hasAttribute(folderChildElement, "expectedFinish-ref")) {
                    if (folderChildElement.getAttribute("expectedFinish-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("expectedFinish", folderChildElement.getAttribute("expectedFinish-ref"));
                    } else {
                        folderBuilder.addPropertyValue("expectedFinish", (("#[registry:"+ folderChildElement.getAttribute("expectedFinish-ref"))+"]"));
                    }
                }
                if (hasAttribute(folderChildElement, "expectedStart-ref")) {
                    if (folderChildElement.getAttribute("expectedStart-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("expectedStart", folderChildElement.getAttribute("expectedStart-ref"));
                    } else {
                        folderBuilder.addPropertyValue("expectedStart", (("#[registry:"+ folderChildElement.getAttribute("expectedStart-ref"))+"]"));
                    }
                }
                if (hasAttribute(folderChildElement, "p98Finish-ref")) {
                    if (folderChildElement.getAttribute("p98Finish-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("p98Finish", folderChildElement.getAttribute("p98Finish-ref"));
                    } else {
                        folderBuilder.addPropertyValue("p98Finish", (("#[registry:"+ folderChildElement.getAttribute("p98Finish-ref"))+"]"));
                    }
                }
                parseListAndSetProperty(folderChildElement, folderBuilder, "globalPriority", "global-priority", "global-priority", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(folderBuilder, folderChildElement, "hasNote", "hasNote");
                parseProperty(folderBuilder, folderChildElement, "highEffortRemaining", "highEffortRemaining");
                parseProperty(folderBuilder, folderChildElement, "isDone", "isDone");
                parseProperty(folderBuilder, folderChildElement, "isOnHold", "isOnHold");
                if (hasAttribute(folderChildElement, "latestFinish-ref")) {
                    if (folderChildElement.getAttribute("latestFinish-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("latestFinish", folderChildElement.getAttribute("latestFinish-ref"));
                    } else {
                        folderBuilder.addPropertyValue("latestFinish", (("#[registry:"+ folderChildElement.getAttribute("latestFinish-ref"))+"]"));
                    }
                }
                parseProperty(folderBuilder, folderChildElement, "lowEffortRemaining", "lowEffortRemaining");
                parseProperty(folderBuilder, folderChildElement, "manualAlert", "manualAlert");
                if (hasAttribute(folderChildElement, "max_effort-ref")) {
                    if (folderChildElement.getAttribute("max_effort-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("max_effort", folderChildElement.getAttribute("max_effort-ref"));
                    } else {
                        folderBuilder.addPropertyValue("max_effort", (("#[registry:"+ folderChildElement.getAttribute("max_effort-ref"))+"]"));
                    }
                }
                parseProperty(folderBuilder, folderChildElement, "name", "name");
                parseProperty(folderBuilder, folderChildElement, "ownerId", "ownerId");
                parseProperty(folderBuilder, folderChildElement, "parentId", "parentId");
                parseListAndSetProperty(folderChildElement, folderBuilder, "parentIds", "parent-ids", "parent-id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(folderChildElement, folderBuilder, "parentCrumbs", "parent-crumbs", "parent-crumb", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                if (hasAttribute(folderChildElement, "promiseBy-ref")) {
                    if (folderChildElement.getAttribute("promiseBy-ref").startsWith("#")) {
                        folderBuilder.addPropertyValue("promiseBy", folderChildElement.getAttribute("promiseBy-ref"));
                    } else {
                        folderBuilder.addPropertyValue("promiseBy", (("#[registry:"+ folderChildElement.getAttribute("promiseBy-ref"))+"]"));
                    }
                }
                parseProperty(folderBuilder, folderChildElement, "externalReference", "externalReference");
                parseProperty(folderBuilder, folderChildElement, "updatedAt", "updatedAt");
                parseProperty(folderBuilder, folderChildElement, "updatedBy", "updatedBy");
                parseProperty(folderBuilder, folderChildElement, "id", "id");
                builder.addPropertyValue("folder", folderBuilder.getBeanDefinition());
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
