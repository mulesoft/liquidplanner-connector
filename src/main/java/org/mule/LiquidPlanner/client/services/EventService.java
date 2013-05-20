/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.CheckListItem;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Event;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.model.TimesheetEntry;

public interface EventService {

    public List<Event> getEvents(String workSpaceId);

    public Event getEvent(String workSpaceId, String eventId);

    public List<CheckListItem> getEventCheckListItems(String workSpaceId, String eventId);

    public List<Comment> getEventComments(String workSpaceId, String eventId);

    public List<Document> getEventDocuments(String workSpaceId, String eventId);

    public List<Link> getEventLinks(String workSpaceId, String eventId);

    public List<TimesheetEntry> getEventTimesheetEntries(String workSpaceId, String eventId);

    public Event createEvent(String workSpaceId, Event event);

    public Event updateEvent(String workSpaceId, Event event);

    public Event deleteEvent(String workSpaceId, String commentId);

}