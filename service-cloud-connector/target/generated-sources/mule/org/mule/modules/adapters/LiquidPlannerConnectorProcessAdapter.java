
package org.mule.modules.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.LiquidPlannerConnector;
import org.mule.modules.process.ProcessAdapter;
import org.mule.modules.process.ProcessCallback;
import org.mule.modules.process.ProcessTemplate;
import org.mule.modules.process.ProcessTemplate;


/**
 * A <code>LiquidPlannerConnectorProcessAdapter</code> is a wrapper around {@link LiquidPlannerConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class LiquidPlannerConnectorProcessAdapter
    extends LiquidPlannerConnectorLifecycleAdapter
    implements ProcessAdapter<LiquidPlannerConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, LiquidPlannerConnectorCapabilitiesAdapter> getProcessTemplate() {
        final LiquidPlannerConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,LiquidPlannerConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, LiquidPlannerConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, LiquidPlannerConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
