package org.mule.LiquidPlanner.integration.client.core;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Timesheet;
import org.mule.LiquidPlanner.client.model.TimesheetEntry;
import org.mule.LiquidPlanner.client.services.TimesheetEntryService;
import org.mule.LiquidPlanner.client.services.TimesheetService;
import org.mule.LiquidPlanner.client.services.impl.TimesheetEntryServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TimesheetServiceClient;

public class TimesheetEntryServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String TIMESHEET_ENTRY_ID = "9323623";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetTimesheetEntries() {
        TimesheetEntryService service = new TimesheetEntryServiceClient(USER, PASSWORD);
        List<TimesheetEntry> timesheetEntries = service.getTimesheetEntries(WORKSPACE_ID, new ArrayList<Filter>());

        printOutResponse(timesheetEntries.toString());
    }

    @Test
    public void testGetTimesheetEntry() {
        TimesheetEntryService service = new TimesheetEntryServiceClient(USER, PASSWORD);
        TimesheetEntry timesheetEntry = service.getTimesheetEntry(WORKSPACE_ID, TIMESHEET_ENTRY_ID);

        printOutResponse(timesheetEntry.toString());
    }

}
