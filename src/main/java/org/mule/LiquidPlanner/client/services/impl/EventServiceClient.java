/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.CheckListItem;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Event;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.model.TimesheetEntry;
import org.mule.LiquidPlanner.client.services.EventService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

/**
 * Provide access to all the event's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class EventServiceClient extends AbstractServiceClient implements EventService {

    public EventServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.EventService#getEvents(java
     * .lang.String)
     */
    @Override
    public List<Event> getEvents(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Event>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.EventService#getEvent(java
     * .lang.String, java.lang.String)
     */
    @Override
    public Event getEvent(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getURL(workSpaceId) + "/" + eventId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Event.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.EventService#
     * getEventCheckListItems(java.lang.String, java.lang.String)
     */
    @Override
    public List<CheckListItem> getEventCheckListItems(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getURL(workSpaceId) + "/" + eventId + ServiceEntity.CHECKLIST_ITEM.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<CheckListItem>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.EventService#getEventComments
     * (java.lang.String, java.lang.String)
     */
    @Override
    public List<Comment> getEventComments(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getURL(workSpaceId) + "/" + eventId + ServiceEntity.COMMENT.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Comment>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.EventService#getEventDocuments
     * (java.lang.String, java.lang.String)
     */
    @Override
    public List<Document> getEventDocuments(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getURL(workSpaceId) + "/" + eventId + ServiceEntity.DOCUMENT.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Document>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.EventService#getEventLinks
     * (java.lang.String, java.lang.String)
     */
    @Override
    public List<Link> getEventLinks(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getURL(workSpaceId) + "/" + eventId + ServiceEntity.LINK.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Link>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.EventService#
     * getEventTimesheetEntries(java.lang.String, java.lang.String)
     */
    @Override
    public List<TimesheetEntry> getEventTimesheetEntries(String workSpaceId, String eventId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(eventId, "The event id should not be null nor empty");

        String url = getURL(workSpaceId) + "/" + eventId + ServiceEntity.TIMESHEET_ENTRIES.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<TimesheetEntry>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.EventService#
     * createEvent (java.lang.String, java.lang.String,
     * org.mule.LiquidPLanner.client.model.Event)
     */
    @Override
    public Event createEvent(String workSpaceId, Event event) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId);
        return this.createEntity(ServiceEntity.EVENT.getName(), event, url);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.TaskService#updateEvent(
     * java.lang.String, org.mule.LiquidPlaner.client.Model.Event)
     */
    @Override
    public Event updateEvent(String workSpaceId, Event event) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + event.getId();
        return this.updateEntity(ServiceEntity.EVENT.getName(), event, url);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.TaskService#deleteEvent(
     * java.lang.String, java.lan.String)
     */
    @Override
    public Event deleteEvent(String workSpaceId, String id) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(id, "The id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + id;
        return this.deleteEntity(url, Event.class);
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + ServiceEntity.WORKSPACE.path();
    }

    @Override
    protected ClientConfig getJerseyClientConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    private String getURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.EVENT.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }
}
