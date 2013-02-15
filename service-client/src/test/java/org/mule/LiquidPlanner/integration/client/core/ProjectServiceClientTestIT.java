package org.mule.LiquidPlanner.integration.client.core;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.services.ProjectService;
import org.mule.LiquidPlanner.client.services.impl.ProjectServiceClient;

public class ProjectServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    // private static final String PROJECT_ID = "7351876";
    private static final String PROJECT_ID = "7497110";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetProjects() throws JSONException, JsonParseException, JsonMappingException, IOException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);
        List<Project> response = service.getProjects(WORKSPACE_ID);

        printOutResponse(response.toString());

    }

    @Test
    public void testGetProject() throws JSONException, JsonParseException, JsonMappingException, IOException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);
        Project response = service.getProject(WORKSPACE_ID, PROJECT_ID);

        printOutResponse(response.toString());

    }

}
