package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Activity;
import org.mule.LiquidPlanner.client.services.ActivityService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

/**
 * Provide access to all the activity's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class ActivityServiceClient extends AbstractServiceClient implements ActivityService {

    public ActivityServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ActivityService#getActivities
     * (java.lang.String)
     */
    @Override
    public List<Activity> getActivities(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getActivityBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Activity>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ActivityService#getActivity
     * (java.lang.String, java.lang.String)
     */
    @Override
    public Activity getActivity(String workSpaceId, String activityId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(activityId, "The activity id should not be null nor empty");

        String url = getActivityBaseURL(workSpaceId) + "/" + activityId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Activity.class);
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

    private String getActivityBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.ACTIVITY.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }
}
