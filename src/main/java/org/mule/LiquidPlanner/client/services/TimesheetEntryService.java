package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.TimesheetEntry;

public interface TimesheetEntryService {

    public List<TimesheetEntry> getTimesheetEntries(String workSpaceId, List<Filter> filters);

    public TimesheetEntry getTimesheetEntry(String workSpaceId, String timesheetEntryId);

}