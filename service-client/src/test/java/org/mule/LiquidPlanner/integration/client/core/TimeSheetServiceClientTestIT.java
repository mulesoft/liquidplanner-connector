package org.mule.LiquidPlanner.integration.client.core;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.services.TimeSheetService;
import org.mule.LiquidPlanner.client.services.impl.TimeSheetServiceClient;

public class TimeSheetServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String TIMESHEET_ID = "436154";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetTimesheets() throws JSONException {
        TimeSheetService service = new TimeSheetServiceClient(USER, PASSWORD);
        String response = service.getTimeSheets(WORKSPACE_ID, new ArrayList<Filter>());

        printOutResponse(response);
    }

    @Test
    public void testGetTimesheet() {
        TimeSheetService service = new TimeSheetServiceClient(USER, PASSWORD);
        String response = service.getTimeSheet(WORKSPACE_ID, TIMESHEET_ID);

        printOutResponse(response);
    }

    @Test
    public void testGetTimesheetEntries() {
        TimeSheetService service = new TimeSheetServiceClient(USER, PASSWORD);
        String response = service.getTimeSheetEntries(WORKSPACE_ID, TIMESHEET_ID, new ArrayList<Filter>());

        printOutResponse(response);
    }

    @Test
    public void testGetTimesheetEntry() {
        TimeSheetService service = new TimeSheetServiceClient(USER, PASSWORD);
        String response = service.getTimeSheetEntry(WORKSPACE_ID, TIMESHEET_ID, "9323623");

        printOutResponse(response);
    }

}
