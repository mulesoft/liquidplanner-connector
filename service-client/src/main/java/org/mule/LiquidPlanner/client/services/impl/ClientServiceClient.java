package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.core.ServicePath;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.ErrorMessage;
import org.mule.LiquidPlanner.client.model.Estimate;
import org.mule.LiquidPlanner.client.model.LPPackage;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.model.Note;
import org.mule.LiquidPlanner.client.services.ClientService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

/**
 * Provide access to all the client's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class ClientServiceClient extends AbstractServiceClient implements ClientService {

    public ClientServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ClientService#getClients(
     * java.lang.String)
     */
    @Override
    public List<Client> getClients(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getClientBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Client>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ClientService#getClient(java
     * .lang.String, java.lang.String)
     */
    @Override
    public Client getClient(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getClientBaseURL(workSpaceId) + "/" + clientId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Client.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ClientService#getClientComments
     * (java.lang.String, java.lang.String)
     */
    @Override
    public List<Comment> getClientComments(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getClientBaseURL(workSpaceId) + "/" + clientId + ServicePath.COMMENT.path();
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
     * org.mule.LiquidPlanner.client.services.impl.ClientService#getClientEstimates
     * (java.lang.String, java.lang.String)
     */
    @Override
    public List<Document> getClientDocuments(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getClientBaseURL(workSpaceId) + "/" + clientId + ServicePath.DOCUMENT.path();
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
     * org.mule.LiquidPlanner.client.services.impl.ClientService#getClientEstimates
     * (java.lang.String, java.lang.String)
     */
    @Override
    public List<Estimate> getClientEstimates(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getClientBaseURL(workSpaceId) + "/" + clientId + ServicePath.ESTIMATE.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Estimate>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ClientService#getClientEstimate
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Estimate getClientEstimate(String workSpaceId, String clientId, String estimateId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getClientBaseURL(workSpaceId) + "/" + clientId + ServicePath.ESTIMATE.path() + "/" + estimateId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Estimate.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ClientService#getClientLinks
     * (java.lang.String, java.lang.String)
     */
    @Override
    public List<Link> getClientLinks(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getClientBaseURL(workSpaceId) + "/" + clientId + ServicePath.LINK.path();
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
     * @see
     * org.mule.LiquidPlanner.client.services.impl.ClientService#getClientNote
     * (java.lang.String, java.lang.String)
     */
    @Override
    public Note getClientNote(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getClientBaseURL(workSpaceId) + "/" + clientId + ServicePath.NOTE.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Note.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * createClient (java.lang.String, java.lang.String,
     * org.mule.LiquidPLanner.client.model.Client)
     */
    @Override
    public Client createClient(String workSpaceId, Client client) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getClientBaseURL(workSpaceId);
        return this.createEntity(ServiceEntity.CLIENT.getName(), client, url);
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + ServicePath.WORKSPACE.path();
    }

    @Override
    protected ClientConfig getJerseyClientConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    private String getClientBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServicePath.CLIENTE.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }
}
