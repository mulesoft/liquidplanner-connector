package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import junit.framework.Assert;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.CheckListItem;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Event;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.model.TimesheetEntry;
import org.mule.LiquidPlanner.client.services.CommentService;
import org.mule.LiquidPlanner.client.services.EventService;
import org.mule.LiquidPlanner.client.services.impl.CommentServiceClient;
import org.mule.LiquidPlanner.client.services.impl.EventServiceClient;

public class EventServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String EVENT_ID = "6910010";

    private Event aEvent;

    @Before
    public void setUp() {
        aEvent = new Event();
        aEvent.setType(ServiceEntity.MILESTONE.name());
        aEvent.setActivity_id(9034657);
        aEvent.setParent_id(9034648);
        aEvent.setDescription("A test event to be deleted or updated");
        aEvent.setName("A test event to be deleted or updated");
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetEvents() throws JSONException {
        EventService service = new EventServiceClient(USER, PASSWORD);
        List<Event> events = service.getEvents(WORKSPACE_ID);

        printOutResponse(events.toString());
    }

    @Test
    public void testGetEvent() throws JSONException {
        EventService service = new EventServiceClient(USER, PASSWORD);
        Event event = service.getEvent(WORKSPACE_ID, EVENT_ID);

        printOutResponse(event.toString());
    }

    @Test
    public void testGetEventCheckListItems() throws JSONException {
        EventService service = new EventServiceClient(USER, PASSWORD);
        List<CheckListItem> checkListItems = service.getEventCheckListItems(WORKSPACE_ID, EVENT_ID);

        printOutResponse(checkListItems.toString());
    }

    @Test
    public void testGetEventComments() throws JSONException {
        EventService service = new EventServiceClient(USER, PASSWORD);
        List<Comment> comments = service.getEventComments(WORKSPACE_ID, EVENT_ID);

        printOutResponse(comments.toString());
    }

    @Test
    public void testGetEventDocuments() throws JSONException {
        EventService service = new EventServiceClient(USER, PASSWORD);
        List<Document> documents = service.getEventDocuments(WORKSPACE_ID, EVENT_ID);

        printOutResponse(documents.toString());
    }

    @Test
    public void testGetEventLinks() throws JSONException {
        EventService service = new EventServiceClient(USER, PASSWORD);
        List<Link> links = service.getEventLinks(WORKSPACE_ID, EVENT_ID);

        printOutResponse(links.toString());
    }

    @Test
    public void testGetEventTimesheetEntries() throws JSONException {
        EventService service = new EventServiceClient(USER, PASSWORD);
        List<TimesheetEntry> timesheeEntries = service.getEventTimesheetEntries(WORKSPACE_ID, EVENT_ID);

        printOutResponse(timesheeEntries.toString());
    }

    @Ignore
    @Test
    public void testCreateEvent() throws JSONException {
        EventService service = new EventServiceClient(USER, PASSWORD);
        Event aEvent = new Event();
        aEvent.setType(ServiceEntity.MILESTONE.name());
        aEvent.setActivity_id(9034657);
        aEvent.setParent_id(9034648);
        aEvent.setDescription("A test event");
        aEvent.setName("A event name");

        Event event = service.createEvent(WORKSPACE_ID, aEvent);

        printOutResponse(event.toString());
    }

    @Test
    public void testUpdateComment() throws JSONException {
        EventService service = new EventServiceClient(USER, PASSWORD);

        Event newEvent = service.createEvent(WORKSPACE_ID, aEvent);

        String newEventName = newEvent.getName() + "[UPDATED]";

        newEvent.setName(newEventName);

        Event comment = service.updateEvent(WORKSPACE_ID, newEvent);

        printOutResponse(comment.toString());

        try {
            Assert.assertEquals("The names should be the same", newEventName, comment.getName());
        } finally {
            service.deleteEvent(WORKSPACE_ID, comment.getId().toString());
        }

    }

    @Test(expected = LiquidPlannerException.class)
    public void testDeleteComment() throws JSONException {
        EventService service = new EventServiceClient(USER, PASSWORD);

        Event newComment = service.createEvent(WORKSPACE_ID, aEvent);

        Event comment = service.deleteEvent(WORKSPACE_ID, newComment.getId().toString());

        printOutResponse(comment.toString());

        service.getEvent(WORKSPACE_ID, newComment.getId().toString());

    }
}
