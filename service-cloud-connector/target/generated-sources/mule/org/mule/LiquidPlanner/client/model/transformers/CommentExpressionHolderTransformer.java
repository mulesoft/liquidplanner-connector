
package org.mule.LiquidPlanner.client.model.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.holders.CommentExpressionHolder;
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
public class CommentExpressionHolderTransformer
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
        return (aClass == CommentExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CommentExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CommentExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CommentExpressionHolder.class)});
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
        return Comment.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Comment.class);
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
        CommentExpressionHolder holder = ((CommentExpressionHolder) src);
        Comment result = new Comment();
        try {
            final List<String> _transformedAtPersonIds = ((List<String> ) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_atPersonIdsType").getGenericType(), null, holder.getAtPersonIds()));
            result.setAtPersonIds(_transformedAtPersonIds);
            final List<String> _transformedAtMemberIds = ((List<String> ) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_atMemberIdsType").getGenericType(), null, holder.getAtMemberIds()));
            result.setAtMemberIds(_transformedAtMemberIds);
            final String _transformedComment = ((String) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_commentType").getGenericType(), null, holder.getComment()));
            result.setComment(_transformedComment);
            final String _transformedCreatedAt = ((String) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_createdAtType").getGenericType(), null, holder.getCreatedAt()));
            result.setCreatedAt(_transformedCreatedAt);
            final Integer _transformedCreatedBy = ((Integer) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_createdByType").getGenericType(), null, holder.getCreatedBy()));
            result.setCreatedBy(_transformedCreatedBy);
            final Integer _transformedPersonId = ((Integer) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_personIdType").getGenericType(), null, holder.getPersonId()));
            result.setPersonId(_transformedPersonId);
            final Integer _transformedMemberId = ((Integer) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_memberIdType").getGenericType(), null, holder.getMemberId()));
            result.setMemberId(_transformedMemberId);
            final String _transformedPlainText = ((String) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_plainTextType").getGenericType(), null, holder.getPlainText()));
            result.setPlainText(_transformedPlainText);
            final Integer _transformedItemId = ((Integer) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_itemIdType").getGenericType(), null, holder.getItemId()));
            result.setItemId(_transformedItemId);
            final String _transformedUpdatedAt = ((String) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_updatedAtType").getGenericType(), null, holder.getUpdatedAt()));
            result.setUpdatedAt(_transformedUpdatedAt);
            final Integer _transformedUpdatedBy = ((Integer) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_updatedByType").getGenericType(), null, holder.getUpdatedBy()));
            result.setUpdatedBy(_transformedUpdatedBy);
            final Integer _transformedId = ((Integer) evaluateAndTransform(this.muleContext, event, CommentExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
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
