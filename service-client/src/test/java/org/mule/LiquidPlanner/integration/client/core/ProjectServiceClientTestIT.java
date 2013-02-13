package org.mule.LiquidPlanner.integration.client.core;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.services.ProjectService;
import org.mule.LiquidPlanner.client.services.TimeSheetService;
import org.mule.LiquidPlanner.client.services.impl.ProjectServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TimeSheetServiceClient;

public class ProjectServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String PROJECT_ID = "7351876";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetProjects() throws JSONException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);
        String response = service.getProjects(WORKSPACE_ID);

        printOutResponse(response);
    }

    @Test
    public void testGetProject() throws JSONException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);
        String response = service.getProject(WORKSPACE_ID, PROJECT_ID);

        printOutResponse(response);
    }

}
