/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

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