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
import org.mule.LiquidPlanner.client.model.Milestone;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.model.Task;
import org.mule.LiquidPlanner.client.model.TreeItem;
import org.mule.LiquidPlanner.client.services.FolderService;
import org.mule.LiquidPlanner.client.services.MileStoneService;
import org.mule.LiquidPlanner.client.services.TreeItemService;
import org.mule.LiquidPlanner.client.services.impl.FolderServiceClient;
import org.mule.LiquidPlanner.client.services.impl.MilestoneServiceClient;
import org.mule.LiquidPlanner.client.services.impl.ProjectServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TaskServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TreeItemServiceClient;

public class TreeItemServiceClientTestIT extends AbstractServiceClientTestIT {

    private static final String ALERT_TYPE = "Alert";
    private static final String COMMENT_TYPE = "Comment";
    private static final String FOLDER_TYPE = "Folder";
    private static final String MILESTONE_TYPE = "Milestone";
    private static final String PROJECT_TYPE = "Project";
    private static final String TASK_TYPE = "Task";

    private static final String WORKSPACE_ID = "79456";
    private static final String PROJECT_ID = "6883656";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetTreeItems() throws JSONException, JsonParseException, JsonMappingException, IOException {
        TreeItemServiceClient service = new TreeItemServiceClient(USER, PASSWORD);
        String response = service.getTreeItems(WORKSPACE_ID);

        printOutResponse(response.toString());

    }

    @Test
    public void testGetTreeItemsForProject() throws JSONException, JsonParseException, JsonMappingException,
            IOException {
         TreeItemService service = new TreeItemServiceClient(USER, PASSWORD);
         Project response = service.getTreeItem(WORKSPACE_ID, PROJECT_ID, Project.class);
        
         printOutResponse(response.toString());
    }

    @Ignore
    @Test
    public void testDuplicateProject_1() {
        TreeItemServiceClient service = new TreeItemServiceClient(USER, PASSWORD);
        Project project = service.getTreeItem(WORKSPACE_ID, "8150475", Project.class);

        project.setId(null);
        project.setCreatedAt(null);
        project.setCreatedBy(null);
        project.setName(project.getName() + " - duplicated");

        Project newProject = new ProjectServiceClient(USER, PASSWORD).createProject(WORKSPACE_ID, project);
        duplicateChidren(project.getChildren(), newProject.getId());
    }

    private void duplicateChidren(List<TreeItem> chlidrens, String parentId) {

        MileStoneService milestoneService = new MilestoneServiceClient(USER, PASSWORD);
        TaskServiceClient taskService = new TaskServiceClient(USER, PASSWORD);
        FolderService folderService = new FolderServiceClient(USER, PASSWORD);

        for (TreeItem children : chlidrens) {

            if (children.getType().equals(FOLDER_TYPE)) {
                Folder folder = (Folder) children;

                folder.setId(null);
                folder.setParentId(new Integer(parentId));
                Folder newFolder = folderService.createFolder(WORKSPACE_ID, folder);

                this.duplicateChidren(folder.getChildren(), newFolder.getId().toString());
                continue;
            }

            if (children.getType().equals(MILESTONE_TYPE)) {
                Milestone milestone = (Milestone) children;

                milestone.setId(null);
                milestone.setParentId(new Integer(parentId));
                milestoneService.createMilestone(WORKSPACE_ID, milestone);
                continue;
            }

            if (children.getType().equals(TASK_TYPE)) {
                Task task = (Task) children;

                task.setId(null);
                task.setParentId(new Integer(parentId));
                taskService.createTask(WORKSPACE_ID, task);
                continue;
            }
        }
    }

}
