package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Timesheet;
import org.mule.LiquidPlanner.client.model.TimesheetEntry;
import org.mule.LiquidPlanner.client.services.TimesheetService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;

public class TimesheetServiceClient extends AbstractServiceClient implements TimesheetService {

    private static final String API_TIMESHEET_ENTRIES_ACCEPT = "/accept";
    private static final String API_TIMESHEET_ENTRIES_REJECT = "/reject";
    private static final String API_TIMESHEET_ENTRIES_SUMBIT = "/submit";
    private static final String API_TIMESHEET_ENTRIES_UNACCEPT = "/unaccept";
    private static final String API_TIMESHEET_ENTRIES_UNSUBMIT = "/unsubmit";

    public TimesheetServiceClient(String user, String password) {
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
    public List<Timesheet> getTimesheets(String workSpaceId, List<Filter> filters) {

        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notNull(filters, "The filter list can not be null");

        String url = getTimesheetBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, filterListToMap(filters));

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Timesheet>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.TimeSheetService#getTimesheet
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Timesheet getTimesheet(String workSpaceId, String timesheetId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(timesheetId, "The timesheet id can not be null nor empty.");

        String url = getTimesheetBaseURL(workSpaceId) + "/" + timesheetId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        return deserializeResponse(clientResponse, Timesheet.class);
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

    private String getTimesheetBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.TIMESHEET.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        // TODO Auto-generated method stub
        return null;
    }
}
