package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.services.CommentService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;

/**
 * Provide access to all the comments's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class CommentServiceClient extends AbstractServiceClient implements CommentService {
    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_COMMENT_PATH = "/comments";

    public CommentServiceClient(String user, String password) {
        super(user, password);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.CommentService#getComments(java.lang.String)
     */
    @Override
    public List<Comment> getComments(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Comment>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.CommentService#getComment(java.lang.String, java.lang.String)
     */
    @Override
    public Comment getComment(String workSpaceId, String commentId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(commentId, "The comment id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + commentId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return deserializeResponse(clientResponse, Comment.class);
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
        return getBaseURL() + "/" + workSpaceId + API_COMMENT_PATH;
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        // TODO Auto-generated method stub
        return null;
    }
}
