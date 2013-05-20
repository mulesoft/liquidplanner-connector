package org.mule.LiquidPlanner.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;

public class Prerequisite_item extends TreeItem {

    @JsonProperty("activity_id")
    private Object activity_id;

    @JsonProperty("work")
    private Double work;

    @JsonProperty("alerts")
    private List<Object> alerts = new ArrayList<Object>();

    @JsonProperty("project_id")
    private Object project_id;

    @JsonProperty("client_id")
    private Object client_id;

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("created_by")
    private Integer created_by;

    @JsonProperty("custom_field_values")
    private Map<String, Object> custom_field_values;

    @JsonProperty("done_on")
    private Object done_on;

    @JsonProperty("started_on")
    private Object started_on;

    @JsonProperty("delay_until")
    private Object delay_until;

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

    @JsonProperty("global_priority")
    private List<Integer> global_priority = new ArrayList<Integer>();

    @JsonProperty("global_package_priority")
    private Object global_package_priority;

    @JsonProperty("has_note")
    private Boolean has_note;

    @JsonProperty("high_effort_remaining")
    private Double high_effort_remaining;

    @JsonProperty("is_done")
    private Boolean is_done;

    @JsonProperty("is_on_hold")
    private Boolean is_on_hold;

    @JsonProperty("is_packaged_version")
    private Boolean is_packaged_version;

    @JsonProperty("is_shared")
    private Boolean is_shared;

    @JsonProperty("latest_finish")
    private String latest_finish;

    @JsonProperty("low_effort_remaining")
    private Double low_effort_remaining;

    @JsonProperty("manual_alert")
    private String manual_alert;

    @JsonProperty("max_effort")
    private Object max_effort;

    @JsonProperty("name")
    private String name;

    @JsonProperty("owner_id")
    private Integer owner_id;

    @JsonProperty("parent_id")
    private Integer parent_id;

    @JsonProperty("promise_by")
    private Object promise_by;

    @JsonProperty("external_reference")
    private Object external_reference;

    @JsonProperty("package_id")
    private Object package_id;

    @JsonProperty("parent_ids")
    private List<Integer> parent_ids = new ArrayList<Integer>();

    @JsonProperty("parent_crumbs")
    private List<String> parent_crumbs = new ArrayList<String>();

    @JsonProperty("package_ids")
    private List<Object> package_ids = new ArrayList<Object>();

    @JsonProperty("package_crumbs")
    private List<Object> package_crumbs = new ArrayList<Object>();

    @JsonProperty("updated_at")
    private String updated_at;

    @JsonProperty("updated_by")
    private Integer updated_by;

    @JsonProperty("id")
    private Integer id;

    public Object getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Object activity_id) {
        this.activity_id = activity_id;
    }

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

    public Object getProject_id() {
        return project_id;
    }

    public void setProject_id(Object project_id) {
        this.project_id = project_id;
    }

    public Object getClient_id() {
        return client_id;
    }

    public void setClient_id(Object client_id) {
        this.client_id = client_id;
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

    public Map<String, Object> getCustom_field_values() {
        return custom_field_values;
    }

    public void setCustom_field_values(Map<String, Object> custom_field_values) {
        this.custom_field_values = custom_field_values;
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

    public Object getDelay_until() {
        return delay_until;
    }

    public void setDelay_until(Object delay_until) {
        this.delay_until = delay_until;
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

    public List<Integer> getGlobal_priority() {
        return global_priority;
    }

    public void setGlobal_priority(List<Integer> global_priority) {
        this.global_priority = global_priority;
    }

    public Object getGlobal_package_priority() {
        return global_package_priority;
    }

    public void setGlobal_package_priority(Object global_package_priority) {
        this.global_package_priority = global_package_priority;
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

    public Boolean getIs_packaged_version() {
        return is_packaged_version;
    }

    public void setIs_packaged_version(Boolean is_packaged_version) {
        this.is_packaged_version = is_packaged_version;
    }

    public Boolean getIs_shared() {
        return is_shared;
    }

    public void setIs_shared(Boolean is_shared) {
        this.is_shared = is_shared;
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

    public Object getMax_effort() {
        return max_effort;
    }

    public void setMax_effort(Object max_effort) {
        this.max_effort = max_effort;
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

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Object getPromise_by() {
        return promise_by;
    }

    public void setPromise_by(Object promise_by) {
        this.promise_by = promise_by;
    }

    public Object getExternal_reference() {
        return external_reference;
    }

    public void setExternal_reference(Object external_reference) {
        this.external_reference = external_reference;
    }

    public Object getPackage_id() {
        return package_id;
    }

    public void setPackage_id(Object package_id) {
        this.package_id = package_id;
    }

    public List<Integer> getParent_ids() {
        return parent_ids;
    }

    public void setParent_ids(List<Integer> parent_ids) {
        this.parent_ids = parent_ids;
    }

    public List<String> getParent_crumbs() {
        return parent_crumbs;
    }

    public void setParent_crumbs(List<String> parent_crumbs) {
        this.parent_crumbs = parent_crumbs;
    }

    public List<Object> getPackage_ids() {
        return package_ids;
    }

    public void setPackage_ids(List<Object> package_ids) {
        this.package_ids = package_ids;
    }

    public List<Object> getPackage_crumbs() {
        return package_crumbs;
    }

    public void setPackage_crumbs(List<Object> package_crumbs) {
        this.package_crumbs = package_crumbs;
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