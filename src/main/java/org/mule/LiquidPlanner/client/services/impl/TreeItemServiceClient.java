/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.TreeItem;
import org.mule.LiquidPlanner.client.services.TreeItemService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

public class TreeItemServiceClient extends AbstractServiceClient implements TreeItemService {

    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_TREEITEM_PATH = "/treeitems";

    public TreeItemServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.TreeItemService#getTreeItems
     * (java.lang.String)
     */
    @Override
    public String getTreeItems(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getProjectBaseURL(workSpaceId);

        Map<String, String> queryParameters = new HashMap<String, String>();
        queryParameters.put("flat", "true");
        WebResource.Builder builder = getBuilder(user, password, url, queryParameters);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        String response = clientResponse.getEntity(String.class);
        if (clientResponse.getStatus() >= 400) {
            throw new LiquidPlannerException("There has been an error when invoking the API: " + response);
        }

        return response;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.TreeItemService#getTreeItem
     * (java.lang.String, java.lang.String)
     */
    @Override
    public <T extends TreeItem> T getTreeItem(String workSpaceId, String treeItemId, Class<T> clazz) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(treeItemId, "The treeitem id can not be null nor empty.");

        String url = getProjectBaseURL(workSpaceId) + "/" + treeItemId;

        Map<String, String> queryParameters = new HashMap<String, String>();
        queryParameters.put("flat", "false");
        queryParameters.put("depth", "-1");
        WebResource.Builder builder = getBuilder(user, password, url, queryParameters);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, clazz);
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + API_WORKSPACE_PATH;
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

    private String getProjectBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + API_TREEITEM_PATH;
    }
}
