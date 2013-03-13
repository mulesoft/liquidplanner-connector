package org.mule.LiquidPlanner.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonAnySetter;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * POJO that represents the Comment entity
 * 
 * @author damiansima
 * 
 */
public class Comment extends TreeItem {

    @JsonProperty("at_person_ids")
    private List<String> atPersonIds = new ArrayList<String>();

    @JsonProperty("at_member_ids")
    private List<String> atMemberIds = new ArrayList<String>();

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("created_by")
    private int createdBy;

    @JsonProperty("person_id")
    private int personId;

    @JsonProperty("member_id")
    private int memberId;

    @JsonProperty("plain_text")
    private String plainText;

    @JsonProperty("item_id")
    private int itemId;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("updated_by")
    private int updatedBy;

    @JsonProperty("id")
    private int id;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<String> getAtPersonIds() {
        return atPersonIds;
    }

    public void setAtPersonIds(List<String> atPersonIds) {
        this.atPersonIds = atPersonIds;
    }

    public List<String> getAtMemberIds() {
        return atMemberIds;
    }

    public void setAtMemberIds(List<String> atMemberIds) {
        this.atMemberIds = atMemberIds;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getPersonId() {
        return personId;
    }

    // @JsonProperty("person_id")
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public int getItemId() {
        return itemId;
    }

    // @JsonProperty("item_id")
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}