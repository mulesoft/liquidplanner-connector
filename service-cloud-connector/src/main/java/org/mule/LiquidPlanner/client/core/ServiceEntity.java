package org.mule.LiquidPlanner.client.core;

public enum ServiceEntity {
    ACCOUNT("Account", "/account"),

    ACTIVITY("Activity", "/activities"),

    CHECKLIST_ITEM("ChecklistItem", "/checklist_items"),

    CLIENT("Client", "/clients"),

    COMMENT("Comment", "/comments"),

    CUSTOM_FIELD("CustomField", "/custom_fields"),

    DEPENDENCY("Dependency", "/dependencies"),

    DOCUMENT("Document", "/documents"),

    ESTIMATE("estimate", "/estimates"),

    EVENT("Event", "/events"),

    FOLDER("Folder", "/folders"),

    LINK("Link", "/links"),

    MEMEBER("Member", "/members"),

    MILESTONE("Milestone", "/milestones"),

    NOTE("Note", "/note"),

    PACKAGE("Package", "/packages"),

    PROJECT("Project", "/projects"),

    TASK("Task", "/tasks"),

    TIMESHEET("Timesheets", "/timesheets"),
    
    TIMESHEET_ENTRIES("TimesheetEntry", "/timesheet_entries"),

    TREEITEM("Treeitem", "/treeitems"),

    WORKSPACE("Workspace", "/workspaces");

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
