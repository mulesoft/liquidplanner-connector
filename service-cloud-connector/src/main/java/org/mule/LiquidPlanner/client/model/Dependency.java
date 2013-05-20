package org.mule.LiquidPlanner.client.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class Dependency extends TreeItem {

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("created_by")
    private Integer created_by;

    @JsonProperty("prerequisite_item")
    private Prerequisite_item prerequisite_item;

    @JsonProperty("prerequisite_item_id")
    private Integer prerequisite_item_id;

    @JsonProperty("satisfied")
    private Boolean satisfied;

    @JsonProperty("state")
    private String state;

    @JsonProperty("dependent_item_id")
    private Integer dependent_item_id;

    @JsonProperty("updated_at")
    private String updated_at;

    @JsonProperty("updated_by")
    private Integer updated_by;

    @JsonProperty("id")
    private Integer id;

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

    public Prerequisite_item getPrerequisite_item() {
        return prerequisite_item;
    }

    public void setPrerequisite_item(Prerequisite_item prerequisite_item) {
        this.prerequisite_item = prerequisite_item;
    }

    public Integer getPrerequisite_item_id() {
        return prerequisite_item_id;
    }

    public void setPrerequisite_item_id(Integer prerequisite_item_id) {
        this.prerequisite_item_id = prerequisite_item_id;
    }

    public Boolean getSatisfied() {
        return satisfied;
    }

    public void setSatisfied(Boolean satisfied) {
        this.satisfied = satisfied;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getDependent_item_id() {
        return dependent_item_id;
    }

    public void setDependent_item_id(Integer dependent_item_id) {
        this.dependent_item_id = dependent_item_id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
