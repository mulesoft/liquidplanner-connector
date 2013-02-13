package org.mule.LiquidPlanner.client.services.impl;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.services.MemberService;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;

/**
 * Provide access to all the account's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class MemberServiceClient extends AbstractServiceClient implements MemberService {
    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_MEMEBER_PATH = "/members";

    public MemberServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.MemberService#getMemebers
     * (java.lang.String)
     */
    @Override
    public String getMembers(String workSpaceId) {

        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = readResponseFromClientResponse(clientResponse);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }

        return response;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.MemberService#getMemeber(
     * java.lang.String, java.lang.String)
     */
    @Override
    public String getMember(String workSpaceId, String memberId) {

        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(memberId, "The memeber id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + memberId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        String response = readResponseFromClientResponse(clientResponse);
        if (clientResponse.getStatus() >= 400) {
            return response;
        }

        return response;
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
        return getBaseURL() + "/" + workSpaceId + API_MEMEBER_PATH;
    }
}
