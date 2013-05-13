package org.mule.LiquidPlanner.client.core;

public enum ServicePath {
    ACCOUNT("/account"),

    ACTIVITY("/activities"),

    CHECKLIST_ITEM("/checklist_items"),

    CLIENTE("/clients"),

    COMMENT("/comments"),

    CUSTOM_FIELD("/custom_fields"),

    DEPENDENCY("/dependencies"),

    DOCUMENT("/documents"),

    ESTIMATE("/estimates"),

    EVENT("/events"),

    LINK("/links"),

    MEMEBER("/members"),

    MILESTONE("/milestones"),

    NOTE("/note"),

    PACKAGE("/packages"),

    PROJECT("/projects"),

    TASK("/tasks"),

    TIMESHEET_ENTRIES("/timesheet_entries"),

    TREEITEM("/treeitems"),

    WORKSPACE("/workspaces");

    private String path;

    private ServicePath(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }
}
