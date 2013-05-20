package org.mule.LiquidPlanner.integration.client.core;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.Event;
import org.mule.LiquidPlanner.client.model.Folder;
import org.mule.LiquidPlanner.client.services.EventService;
import org.mule.LiquidPlanner.client.services.FolderService;
import org.mule.LiquidPlanner.client.services.impl.EventServiceClient;
import org.mule.LiquidPlanner.client.services.impl.FolderServiceClient;

public class FolderServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String FOLDER_ID = "6913824";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetFolders() throws JSONException, JsonParseException, JsonMappingException, IOException {
        FolderService service = new FolderServiceClient(USER, PASSWORD);
        List<Folder> response = service.getFolders(WORKSPACE_ID);

        printOutResponse(response.toString());

    }

    @Test
    public void testGetFolder() throws JSONException, JsonParseException, JsonMappingException, IOException {
        FolderService service = new FolderServiceClient(USER, PASSWORD);
        Folder response = service.getFolder(WORKSPACE_ID, FOLDER_ID);

        printOutResponse(response.toString());

    }

    @Ignore
    @Test
    public void testCreateFolder() {
        FolderService service = new FolderServiceClient(USER, PASSWORD);
        Folder response = service.getFolder(WORKSPACE_ID, FOLDER_ID);

        response.setId(null);
        response.setParentId(new Integer("8152840"));

        Folder newFolder = service.createFolder(WORKSPACE_ID, response);

        printOutResponse(newFolder.toString());
    }
    
    @Ignore
    @Test
    public void testUpdateFolder() throws JSONException {
        FolderService service = new FolderServiceClient(USER, PASSWORD);

        Folder aFolder = service.getFolder(WORKSPACE_ID, "9070766");
        aFolder.setId(null);
        aFolder.setParentId(new Integer("9070764"));
        Folder newFolder = service.createFolder(WORKSPACE_ID, aFolder);

        String newFolderName = newFolder.getName() + "[UPDATED]";
        newFolder.setName(newFolderName);
        Folder folder = service.updateFolder(WORKSPACE_ID, newFolder);

        printOutResponse(folder.toString());

        try {
            Assert.assertEquals("The names should be the same", newFolderName, folder.getName());
        } finally {
            service.deleteFolder(WORKSPACE_ID, folder.getId().toString());
        }

    }

    @Test(expected = LiquidPlannerException.class)
    public void testDeleteFoldernt() throws JSONException {
        FolderService service = new FolderServiceClient(USER, PASSWORD);

        Folder aFolder = service.getFolder(WORKSPACE_ID, "9070766");
        aFolder.setId(null);
        aFolder.setParentId(new Integer("9070764"));

        Folder newFolder = service.createFolder(WORKSPACE_ID, aFolder);

        Folder folder = service.deleteFolder(WORKSPACE_ID, newFolder.getId().toString());

        printOutResponse(folder.toString());

        service.getFolder(WORKSPACE_ID, newFolder.getId().toString());

    }
}

