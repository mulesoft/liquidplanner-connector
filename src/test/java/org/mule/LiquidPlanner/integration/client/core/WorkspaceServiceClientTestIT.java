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
import org.mule.LiquidPlanner.client.model.Workspace;
import org.mule.LiquidPlanner.client.services.WorkspaceService;
import org.mule.LiquidPlanner.client.services.impl.WorkspaceServiceClient;

public class WorkspaceServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetWorkSpaces() throws JSONException {
        WorkspaceService service = new WorkspaceServiceClient(USER, PASSWORD);
        List<Workspace> workspaces = service.getWorkSpaces();

        printOutResponse(workspaces.toString());
    }

    @Test
    public void testGetClient() throws JSONException {
        WorkspaceService service = new WorkspaceServiceClient(USER, PASSWORD);
        Workspace workspace = service.getWorkspace(WORKSPACE_ID);

        System.out.println(workspace.getInbox_id());
        printOutResponse(workspace.toString());
    }

}
