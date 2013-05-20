package org.mule.LiquidPlanner.client.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Client extends TreeItem {

    @JsonProperty("work")
    private Double work;

    @JsonProperty("alerts")
    private List<Object> alerts = new ArrayList<Object>();

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("created_by")
    private Integer created_by;

    @JsonProperty("done_on")
    private Object done_on;

    @JsonProperty("started_on")
    private Object started_on;

    @JsonProperty("description")
    private String description;

    @JsonProperty("earliest_finish")
    private String earliest_finish;

    @JsonProperty("earliest_start")
    private String earliest_start;

    @JsonProperty("expected_finish")
    private String expected_finish;

    @JsonProperty("expected_start")
    private String expected_start;

    @JsonProperty("p98_finish")
    private String p98_finish;

    @JsonProperty("has_note")
    private Boolean has_note;

    @JsonProperty("high_effort_remaining")
    private Double high_effort_remaining;

    @JsonProperty("is_done")
    private Boolean is_done;

    @JsonProperty("is_on_hold")
    private Boolean is_on_hold;

    @JsonProperty("latest_finish")
    private String latest_finish;

    @JsonProperty("low_effort_remaining")
    private Double low_effort_remaining;

    @JsonProperty("manual_alert")
    private String manual_alert;

    @JsonProperty("name")
    private String name;

    @JsonProperty("owner_id")
    private Integer owner_id;

    @JsonProperty("external_reference")
    private Object external_reference;

    @JsonProperty("updated_at")
    private String updated_at;

    @JsonProperty("updated_by")
    private Integer updated_by;

    @JsonProperty("id")
    private Integer id;

    public Double getWork() {
        return work;
    }

    public void setWork(Double work) {
        this.work = work;
    }

    public List<Object> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
    }

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

    public Object getDone_on() {
        return done_on;
    }

    public void setDone_on(Object done_on) {
        this.done_on = done_on;
    }

    public Object getStarted_on() {
        return started_on;
    }

    public void setStarted_on(Object started_on) {
        this.started_on = started_on;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEarliest_finish() {
        return earliest_finish;
    }

    public void setEarliest_finish(String earliest_finish) {
        this.earliest_finish = earliest_finish;
    }

    public String getEarliest_start() {
        return earliest_start;
    }

    public void setEarliest_start(String earliest_start) {
        this.earliest_start = earliest_start;
    }

    public String getExpected_finish() {
        return expected_finish;
    }

    public void setExpected_finish(String expected_finish) {
        this.expected_finish = expected_finish;
    }

    public String getExpected_start() {
        return expected_start;
    }

    public void setExpected_start(String expected_start) {
        this.expected_start = expected_start;
    }

    public String getP98_finish() {
        return p98_finish;
    }

    public void setP98_finish(String p98_finish) {
        this.p98_finish = p98_finish;
    }

    public Boolean getHas_note() {
        return has_note;
    }

    public void setHas_note(Boolean has_note) {
        this.has_note = has_note;
    }

    public Double getHigh_effort_remaining() {
        return high_effort_remaining;
    }

    public void setHigh_effort_remaining(Double high_effort_remaining) {
        this.high_effort_remaining = high_effort_remaining;
    }

    public Boolean getIs_done() {
        return is_done;
    }

    public void setIs_done(Boolean is_done) {
        this.is_done = is_done;
    }

    public Boolean getIs_on_hold() {
        return is_on_hold;
    }

    public void setIs_on_hold(Boolean is_on_hold) {
        this.is_on_hold = is_on_hold;
    }

    public String getLatest_finish() {
        return latest_finish;
    }

    public void setLatest_finish(String latest_finish) {
        this.latest_finish = latest_finish;
    }

    public Double getLow_effort_remaining() {
        return low_effort_remaining;
    }

    public void setLow_effort_remaining(Double low_effort_remaining) {
        this.low_effort_remaining = low_effort_remaining;
    }

    public String getManual_alert() {
        return manual_alert;
    }

    public void setManual_alert(String manual_alert) {
        this.manual_alert = manual_alert;
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

    public Object getExternal_reference() {
        return external_reference;
    }

    public void setExternal_reference(Object external_reference) {
        this.external_reference = external_reference;
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