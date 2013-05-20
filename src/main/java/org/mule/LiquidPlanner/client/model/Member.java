package org.mule.LiquidPlanner.client.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class Member extends TreeItem {

    @JsonProperty("access_level")
    private String access_level;

    @JsonProperty("avatar_url")
    private String avatar_url;

    @JsonProperty("company")
    private String company;

    @JsonProperty("email")
    private String email;

    @JsonProperty("first_available_date")
    private Object first_available_date;

    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("is_virtual")
    private Boolean is_virtual;

    @JsonProperty("last_available_date")
    private Object last_available_date;

    @JsonProperty("last_name")
    private String last_name;

    @JsonProperty("external_reference")
    private Object external_reference;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("user_name")
    private String user_name;

    @JsonProperty("team_name")
    private String team_name;

    @JsonProperty("id")
    private Integer id;

    public String getAccess_level() {
        return access_level;
    }

    public void setAccess_level(String access_level) {
        this.access_level = access_level;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getFirst_available_date() {
        return first_available_date;
    }

    public void setFirst_available_date(Object first_available_date) {
        this.first_available_date = first_available_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Boolean getIs_virtual() {
        return is_virtual;
    }

    public void setIs_virtual(Boolean is_virtual) {
        this.is_virtual = is_virtual;
    }

    public Object getLast_available_date() {
        return last_available_date;
    }

    public void setLast_available_date(Object last_available_date) {
        this.last_available_date = last_available_date;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Object getExternal_reference() {
        return external_reference;
    }

    public void setExternal_reference(Object external_reference) {
        this.external_reference = external_reference;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}