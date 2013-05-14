package org.mule.LiquidPlanner.client.core;

public enum ServiceEntity {
    ACCOUNT("Account", "/account"),

    ACTIVITY("Activity", "/activities"),

    CHECKLIST_ITEM("checklistItem", "/checklist_items"),

    CLIENT("client", "/clients"),

    COMMENT("comment", "/comments"),

    CUSTOM_FIELD("CustomField", "/custom_fields"),

    DEPENDENCY("dependency", "/dependencies"),

    DOCUMENT("Document", "/documents"),

    ESTIMATE("estimate", "/estimates"),

    EVENT("event", "/events"),

    FOLDER("Folder", "/folders"),

    LINK("Link", "/links"),

    MEMEBER("member", "/members"),

    MILESTONE("Milestone", "/milestones"),

    NOTE("note", "/note"),

    PACKAGE("package", "/packages"),

    PROJECT("project", "/projects"),

    TASK("task", "/tasks"),

    TIMESHEET_ENTRIES("timesheetEntrie", "/timesheet_entries"),

    TREEITEM("treeitem", "/treeitems"),

    WORKSPACE("workspace", "/workspaces");

    private String name;
    private String path;

    private ServiceEntity(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String path() {
        return path;
    }
}
