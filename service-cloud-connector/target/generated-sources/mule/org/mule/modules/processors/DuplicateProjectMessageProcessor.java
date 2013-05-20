
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
 * DuplicateProjectMessageProcessor invokes the {@link org.mule.modules.LiquidPlannerConnector#duplicateProject(java.lang.String, java.lang.String, java.lang.String, java.lang.String)} method in {@link LiquidPlannerConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class DuplicateProjectMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor
{

    protected Object workSpaceId;
    protected String _workSpaceIdType;
    protected Object sourceProjectId;
    protected String _sourceProjectIdType;
    protected Object destinationParentId;
    protected String _destinationParentIdType;
    protected Object newProjectName;
    protected String _newProjectNameType;

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
     * Sets newProjectName
     * 
     * @param value Value to set
     */
    public void setNewProjectName(Object value) {
        this.newProjectName = value;
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
     * Sets sourceProjectId
     * 
     * @param value Value to set
     */
    public void setSourceProjectId(Object value) {
        this.sourceProjectId = value;
    }

    /**
     * Sets destinationParentId
     * 
     * @param value Value to set
     */
    public void setDestinationParentId(Object value) {
        this.destinationParentId = value;
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
            final String _transformedWorkSpaceId = ((String) evaluateAndTransform(getMuleContext(), event, DuplicateProjectMessageProcessor.class.getDeclaredField("_workSpaceIdType").getGenericType(), null, workSpaceId));
            final String _transformedSourceProjectId = ((String) evaluateAndTransform(getMuleContext(), event, DuplicateProjectMessageProcessor.class.getDeclaredField("_sourceProjectIdType").getGenericType(), null, sourceProjectId));
            final String _transformedDestinationParentId = ((String) evaluateAndTransform(getMuleContext(), event, DuplicateProjectMessageProcessor.class.getDeclaredField("_destinationParentIdType").getGenericType(), null, destinationParentId));
            final String _transformedNewProjectName = ((String) evaluateAndTransform(getMuleContext(), event, DuplicateProjectMessageProcessor.class.getDeclaredField("_newProjectNameType").getGenericType(), null, newProjectName));
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
                    return ((LiquidPlannerConnector) object).duplicateProject(_transformedWorkSpaceId, _transformedSourceProjectId, _transformedDestinationParentId, _transformedNewProjectName);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("duplicateProject"), event, e);
        }
    }

}
