package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.CheckListItem;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Event;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.services.impl.EventServiceClient;

public class EventServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String EVENT_ID = "6910010";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetEvents() throws JSONException {
        EventServiceClient service = new EventServiceClient(USER, PASSWORD);
        List<Event> events = service.getEvents(WORKSPACE_ID);

        printOutResponse(events.toString());
    }

    @Test
    public void testGetEvent() throws JSONException {
        EventServiceClient service = new EventServiceClient(USER, PASSWORD);
        Event event = service.getEvent(WORKSPACE_ID, EVENT_ID);

        printOutResponse(event.toString());
    }

    @Test
    public void testGetEventCheckListItems() throws JSONException {
        EventServiceClient service = new EventServiceClient(USER, PASSWORD);
        List<CheckListItem> checkListItems = service.getEventCheckListItems(WORKSPACE_ID, EVENT_ID);

        printOutResponse(checkListItems.toString());
    }

    @Test
    public void testGetEventComments() throws JSONException {
        EventServiceClient service = new EventServiceClient(USER, PASSWORD);
        List<Comment> comments = service.getEventComments(WORKSPACE_ID, EVENT_ID);

        printOutResponse(comments.toString());
    }

    @Test
    public void testGetEventDocuments() throws JSONException {
        EventServiceClient service = new EventServiceClient(USER, PASSWORD);
        List<Document> documents = service.getEventDocuments(WORKSPACE_ID, EVENT_ID);

        printOutResponse(documents.toString());
    }

    @Test
    public void testGetEventLinks() throws JSONException {
        EventServiceClient service = new EventServiceClient(USER, PASSWORD);
        List<Link> links = service.getEventLinks(WORKSPACE_ID, EVENT_ID);

        printOutResponse(links.toString());
    }

    @Test
    public void testGetEventTimesheetEntries() throws JSONException {
        EventServiceClient service = new EventServiceClient(USER, PASSWORD);
        String response = service.getEventTimesheetEntries(WORKSPACE_ID, EVENT_ID);

        printOutResponse(response.toString());
    }

}
