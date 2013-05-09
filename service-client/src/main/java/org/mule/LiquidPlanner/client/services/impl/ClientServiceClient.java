package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Estimate;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.services.ClientService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;

/**
 * Provide access to all the client's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class ClientServiceClient extends AbstractServiceClient implements ClientService {
    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_CLIENTE_PATH = "/clients";

    private static final String API_CLIENT_COMMENT_PATH = "/comments";
    private static final String API_CLIENT_DOCUMENT_PATH = "/documents";
    private static final String API_CLIENT_ESTIMATE_PATH = "/estimates";
    private static final String API_CLIENT_LINK_PATH = "/links";
    private static final String API_CLIENT_NOTE_PATH = "/note";

    public ClientServiceClient(String user, String password) {
        super(user, password);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.ClientService#getClients(java.lang.String)
     */
    @Override
    public List<Client> getClients(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Client>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.ClientService#getClient(java.lang.String, java.lang.String)
     */
    @Override
    public Client getClient(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + clientId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return deserializeResponse(clientResponse, Client.class);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.ClientService#getClientComments(java.lang.String, java.lang.String)
     */
    @Override
    public List<Comment> getClientComments(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + clientId + API_CLIENT_COMMENT_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Comment>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }
    
    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.ClientService#getClientEstimates(java.lang.String, java.lang.String)
     */
    @Override
    public List<Document> getClientDocuments(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + clientId +  API_CLIENT_DOCUMENT_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Document>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }


    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.ClientService#getClientEstimates(java.lang.String, java.lang.String)
     */
    @Override
    public List<Estimate> getClientEstimates(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + clientId + API_CLIENT_ESTIMATE_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Estimate>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.ClientService#getClientEstimate(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Estimate getClientEstimate(String workSpaceId, String clientId, String estimateId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + clientId + API_CLIENT_ESTIMATE_PATH + "/" + estimateId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return deserializeResponse(clientResponse, Estimate.class);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.ClientService#getClientLinks(java.lang.String, java.lang.String)
     */
    @Override
    public List<Link> getClientLinks(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + clientId + API_CLIENT_LINK_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Link>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.ClientService#getClientNote(java.lang.String, java.lang.String)
     */
    @Override
    public String getClientNote(String workSpaceId, String clientId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(clientId, "The client id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + clientId + API_CLIENT_NOTE_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = clientResponse.getEntity(String.class);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }
        return response;

        // Type type = new TypeToken<List<Link>>() {
        // }.getType();
        // return deserializeResponse(clientResponse, type);
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
        return getBaseURL() + "/" + workSpaceId + API_CLIENTE_PATH;
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        // TODO Auto-generated method stub
        return null;
    }
}
