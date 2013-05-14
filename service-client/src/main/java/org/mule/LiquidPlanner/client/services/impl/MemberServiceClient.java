package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.LPPackage;
import org.mule.LiquidPlanner.client.model.Member;
import org.mule.LiquidPlanner.client.services.MemberService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

/**
 * Provide access to all the account's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class MemberServiceClient extends AbstractServiceClient implements MemberService {

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
    public List<Member> getMembers(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Member>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.MemberService#getMemeber(
     * java.lang.String, java.lang.String)
     */
    @Override
    public Member getMember(String workSpaceId, String memberId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(memberId, "The memeber id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + memberId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return deserializeResponse(clientResponse, Member.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * createMember (java.lang.String, java.lang.String,
     * org.mule.LiquidPLanner.client.model.Member)
     */
    @Override
    public Member createMember(String workSpaceId, Member member) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getMemeberBaseURL(workSpaceId);
        return this.createEntity(ServiceEntity.MEMEBER.getName(), member, url);
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

    private String getMemeberBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.MEMEBER.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }
}
