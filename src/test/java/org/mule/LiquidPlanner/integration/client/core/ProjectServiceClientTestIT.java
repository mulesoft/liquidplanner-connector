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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.services.ProjectService;
import org.mule.LiquidPlanner.client.services.impl.ProjectServiceClient;

import com.google.gson.GsonBuilder;

public class ProjectServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";

    // private static final String PROJECT_ID = "7351876";
    // private static final String PROJECT_ID = "7497110";
    // private static final String PROJECT_ID = "7497110";
    private static final String PROJECT_ID = "6883656";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetProjects() throws JSONException, JsonParseException, JsonMappingException, IOException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);
        List<Project> response = service.getProjects(WORKSPACE_ID);

        printOutResponse(response.toString());

    }

    @Test
    public void testGetProject() throws JSONException, JsonParseException, JsonMappingException, IOException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);
        Project response = service.getProject(WORKSPACE_ID, PROJECT_ID);

        printOutResponse(response.toString());

    }

    @Test
    public void testGetProjectComments() throws JSONException, JsonParseException, JsonMappingException, IOException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);
        List<Comment> response = service.getProjectComments(WORKSPACE_ID, PROJECT_ID);

        printOutResponse(response.toString());
    }

    @Ignore
    @Test
    public void testCreateProject() throws JSONException, JsonParseException, JsonMappingException, IOException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);

        Project project = new Project();
        project.setDescription("some description");
        project.setName("Test_iapp_Name");
        project.setParentId("6875321");
        Project response = service.createProject(WORKSPACE_ID, project);

        printOutResponse(response.toString());

    }

    @Test
    public void testUpdateProject() throws JSONException, JsonParseException, JsonMappingException, IOException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);

        Project project = new Project();
        project.setDescription("some description");
        project.setName("Test_iapp_Name_to_update");
        project.setParentId("6875321");

        Project createdProject = service.createProject(WORKSPACE_ID, project);

        String updatedName = createdProject.getName() + "[UPDATED]";
        createdProject.setName(updatedName);

        Project updatedProject = service.updateProject(WORKSPACE_ID, createdProject);
        try {
            Assert.assertEquals("The names should be the same.", updatedName, updatedProject.getName());
        } finally {
            service.deleteProject(WORKSPACE_ID, createdProject.getId().toString());
        }

    }

    @Test(expected = LiquidPlannerException.class)
    public void testDeleteProject() throws JSONException, JsonParseException, JsonMappingException, IOException {
        ProjectService service = new ProjectServiceClient(USER, PASSWORD);

        Project project = new Project();
        project.setDescription("some description");
        project.setName("Test_iapp_Name_to_delete");
        project.setParentId("6875321");

        Project createdProject = service.createProject(WORKSPACE_ID, project);

        service.deleteProject(WORKSPACE_ID, createdProject.getId().toString());

        service.getProject(WORKSPACE_ID, createdProject.getId().toString());
    }

}
