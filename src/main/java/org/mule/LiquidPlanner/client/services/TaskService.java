/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Task;
import org.mule.LiquidPlanner.client.model.Timesheet;

/**
 * The interface describe operations to be performed over the Task resources of
 * the LiquidPlanner API.
 * 
 * @author damiansima
 * 
 */
public interface TaskService {

    /**
     * Retrieves tasks related to a workspace
     * 
     * @param workSpaceId
     * @param filter
     * @return
     */
    public List<Task> getTasks(String workSpaceId, List<Filter> filters);

    /**
     * Retrieves a particular task related to a workspace
     * 
     * @param workSpaceId
     * @return
     */
    public Task getTask(String workSpaceId, String taskId);

    /**
     * Retrieves time sheets related to a particular task
     * 
     * @param workSpaceId
     * @param filter
     * @return
     */
    public List<Timesheet> getTaskTimesheets(String workSpaceId, String taskId, List<Filter> filters);

    /**
     * Retrieves a particular time sheets
     * 
     * @param workSpaceId
     * @return
     */
    public Timesheet getTaskTimesheet(String workSpaceId, String taskId, String timesheetId);

    /**
     * Create a Task
     * 
     * @param workSpaceId
     * @param task
     * @return
     */
    public Task createTask(String workSpaceId, Task task);

    /**
     * 
     * @param workSpaceId
     * @param task
     * @return
     */
    public Task updateTask(String workSpaceId, Task task);

    /**
     * 
     * @param workSpaceId
     * @param taskId
     * @return
     */
    public Task deleteTask(String workSpaceId, String taskId);

}