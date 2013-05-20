/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class TimesheetEntry extends TreeItem {

    @JsonProperty("activity_id")
    private Integer activity_id;

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("created_by")
    private Integer created_by;

    @JsonProperty("note")
    private String note;

    @JsonProperty("member_id")
    private Integer member_id;

    @JsonProperty("item_id")
    private Integer item_id;

    @JsonProperty("updated_at")
    private String updated_at;

    @JsonProperty("updated_by")
    private Integer updated_by;

    @JsonProperty("work")
    private Double work;

    @JsonProperty("work_performed_on")
    private String work_performed_on;

    @JsonProperty("state")
    private String state;

    @JsonProperty("id")
    private Integer id;

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Integer getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Integer updated_by) {
        this.updated_by = updated_by;
    }

    public Double getWork() {
        return work;
    }

    public void setWork(Double work) {
        this.work = work;
    }

    public String getWork_performed_on() {
        return work_performed_on;
    }

    public void setWork_performed_on(String work_performed_on) {
        this.work_performed_on = work_performed_on;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}