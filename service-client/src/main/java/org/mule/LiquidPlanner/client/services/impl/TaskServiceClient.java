package org.mule.LiquidPlanner.client.services.impl;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.services.TaskService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;

public class TaskServiceClient extends AbstractServiceClient implements TaskService {
    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_TASK_PATH = "/tasks";

    private static final String API_MOVE_AFTER_PATH = "/move_after";
    private static final String API_MOVE_BEFORE_PATH = "/move_before";
    private static final String API_TRACK_TIME_PATH = "/track_time";
    private static final String API_DEPENDENCY_PATH = "/dependencies";
    private static final String API_COMMENT_PATH = "/comments";
    private static final String API_DOCUMENT_PATH = "/documents";
    private static final String API_ESTIMATE_PATH = "/estimates";
    private static final String API_LINK_PATH = "/links";
    private static final String API_NOTE_PATH = "/note";
    private static final String API_SNAPSHOT_PATH = "/snapshots";

    private static final String API_ACTIVITY_PATH = "/activities";
    private static final String API_PACKAGE_AFTER_PATH = "/package_after";
    private static final String API_PACKAGE_BEFORE_PATH = "/package_before";
    private static final String API_TIMER_PATH = "/timer";
    private static final String API_TIMESEET_ENTRY_PATH = "/timesheet_entries";

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
    public String getTasks(String workSpaceId, List<Filter> filters) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notNull(filters, "The filters parameter can not be null");

        String url = getTimesheetBaseURL(workSpaceId);

        WebResource.Builder builder = getBuilder(user, password, url, filterListToMap(filters));
        ClientResponse clientResponse = builder.get(ClientResponse.class);

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
     * org.mule.LiquidPlanner.client.services.impl.TaskService#getTask(java.
     * lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String getTask(String workSpaceId, String taskId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(taskId, "The task id can not be null nor empty.");

        String url = getTimesheetBaseURL(workSpaceId) + "/" + taskId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

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
     * org.mule.LiquidPlanner.client.services.impl.TaskService#getTimeSheets
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String getTimeSheets(String workSpaceId, String taskId, List<Filter> filters) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(taskId, "The task id can not be null nor empty.");
        Validate.notNull(filters, "The filters parameter can not be null");

        String url = getTimesheetBaseURL(workSpaceId) + "/" + taskId + API_TIMESEET_ENTRY_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, filterListToMap(filters));

        ClientResponse clientResponse = builder.get(ClientResponse.class);

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

        String url = getTimesheetBaseURL(workSpaceId) + "/" + taskId + API_TIMESEET_ENTRY_PATH + "/" + timesheetId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = clientResponse.getEntity(String.class);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }

        return response;
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + API_WORKSPACE_PATH;
    }

    @Override
    protected ClientConfig getJerseyClientConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    private String getTimesheetBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + API_TASK_PATH;
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        // TODO Auto-generated method stub
        return null;
    }

}
