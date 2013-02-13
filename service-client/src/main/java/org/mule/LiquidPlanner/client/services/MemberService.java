package org.mule.LiquidPlanner.client.services;

public interface MemberService {

    /**
     * Retrieve all the members related to a workspace
     * 
     * @param workspaceId
     * @return
     */
    public String getMembers(String workSpaceId);

    /**
     * Retrieve a particular member
     * 
     * @param workspaceId
     * @param memeberId
     * @return
     */
    public String getMember(String workSpaceId, String memberId);

}