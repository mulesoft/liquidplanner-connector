package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.model.CheckListItem;
import org.mule.LiquidPlanner.client.services.CheckListItemService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;

/**
 * Provide access to all the check list items's related operations in
 * LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class CheckListItemServiceClient extends AbstractServiceClient implements CheckListItemService {
    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_CHECKLIST_ITEM_PATH = "/checklist_items";

    public CheckListItemServiceClient(String user, String password) {
        super(user, password);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.CheckListItemService#getCheckListItems(java.lang.String)
     */
    @Override
    public List<CheckListItem> getCheckListItems(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<CheckListItem>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.CheckListItemService#getCheckListItem(java.lang.String, java.lang.String)
     */
    @Override
    public CheckListItem getCheckListItem(String workSpaceId, String checkListItemId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(checkListItemId, "The check List Item id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + checkListItemId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, CheckListItem.class);
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
        return getBaseURL() + "/" + workSpaceId + API_CHECKLIST_ITEM_PATH;
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        // TODO Auto-generated method stub
        return null;
    }
}
