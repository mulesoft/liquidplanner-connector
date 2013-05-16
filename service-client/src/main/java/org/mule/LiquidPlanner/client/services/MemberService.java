package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Member;

public interface MemberService {

    /**
     * Retrieve all the members related to a workspace
     * 
     * @param workspaceId
     * @return
     */
    public List<Member> getMembers(String workSpaceId);

    /**
     * Retrieve a particular member
     * 
     * @param workspaceId
     * @param memeberId
     * @return
     */
    public Member getMember(String workSpaceId, String memberId);

}