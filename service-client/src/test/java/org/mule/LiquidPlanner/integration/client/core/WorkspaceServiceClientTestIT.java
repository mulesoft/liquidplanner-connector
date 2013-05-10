package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Workspace;
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
        WorkspaceServiceClient service = new WorkspaceServiceClient(USER, PASSWORD);
        List<Workspace> workspaces = service.getWorkSpaces();

        printOutResponse(workspaces.toString());
    }

    @Test
    public void testGetClient() throws JSONException {
        WorkspaceServiceClient service = new WorkspaceServiceClient(USER, PASSWORD);
        Workspace workspace = service.getComment(WORKSPACE_ID);

        System.out.println(workspace.getInbox_id());
        printOutResponse(workspace.toString());
    }

}
