package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Folder;
import org.mule.LiquidPlanner.client.services.FolderService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

public class FolderServiceClient extends AbstractServiceClient implements FolderService {

    public FolderServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.FolderService#getFolders(
     * java.lang.String)
     */
    @Override
    public List<Folder> getFolders(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getFolderBaseURL(workSpaceId);

        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Folder>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.FolderService#getFolder(java
     * .lang.String, java.lang.String)
     */
    @Override
    public Folder getFolder(String workSpaceId, String folderId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(folderId, "The folder id can not be null nor empty.");

        String url = getFolderBaseURL(workSpaceId) + "/" + folderId;

        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Folder.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.FolderService#createFolder
     * (java.lang.String, org.mule.LiquidPlanner.client.model.Folder)
     */
    @Override
    public Folder createFolder(String workSpaceId, Folder folder) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getFolderBaseURL(workSpaceId);

        return this.createEntity(ServiceEntity.FOLDER.getName(), folder, url);
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + ServiceEntity.WORKSPACE.path();
    }

    @Override
    protected ClientConfig getJerseyClientConfiguration() {
        return null;
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }

    private String getFolderBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.FOLDER.path();
    }
}
