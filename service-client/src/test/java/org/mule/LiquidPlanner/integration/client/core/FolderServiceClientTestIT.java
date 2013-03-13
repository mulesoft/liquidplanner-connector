package org.mule.LiquidPlanner.integration.client.core;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Folder;
import org.mule.LiquidPlanner.client.services.FolderService;
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
}
