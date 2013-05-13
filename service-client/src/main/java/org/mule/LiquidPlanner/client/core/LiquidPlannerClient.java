package org.mule.LiquidPlanner.client.core;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Folder;
import org.mule.LiquidPlanner.client.model.Member;
import org.mule.LiquidPlanner.client.model.Milestone;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.model.Task;
import org.mule.LiquidPlanner.client.model.TreeItem;
import org.mule.LiquidPlanner.client.services.FolderService;
import org.mule.LiquidPlanner.client.services.MemberService;
import org.mule.LiquidPlanner.client.services.MileStoneService;
import org.mule.LiquidPlanner.client.services.ProjectService;
import org.mule.LiquidPlanner.client.services.TaskService;
import org.mule.LiquidPlanner.client.services.TimeSheetService;
import org.mule.LiquidPlanner.client.services.TreeItemService;
import org.mule.LiquidPlanner.client.services.impl.FolderServiceClient;
import org.mule.LiquidPlanner.client.services.impl.MemberServiceClient;
import org.mule.LiquidPlanner.client.services.impl.MilestoneServiceClient;
import org.mule.LiquidPlanner.client.services.impl.ProjectServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TaskServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TimeSheetServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TreeItemServiceClient;

/**
 * This is the entry point for the LiquidPlanner client.
 * 
 * @author damiansima
 * 
 */
public class LiquidPlannerClient implements ProjectService, TimeSheetService, MemberService, TreeItemService,
        TaskService, MileStoneService, FolderService {

    private ProjectService projectService;
    private TimeSheetService timeSheetService;
    private MemberService memberService;
    private TreeItemService treeItemService;
    private TaskService taskService;
    private MileStoneService milestoneService;
    private FolderService folderService;

    public LiquidPlannerClient(String user, String password) {
        Validate.notEmpty(user, "The user can not be null nor empty");
        Validate.notEmpty(password, "The password can not be null nor empty");

        this.projectService = new ProjectServiceClient(user, password);
        this.timeSheetService = new TimeSheetServiceClient(user, password);
        this.memberService = new MemberServiceClient(user, password);
        this.treeItemService = new TreeItemServiceClient(user, password);
        this.taskService = new TaskServiceClient(user, password);
        this.milestoneService = new MilestoneServiceClient(user, password);
        this.folderService = new FolderServiceClient(user, password);
    }

    @Override
    public String getTimeSheets(String workSpaceId, List<Filter> filters) {
        return timeSheetService.getTimeSheets(workSpaceId, filters);
    }

    @Override
    public String getTimeSheet(String workSpaceId, String timesheetId) {
        return timeSheetService.getTimeSheet(workSpaceId, timesheetId);
    }

    @Override
    public String getTimeSheetEntries(String workSpaceId, String timesheetId, List<Filter> filters) {
        return timeSheetService.getTimeSheetEntries(workSpaceId, timesheetId, filters);
    }

    @Override
    public String getTimeSheetEntry(String workSpaceId, String timesheetId, String timesheetEntryId) {
        return timeSheetService.getTimeSheetEntry(workSpaceId, timesheetId, timesheetEntryId);

    }

    @Override
    public List<Project> getProjects(String workSpaceId) {
        return projectService.getProjects(workSpaceId);
    }

    @Override
    public Project getProject(String workSpaceId, String projectId) {
        return projectService.getProject(workSpaceId, projectId);
    }

    @Override
    public List<Comment> getProjectComments(String workSpaceId, String projectId) {
        return projectService.getProjectComments(workSpaceId, projectId);
    }

    @Override
    public Project createProject(String workSpaceId, Project project) {
        return projectService.createProject(workSpaceId, project);
    }

    @Override
    public List<Member> getMembers(String workspaceId) {
        return memberService.getMembers(workspaceId);
    }

    @Override
    public Member getMember(String workspaceId, String memeberId) {
        return memberService.getMember(workspaceId, memeberId);
    }

    @Override
    public String getTreeItems(String workSpaceId) {
        return treeItemService.getTreeItems(workSpaceId);
    }

    @Override
    public <T extends TreeItem> T getTreeItem(String workSpaceId, String treeItemId, Class<T> clazz) {
        return treeItemService.getTreeItem(workSpaceId, treeItemId, clazz);
    }

    @Override
    public List<Task> getTasks(String workSpaceId, List<Filter> filters) {
        return taskService.getTasks(workSpaceId, filters);
    }

    @Override
    public Task getTask(String workSpaceId, String taskId) {
        return taskService.getTask(workSpaceId, taskId);
    }

    @Override
    public String getTimeSheets(String workSpaceId, String taskId, List<Filter> filters) {
        return taskService.getTimeSheets(workSpaceId, taskId, filters);
    }

    @Override
    public String getTimeSheet(String workSpaceId, String taskId, String timesheetId) {
        return taskService.getTimeSheet(workSpaceId, taskId, timesheetId);
    }

    @Override
    public Task createTask(String workSpaceId, Task task) {
        return taskService.createTask(workSpaceId, task);
    }

    @Override
    public List<Folder> getFolders(String workSpaceId) {
        return folderService.getFolders(workSpaceId);
    }

    @Override
    public Folder getFolder(String workSpaceId, String folderId) {
        return folderService.getFolder(workSpaceId, folderId);
    }

    @Override
    public Folder createFolder(String workSpaceId, Folder folder) {
        return folderService.createFolder(workSpaceId, folder);
    }

    @Override
    public List<Milestone> getMilestones(String workSpaceId) {
        return milestoneService.getMilestones(workSpaceId);
    }

    @Override
    public Milestone getMilestone(String workSpaceId, String mileStoneId) {
        return milestoneService.getMilestone(workSpaceId, mileStoneId);
    }

    @Override
    public Milestone createMilestone(String workSpaceId, Milestone milestone) {
        return milestoneService.createMilestone(workSpaceId, milestone);
    }
}
