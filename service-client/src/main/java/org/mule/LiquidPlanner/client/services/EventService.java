package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.CheckListItem;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Event;
import org.mule.LiquidPlanner.client.model.Link;

public interface EventService {

    public List<Event> getEvents(String workSpaceId);

    public Event getEvent(String workSpaceId, String eventId);

    public List<CheckListItem> getEventCheckListItems(String workSpaceId, String eventId);

    public List<Comment> getEventComments(String workSpaceId, String eventId);

    public List<Document> getEventDocuments(String workSpaceId, String eventId);

    public List<Link> getEventLinks(String workSpaceId, String eventId);

    public String getEventTimesheetEntries(String workSpaceId, String eventId);

}