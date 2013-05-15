package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Folder;
import org.mule.LiquidPlanner.client.model.Link;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

/**
 * Provide access to all the link's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class LinkServiceClient extends AbstractServiceClient {

    public LinkServiceClient(String user, String password) {
        super(user, password);
    }

    public List<Link> getLinks(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Link>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);

    }

    public Link getLink(String workSpaceId, String linkId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(linkId, "The link id should not be null nor empty");

        String url = getURL(workSpaceId) + "/" + linkId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Link.class);
    }

    public Link createLink(String workSpaceId, Link link) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId);
        return this.createEntity(ServiceEntity.LINK.getName(), link, url);
    }

    public Link updateLink(String workSpaceId, Link link) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + link.getId();
        return this.updateEntity(ServiceEntity.LINK.getName(), link, url);
    }

    public Link deleteLink(String workSpaceId, String id) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(id, "The id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + id;
        return this.deleteEntity(url, Link.class);
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
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.LINK.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }
}
