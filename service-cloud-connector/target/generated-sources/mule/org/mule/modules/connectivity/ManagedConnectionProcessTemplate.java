
package org.mule.modules.connectivity;

import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.adapters.LiquidPlannerConnectorConnectionIdentifierAdapter;
import org.mule.modules.connection.ConnectionManager;
import org.mule.modules.process.ManagedConnectionProcessInterceptor;
import org.mule.modules.process.ProcessCallback;
import org.mule.modules.process.ProcessCallbackProcessInterceptor;
import org.mule.modules.process.ProcessInterceptor;
import org.mule.modules.process.ProcessTemplate;
import org.mule.modules.process.RetryProcessInterceptor;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class ManagedConnectionProcessTemplate<P >implements ProcessTemplate<P, LiquidPlannerConnectorConnectionIdentifierAdapter>
{

    private final ProcessInterceptor<P, LiquidPlannerConnectorConnectionIdentifierAdapter> processInterceptor;

    public ManagedConnectionProcessTemplate(ConnectionManager<LiquidPlannerConnectorConnectionKey, LiquidPlannerConnectorConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        ProcessInterceptor<P, LiquidPlannerConnectorConnectionIdentifierAdapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, LiquidPlannerConnectorConnectionIdentifierAdapter>();
        ProcessInterceptor<P, LiquidPlannerConnectorConnectionIdentifierAdapter> managedConnectionProcessInterceptor = new ManagedConnectionProcessInterceptor<P>(processCallbackProcessInterceptor, connectionManager, muleContext);
        ProcessInterceptor<P, LiquidPlannerConnectorConnectionIdentifierAdapter> retryProcessInterceptor = new RetryProcessInterceptor<P, LiquidPlannerConnectorConnectionIdentifierAdapter>(managedConnectionProcessInterceptor, muleContext, connectionManager.getRetryPolicyTemplate());
        processInterceptor = retryProcessInterceptor;
    }

    public P execute(ProcessCallback<P, LiquidPlannerConnectorConnectionIdentifierAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, LiquidPlannerConnectorConnectionIdentifierAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
