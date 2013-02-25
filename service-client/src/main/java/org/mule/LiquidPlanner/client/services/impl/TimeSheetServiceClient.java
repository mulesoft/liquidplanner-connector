package org.mule.LiquidPlanner.client.services.impl;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.services.TimeSheetService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;

public class TimeSheetServiceClient extends AbstractServiceClient implements TimeSheetService {

    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_TIMESHEET_PATH = "/timesheets";
    private static final String API_TIMESHEET_ENTRIES_PATH = "/timesheet_entries";

    private static final String API_TIMESHEET_ENTRIES_ACCEPT = "/accept";
    private static final String API_TIMESHEET_ENTRIES_REJECT = "/reject";
    private static final String API_TIMESHEET_ENTRIES_SUMBIT = "/submit";
    private static final String API_TIMESHEET_ENTRIES_UNACCEPT = "/unaccept";
    private static final String API_TIMESHEET_ENTRIES_UNSUBMIT = "/unsubmit";

    public TimeSheetServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.TimeSheetService#getTimesheets
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String getTimeSheets(String workSpaceId, List<Filter> filters) {

        Validate.notEmpty(user, "The user can not be null nor empty.");
        Validate.notEmpty(password, "The password can not be null nor empty.");
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notNull(filters, "The filter list can not be null");

        String url = getTimesheetBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, filterListToMap(filters));

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = readResponseFromClientResponse(clientResponse);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }

        return response;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.TimeSheetService#getTimesheet
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String getTimeSheet(String workSpaceId, String timesheetId) {
        Validate.notEmpty(user, "The user can not be null nor empty.");
        Validate.notEmpty(password, "The password can not be null nor empty.");
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(timesheetId, "The timesheet id can not be null nor empty.");

        String url = getTimesheetBaseURL(workSpaceId) + "/" + timesheetId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = readResponseFromClientResponse(clientResponse);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }

        return response;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.TimeSheetService#
     * getTimesheetEntries(java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    @Override
    public String getTimeSheetEntries(String workSpaceId, String timesheetId, List<Filter> filters) {
        Validate.notEmpty(user, "The user can not be null nor empty.");
        Validate.notEmpty(password, "The password can not be null nor empty.");
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(timesheetId, "The timesheet id can not be null nor empty.");
        Validate.notNull(filters, "The filter list can not be null");

        String url = getTimesheetBaseURL(workSpaceId) + "/" + timesheetId + API_TIMESHEET_ENTRIES_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, filterListToMap(filters));

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = readResponseFromClientResponse(clientResponse);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }

        return response;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.TimeSheetService#
     * getTimesheetEntry(java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public String getTimeSheetEntry(String workSpaceId, String timesheetId, String timesheetEntryId) {
        Validate.notEmpty(user, "The user can not be null nor empty.");
        Validate.notEmpty(password, "The password can not be null nor empty.");
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(timesheetId, "The timesheet id can not be null nor empty.");
        Validate.notEmpty(timesheetEntryId, "The timesheet entry id can not be null nor empty.");

        String url = getTimesheetBaseURL(workSpaceId) + "/" + timesheetId + API_TIMESHEET_ENTRIES_PATH + "/"
                + timesheetEntryId;

        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = readResponseFromClientResponse(clientResponse);
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
        return getBaseURL() + "/" + workSpaceId + API_TIMESHEET_PATH;
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        // TODO Auto-generated method stub
        return null;
    }
}
