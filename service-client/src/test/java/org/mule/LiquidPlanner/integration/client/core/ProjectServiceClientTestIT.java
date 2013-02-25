package org.mule.LiquidPlanner.integration.client.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.services.ProjectService;
import org.mule.LiquidPlanner.client.services.impl.ProjectServiceClient;

public class ProjectServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    // private static final String PROJECT_ID = "7351876";

    // private static final String PROJECT_ID = "7497110";
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

    @Test
    public void testGetProjectComments() throws JSONException, JsonParseException, JsonMappingException, IOException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);
        List<Comment> response = service.getProjectComments(WORKSPACE_ID, PROJECT_ID);

        printOutResponse(response.toString());
    }

    @Test
    public void testCreateProject() throws JSONException, JsonParseException, JsonMappingException, IOException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);

        Project project = new Project();
        project.setDescription("some description");
        project.setName("Test_iapp_Name");
        project.setParentId("6875321");
        String response = service.createProject(WORKSPACE_ID, project);

        printOutResponse(response.toString());
    }

    @Test
    public void test() throws JsonGenerationException, JsonMappingException, IOException {
        Project project = new Project();
        project.setDescription("some description");
        project.setName("Test_iapp_Name");
        project.setParentId("6875321");
        project.setCustomFieldValues(new HashMap<String, String>());
        System.out.println(project.toString());

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("project", project.toString());

        System.out.println(new ObjectMapper().writeValueAsString(parameters));

        // {"alerts":null,"description":null,"id":null,"name":"Test_iapp_Name","type":"Project","work":null,"client_id":null,"created_at":null,"created_by":null,"custom_field_values":null,"delay_until":null,"done_on":null,"earliest_finish":null,"earliest_start":null,"expected_finish":null,"expected_start":null,"external_reference":null,"global_priority":null,"has_note":null,"high_effort_remaining":null,"is_done":null,"is_on_hold":null,"latest_finish":null,"low_effort_remaining":null,"manual_alert":null,"max_effort":null,"owner_id":"260403","p98_finish":null,"parent_crumbs":null,"parent_id":"6853445","parent_ids":null,"promise_by":null,"started_on":null,"updated_at":null,"updated_by":null}
        // {"alerts":[],"description":"","id":"7938082","name":"test_project","type":"Project","work":0.0,"client_id":null,"created_at":"2013-02-22T18:59:02+00:00","created_by":"260403","custom_field_values":{},"delay_until":null,"done_on":null,"earliest_finish":null,"earliest_start":null,"expected_finish":null,"expected_start":null,"external_reference":null,"global_priority":["1","606"],"has_note":false,"high_effort_remaining":0.0,"is_done":false,"is_on_hold":false,"latest_finish":null,"low_effort_remaining":0.0,"manual_alert":"","max_effort":null,"owner_id":"260403","p98_finish":null,"parent_crumbs":[],"parent_id":"6853445","parent_ids":["6853445"],"promise_by":null,"started_on":null,"updated_at":"2013-02-22T18:59:02+00:00","updated_by":"260403"}

    }
}
