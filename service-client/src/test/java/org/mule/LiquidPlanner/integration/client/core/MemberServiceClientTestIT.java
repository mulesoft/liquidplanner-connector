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

    @Ignore
    @Test
    public void testCreateMemeber() throws JSONException {
        MemberService service = new MemberServiceClient(USER, PASSWORD);

        Member aMember = new Member();
        aMember.setAccess_level("member");
        aMember.setCompany("fakemember");
        aMember.setEmail("fake.member@gmail.com");
        aMember.setFirst_name("Fake");
        aMember.setIs_virtual(false);
        aMember.setLast_name("Memeber");
        aMember.setUser_name("fakemember");
        aMember.setTeam_name("iApps");
        aMember.setType(ServiceEntity.MEMEBER.getName());

        Member member = service.createMember(WORKSPACE_ID, aMember);

        printOutResponse(member.toString());
    }

}
