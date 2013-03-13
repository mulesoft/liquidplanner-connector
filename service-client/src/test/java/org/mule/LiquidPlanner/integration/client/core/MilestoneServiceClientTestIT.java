package org.mule.LiquidPlanner.integration.client.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Milestone;
import org.mule.LiquidPlanner.client.services.MileStoneService;
import org.mule.LiquidPlanner.client.services.impl.MilestoneServiceClient;

public class MilestoneServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String MILESTONE_ID = "6887830";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetMilestones() throws JSONException, JsonParseException, JsonMappingException, IOException {
        MileStoneService service = new MilestoneServiceClient(USER, PASSWORD);
        List<Milestone> response = service.getMilestones(WORKSPACE_ID);

        printOutResponse(response.toString());

    }

    @Test
    public void testGetMilestone() throws JSONException, JsonParseException, JsonMappingException, IOException {
        MileStoneService service = new MilestoneServiceClient(USER, PASSWORD);
        Milestone response = service.getMilestone(WORKSPACE_ID, MILESTONE_ID);

        printOutResponse(response.toString());

    }

    @Ignore
    @Test
    public void testCreateMilestone() throws JSONException, JsonParseException, JsonMappingException, IOException {
        MileStoneService service = new MilestoneServiceClient(USER, PASSWORD);
        Milestone response = service.getMilestone(WORKSPACE_ID, MILESTONE_ID);

        response.setId(null);
        response.setParentId(new Integer("8152840"));
        List<Integer> parentIds = new ArrayList<Integer>();
        parentIds.add(new Integer("8152840"));
        response.setParentIds(parentIds);

        Milestone newMilestone = service.createMilestone(WORKSPACE_ID, response);

        printOutResponse(newMilestone.toString());

    }

}
