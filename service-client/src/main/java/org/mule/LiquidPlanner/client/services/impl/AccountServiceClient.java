package org.mule.LiquidPlanner.client.services.impl;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.services.impl.AbstractServiceClient;
import org.mule.LiquidPlanner.client.services.AccountService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;

/**
 * Provide access to all the account's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class AccountServiceClient extends AbstractServiceClient implements AccountService {

    private static final String API_ACCOUNT_PATH = "/account";

    public AccountServiceClient(String user, String password) {
        super(user, password);
    }

    public String getAccountDetails() {

        String url = getBaseURL();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = clientResponse.getEntity(String.class);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }

        return response;
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + API_ACCOUNT_PATH;
    }

    @Override
    protected ClientConfig getJerseyClientConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        // TODO Auto-generated method stub
        return null;
    }
}
