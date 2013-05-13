package org.mule.LiquidPlanner.client.core;

public enum ServiceEntity {
    ACCOUNT("account"),

    ACTIVITY("Activity"),

    CHECKLIST_ITEM("checklistItem"),

    CLIENTE("client"),

    COMMENT("comment"),

    CUSTOM_FIELD("customField"),

    DEPENDENCY("dependency"),

    DOCUMENT("document"),

    ESTIMATE("estimate"),

    EVENT("event"),

    LINK("link"),

    MEMEBER("member"),

    MILESTONE("milestone"),

    NOTE("note"),

    PACKAGE("package"),

    PROJECT("project"),

    TASK("task"),

    TIMESHEET_ENTRIES("timesheetEntrie"),

    TREEITEM("treeitem"),

    WORKSPACE("workspace");

    private String name;

    private ServiceEntity(String path) {
        this.name = path;
    }

    public String getName() {
        return name;
    }
}
