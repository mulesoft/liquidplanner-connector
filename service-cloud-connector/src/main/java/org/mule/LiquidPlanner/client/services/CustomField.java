package org.mule.LiquidPlanner.client.services;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.mule.LiquidPlanner.client.model.TreeItem;

public class CustomField extends TreeItem {

    @JsonProperty("category")
    private String category;

    @JsonProperty("name")
    private String name;

    @JsonProperty("values")
    private List<Object> values = new ArrayList<Object>();

    @JsonProperty("id")
    private Integer id;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}