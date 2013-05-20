
package org.mule.LiquidPlanner.client.model.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.model.holders.LinkExpressionHolder;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.processors.AbstractExpressionEvaluator;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class LinkExpressionHolderTransformer
    extends AbstractExpressionEvaluator
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == LinkExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == LinkExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {LinkExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(LinkExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return Link.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Link.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        LinkExpressionHolder holder = ((LinkExpressionHolder) src);
        Link result = new Link();
        try {
            final String _transformedCreated_at = ((String) evaluateAndTransform(this.muleContext, event, LinkExpressionHolder.class.getDeclaredField("_created_atType").getGenericType(), null, holder.getCreated_at()));
            result.setCreated_at(_transformedCreated_at);
            final Integer _transformedCreated_by = ((Integer) evaluateAndTransform(this.muleContext, event, LinkExpressionHolder.class.getDeclaredField("_created_byType").getGenericType(), null, holder.getCreated_by()));
            result.setCreated_by(_transformedCreated_by);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, LinkExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final Integer _transformedItem_id = ((Integer) evaluateAndTransform(this.muleContext, event, LinkExpressionHolder.class.getDeclaredField("_item_idType").getGenericType(), null, holder.getItem_id()));
            result.setItem_id(_transformedItem_id);
            final String _transformedUpdated_at = ((String) evaluateAndTransform(this.muleContext, event, LinkExpressionHolder.class.getDeclaredField("_updated_atType").getGenericType(), null, holder.getUpdated_at()));
            result.setUpdated_at(_transformedUpdated_at);
            final Integer _transformedUpdated_by = ((Integer) evaluateAndTransform(this.muleContext, event, LinkExpressionHolder.class.getDeclaredField("_updated_byType").getGenericType(), null, holder.getUpdated_by()));
            result.setUpdated_by(_transformedUpdated_by);
            final String _transformedUrl = ((String) evaluateAndTransform(this.muleContext, event, LinkExpressionHolder.class.getDeclaredField("_urlType").getGenericType(), null, holder.getUrl()));
            result.setUrl(_transformedUrl);
            final Integer _transformedId = ((Integer) evaluateAndTransform(this.muleContext, event, LinkExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

}
