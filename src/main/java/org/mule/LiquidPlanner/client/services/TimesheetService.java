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
import org.mule.LiquidPlanner.client.model.Timesheet;
import org.mule.LiquidPlanner.client.model.TimesheetEntry;

/**
 * The interface describe operations to be performed over the TimeSheet
 * resources of the LiquidPlanner API.
 * 
 * @author damiansima
 * 
 */
public interface TimesheetService {

    /**
     * Returns a list of all the time sheets related to given project.
     * 
     * @param user
     * 
     * @param workSpaceId
     * @param filters
     * @return
     */
    public List<Timesheet> getTimesheets(String workSpaceId, List<Filter> filters);

    /**
     * Returns a particular time sheet for the provided workspace.
     * 
     * @param user
     * 
     * @param workSpaceId
     * @param timesheetId
     * @return
     */
    public Timesheet getTimesheet(String workSpaceId, String timesheetId);

}