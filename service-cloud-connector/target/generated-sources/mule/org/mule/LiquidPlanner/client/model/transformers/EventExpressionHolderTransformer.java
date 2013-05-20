
package org.mule.LiquidPlanner.client.model.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.Alert;
import org.mule.LiquidPlanner.client.model.Event;
import org.mule.LiquidPlanner.client.model.holders.EventExpressionHolder;
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
public class EventExpressionHolderTransformer
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
        return (aClass == EventExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == EventExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {EventExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(EventExpressionHolder.class)});
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
        return Event.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Event.class);
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
        EventExpressionHolder holder = ((EventExpressionHolder) src);
        Event result = new Event();
        try {
            final Integer _transformedActivity_id = ((Integer) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_activity_idType").getGenericType(), null, holder.getActivity_id()));
            result.setActivity_id(_transformedActivity_id);
            final Double _transformedWork = ((Double) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_workType").getGenericType(), null, holder.getWork()));
            result.setWork(_transformedWork);
            final List<Alert> _transformedAlerts = ((List<Alert> ) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_alertsType").getGenericType(), null, holder.getAlerts()));
            result.setAlerts(_transformedAlerts);
            final Integer _transformedProject_id = ((Integer) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_project_idType").getGenericType(), null, holder.getProject_id()));
            result.setProject_id(_transformedProject_id);
            final Integer _transformedClient_id = ((Integer) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_client_idType").getGenericType(), null, holder.getClient_id()));
            result.setClient_id(_transformedClient_id);
            final String _transformedCreated_at = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_created_atType").getGenericType(), null, holder.getCreated_at()));
            result.setCreated_at(_transformedCreated_at);
            final Integer _transformedCreated_by = ((Integer) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_created_byType").getGenericType(), null, holder.getCreated_by()));
            result.setCreated_by(_transformedCreated_by);
            final Object _transformedDone_on = ((Object) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_done_onType").getGenericType(), null, holder.getDone_on()));
            result.setDone_on(_transformedDone_on);
            final Object _transformedStarted_on = ((Object) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_started_onType").getGenericType(), null, holder.getStarted_on()));
            result.setStarted_on(_transformedStarted_on);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final String _transformedEarliest_finish = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_earliest_finishType").getGenericType(), null, holder.getEarliest_finish()));
            result.setEarliest_finish(_transformedEarliest_finish);
            final String _transformedEarliest_start = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_earliest_startType").getGenericType(), null, holder.getEarliest_start()));
            result.setEarliest_start(_transformedEarliest_start);
            final String _transformedExpected_finish = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_expected_finishType").getGenericType(), null, holder.getExpected_finish()));
            result.setExpected_finish(_transformedExpected_finish);
            final String _transformedExpected_start = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_expected_startType").getGenericType(), null, holder.getExpected_start()));
            result.setExpected_start(_transformedExpected_start);
            final String _transformedP98_finish = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_p98_finishType").getGenericType(), null, holder.getP98_finish()));
            result.setP98_finish(_transformedP98_finish);
            final List<Integer> _transformedGlobal_priority = ((List<Integer> ) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_global_priorityType").getGenericType(), null, holder.getGlobal_priority()));
            result.setGlobal_priority(_transformedGlobal_priority);
            final Object _transformedGlobal_package_priority = ((Object) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_global_package_priorityType").getGenericType(), null, holder.getGlobal_package_priority()));
            result.setGlobal_package_priority(_transformedGlobal_package_priority);
            final Boolean _transformedHas_note = ((Boolean) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_has_noteType").getGenericType(), null, holder.getHas_note()));
            result.setHas_note(_transformedHas_note);
            final Double _transformedHigh_effort_remaining = ((Double) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_high_effort_remainingType").getGenericType(), null, holder.getHigh_effort_remaining()));
            result.setHigh_effort_remaining(_transformedHigh_effort_remaining);
            final Boolean _transformedIs_done = ((Boolean) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_is_doneType").getGenericType(), null, holder.getIs_done()));
            result.setIs_done(_transformedIs_done);
            final Boolean _transformedIs_on_hold = ((Boolean) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_is_on_holdType").getGenericType(), null, holder.getIs_on_hold()));
            result.setIs_on_hold(_transformedIs_on_hold);
            final Boolean _transformedIs_packaged_version = ((Boolean) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_is_packaged_versionType").getGenericType(), null, holder.getIs_packaged_version()));
            result.setIs_packaged_version(_transformedIs_packaged_version);
            final Boolean _transformedIs_shared = ((Boolean) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_is_sharedType").getGenericType(), null, holder.getIs_shared()));
            result.setIs_shared(_transformedIs_shared);
            final String _transformedLatest_finish = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_latest_finishType").getGenericType(), null, holder.getLatest_finish()));
            result.setLatest_finish(_transformedLatest_finish);
            final Double _transformedLow_effort_remaining = ((Double) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_low_effort_remainingType").getGenericType(), null, holder.getLow_effort_remaining()));
            result.setLow_effort_remaining(_transformedLow_effort_remaining);
            final String _transformedManual_alert = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_manual_alertType").getGenericType(), null, holder.getManual_alert()));
            result.setManual_alert(_transformedManual_alert);
            final Object _transformedMax_effort = ((Object) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_max_effortType").getGenericType(), null, holder.getMax_effort()));
            result.setMax_effort(_transformedMax_effort);
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final Integer _transformedOwner_id = ((Integer) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_owner_idType").getGenericType(), null, holder.getOwner_id()));
            result.setOwner_id(_transformedOwner_id);
            final Integer _transformedParent_id = ((Integer) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_parent_idType").getGenericType(), null, holder.getParent_id()));
            result.setParent_id(_transformedParent_id);
            final String _transformedDate = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_dateType").getGenericType(), null, holder.getDate()));
            result.setDate(_transformedDate);
            final String _transformedExternal_reference = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_external_referenceType").getGenericType(), null, holder.getExternal_reference()));
            result.setExternal_reference(_transformedExternal_reference);
            final Object _transformedPackage_id = ((Object) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_package_idType").getGenericType(), null, holder.getPackage_id()));
            result.setPackage_id(_transformedPackage_id);
            final List<Integer> _transformedParent_ids = ((List<Integer> ) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_parent_idsType").getGenericType(), null, holder.getParent_ids()));
            result.setParent_ids(_transformedParent_ids);
            final List<String> _transformedParent_crumbs = ((List<String> ) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_parent_crumbsType").getGenericType(), null, holder.getParent_crumbs()));
            result.setParent_crumbs(_transformedParent_crumbs);
            final List<Object> _transformedPackage_ids = ((List<Object> ) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_package_idsType").getGenericType(), null, holder.getPackage_ids()));
            result.setPackage_ids(_transformedPackage_ids);
            final List<Object> _transformedPackage_crumbs = ((List<Object> ) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_package_crumbsType").getGenericType(), null, holder.getPackage_crumbs()));
            result.setPackage_crumbs(_transformedPackage_crumbs);
            final String _transformedUpdated_at = ((String) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_updated_atType").getGenericType(), null, holder.getUpdated_at()));
            result.setUpdated_at(_transformedUpdated_at);
            final Integer _transformedUpdated_by = ((Integer) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_updated_byType").getGenericType(), null, holder.getUpdated_by()));
            result.setUpdated_by(_transformedUpdated_by);
            final Integer _transformedId = ((Integer) evaluateAndTransform(this.muleContext, event, EventExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
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
