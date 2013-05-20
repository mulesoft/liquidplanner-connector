/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.integration.client.core;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.IdFilter;
import org.mule.LiquidPlanner.client.model.Timesheet;
import org.mule.LiquidPlanner.client.model.IdFilter.IdFilterOperator;
import org.mule.LiquidPlanner.client.model.IdFilter.IdFilterType;
import org.mule.LiquidPlanner.client.model.Task;
import org.mule.LiquidPlanner.client.services.TaskService;
import org.mule.LiquidPlanner.client.services.impl.TaskServiceClient;

public class TaskServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    // private static final String TASK_ID = "7371128";
    private static final String TASK_ID = "7371543";
    // private static final String PROJECT_ID = "7351876";
    private static final String PROJECT_ID = "6883656";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetTasks() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);
        List<Task> response = service.getTasks(WORKSPACE_ID, new ArrayList<Filter>());

        printOutResponse(response.toString());
    }

    @Test
    public void testGetTasksForProject() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);

        List<Filter> filters = new ArrayList<Filter>();
        filters.add(new IdFilter(IdFilterType.project_id, IdFilterOperator.EQUALS, PROJECT_ID));
        List<Task> response = service.getTasks(WORKSPACE_ID, filters);

        printOutResponse(response.toString());
    }

    @Test
    public void testGetTask() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);
        Task response = service.getTask(WORKSPACE_ID, TASK_ID);

        printOutResponse(response.toString());
    }

    @Test
    public void testGetTimeSheets() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);
        List<Timesheet> response = service.getTaskTimesheets(WORKSPACE_ID, TASK_ID, new ArrayList<Filter>());

        printOutResponse(response.toString());
    }

    @Ignore
    @Test
    public void testCreateTask() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);
        Task response = service.getTask(WORKSPACE_ID, "7371543");

        response.setId(new Integer(0));
        response.setParentId(new Integer("8152840"));

        response.setParentCrumbs(new ArrayList<String>());

        List<Integer> parentIds = new ArrayList<Integer>();
        parentIds.add(new Integer("8152840"));
        response.setParentIds(parentIds);
        response.setWork(new Double(0));

        Task newTask = service.createTask(WORKSPACE_ID, response);

        printOutResponse(newTask.toString());
    }

    @Ignore
    @Test
    public void testDeleteTask() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);

        String taskId = "9069260";
        Task newTask = service.deleteTask(WORKSPACE_ID, taskId);

        printOutResponse(newTask.toString());
    }

    @Ignore
    @Test
    public void testUpdateTask() throws JSONException {
        TaskService service = new TaskServiceClient(USER, PASSWORD);
        Task task = service.getTask(WORKSPACE_ID, "9069525");

        task.setName(task.getName() + " - [UPDATED-1]");
        task.setParentId(9034648);

        Task newTask = service.updateTask(WORKSPACE_ID, task);

        printOutResponse(newTask.toString());
    }
}
