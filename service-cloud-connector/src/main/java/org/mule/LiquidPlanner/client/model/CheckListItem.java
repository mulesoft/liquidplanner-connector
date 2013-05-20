package org.mule.LiquidPlanner.client.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class CheckListItem extends TreeItem {

    @JsonProperty("sort_order")
    private Integer sort_order;

    @JsonProperty("name")
    private String name;

    @JsonProperty("owner_id")
    private Integer owner_id;

    @JsonProperty("completed")
    private Boolean completed;

    @JsonProperty("completed_by")
    private Integer completed_by;

    @JsonProperty("completed_at")
    private String completed_at;

    @JsonProperty("item_id")
    private Integer item_id;

    @JsonProperty("space_id")
    private Integer space_id;

    @JsonProperty("created_by")
    private Integer created_by;

    @JsonProperty("updated_by")
    private Integer updated_by;

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("updated_at")
    private String updated_at;

    @JsonProperty("id")
    private Integer id;

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getCompleted_by() {
        return completed_by;
    }

    public void setCompleted_by(Integer completed_by) {
        this.completed_by = completed_by;
    }

    public String getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(String completed_at) {
        this.completed_at = completed_at;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getSpace_id() {
        return space_id;
    }

    public void setSpace_id(Integer space_id) {
        this.space_id = space_id;
    }

    public Integer getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    public Integer getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Integer updated_by) {
        this.updated_by = updated_by;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}