package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Timesheet;
import org.mule.LiquidPlanner.client.model.TimesheetEntry;

/**
 * The interface describe operations to be performed over the TimeSheet
 * resources of the LiquidPlanner API.
 * 
 * @author damiansima
 * 
 */
public interface TimeSheetService {

    /**
     * Returns a list of all the time sheets related to given project.
     * 
     * @param user
     * 
     * @param workSpaceId
     * @param filters
     * @return
     */
    public List<Timesheet> getTimeSheets(String workSpaceId, List<Filter> filters);

    /**
     * Returns a particular time sheet for the provided workspace.
     * 
     * @param user
     * 
     * @param workSpaceId
     * @param timesheetId
     * @return
     */
    public Timesheet getTimeSheet(String workSpaceId, String timesheetId);

    /**
     * Returns all the time sheet entries related to a particular time sheet
     * 
     * @param user
     * 
     * @param workSpaceId
     * @param timesheetId
     * @param filters
     * @return
     */
    public List<TimesheetEntry> getTimeSheetEntries(String workSpaceId, String timesheetId, List<Filter> filters);

    /**
     * Returns a particular time sheet entry related to a given time sheet id
     * 
     * 
     * @param workSpaceId
     * @param timesheetId
     * @param timesheetEntryId
     * @return
     */
    public TimesheetEntry getTimeSheetEntry(String workSpaceId, String timesheetId, String timesheetEntryId);

}