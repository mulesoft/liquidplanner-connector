package org.mule.LiquidPlanner.client.services;

import org.mule.LiquidPlanner.client.model.TreeItem;

public interface TreeItemService {

    public String getTreeItems(String workSpaceId);

    public <T extends TreeItem> T getTreeItem(String workSpaceId, String treeItemId, Class<T> clazz) ;

}