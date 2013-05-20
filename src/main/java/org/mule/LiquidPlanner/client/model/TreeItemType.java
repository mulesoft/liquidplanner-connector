package org.mule.LiquidPlanner.client.model;

public enum TreeItemType {
    ALERT_TYPE("Alert"), COMMENT_TYPE("Comment"), FOLDER_TYPE("Folder"), MILESTONE_TYPE("Milestone"), PROJECT_TYPE(
            "Project"), TASK_TYPE("Task"), TREE_ITEM("TreeItem");

    private final String type;

    TreeItemType(String type) {
        this.type = type;
    }

    public String type() {
        return this.type;
    }
}
