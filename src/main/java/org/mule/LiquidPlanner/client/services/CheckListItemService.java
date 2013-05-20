package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.CheckListItem;

public interface CheckListItemService {

    public List<CheckListItem> getCheckListItems(String workSpaceId);

    public CheckListItem getCheckListItem(String workSpaceId, String checkListItemId);

}