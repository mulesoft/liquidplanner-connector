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

public class Milestone extends TreeItem {

    @JsonProperty("activity_id")
    private Integer activityId;
    @JsonProperty("work")
    private Double work;
    @JsonProperty("alerts")
    private List<Alert> alerts = new ArrayList<Alert>();
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
    @JsonProperty("description")
    private String description;
    @JsonProperty("earliest_finish")
    private String earliestFinish;
    @JsonProperty("earliest_start")
    private String earliestStart;
    @JsonProperty("expected_finish")
    private String expectedFinish;
    @JsonProperty("expected_start")
    private String expectedStart;
    @JsonProperty("p98_finish")
    private String p98Finish;
    @JsonProperty("global_priority")
    private List<Integer> globalPriority = new ArrayList<Integer>();
    @JsonProperty("global_package_priority")
    private Object globalPackagePriority;
    @JsonProperty("has_note")
    private Boolean hasNote;
    @JsonProperty("high_effort_remaining")
    private Double highEffortRemaining;
    @JsonProperty("is_done")
    private Boolean isDone;
    @JsonProperty("is_on_hold")
    private Boolean isOnHold;
    @JsonProperty("is_packaged_version")
    private Boolean isPackagedVersion;
    @JsonProperty("is_shared")
    private Boolean isShared;
    @JsonProperty("latest_finish")
    private String latestFinish;
    @JsonProperty("low_effort_remaining")
    private Double lowEffortRemaining;
    @JsonProperty("manual_alert")
    private String manualAlert;
    @JsonProperty("max_effort")
    private Object maxEffort;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("parent_id")
    private Integer parentId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("external_reference")
    private String externalReference;
    @JsonProperty("package_id")
    private Object packageId;
    @JsonProperty("parent_ids")
    private List<Integer> parentIds = new ArrayList<Integer>();
    @JsonProperty("parent_crumbs")
    private List<String> parentCrumbs = new ArrayList<String>();
    @JsonProperty("package_ids")
    private List<Object> packageIds = new ArrayList<Object>();
    @JsonProperty("package_crumbs")
    private List<Object> packageCrumbs = new ArrayList<Object>();
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("updated_by")
    private Integer updatedBy;
    @JsonProperty("id")
    private Integer id;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Double getWork() {
        return work;
    }

    public void setWork(Double work) {
        this.work = work;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getP98Finish() {
        return p98Finish;
    }

    public void setP98Finish(String p98Finish) {
        this.p98Finish = p98Finish;
    }

    public List<Integer> getGlobalPriority() {
        return globalPriority;
    }

    public void setGlobalPriority(List<Integer> globalPriority) {
        this.globalPriority = globalPriority;
    }

    public Object getGlobalPackagePriority() {
        return globalPackagePriority;
    }

    public void setGlobalPackagePriority(Object globalPackagePriority) {
        this.globalPackagePriority = globalPackagePriority;
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

    public Boolean getIsPackagedVersion() {
        return isPackagedVersion;
    }

    public void setIsPackagedVersion(Boolean isPackagedVersion) {
        this.isPackagedVersion = isPackagedVersion;
    }

    public Boolean getIsShared() {
        return isShared;
    }

    public void setIsShared(Boolean isShared) {
        this.isShared = isShared;
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

    public Object getMaxEffort() {
        return maxEffort;
    }

    public void setMaxEffort(Object maxEffort) {
        this.maxEffort = maxEffort;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public Object getPackageId() {
        return packageId;
    }

    public void setPackageId(Object packageId) {
        this.packageId = packageId;
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

    public List<Object> getPackageIds() {
        return packageIds;
    }

    public void setPackageIds(List<Object> packageIds) {
        this.packageIds = packageIds;
    }

    public List<Object> getPackageCrumbs() {
        return packageCrumbs;
    }

    public void setPackageCrumbs(List<Object> packageCrumbs) {
        this.packageCrumbs = packageCrumbs;
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