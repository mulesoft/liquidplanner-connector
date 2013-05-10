package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.model.CheckListItem;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Event;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.services.EventService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;

/**
 * Provide access to all the event's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class EventServiceClient extends AbstractServiceClient implements EventService {
    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_EVENT_PATH = "/events";

    private static final String API_EVENT_CHECKLIST_ITEM_PATH = "/checklist_items";
    private static final String API_EVENT_COMMENT_PATH = "/comments";
    private static final String API_EVENT_DOCUMENT_PATH = "/documents";
    private static final String API_EVENT_LINK_PATH = "/links";
    private static final String API_EVENT_TIMESHEET_ENTRIES_PATH = "/timesheet_entries";

    public EventServiceClient(String user, String password) {
        super(user, password);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.EventService#getEvents(java.lang.String)
     */
    @Override
    public List<Event> getEvents(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Event>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.EventService#getEvent(java.lang.String, java.lang.String)
     */
    @Override
    public Event getEvent(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + eventId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return deserializeResponse(clientResponse, Event.class);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.EventService#getEventCheckListItems(java.lang.String, java.lang.String)
     */
    @Override
    public List<CheckListItem> getEventCheckListItems(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + eventId + API_EVENT_CHECKLIST_ITEM_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        Type type = new TypeToken<List<CheckListItem>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);

    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.EventService#getEventComments(java.lang.String, java.lang.String)
     */
    @Override
    public List<Comment> getEventComments(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + eventId + API_EVENT_COMMENT_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Comment>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.EventService#getEventDocuments(java.lang.String, java.lang.String)
     */
    @Override
    public List<Document> getEventDocuments(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + eventId + API_EVENT_DOCUMENT_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Document>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.EventService#getEventLinks(java.lang.String, java.lang.String)
     */
    @Override
    public List<Link> getEventLinks(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + eventId + API_EVENT_LINK_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Link>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.EventService#getEventTimesheetEntries(java.lang.String, java.lang.String)
     */
    @Override
    public String getEventTimesheetEntries(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + eventId + API_EVENT_TIMESHEET_ENTRIES_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        // Type type = new TypeToken<List<>>() {
        // }.getType();
        // return deserializeResponse(clientResponse, type);

        String response = clientResponse.getEntity(String.class);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }
        return response;
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + API_WORKSPACE_PATH;
    }

    @Override
    protected ClientConfig getJerseyClientConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    private String getMemeberBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + API_EVENT_PATH;
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        // TODO Auto-generated method stub
        return null;
    }
}
