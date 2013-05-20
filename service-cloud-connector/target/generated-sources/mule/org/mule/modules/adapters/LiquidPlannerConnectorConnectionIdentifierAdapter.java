
package org.mule.modules.adapters;

import javax.annotation.Generated;
import org.mule.modules.LiquidPlannerConnector;
import org.mule.modules.connection.Connection;


/**
 * A <code>LiquidPlannerConnectorConnectionIdentifierAdapter</code> is a wrapper around {@link LiquidPlannerConnector } that implements {@link org.mule.devkit.dynamic.api.helper.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class LiquidPlannerConnectorConnectionIdentifierAdapter
    extends LiquidPlannerConnectorProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.connectionId();
    }

}
