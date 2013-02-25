package org.mule.LiquidPlanner.client.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.codehaus.jackson.type.TypeReference;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.services.ProjectService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

public class ProjectServiceClient extends AbstractServiceClient implements ProjectService {

    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_PROJECT_PATH = "/projects";

    private static final String API_MOVE_AFTER_PATH = "/move_after";
    private static final String API_MOVE_BEFORE_PATH = "/move_before";
    private static final String API_TRACK_TIME_PATH = "/track_time";
    private static final String API_DEPENDENCY_PATH = "/dependencies";
    private static final String API_COMMENT_PATH = "/comments";
    private static final String API_DOCUMENT_PATH = "/documents";
    private static final String API_ESTIMATE_PATH = "/estimates";
    private static final String API_LINK_PATH = "/links";
    private static final String API_NOTE_PATH = "/note";

    public ProjectServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ProjectService#getProjects
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<Project> getProjects(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getProjectBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = readResponseFromClientResponse(clientResponse);
        if (clientResponse.getStatus() >= 400) {
            throw new LiquidPlannerException("There has been an error when invoking the API: " + response);
        }

        try {
            return MAPPER.readValue(response, new TypeReference<List<Project>>() {
            });
        } catch (Exception e) {
            throw new LiquidPlannerException("There has been an error when de seralizing the response: " + response, e);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ProjectService#getProject
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Project getProject(String workSpaceId, String projectId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(projectId, "The project id can not be null nor empty.");

        String url = getProjectBaseURL(workSpaceId) + "/" + projectId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = readResponseFromClientResponse(clientResponse);
        if (clientResponse.getStatus() >= 400) {
            throw new LiquidPlannerException("There has been an error when invoking the API: " + response);
        }

        try {
            return MAPPER.readValue(response, Project.class);
        } catch (Exception e) {
            throw new LiquidPlannerException("There has been an error when de seralizing the response: " + response, e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ProjectService#getProjectComments
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<Comment> getProjectComments(String workSpaceId, String projectId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(projectId, "The project id can not be null nor empty.");

        String url = getProjectBaseURL(workSpaceId) + "/" + projectId + API_COMMENT_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = readResponseFromClientResponse(clientResponse);
        if (clientResponse.getStatus() >= 400) {
            throw new LiquidPlannerException("There has been an error when invoking the API: " + response);
        }

        try {
            return MAPPER.readValue(response, new TypeReference<List<Comment>>() {
            });
        } catch (Exception e) {
            throw new LiquidPlannerException("There has been an error when de seralizing the response: " + response, e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ProjectService#createProject
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Project createProject(String workSpaceId, Project project) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getProjectBaseURL(workSpaceId);

        Map<String, Object> payloadMap = new HashMap<String, Object>();
        payloadMap.put("project", project);

        String payload;
        try {
            payload = MAPPER.writeValueAsString(payloadMap);
        } catch (Exception e) {
            throw new LiquidPlannerException("There has been an error when serializing the project to json", e);
        }

        WebResource.Builder builder = getBuilder(user, password, url, null);
        ClientResponse clientResponse = builder.post(ClientResponse.class, payload);
        String response = clientResponse.getEntity(String.class);

        if (clientResponse.getStatus() >= 400) {
            throw new LiquidPlannerException("There has been an error when invoking the API: " + response);
        }

        try {
            return  MAPPER.readValue(response, Project.class);
        } catch (Exception e) {
            throw new LiquidPlannerException("There has been an error when de seralizing the response: " + response, e);
        }
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

    private String getProjectBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + API_PROJECT_PATH;
    }
}
