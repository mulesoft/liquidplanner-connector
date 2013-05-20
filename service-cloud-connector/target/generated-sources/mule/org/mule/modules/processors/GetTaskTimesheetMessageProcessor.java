
package org.mule.modules.processors;

import java.util.List;
import javax.annotation.Generated;
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
 * GetTaskTimesheetMessageProcessor invokes the {@link org.mule.modules.LiquidPlannerConnector#getTaskTimesheet(java.lang.String, java.lang.String, java.lang.String)} method in {@link LiquidPlannerConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class GetTaskTimesheetMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor
{

    protected Object workSpaceId;
    protected String _workSpaceIdType;
    protected Object taskId;
    protected String _taskIdType;
    protected Object timesheetId;
    protected String _timesheetIdType;

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
     * Sets taskId
     * 
     * @param value Value to set
     */
    public void setTaskId(Object value) {
        this.taskId = value;
    }

    /**
     * Sets timesheetId
     * 
     * @param value Value to set
     */
    public void setTimesheetId(Object value) {
        this.timesheetId = value;
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
            final String _transformedWorkSpaceId = ((String) evaluateAndTransform(getMuleContext(), event, GetTaskTimesheetMessageProcessor.class.getDeclaredField("_workSpaceIdType").getGenericType(), null, workSpaceId));
            final String _transformedTaskId = ((String) evaluateAndTransform(getMuleContext(), event, GetTaskTimesheetMessageProcessor.class.getDeclaredField("_taskIdType").getGenericType(), null, taskId));
            final String _transformedTimesheetId = ((String) evaluateAndTransform(getMuleContext(), event, GetTaskTimesheetMessageProcessor.class.getDeclaredField("_timesheetIdType").getGenericType(), null, timesheetId));
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
                    return ((LiquidPlannerConnector) object).getTaskTimesheet(_transformedWorkSpaceId, _transformedTaskId, _transformedTimesheetId);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("getTaskTimesheet"), event, e);
        }
    }

}
