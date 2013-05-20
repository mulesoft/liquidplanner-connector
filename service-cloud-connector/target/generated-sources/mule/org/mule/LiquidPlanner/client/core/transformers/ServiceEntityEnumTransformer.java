
package org.mule.LiquidPlanner.client.core.transformers;

import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class ServiceEntityEnumTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;

    public ServiceEntityEnumTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(ServiceEntity.class);
        setName("ServiceEntityEnumTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        ServiceEntity result = null;
        result = Enum.valueOf(ServiceEntity.class, ((String) src));
        return result;
    }

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

}
