package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.codehaus.jackson.type.TypeReference;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
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

    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_MILESTONE_PATH = "/milestones";

    public MilestoneServiceClient(String user, String password) {
        super(user, password);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.MileStoneService#getMilestones(java.lang.String)
     */
    @Override
    public List<Milestone> getMilestones(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getMilestoneBaseURL(workSpaceId);

        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Milestone>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.MileStoneService#getMilestone(java.lang.String, java.lang.String)
     */
    @Override
    public Milestone getMilestone(String workSpaceId, String mileStoneId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(mileStoneId, "The milestone id can not be null nor empty.");

        String url = getMilestoneBaseURL(workSpaceId) + "/" + mileStoneId;

        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return deserializeResponse(clientResponse, Milestone.class);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.MileStoneService#createMilestone(java.lang.String, org.mule.LiquidPlanner.client.model.Milestone)
     */
    @Override
    public Milestone createMilestone(String workSpaceId, Milestone milestone) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getMilestoneBaseURL(workSpaceId);
        return this.createEntity("milestone", milestone, url);
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

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }

    private String getMilestoneBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + API_MILESTONE_PATH;
    }
}
