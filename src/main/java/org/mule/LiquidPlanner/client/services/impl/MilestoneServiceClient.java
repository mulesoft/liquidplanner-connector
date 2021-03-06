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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.codehaus.jackson.type.TypeReference;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Folder;
import org.mule.LiquidPlanner.client.model.Milestone;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.services.MileStoneService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

public class MilestoneServiceClient extends AbstractServiceClient implements MileStoneService {

    public MilestoneServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.MileStoneService#getMilestones
     * (java.lang.String)
     */
    @Override
    public List<Milestone> getMilestones(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId);

        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Milestone>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.MileStoneService#getMilestone
     * (java.lang.String, java.lang.String)
     */
    @Override
    public Milestone getMilestone(String workSpaceId, String mileStoneId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(mileStoneId, "The milestone id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + mileStoneId;

        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Milestone.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.MileStoneService#createMilestone
     * (java.lang.String, org.mule.LiquidPlanner.client.model.Milestone)
     */
    @Override
    public Milestone createMilestone(String workSpaceId, Milestone milestone) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId);
        return this.createEntity("milestone", milestone, url);
    }
    
    @Override
    public Milestone updateMilestone(String workSpaceId, Milestone milestone) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + milestone.getId();
        return this.updateEntity(ServiceEntity.MILESTONE.getName(), milestone, url);
    }

    @Override
    public Milestone deleteMilestone(String workSpaceId, String id) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(id, "The id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + id;
        return this.deleteEntity(url, Milestone.class);
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

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }

    private String getURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.MILESTONE.path();
    }
}
