package org.mule.LiquidPlanner.client.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Timesheet extends TreeItem {

    @JsonProperty("daily_totals")
    private List<Float> daily_totals = new ArrayList<Float>();

    @JsonProperty("ends")
    private String ends;

    @JsonProperty("member_id")
    private Integer member_id;

    @JsonProperty("starts")
    private String starts;

    @JsonProperty("state")
    private String state;

    @JsonProperty("id")
    private Integer id;

    public List<Float> getDaily_totals() {
        return daily_totals;
    }

    public void setDaily_totals(List<Float> daily_totals) {
        this.daily_totals = daily_totals;
    }

    public String getEnds() {
        return ends;
    }

    public void setEnds(String ends) {
        this.ends = ends;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public String getStarts() {
        return starts;
    }

    public void setStarts(String starts) {
        this.starts = starts;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}