package org.mule.LiquidPlanner.client.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Alert extends TreeItem {

    @JsonProperty("description")
    private String description;
    @JsonProperty("flag")
    private String flag;
    @JsonProperty("key")
    private String key;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Double id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

}