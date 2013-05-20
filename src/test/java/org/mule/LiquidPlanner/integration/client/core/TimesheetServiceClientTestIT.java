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
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Timesheet;
import org.mule.LiquidPlanner.client.model.TimesheetEntry;
import org.mule.LiquidPlanner.client.services.TimesheetService;
import org.mule.LiquidPlanner.client.services.impl.TimesheetServiceClient;

public class TimesheetServiceClientTestIT extends AbstractServiceClientTestIT {
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
        TimesheetService service = new TimesheetServiceClient(USER, PASSWORD);
        List<Timesheet> timesheets = service.getTimesheets(WORKSPACE_ID, new ArrayList<Filter>());

        printOutResponse(timesheets.toString());
    }

    @Test
    public void testGetTimesheet() {
        TimesheetService service = new TimesheetServiceClient(USER, PASSWORD);
        Timesheet timesheet = service.getTimesheet(WORKSPACE_ID, TIMESHEET_ID);

        printOutResponse(timesheet.toString());
    }

}
