package org.mule.LiquidPlanner.client.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * POJO that represents the Error Message entity
 * 
 * @author damiansima
 * 
 */
public class ErrorMessage {

    @JsonProperty("type")
    private String type;

    @JsonProperty("message")
    private String message;

    @JsonProperty("error")
    private String error;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        String jsonRepresentation = "";

        try {
            jsonRepresentation = new ObjectMapper().writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("There was an error when serializing the field to JSON", e);
        }

        return jsonRepresentation;
    }

}