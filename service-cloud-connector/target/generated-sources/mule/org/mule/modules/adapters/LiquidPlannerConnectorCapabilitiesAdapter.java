
package org.mule.modules.adapters;

import javax.annotation.Generated;
import org.mule.modules.LiquidPlannerConnector;
import org.mule.modules.basic.Capabilities;
import org.mule.modules.basic.Capability;


/**
 * A <code>LiquidPlannerConnectorCapabilitiesAdapter</code> is a wrapper around {@link LiquidPlannerConnector } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class LiquidPlannerConnectorCapabilitiesAdapter
    extends LiquidPlannerConnector
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(Capability capability) {
        if (capability == Capability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == Capability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

}
