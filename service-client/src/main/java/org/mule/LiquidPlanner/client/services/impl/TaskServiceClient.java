package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Milestone;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.model.Task;
import org.mule.LiquidPlanner.client.services.TaskService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

public class TaskServiceClient extends AbstractServiceClient implements TaskService {

    private static final String API_MOVE_AFTER_PATH = "/move_after";
    private static final String API_MOVE_BEFORE_PATH = "/move_before";
    private static final String API_TRACK_TIME_PATH = "/track_time";
    private static final String API_SNAPSHOT_PATH = "/snapshots";

    private static final String API_PACKAGE_AFTER_PATH = "/package_after";
    private static final String API_PACKAGE_BEFORE_PATH = "/package_before";
    private static final String API_TIMER_PATH = "/timer";

    public TaskServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.TaskService#getTasks(java
     * .lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<Task> getTasks(String workSpaceId, List<Filter> filters) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notNull(filters, "The filters parameter can not be null");

        String url = getURL(workSpaceId);

        WebResource.Builder builder = getBuilder(user, password, url, filterListToMap(filters));
        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Task>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.TaskService#getTask(java.
     * lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Task getTask(String workSpaceId, String taskId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(taskId, "The task id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + taskId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Task.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.TaskService#getTimeSheets
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String getTimeSheets(String workSpaceId, String taskId, List<Filter> filters) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(taskId, "The task id can not be null nor empty.");
        Validate.notNull(filters, "The filters parameter can not be null");

        String url = getURL(workSpaceId) + "/" + taskId + ServiceEntity.TIMESHEET_ENTRIES.path();
        WebResource.Builder builder = getBuilder(user, password, url, filterListToMap(filters));

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        String response = clientResponse.getEntity(String.class);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }

        return response;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.TaskService#getTimeSheet(
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    @Override
    public String getTimeSheet(String workSpaceId, String taskId, String timesheetId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(taskId, "The task id can not be null nor empty.");
        Validate.notEmpty(timesheetId, "The timesheet id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + taskId + ServiceEntity.TIMESHEET_ENTRIES.path() + "/"
                + timesheetId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        String response = clientResponse.getEntity(String.class);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }

        return response;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.TaskService#createTask(
     * java.lang.String, org.mule.LiquidPlaner.client.Model.Task)
     */
    @Override
    public Task createTask(String workSpaceId, Task task) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId);
        return this.createEntity(ServiceEntity.TASK.getName(), task, url);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.TaskService#createTask(
     * java.lang.String, org.mule.LiquidPlaner.client.Model.Task)
     */
    @Override
    public Task updateTask(String workSpaceId, Task task) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + task.getId();
        return this.updateEntity(ServiceEntity.TASK.getName(), task, url);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.TaskService#deleteTask(
     * java.lang.String, java.lang.String)
     */
    @Override
    public Task deleteTask(String workSpaceId, String taskId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(taskId, "The id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + taskId;
        return (Task) this.deleteEntity(url, Task.class);
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + ServiceEntity.WORKSPACE.path();
    }

    @Override
    protected ClientConfig getJerseyClientConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    private String getURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.TASK.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }

}
