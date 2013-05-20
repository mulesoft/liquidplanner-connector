
package org.mule.modules.processors;

import java.util.List;
import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.api.MessagingException;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.api.processor.MessageProcessor;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.LiquidPlannerConnector;
import org.mule.modules.connectivity.LiquidPlannerConnectorConnectionManager;
import org.mule.modules.process.ProcessAdapter;
import org.mule.modules.process.ProcessCallback;
import org.mule.modules.process.ProcessTemplate;


/**
 * UpdateProjectMessageProcessor invokes the {@link org.mule.modules.LiquidPlannerConnector#updateProject(java.lang.String, org.mule.LiquidPlanner.client.model.Project)} method in {@link LiquidPlannerConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class UpdateProjectMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor
{

    protected Object workSpaceId;
    protected String _workSpaceIdType;
    protected Object project;
    protected Project _projectType;

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    public void start()
        throws MuleException
    {
    }

    public void stop()
        throws MuleException
    {
    }

    public void dispose() {
    }

    /**
     * Set the Mule context
     * 
     * @param context Mule context to set
     */
    public void setMuleContext(MuleContext context) {
        super.setMuleContext(context);
    }

    /**
     * Sets flow construct
     * 
     * @param flowConstruct Flow construct to set
     */
    public void setFlowConstruct(FlowConstruct flowConstruct) {
        super.setFlowConstruct(flowConstruct);
    }

    /**
     * Sets project
     * 
     * @param value Value to set
     */
    public void setProject(Object value) {
        this.project = value;
    }

    /**
     * Sets workSpaceId
     * 
     * @param value Value to set
     */
    public void setWorkSpaceId(Object value) {
        this.workSpaceId = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws MuleException
     */
    public MuleEvent process(final MuleEvent event)
        throws MuleException
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(LiquidPlannerConnectorConnectionManager.class, true, event);
            final String _transformedWorkSpaceId = ((String) evaluateAndTransform(getMuleContext(), event, UpdateProjectMessageProcessor.class.getDeclaredField("_workSpaceIdType").getGenericType(), null, workSpaceId));
            final Project _transformedProject = ((Project) evaluateAndTransform(getMuleContext(), event, UpdateProjectMessageProcessor.class.getDeclaredField("_projectType").getGenericType(), null, project));
            Object resultPayload;
            ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((LiquidPlannerConnector) object).updateProject(_transformedWorkSpaceId, _transformedProject);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("updateProject"), event, e);
        }
    }

}
