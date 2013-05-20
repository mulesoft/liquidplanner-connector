/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.integration.client.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
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

    @Test
    public void testUpdateMilestone() throws JSONException, JsonParseException, JsonMappingException, IOException {
        MileStoneService service = new MilestoneServiceClient(USER, PASSWORD);

        // Get Base Milstone
        Milestone response = service.getMilestone(WORKSPACE_ID, MILESTONE_ID);

        // Null some stuff to create a new one
        response.setId(null);
        response.setParentId(new Integer("8152840"));
        List<Integer> parentIds = new ArrayList<Integer>();
        parentIds.add(new Integer("8152840"));
        response.setParentIds(parentIds);
        response.setName("Milestone_to_be_deleted");
        Milestone newMilestone = service.createMilestone(WORKSPACE_ID, response);

        Milestone aMilestone = service.getMilestone(WORKSPACE_ID, newMilestone.getId().toString());
        String updatedName = aMilestone.getName() + "[UPDATED]";
        aMilestone.setName(updatedName);

        Milestone updatedMilestone = service.updateMilestone(WORKSPACE_ID, aMilestone);
        try {
            Assert.assertEquals("The milestone names should be the same.", updatedName, updatedMilestone.getName());
        } finally {
            service.deleteMilestone(WORKSPACE_ID, newMilestone.getId().toString());
        }
    }

    @Test(expected = LiquidPlannerException.class)
    public void testDeleteMilestone() throws JSONException, JsonParseException, JsonMappingException, IOException {
        MileStoneService service = new MilestoneServiceClient(USER, PASSWORD);

        // Get Base Milstone
        Milestone response = service.getMilestone(WORKSPACE_ID, MILESTONE_ID);

        // Null some stuff to create a new one
        response.setId(null);
        response.setParentId(new Integer("8152840"));
        List<Integer> parentIds = new ArrayList<Integer>();
        parentIds.add(new Integer("8152840"));
        response.setParentIds(parentIds);
        response.setName("Milestone_to_be_deleted");
        Milestone newMilestone = service.createMilestone(WORKSPACE_ID, response);

        // Delete milestone
        service.deleteMilestone(WORKSPACE_ID, newMilestone.getId().toString());

        service.getMilestone(WORKSPACE_ID, newMilestone.getId().toString());
    }

}
