package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.services.CommentService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

/**
 * Provide access to all the comments's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class CommentServiceClient extends AbstractServiceClient implements CommentService {

    public CommentServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.CommentService#getComments
     * (java.lang.String)
     */
    @Override
    public List<Comment> getComments(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getCommentBaseURL(workSpaceId);
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
     * org.mule.LiquidPlanner.client.services.impl.CommentService#getComment
     * (java.lang.String, java.lang.String)
     */
    @Override
    public Comment getComment(String workSpaceId, String commentId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(commentId, "The comment id should not be null nor empty");

        String url = getCommentBaseURL(workSpaceId) + "/" + commentId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Comment.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * createComment (java.lang.String, java.lang.String,
     * org.mule.LiquidPLanner.client.model.Comment)
     */
    @Override
    public Comment createComment(String workSpaceId, Comment comment) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getCommentBaseURL(workSpaceId);
        return this.createEntity(ServiceEntity.COMMENT.getName(), comment, url);
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

    private String getCommentBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.COMMENT.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }
}
