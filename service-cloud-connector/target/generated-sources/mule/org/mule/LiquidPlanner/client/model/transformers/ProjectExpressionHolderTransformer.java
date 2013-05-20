
package org.mule.LiquidPlanner.client.model.transformers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.mule.LiquidPlanner.client.model.Alert;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.model.holders.ProjectExpressionHolder;
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
public class ProjectExpressionHolderTransformer
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
        return (aClass == ProjectExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ProjectExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ProjectExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ProjectExpressionHolder.class)});
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
        return Project.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Project.class);
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
        ProjectExpressionHolder holder = ((ProjectExpressionHolder) src);
        Project result = new Project();
        try {
            final List<Alert> _transformedAlerts = ((List<Alert> ) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_alertsType").getGenericType(), null, holder.getAlerts()));
            result.setAlerts(_transformedAlerts);
            final String _transformedClientId = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_clientIdType").getGenericType(), null, holder.getClientId()));
            result.setClientId(_transformedClientId);
            final String _transformedCreatedAt = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_createdAtType").getGenericType(), null, holder.getCreatedAt()));
            result.setCreatedAt(_transformedCreatedAt);
            final String _transformedCreatedBy = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_createdByType").getGenericType(), null, holder.getCreatedBy()));
            result.setCreatedBy(_transformedCreatedBy);
            final Map<String, String> _transformedCustomFieldValues = ((Map<String, String> ) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_customFieldValuesType").getGenericType(), null, holder.getCustomFieldValues()));
            result.setCustomFieldValues(_transformedCustomFieldValues);
            final String _transformedDelayUntil = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_delayUntilType").getGenericType(), null, holder.getDelayUntil()));
            result.setDelayUntil(_transformedDelayUntil);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final String _transformedDoneOn = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_doneOnType").getGenericType(), null, holder.getDoneOn()));
            result.setDoneOn(_transformedDoneOn);
            final String _transformedEarliestFinish = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_earliestFinishType").getGenericType(), null, holder.getEarliestFinish()));
            result.setEarliestFinish(_transformedEarliestFinish);
            final String _transformedEarliestStart = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_earliestStartType").getGenericType(), null, holder.getEarliestStart()));
            result.setEarliestStart(_transformedEarliestStart);
            final String _transformedExpectedFinish = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_expectedFinishType").getGenericType(), null, holder.getExpectedFinish()));
            result.setExpectedFinish(_transformedExpectedFinish);
            final String _transformedExpectedStart = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_expectedStartType").getGenericType(), null, holder.getExpectedStart()));
            result.setExpectedStart(_transformedExpectedStart);
            final String _transformedExternalReference = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_externalReferenceType").getGenericType(), null, holder.getExternalReference()));
            result.setExternalReference(_transformedExternalReference);
            final List<String> _transformedGlobalPriority = ((List<String> ) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_globalPriorityType").getGenericType(), null, holder.getGlobalPriority()));
            result.setGlobalPriority(_transformedGlobalPriority);
            final Boolean _transformedHasNote = ((Boolean) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_hasNoteType").getGenericType(), null, holder.getHasNote()));
            result.setHasNote(_transformedHasNote);
            final Double _transformedHighEffortRemaining = ((Double) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_highEffortRemainingType").getGenericType(), null, holder.getHighEffortRemaining()));
            result.setHighEffortRemaining(_transformedHighEffortRemaining);
            final String _transformedId = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final Boolean _transformedIsDone = ((Boolean) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_isDoneType").getGenericType(), null, holder.getIsDone()));
            result.setIsDone(_transformedIsDone);
            final Boolean _transformedIsOnHold = ((Boolean) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_isOnHoldType").getGenericType(), null, holder.getIsOnHold()));
            result.setIsOnHold(_transformedIsOnHold);
            final String _transformedLatestFinish = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_latestFinishType").getGenericType(), null, holder.getLatestFinish()));
            result.setLatestFinish(_transformedLatestFinish);
            final Double _transformedLowEffortRemaining = ((Double) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_lowEffortRemainingType").getGenericType(), null, holder.getLowEffortRemaining()));
            result.setLowEffortRemaining(_transformedLowEffortRemaining);
            final String _transformedManualAlert = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_manualAlertType").getGenericType(), null, holder.getManualAlert()));
            result.setManualAlert(_transformedManualAlert);
            final String _transformedMaxEffort = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_maxEffortType").getGenericType(), null, holder.getMaxEffort()));
            result.setMaxEffort(_transformedMaxEffort);
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final String _transformedOwnerId = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_ownerIdType").getGenericType(), null, holder.getOwnerId()));
            result.setOwnerId(_transformedOwnerId);
            final String _transformedP98Finish = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_p98FinishType").getGenericType(), null, holder.getP98Finish()));
            result.setP98Finish(_transformedP98Finish);
            final List<String> _transformedParentCrumbs = ((List<String> ) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_parentCrumbsType").getGenericType(), null, holder.getParentCrumbs()));
            result.setParentCrumbs(_transformedParentCrumbs);
            final String _transformedParentId = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_parentIdType").getGenericType(), null, holder.getParentId()));
            result.setParentId(_transformedParentId);
            final List<String> _transformedParentIds = ((List<String> ) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_parentIdsType").getGenericType(), null, holder.getParentIds()));
            result.setParentIds(_transformedParentIds);
            final String _transformedPromiseBy = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_promiseByType").getGenericType(), null, holder.getPromiseBy()));
            result.setPromiseBy(_transformedPromiseBy);
            final String _transformedStartedOn = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_startedOnType").getGenericType(), null, holder.getStartedOn()));
            result.setStartedOn(_transformedStartedOn);
            final String _transformedUpdatedAt = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_updatedAtType").getGenericType(), null, holder.getUpdatedAt()));
            result.setUpdatedAt(_transformedUpdatedAt);
            final String _transformedUpdatedBy = ((String) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_updatedByType").getGenericType(), null, holder.getUpdatedBy()));
            result.setUpdatedBy(_transformedUpdatedBy);
            final Double _transformedWork = ((Double) evaluateAndTransform(this.muleContext, event, ProjectExpressionHolder.class.getDeclaredField("_workType").getGenericType(), null, holder.getWork()));
            result.setWork(_transformedWork);
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
