package org.mule.LiquidPlanner.client.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Note extends TreeItem {

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("created_by")
    private Integer created_by;

    @JsonProperty("note")
    private String note;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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