package org.mule.LiquidPlanner.client.core;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.model.Activity;
import org.mule.LiquidPlanner.client.model.CheckListItem;
import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Dependency;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Estimate;
import org.mule.LiquidPlanner.client.model.Event;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Folder;
import org.mule.LiquidPlanner.client.model.LPPackage;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.model.Member;
import org.mule.LiquidPlanner.client.model.Milestone;
import org.mule.LiquidPlanner.client.model.Note;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.model.Task;
import org.mule.LiquidPlanner.client.model.Timesheet;
import org.mule.LiquidPlanner.client.model.TimesheetEntry;
import org.mule.LiquidPlanner.client.model.TreeItem;
import org.mule.LiquidPlanner.client.model.Workspace;
import org.mule.LiquidPlanner.client.services.ActivityService;
import org.mule.LiquidPlanner.client.services.CheckListItemService;
import org.mule.LiquidPlanner.client.services.ClientService;
import org.mule.LiquidPlanner.client.services.CommentService;
import org.mule.LiquidPlanner.client.services.CustomField;
import org.mule.LiquidPlanner.client.services.CustomFieldService;
import org.mule.LiquidPlanner.client.services.DocumentService;
import org.mule.LiquidPlanner.client.services.EventService;
import org.mule.LiquidPlanner.client.services.FolderService;
import org.mule.LiquidPlanner.client.services.LinkService;
import org.mule.LiquidPlanner.client.services.MemberService;
import org.mule.LiquidPlanner.client.services.MileStoneService;
import org.mule.LiquidPlanner.client.services.PackageService;
import org.mule.LiquidPlanner.client.services.ProjectService;
import org.mule.LiquidPlanner.client.services.TaskService;
import org.mule.LiquidPlanner.client.services.TimesheetEntryService;
import org.mule.LiquidPlanner.client.services.TimesheetService;
import org.mule.LiquidPlanner.client.services.TreeItemService;
import org.mule.LiquidPlanner.client.services.WorkspaceService;
import org.mule.LiquidPlanner.client.services.impl.ActivityServiceClient;
import org.mule.LiquidPlanner.client.services.impl.CheckListItemServiceClient;
import org.mule.LiquidPlanner.client.services.impl.ClientServiceClient;
import org.mule.LiquidPlanner.client.services.impl.CommentServiceClient;
import org.mule.LiquidPlanner.client.services.impl.CustomFieldServiceClient;
import org.mule.LiquidPlanner.client.services.impl.DocumentServiceClient;
import org.mule.LiquidPlanner.client.services.impl.EventServiceClient;
import org.mule.LiquidPlanner.client.services.impl.FolderServiceClient;
import org.mule.LiquidPlanner.client.services.impl.LinkServiceClient;
import org.mule.LiquidPlanner.client.services.impl.MemberServiceClient;
import org.mule.LiquidPlanner.client.services.impl.MilestoneServiceClient;
import org.mule.LiquidPlanner.client.services.impl.PackageServiceClient;
import org.mule.LiquidPlanner.client.services.impl.ProjectServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TaskServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TimesheetEntryServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TimesheetServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TreeItemServiceClient;
import org.mule.LiquidPlanner.client.services.impl.WorkspaceServiceClient;

/**
 * This is the entry point for the LiquidPlanner client.
 * 
 * @author damiansima
 * 
 */
public class LiquidPlannerClient implements ProjectService, TimesheetService, TimesheetEntryService, MemberService,
        TreeItemService, TaskService, MileStoneService, FolderService, ClientService, EventService, CustomFieldService,
        LinkService, PackageService, ActivityService, DocumentService, WorkspaceService, CheckListItemService,
        CommentService {

    private ProjectService projectService;
    private TimesheetService timesheetService;
    private TimesheetEntryService timesheetEntryService;
    private MemberService memberService;
    private TreeItemService treeItemService;
    private TaskService taskService;
    private MileStoneService milestoneService;
    private FolderService folderService;
    private ClientService clientService;
    private EventService eventService;
    private CustomFieldService customFieldService;
    private LinkService linkService;
    private PackageService packageService;
    private ActivityService activityService;
    private DocumentService documentService;
    private WorkspaceService workspaceService;
    private CheckListItemService checkListItemService;
    private CommentService commentService;

    public LiquidPlannerClient(String user, String password) {
        Validate.notEmpty(user, "The user can not be null nor empty");
        Validate.notEmpty(password, "The password can not be null nor empty");

        this.projectService = new ProjectServiceClient(user, password);
        this.timesheetService = new TimesheetServiceClient(user, password);
        this.timesheetEntryService = new TimesheetEntryServiceClient(user, password);
        this.memberService = new MemberServiceClient(user, password);
        this.treeItemService = new TreeItemServiceClient(user, password);
        this.taskService = new TaskServiceClient(user, password);
        this.milestoneService = new MilestoneServiceClient(user, password);
        this.folderService = new FolderServiceClient(user, password);
        this.clientService = new ClientServiceClient(user, password);
        this.eventService = new EventServiceClient(user, password);
        this.customFieldService = new CustomFieldServiceClient(user, password);
        this.linkService = new LinkServiceClient(user, password);
        this.packageService = new PackageServiceClient(user, password);
        this.activityService = new ActivityServiceClient(user, password);
        this.documentService = new DocumentServiceClient(user, password);
        this.workspaceService = new WorkspaceServiceClient(user, password);
        this.checkListItemService = new CheckListItemServiceClient(user, password);
        this.commentService = new CommentServiceClient(user, password);
    }

    @Override
    public List<Timesheet> getTimesheets(String workSpaceId, List<Filter> filters) {
        return timesheetService.getTimesheets(workSpaceId, filters);
    }

    @Override
    public Timesheet getTimesheet(String workSpaceId, String timesheetId) {
        return timesheetService.getTimesheet(workSpaceId, timesheetId);
    }

    @Override
    public List<TimesheetEntry> getTimesheetEntries(String workSpaceId, List<Filter> filters) {
        return timesheetEntryService.getTimesheetEntries(workSpaceId, filters);
    }

    @Override
    public TimesheetEntry getTimesheetEntry(String workSpaceId, String timesheetEntryId) {
        return timesheetEntryService.getTimesheetEntry(workSpaceId, timesheetEntryId);

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
    public List<Timesheet> getTaskTimesheets(String workSpaceId, String taskId, List<Filter> filters) {
        return taskService.getTaskTimesheets(workSpaceId, taskId, filters);
    }

    @Override
    public Timesheet getTaskTimesheet(String workSpaceId, String taskId, String timesheetId) {
        return taskService.getTaskTimesheet(workSpaceId, taskId, timesheetId);
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

    @Override
    public Folder updateFolder(String workSpaceId, Folder folder) {
        return folderService.updateFolder(workSpaceId, folder);
    }

    @Override
    public Folder deleteFolder(String workSpaceId, String id) {
        return folderService.deleteFolder(workSpaceId, id);
    }

    @Override
    public Milestone updateMilestone(String workSpaceId, Milestone milestone) {
        return milestoneService.updateMilestone(workSpaceId, milestone);
    }

    @Override
    public Milestone deleteMilestone(String workSpaceId, String id) {
        return milestoneService.deleteMilestone(workSpaceId, id);
    }

    @Override
    public Task updateTask(String workSpaceId, Task task) {
        return taskService.updateTask(workSpaceId, task);
    }

    @Override
    public Task deleteTask(String workSpaceId, String taskId) {
        return taskService.deleteTask(workSpaceId, taskId);
    }

    @Override
    public Project updateProject(String workSpaceId, Project project) {
        return projectService.updateProject(workSpaceId, project);
    }

    @Override
    public Project deleteProject(String workSpaceId, String id) {
        return projectService.deleteProject(workSpaceId, id);
    }

    @Override
    public List<Client> getClients(String workSpaceId) {
        return clientService.getClients(workSpaceId);
    }

    @Override
    public Client getClient(String workSpaceId, String clientId) {
        return clientService.getClient(workSpaceId, clientId);
    }

    @Override
    public List<Comment> getClientComments(String workSpaceId, String clientId) {
        return clientService.getClientComments(workSpaceId, clientId);
    }

    @Override
    public List<Document> getClientDocuments(String workSpaceId, String clientId) {
        return clientService.getClientDocuments(workSpaceId, clientId);
    }

    @Override
    public List<Estimate> getClientEstimates(String workSpaceId, String clientId) {
        return clientService.getClientEstimates(workSpaceId, clientId);
    }

    @Override
    public Estimate getClientEstimate(String workSpaceId, String clientId, String estimateId) {
        return clientService.getClientEstimate(workSpaceId, clientId, estimateId);
    }

    @Override
    public List<Link> getClientLinks(String workSpaceId, String clientId) {
        return clientService.getClientLinks(workSpaceId, clientId);
    }

    @Override
    public Note getClientNote(String workSpaceId, String clientId) {
        return clientService.getClientNote(workSpaceId, clientId);
    }

    @Override
    public Client createClient(String workSpaceId, Client client) {
        return clientService.createClient(workSpaceId, client);
    }

    @Override
    public Client updateClient(String workSpaceId, Client client) {
        return clientService.updateClient(workSpaceId, client);
    }

    @Override
    public Client deleteClient(String workSpaceId, String id) {
        return clientService.deleteClient(workSpaceId, id);
    }

    @Override
    public List<Event> getEvents(String workSpaceId) {
        return eventService.getEvents(workSpaceId);
    }

    @Override
    public Event getEvent(String workSpaceId, String eventId) {
        return eventService.getEvent(workSpaceId, eventId);
    }

    @Override
    public List<CheckListItem> getEventCheckListItems(String workSpaceId, String eventId) {
        return eventService.getEventCheckListItems(workSpaceId, eventId);
    }

    @Override
    public List<Comment> getEventComments(String workSpaceId, String eventId) {
        return eventService.getEventComments(workSpaceId, eventId);
    }

    @Override
    public List<Document> getEventDocuments(String workSpaceId, String eventId) {
        return eventService.getEventDocuments(workSpaceId, eventId);
    }

    @Override
    public List<Link> getEventLinks(String workSpaceId, String eventId) {
        return eventService.getEventLinks(workSpaceId, eventId);
    }

    @Override
    public List<TimesheetEntry> getEventTimesheetEntries(String workSpaceId, String eventId) {
        return eventService.getEventTimesheetEntries(workSpaceId, eventId);
    }

    @Override
    public Event createEvent(String workSpaceId, Event event) {
        return eventService.createEvent(workSpaceId, event);
    }

    @Override
    public Event updateEvent(String workSpaceId, Event event) {
        return eventService.updateEvent(workSpaceId, event);
    }

    @Override
    public Event deleteEvent(String workSpaceId, String commentId) {
        return eventService.deleteEvent(workSpaceId, commentId);
    }

    @Override
    public List<CustomField> getCustomFields(String workSpaceId) {
        return customFieldService.getCustomFields(workSpaceId);
    }

    @Override
    public CustomField getCustomField(String workSpaceId, String customFieldId) {
        return customFieldService.getCustomField(workSpaceId, customFieldId);
    }

    @Override
    public List<Link> getLinks(String workSpaceId) {
        return linkService.getLinks(workSpaceId);
    }

    @Override
    public Link getLink(String workSpaceId, String linkId) {
        return linkService.getLink(workSpaceId, linkId);
    }

    @Override
    public Link createLink(String workSpaceId, Link link) {
        return linkService.createLink(workSpaceId, link);
    }

    @Override
    public Link updateLink(String workSpaceId, Link link) {
        return linkService.updateLink(workSpaceId, link);
    }

    @Override
    public Link deleteLink(String workSpaceId, String id) {
        return linkService.deleteLink(workSpaceId, id);
    }

    @Override
    public List<LPPackage> getPackages(String workSpaceId, List<Filter> filters) {
        return packageService.getPackages(workSpaceId, filters);
    }

    @Override
    public LPPackage getPackage(String workSpaceId, String packageId) {
        return packageService.getPackage(workSpaceId, packageId);
    }

    @Override
    public List<Comment> getPackageComments(String workSpaceId, String packageId) {
        return packageService.getPackageComments(workSpaceId, packageId);
    }

    @Override
    public List<Dependency> getPackageDependencies(String workSpaceId, String packageId) {
        return packageService.getPackageDependencies(workSpaceId, packageId);
    }

    @Override
    public List<Document> getPackageDocuments(String workSpaceId, String packageId) {
        return packageService.getPackageDocuments(workSpaceId, packageId);
    }

    @Override
    public List<Estimate> getPackageEstimates(String workSpaceId, String packageId) {
        return packageService.getPackageEstimates(workSpaceId, packageId);
    }

    @Override
    public List<Link> getPackageLinks(String workSpaceId, String packageId) {
        return packageService.getPackageLinks(workSpaceId, packageId);
    }

    @Override
    public List<Note> getPackageNote(String workSpaceId, String packageId) {
        return packageService.getPackageNote(workSpaceId, packageId);
    }

    @Override
    public LPPackage createPackage(String workSpaceId, LPPackage aPackage) {
        return packageService.createPackage(workSpaceId, aPackage);
    }

    @Override
    public LPPackage updatePackage(String workSpaceId, LPPackage lpPackage) {
        return packageService.updatePackage(workSpaceId, lpPackage);
    }

    @Override
    public LPPackage deletePackage(String workSpaceId, String id) {
        return packageService.deletePackage(workSpaceId, id);
    }

    @Override
    public List<Activity> getActivities(String workSpaceId) {
        return activityService.getActivities(workSpaceId);
    }

    @Override
    public Activity getActivity(String workSpaceId, String activityId) {
        return activityService.getActivity(workSpaceId, activityId);
    }

    @Override
    public List<Document> getDocuments(String workSpaceId) {
        return documentService.getDocuments(workSpaceId);
    }

    @Override
    public Document getDocument(String workSpaceId, String documentId) {
        return documentService.getDocument(workSpaceId, documentId);
    }

    @Override
    public InputStream downloadDocument(String workSpaceId, String documentId) {
        return documentService.downloadDocument(workSpaceId, documentId);
    }

    @Override
    public String createDocument(String workSpaceId, ServiceEntity entity, String entityId, String fileName,
            String fileDescription, InputStream fileInputStream) {
        return documentService
                .createDocument(workSpaceId, entity, entityId, fileName, fileDescription, fileInputStream);
    }

    @Override
    public Document deleteDocument(String workSpaceId, String id) {
        return documentService.deleteDocument(workSpaceId, id);
    }

    @Override
    public List<Workspace> getWorkSpaces() {
        return workspaceService.getWorkSpaces();
    }

    @Override
    public Workspace getWorkspace(String workSpaceId) {
        return workspaceService.getWorkspace(workSpaceId);
    }

    @Override
    public List<CheckListItem> getCheckListItems(String workSpaceId) {
        return checkListItemService.getCheckListItems(workSpaceId);
    }

    @Override
    public CheckListItem getCheckListItem(String workSpaceId, String checkListItemId) {
        return checkListItemService.getCheckListItem(workSpaceId, checkListItemId);
    }

    @Override
    public List<Comment> getComments(String workSpaceId) {
        return commentService.getComments(workSpaceId);
    }

    @Override
    public Comment getComment(String workSpaceId, String commentId) {
        return commentService.getComment(workSpaceId, commentId);
    }

    @Override
    public Comment createComment(String workSpaceId, Comment comment) {
        return commentService.createComment(workSpaceId, comment);
    }

    @Override
    public Comment updateComment(String workSpaceId, Comment comment) {
        return commentService.updateComment(workSpaceId, comment);
    }

    @Override
    public Comment deleteComment(String workSpaceId, String commentId) {
        return commentService.deleteComment(workSpaceId, commentId);
    }

}
