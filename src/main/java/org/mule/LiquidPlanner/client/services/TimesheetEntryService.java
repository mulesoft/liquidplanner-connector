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
import org.mule.LiquidPlanner.client.model.TimesheetEntry;

public interface TimesheetEntryService {

    public List<TimesheetEntry> getTimesheetEntries(String workSpaceId, List<Filter> filters);

    public TimesheetEntry getTimesheetEntry(String workSpaceId, String timesheetEntryId);

}