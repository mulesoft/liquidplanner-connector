package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Task;

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
    public String getTimeSheets(String workSpaceId, String taskId, List<Filter> filters);

    /**
     * Retrieves a particular time sheets
     * 
     * @param workSpaceId
     * @return
     */
    public String getTimeSheet(String workSpaceId, String taskId, String timesheetId);

    /**
     * Create a Task
     * 
     * @param workSpaceId
     * @param task
     * @return
     */
    public Task createTask(String workSpaceId, Task task);

}