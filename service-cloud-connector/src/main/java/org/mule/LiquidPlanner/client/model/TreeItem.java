package org.mule.LiquidPlanner.client.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TreeItem {
    @JsonProperty("children")
    protected List<TreeItem> children = new ArrayList<TreeItem>();

    @JsonProperty("type")
    protected String type;

    public List<TreeItem> getChildren() {
        return children;
    }

    public void setChildren(List<TreeItem> children) {
        this.children = children;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String jsonRepresentation = "";

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .serializeNulls().create();
        try {
            jsonRepresentation = gson.toJson(this);
        } catch (Exception e) {
            throw new RuntimeException("There was an error when serializing the field to JSON", e);
        }

        return jsonRepresentation;
    }
}
