/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Member;
import org.mule.LiquidPlanner.client.services.MemberService;
import org.mule.LiquidPlanner.client.services.impl.MemberServiceClient;

public class MemberServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String MEMBER_ID = "260403";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetMemebers() throws JSONException {
        MemberService service = new MemberServiceClient(USER, PASSWORD);
        List<Member> members = service.getMembers(WORKSPACE_ID);

        printOutResponse(members.toString());
    }

    @Test
    public void testGetMemeber() throws JSONException {
        MemberService service = new MemberServiceClient(USER, PASSWORD);
        Member member = service.getMember(WORKSPACE_ID, MEMBER_ID);

        printOutResponse(member.toString());
    }

}
