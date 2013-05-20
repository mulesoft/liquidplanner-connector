
package org.mule.LiquidPlanner.client.model.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.holders.ClientExpressionHolder;
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
public class ClientExpressionHolderTransformer
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
        return (aClass == ClientExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ClientExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ClientExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ClientExpressionHolder.class)});
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
        return Client.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Client.class);
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
        ClientExpressionHolder holder = ((ClientExpressionHolder) src);
        Client result = new Client();
        try {
            final Double _transformedWork = ((Double) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_workType").getGenericType(), null, holder.getWork()));
            result.setWork(_transformedWork);
            final List<Object> _transformedAlerts = ((List<Object> ) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_alertsType").getGenericType(), null, holder.getAlerts()));
            result.setAlerts(_transformedAlerts);
            final String _transformedCreated_at = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_created_atType").getGenericType(), null, holder.getCreated_at()));
            result.setCreated_at(_transformedCreated_at);
            final Integer _transformedCreated_by = ((Integer) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_created_byType").getGenericType(), null, holder.getCreated_by()));
            result.setCreated_by(_transformedCreated_by);
            final Object _transformedDone_on = ((Object) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_done_onType").getGenericType(), null, holder.getDone_on()));
            result.setDone_on(_transformedDone_on);
            final Object _transformedStarted_on = ((Object) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_started_onType").getGenericType(), null, holder.getStarted_on()));
            result.setStarted_on(_transformedStarted_on);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final String _transformedEarliest_finish = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_earliest_finishType").getGenericType(), null, holder.getEarliest_finish()));
            result.setEarliest_finish(_transformedEarliest_finish);
            final String _transformedEarliest_start = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_earliest_startType").getGenericType(), null, holder.getEarliest_start()));
            result.setEarliest_start(_transformedEarliest_start);
            final String _transformedExpected_finish = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_expected_finishType").getGenericType(), null, holder.getExpected_finish()));
            result.setExpected_finish(_transformedExpected_finish);
            final String _transformedExpected_start = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_expected_startType").getGenericType(), null, holder.getExpected_start()));
            result.setExpected_start(_transformedExpected_start);
            final String _transformedP98_finish = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_p98_finishType").getGenericType(), null, holder.getP98_finish()));
            result.setP98_finish(_transformedP98_finish);
            final Boolean _transformedHas_note = ((Boolean) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_has_noteType").getGenericType(), null, holder.getHas_note()));
            result.setHas_note(_transformedHas_note);
            final Double _transformedHigh_effort_remaining = ((Double) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_high_effort_remainingType").getGenericType(), null, holder.getHigh_effort_remaining()));
            result.setHigh_effort_remaining(_transformedHigh_effort_remaining);
            final Boolean _transformedIs_done = ((Boolean) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_is_doneType").getGenericType(), null, holder.getIs_done()));
            result.setIs_done(_transformedIs_done);
            final Boolean _transformedIs_on_hold = ((Boolean) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_is_on_holdType").getGenericType(), null, holder.getIs_on_hold()));
            result.setIs_on_hold(_transformedIs_on_hold);
            final String _transformedLatest_finish = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_latest_finishType").getGenericType(), null, holder.getLatest_finish()));
            result.setLatest_finish(_transformedLatest_finish);
            final Double _transformedLow_effort_remaining = ((Double) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_low_effort_remainingType").getGenericType(), null, holder.getLow_effort_remaining()));
            result.setLow_effort_remaining(_transformedLow_effort_remaining);
            final String _transformedManual_alert = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_manual_alertType").getGenericType(), null, holder.getManual_alert()));
            result.setManual_alert(_transformedManual_alert);
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final Integer _transformedOwner_id = ((Integer) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_owner_idType").getGenericType(), null, holder.getOwner_id()));
            result.setOwner_id(_transformedOwner_id);
            final Object _transformedExternal_reference = ((Object) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_external_referenceType").getGenericType(), null, holder.getExternal_reference()));
            result.setExternal_reference(_transformedExternal_reference);
            final String _transformedUpdated_at = ((String) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_updated_atType").getGenericType(), null, holder.getUpdated_at()));
            result.setUpdated_at(_transformedUpdated_at);
            final Integer _transformedUpdated_by = ((Integer) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_updated_byType").getGenericType(), null, holder.getUpdated_by()));
            result.setUpdated_by(_transformedUpdated_by);
            final Integer _transformedId = ((Integer) evaluateAndTransform(this.muleContext, event, ClientExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
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
