/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

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
