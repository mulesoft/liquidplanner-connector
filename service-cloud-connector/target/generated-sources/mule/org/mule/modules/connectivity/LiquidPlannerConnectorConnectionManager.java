
package org.mule.modules.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.mule.api.MuleContext;
import org.mule.api.config.MuleProperties;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.retry.RetryPolicyTemplate;
import org.mule.config.PoolingProfile;
import org.mule.modules.LiquidPlannerConnector;
import org.mule.modules.adapters.LiquidPlannerConnectorConnectionIdentifierAdapter;
import org.mule.modules.basic.Capabilities;
import org.mule.modules.basic.Capability;
import org.mule.modules.basic.MetadataAware;
import org.mule.modules.connection.ConnectionManager;
import org.mule.modules.process.ProcessAdapter;
import org.mule.modules.process.ProcessTemplate;


/**
 * A {@code LiquidPlannerConnectorConnectionManager} is a wrapper around {@link LiquidPlannerConnector } that adds connection management capabilities to the pojo.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class LiquidPlannerConnectorConnectionManager implements MuleContextAware, Initialisable, Capabilities, MetadataAware, ConnectionManager<LiquidPlannerConnectorConnectionKey, LiquidPlannerConnectorConnectionIdentifierAdapter> , ProcessAdapter<LiquidPlannerConnectorConnectionIdentifierAdapter>
{

    /**
     * 
     */
    private String username;
    /**
     * 
     */
    private String password;
    /**
     * Mule Context
     * 
     */
    protected MuleContext muleContext;
    /**
     * Flow Construct
     * 
     */
    protected FlowConstruct flowConstruct;
    /**
     * Connector Pool
     * 
     */
    private GenericKeyedObjectPool connectionPool;
    protected PoolingProfile connectionPoolingProfile;
    protected RetryPolicyTemplate retryPolicyTemplate;
    private final static String MODULE_NAME = "liquidplanner";
    private final static String MODULE_VERSION = "1.0-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.4.0";
    private final static String DEVKIT_BUILD = "3.4.0.1555.8df15c1";

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets flowConstruct
     * 
     * @param value Value to set
     */
    public void setFlowConstruct(FlowConstruct value) {
        this.flowConstruct = value;
    }

    /**
     * Retrieves flowConstruct
     * 
     */
    public FlowConstruct getFlowConstruct() {
        return this.flowConstruct;
    }

    /**
     * Sets connectionPoolingProfile
     * 
     * @param value Value to set
     */
    public void setConnectionPoolingProfile(PoolingProfile value) {
        this.connectionPoolingProfile = value;
    }

    /**
     * Retrieves connectionPoolingProfile
     * 
     */
    public PoolingProfile getConnectionPoolingProfile() {
        return this.connectionPoolingProfile;
    }

    /**
     * Sets retryPolicyTemplate
     * 
     * @param value Value to set
     */
    public void setRetryPolicyTemplate(RetryPolicyTemplate value) {
        this.retryPolicyTemplate = value;
    }

    /**
     * Retrieves retryPolicyTemplate
     * 
     */
    public RetryPolicyTemplate getRetryPolicyTemplate() {
        return this.retryPolicyTemplate;
    }

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Retrieves username
     * 
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets password
     * 
     * @param value Value to set
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Retrieves password
     * 
     */
    public String getPassword() {
        return this.password;
    }

    public void initialise() {
        GenericKeyedObjectPool.Config config = new GenericKeyedObjectPool.Config();
        if (connectionPoolingProfile!= null) {
            config.maxIdle = connectionPoolingProfile.getMaxIdle();
            config.maxActive = connectionPoolingProfile.getMaxActive();
            config.maxWait = connectionPoolingProfile.getMaxWait();
            config.whenExhaustedAction = ((byte) connectionPoolingProfile.getExhaustedAction());
        }
        connectionPool = new GenericKeyedObjectPool(new LiquidPlannerConnectorConnectionFactory(this), config);
        if (retryPolicyTemplate == null) {
            retryPolicyTemplate = muleContext.getRegistry().lookupObject(MuleProperties.OBJECT_DEFAULT_RETRY_POLICY_TEMPLATE);
        }
    }

    public LiquidPlannerConnectorConnectionIdentifierAdapter acquireConnection(LiquidPlannerConnectorConnectionKey key)
        throws Exception
    {
        return ((LiquidPlannerConnectorConnectionIdentifierAdapter) connectionPool.borrowObject(key));
    }

    public void releaseConnection(LiquidPlannerConnectorConnectionKey key, LiquidPlannerConnectorConnectionIdentifierAdapter connection)
        throws Exception
    {
        connectionPool.returnObject(key, connection);
    }

    public void destroyConnection(LiquidPlannerConnectorConnectionKey key, LiquidPlannerConnectorConnectionIdentifierAdapter connection)
        throws Exception
    {
        connectionPool.invalidateObject(key, connection);
    }

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

    @Override
    public<P >ProcessTemplate<P, LiquidPlannerConnectorConnectionIdentifierAdapter> getProcessTemplate() {
        return new ManagedConnectionProcessTemplate(this, muleContext);
    }

    public LiquidPlannerConnectorConnectionKey getDefaultConnectionKey() {
        return new LiquidPlannerConnectorConnectionKey(getUsername(), getPassword());
    }

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

}
