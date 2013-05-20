/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.CheckListItem;
import org.mule.LiquidPlanner.client.services.CheckListItemService;
import org.mule.LiquidPlanner.client.services.impl.CheckListItemServiceClient;

public class CheckListItemServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String CHECKLIST_ITEM_ID = "90202";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testActivities() throws JSONException {
        CheckListItemService service = new CheckListItemServiceClient(USER, PASSWORD);
        List<CheckListItem> checklistItems = service.getCheckListItems(WORKSPACE_ID);

        printOutResponse(checklistItems.toString());
    }

    @Test
    public void testGetActivity() throws JSONException {
        CheckListItemService service = new CheckListItemServiceClient(USER, PASSWORD);
        CheckListItem checklistItem = service.getCheckListItem(WORKSPACE_ID, CHECKLIST_ITEM_ID);

        printOutResponse(checklistItem.toString());
    }

}
