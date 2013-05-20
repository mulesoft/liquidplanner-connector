
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
 * GetEventMessageProcessor invokes the {@link org.mule.modules.LiquidPlannerConnector#getEvent(java.lang.String, java.lang.String)} method in {@link LiquidPlannerConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class GetEventMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor
{

    protected Object workSpaceId;
    protected String _workSpaceIdType;
    protected Object eventId;
    protected String _eventIdType;

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
     * Sets workSpaceId
     * 
     * @param value Value to set
     */
    public void setWorkSpaceId(Object value) {
        this.workSpaceId = value;
    }

    /**
     * Sets eventId
     * 
     * @param value Value to set
     */
    public void setEventId(Object value) {
        this.eventId = value;
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
            final String _transformedWorkSpaceId = ((String) evaluateAndTransform(getMuleContext(), event, GetEventMessageProcessor.class.getDeclaredField("_workSpaceIdType").getGenericType(), null, workSpaceId));
            final String _transformedEventId = ((String) evaluateAndTransform(getMuleContext(), event, GetEventMessageProcessor.class.getDeclaredField("_eventIdType").getGenericType(), null, eventId));
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
                    return ((LiquidPlannerConnector) object).getEvent(_transformedWorkSpaceId, _transformedEventId);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("getEvent"), event, e);
        }
    }

}
