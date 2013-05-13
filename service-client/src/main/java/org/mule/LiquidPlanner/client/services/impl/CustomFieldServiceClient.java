package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.core.ServicePath;
import org.mule.LiquidPlanner.client.model.LPPackage;
import org.mule.LiquidPlanner.client.services.CustomField;
import org.mule.LiquidPlanner.client.services.CustomFieldService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

/**
 * Provide access to all the custom field's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class CustomFieldServiceClient extends AbstractServiceClient implements CustomFieldService {

    public CustomFieldServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.CustomFieldService#
     * getCustomFields(java.lang.String)
     */
    @Override
    public List<CustomField> getCustomFields(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getCustomFieldBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<CustomField>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.CustomFieldService#getCustomField
     * (java.lang.String, java.lang.String)
     */
    @Override
    public CustomField getCustomField(String workSpaceId, String customFieldId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(customFieldId, "The custom field id should not be null nor empty");

        String url = getCustomFieldBaseURL(workSpaceId) + "/" + customFieldId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, CustomField.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * createCuatomField (java.lang.String, java.lang.String,
     * org.mule.LiquidPLanner.client.model.CustomField)
     */
    @Override
    public CustomField createCuatomField(String workSpaceId, CustomField customField) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getCustomFieldBaseURL(workSpaceId);
        return this.createEntity(ServiceEntity.CUSTOM_FIELD.getName(), customField, url);
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

    private String getCustomFieldBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServicePath.CUSTOM_FIELD.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }
}
