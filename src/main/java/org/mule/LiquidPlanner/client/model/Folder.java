/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Folder extends TreeItem {

    @JsonProperty("work")
    private Double work;
    @JsonProperty("alerts")
    private List<Object> alerts = new ArrayList<Object>();
    @JsonProperty("project_id")
    private Integer projectId;
    @JsonProperty("client_id")
    private Integer clientId;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("created_by")
    private Integer createdBy;
    @JsonProperty("done_on")
    private Object doneOn;
    @JsonProperty("started_on")
    private Object startedOn;
    @JsonProperty("delay_until")
    private Object delayUntil;
    @JsonProperty("description")
    private String description;
    @JsonProperty("earliest_finish")
    private Object earliestFinish;
    @JsonProperty("earliest_start")
    private Object earliestStart;
    @JsonProperty("expected_finish")
    private Object expectedFinish;
    @JsonProperty("expected_start")
    private Object expectedStart;
    @JsonProperty("p98_finish")
    private Object p98Finish;
    @JsonProperty("global_priority")
    private List<Integer> globalPriority = new ArrayList<Integer>();
    @JsonProperty("has_note")
    private Boolean hasNote;
    @JsonProperty("high_effort_remaining")
    private Double highEffortRemaining;
    @JsonProperty("is_done")
    private Boolean isDone;
    @JsonProperty("is_on_hold")
    private Boolean isOnHold;
    @JsonProperty("latest_finish")
    private Object latestFinish;
    @JsonProperty("low_effort_remaining")
    private Double lowEffortRemaining;
    @JsonProperty("manual_alert")
    private String manualAlert;
    @JsonProperty("max_effort")
    private Object max_effort;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("parent_id")
    private Integer parentId;
    @JsonProperty("parent_ids")
    private List<Integer> parentIds = new ArrayList<Integer>();
    @JsonProperty("parent_crumbs")
    private List<String> parentCrumbs = new ArrayList<String>();
    @JsonProperty("promise_by")
    private Object promiseBy;
    @JsonProperty("external_reference")
    private String externalReference;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("updated_by")
    private Integer updatedBy;
    @JsonProperty("id")
    private Integer id;

    public Double getWork() {
        return work;
    }

    public void setWork(Double work) {
        this.work = work;
    }

    public List<Object> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Object getDoneOn() {
        return doneOn;
    }

    public void setDoneOn(Object doneOn) {
        this.doneOn = doneOn;
    }

    public Object getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(Object startedOn) {
        this.startedOn = startedOn;
    }

    public Object getDelayUntil() {
        return delayUntil;
    }

    public void setDelayUntil(Object delayUntil) {
        this.delayUntil = delayUntil;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getEarliestFinish() {
        return earliestFinish;
    }

    public void setEarliestFinish(Object earliestFinish) {
        this.earliestFinish = earliestFinish;
    }

    public Object getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(Object earliestStart) {
        this.earliestStart = earliestStart;
    }

    public Object getExpectedFinish() {
        return expectedFinish;
    }

    public void setExpectedFinish(Object expectedFinish) {
        this.expectedFinish = expectedFinish;
    }

    public Object getExpectedStart() {
        return expectedStart;
    }

    public void setExpectedStart(Object expectedStart) {
        this.expectedStart = expectedStart;
    }

    public Object getP98Finish() {
        return p98Finish;
    }

    public void setP98Finish(Object p98Finish) {
        this.p98Finish = p98Finish;
    }

    public List<Integer> getGlobalPriority() {
        return globalPriority;
    }

    public void setGlobalPriority(List<Integer> globalPriority) {
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

    public Object getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(Object latestFinish) {
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

    public Object getMax_effort() {
        return max_effort;
    }

    public void setMax_effort(Object max_effort) {
        this.max_effort = max_effort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Integer> getParentIds() {
        return parentIds;
    }

    public void setParentIds(List<Integer> parentIds) {
        this.parentIds = parentIds;
    }

    public List<String> getParentCrumbs() {
        return parentCrumbs;
    }

    public void setParentCrumbs(List<String> parentCrumbs) {
        this.parentCrumbs = parentCrumbs;
    }

    public Object getPromiseBy() {
        return promiseBy;
    }

    public void setPromiseBy(Object promiseBy) {
        this.promiseBy = promiseBy;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
