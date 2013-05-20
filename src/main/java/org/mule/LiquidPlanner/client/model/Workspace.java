/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Workspace extends TreeItem {

    @JsonProperty("company_name")
    private String company_name;

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("created_by")
    private Integer created_by;

    @JsonProperty("default_units")
    private Integer default_units;

    @JsonProperty("description")
    private String description;

    @JsonProperty("week_start")
    private Integer week_start;

    @JsonProperty("hours_per_day")
    private Double hours_per_day;

    @JsonProperty("name")
    private String name;

    @JsonProperty("owner_id")
    private Integer owner_id;

    @JsonProperty("root_id")
    private Integer root_id;

    @JsonProperty("inbox_id")
    private Integer inbox_id;

    @JsonProperty("updated_at")
    private String updated_at;

    @JsonProperty("updated_by")
    private Integer updated_by;

    @JsonProperty("id")
    private Integer id;

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
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

    public Integer getDefault_units() {
        return default_units;
    }

    public void setDefault_units(Integer default_units) {
        this.default_units = default_units;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeek_start() {
        return week_start;
    }

    public void setWeek_start(Integer week_start) {
        this.week_start = week_start;
    }

    public Double getHours_per_day() {
        return hours_per_day;
    }

    public void setHours_per_day(Double hours_per_day) {
        this.hours_per_day = hours_per_day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Integer getRoot_id() {
        return root_id;
    }

    public void setRoot_id(Integer root_id) {
        this.root_id = root_id;
    }

    public Integer getInbox_id() {
        return inbox_id;
    }

    public void setInbox_id(Integer inbox_id) {
        this.inbox_id = inbox_id;
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

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

}