/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * POJO that represents the Project entity
 * 
 * @author damiansima
 * 
 */
public class Project extends TreeItem {
    @JsonProperty("alerts")
    private List<Alert> alerts;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("custom_field_values")
    private Map<String, String> customFieldValues = new HashMap<String, String>();

    @JsonProperty("delay_until")
    private String delayUntil;

    @JsonProperty("description")
    private String description;

    @JsonProperty("done_on")
    private String doneOn;

    @JsonProperty("earliest_finish")
    private String earliestFinish;

    @JsonProperty("earliest_start")
    private String earliestStart;

    @JsonProperty("expected_finish")
    private String expectedFinish;

    @JsonProperty("expected_start")
    private String expectedStart;

    @JsonProperty("external_reference")
    private String externalReference;

    @JsonProperty("global_priority")
    private List<String> globalPriority;

    @JsonProperty("has_note")
    private Boolean hasNote;

    @JsonProperty("high_effort_remaining")
    private Double highEffortRemaining;

    @JsonProperty("id")
    private String id;

    @JsonProperty("is_done")
    private Boolean isDone;

    @JsonProperty("is_on_hold")
    private Boolean isOnHold;

    @JsonProperty("latest_finish")
    private String latestFinish;

    @JsonProperty("low_effort_remaining")
    private Double lowEffortRemaining;

    @JsonProperty("manual_alert")
    private String manualAlert;

    @JsonProperty("max_effort")
    private String maxEffort;

    @JsonProperty("name")
    private String name;

    @JsonProperty("owner_id")
    private String ownerId;

    @JsonProperty("p98_finish")
    private String p98Finish;

    @JsonProperty("parent_crumbs")
    private List<String> parentCrumbs;

    @JsonProperty("parent_id")
    private String parentId;

    @JsonProperty("parent_ids")
    private List<String> parentIds;

    @JsonProperty("promise_by")
    private String promiseBy;

    @JsonProperty("started_on")
    private String startedOn;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("updated_by")
    private String updatedBy;

    @JsonProperty("work")
    private Double work;

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Map<String, String> getCustomFieldValues() {
        return customFieldValues;
    }

    public void setCustomFieldValues(Map<String, String> customFieldValues) {
        this.customFieldValues = customFieldValues;
    }

    public String getDelayUntil() {
        return delayUntil;
    }

    public void setDelayUntil(String delayUntil) {
        this.delayUntil = delayUntil;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoneOn() {
        return doneOn;
    }

    public void setDoneOn(String doneOn) {
        this.doneOn = doneOn;
    }

    public String getEarliestFinish() {
        return earliestFinish;
    }

    public void setEarliestFinish(String earliestFinish) {
        this.earliestFinish = earliestFinish;
    }

    public String getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(String earliestStart) {
        this.earliestStart = earliestStart;
    }

    public String getExpectedFinish() {
        return expectedFinish;
    }

    public void setExpectedFinish(String expectedFinish) {
        this.expectedFinish = expectedFinish;
    }

    public String getExpectedStart() {
        return expectedStart;
    }

    public void setExpectedStart(String expectedStart) {
        this.expectedStart = expectedStart;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public List<String> getGlobalPriority() {
        return globalPriority;
    }

    public void setGlobalPriority(List<String> globalPriority) {
        this.globalPriority = globalPriority;
    }

    public Boolean getHasNote() {
        return hasNote;
    }

    public void setHasNote(Boolean hasNote) {
        this.hasNote = hasNote;
    }

    public Double getHighEffortRemaining() {
        return highEffortRemaining;
    }

    public void setHighEffortRemaining(Double highEffortRemaining) {
        this.highEffortRemaining = highEffortRemaining;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Boolean getIsOnHold() {
        return isOnHold;
    }

    public void setIsOnHold(Boolean isOnHold) {
        this.isOnHold = isOnHold;
    }

    public String getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(String latestFinish) {
        this.latestFinish = latestFinish;
    }

    public Double getLowEffortRemaining() {
        return lowEffortRemaining;
    }

    public void setLowEffortRemaining(Double lowEffortRemaining) {
        this.lowEffortRemaining = lowEffortRemaining;
    }

    public String getManualAlert() {
        return manualAlert;
    }

    public void setManualAlert(String manualAlert) {
        this.manualAlert = manualAlert;
    }

    public String getMaxEffort() {
        return maxEffort;
    }

    public void setMaxEffort(String maxEffort) {
        this.maxEffort = maxEffort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getP98Finish() {
        return p98Finish;
    }

    public void setP98Finish(String p98Finish) {
        this.p98Finish = p98Finish;
    }

    public List<String> getParentCrumbs() {
        return parentCrumbs;
    }

    public void setParentCrumbs(List<String> parentCrumbs) {
        this.parentCrumbs = parentCrumbs;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<String> getParentIds() {
        return parentIds;
    }

    public void setParentIds(List<String> parentIds) {
        this.parentIds = parentIds;
    }

    public String getPromiseBy() {
        return promiseBy;
    }

    public void setPromiseBy(String promiseBy) {
        this.promiseBy = promiseBy;
    }

    public String getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(String starterdOn) {
        this.startedOn = starterdOn;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Double getWork() {
        return work;
    }

    public void setWork(Double work) {
        this.work = work;
    }

}
