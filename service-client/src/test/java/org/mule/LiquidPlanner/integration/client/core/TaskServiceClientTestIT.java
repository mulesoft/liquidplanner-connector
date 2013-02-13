package org.mule.LiquidPlanner.integration.client.core;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.IdFilter;
import org.mule.LiquidPlanner.client.model.IdFilter.IdFilterOperator;
import org.mule.LiquidPlanner.client.model.IdFilter.IdFilterType;
import org.mule.LiquidPlanner.client.services.TaskService;
import org.mule.LiquidPlanner.client.services.impl.TaskServiceClient;

public class TaskServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String TASK_ID = "7371128";
    private static final String PROJECT_ID = "7351876";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetTasks() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);
        String response = service.getTasks(WORKSPACE_ID, new ArrayList<Filter>());

        printOutResponse(response);
    }

    @Test
    public void testGetTasksForProject() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);

        List<Filter> filters = new ArrayList<Filter>();
        filters.add(new IdFilter(IdFilterType.project_id, IdFilterOperator.EQUALS, PROJECT_ID));
        String response = service.getTasks(WORKSPACE_ID, filters);

        printOutResponse(response);
    }

    @Test
    public void testGetTask() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);
        String response = service.getTask(WORKSPACE_ID, TASK_ID);

        printOutResponse(response);
    }

    @Test
    public void testGetTimeSheets() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);
        String response = service.getTimeSheets(WORKSPACE_ID, TASK_ID, new ArrayList<Filter>());

        printOutResponse(response);
    }

}
