
package org.mule.modules.config;

import javax.annotation.Generated;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/liquidplanner</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.0", date = "2013-05-17T06:10:37-03:00", comments = "Build 3.4.0.1555.8df15c1")
public class LiquidplannerNamespaceHandler
    extends NamespaceHandlerSupport
{


    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        registerBeanDefinitionParser("config", new LiquidPlannerConnectorConfigDefinitionParser());
        registerBeanDefinitionParser("get-timesheets", new GetTimesheetsDefinitionParser());
        registerBeanDefinitionParser("get-timesheet", new GetTimesheetDefinitionParser());
        registerBeanDefinitionParser("get-timesheet-entries", new GetTimesheetEntriesDefinitionParser());
        registerBeanDefinitionParser("get-timesheet-entry", new GetTimesheetEntryDefinitionParser());
        registerBeanDefinitionParser("get-members", new GetMembersDefinitionParser());
        registerBeanDefinitionParser("get-member", new GetMemberDefinitionParser());
        registerBeanDefinitionParser("get-projects", new GetProjectsDefinitionParser());
        registerBeanDefinitionParser("get-project", new GetProjectDefinitionParser());
        registerBeanDefinitionParser("get-project-comments", new GetProjectCommentsDefinitionParser());
        registerBeanDefinitionParser("create-project", new CreateProjectDefinitionParser());
        registerBeanDefinitionParser("get-tree-items", new GetTreeItemsDefinitionParser());
        registerBeanDefinitionParser("duplicate-project", new DuplicateProjectDefinitionParser());
        registerBeanDefinitionParser("update-project", new UpdateProjectDefinitionParser());
        registerBeanDefinitionParser("delete-project", new DeleteProjectDefinitionParser());
        registerBeanDefinitionParser("get-tasks", new GetTasksDefinitionParser());
        registerBeanDefinitionParser("get-task", new GetTaskDefinitionParser());
        registerBeanDefinitionParser("create-task", new CreateTaskDefinitionParser());
        registerBeanDefinitionParser("update-task", new UpdateTaskDefinitionParser());
        registerBeanDefinitionParser("delete-task", new DeleteTaskDefinitionParser());
        registerBeanDefinitionParser("get-task-timesheets", new GetTaskTimesheetsDefinitionParser());
        registerBeanDefinitionParser("get-task-timesheet", new GetTaskTimesheetDefinitionParser());
        registerBeanDefinitionParser("get-clients", new GetClientsDefinitionParser());
        registerBeanDefinitionParser("get-client", new GetClientDefinitionParser());
        registerBeanDefinitionParser("get-client-comments", new GetClientCommentsDefinitionParser());
        registerBeanDefinitionParser("get-client-documents", new GetClientDocumentsDefinitionParser());
        registerBeanDefinitionParser("get-client-estimates", new GetClientEstimatesDefinitionParser());
        registerBeanDefinitionParser("get-client-estimate", new GetClientEstimateDefinitionParser());
        registerBeanDefinitionParser("get-client-links", new GetClientLinksDefinitionParser());
        registerBeanDefinitionParser("get-client-note", new GetClientNoteDefinitionParser());
        registerBeanDefinitionParser("create-client", new CreateClientDefinitionParser());
        registerBeanDefinitionParser("update-client", new UpdateClientDefinitionParser());
        registerBeanDefinitionParser("delete-client", new DeleteClientDefinitionParser());
        registerBeanDefinitionParser("get-custom-fields", new GetCustomFieldsDefinitionParser());
        registerBeanDefinitionParser("get-custom-field", new GetCustomFieldDefinitionParser());
        registerBeanDefinitionParser("get-comments", new GetCommentsDefinitionParser());
        registerBeanDefinitionParser("get-comment", new GetCommentDefinitionParser());
        registerBeanDefinitionParser("create-comment", new CreateCommentDefinitionParser());
        registerBeanDefinitionParser("update-comment", new UpdateCommentDefinitionParser());
        registerBeanDefinitionParser("delete-comment", new DeleteCommentDefinitionParser());
        registerBeanDefinitionParser("get-events", new GetEventsDefinitionParser());
        registerBeanDefinitionParser("get-event", new GetEventDefinitionParser());
        registerBeanDefinitionParser("get-event-check-list-items", new GetEventCheckListItemsDefinitionParser());
        registerBeanDefinitionParser("get-event-comments", new GetEventCommentsDefinitionParser());
        registerBeanDefinitionParser("get-event-documents", new GetEventDocumentsDefinitionParser());
        registerBeanDefinitionParser("get-event-links", new GetEventLinksDefinitionParser());
        registerBeanDefinitionParser("get-event-timesheet-entries", new GetEventTimesheetEntriesDefinitionParser());
        registerBeanDefinitionParser("create-event", new CreateEventDefinitionParser());
        registerBeanDefinitionParser("update-event", new UpdateEventDefinitionParser());
        registerBeanDefinitionParser("delete-event", new DeleteEventDefinitionParser());
        registerBeanDefinitionParser("get-links", new GetLinksDefinitionParser());
        registerBeanDefinitionParser("get-link", new GetLinkDefinitionParser());
        registerBeanDefinitionParser("create-link", new CreateLinkDefinitionParser());
        registerBeanDefinitionParser("update-link", new UpdateLinkDefinitionParser());
        registerBeanDefinitionParser("delete-link", new DeleteLinkDefinitionParser());
        registerBeanDefinitionParser("get-milestones", new GetMilestonesDefinitionParser());
        registerBeanDefinitionParser("get-milestone", new GetMilestoneDefinitionParser());
        registerBeanDefinitionParser("create-milestone", new CreateMilestoneDefinitionParser());
        registerBeanDefinitionParser("update-milestone", new UpdateMilestoneDefinitionParser());
        registerBeanDefinitionParser("delete-milestone", new DeleteMilestoneDefinitionParser());
        registerBeanDefinitionParser("get-packages", new GetPackagesDefinitionParser());
        registerBeanDefinitionParser("get-package", new GetPackageDefinitionParser());
        registerBeanDefinitionParser("get-package-comments", new GetPackageCommentsDefinitionParser());
        registerBeanDefinitionParser("get-package-dependencies", new GetPackageDependenciesDefinitionParser());
        registerBeanDefinitionParser("get-package-documents", new GetPackageDocumentsDefinitionParser());
        registerBeanDefinitionParser("get-package-estimates", new GetPackageEstimatesDefinitionParser());
        registerBeanDefinitionParser("get-package-links", new GetPackageLinksDefinitionParser());
        registerBeanDefinitionParser("get-package-note", new GetPackageNoteDefinitionParser());
        registerBeanDefinitionParser("create-package", new CreatePackageDefinitionParser());
        registerBeanDefinitionParser("update-package", new UpdatePackageDefinitionParser());
        registerBeanDefinitionParser("delete-package", new DeletePackageDefinitionParser());
        registerBeanDefinitionParser("get-folders", new GetFoldersDefinitionParser());
        registerBeanDefinitionParser("get-folder", new GetFolderDefinitionParser());
        registerBeanDefinitionParser("create-folder", new CreateFolderDefinitionParser());
        registerBeanDefinitionParser("update-folder", new UpdateFolderDefinitionParser());
        registerBeanDefinitionParser("delete-folder", new DeleteFolderDefinitionParser());
        registerBeanDefinitionParser("get-activities", new GetActivitiesDefinitionParser());
        registerBeanDefinitionParser("get-activity", new GetActivityDefinitionParser());
        registerBeanDefinitionParser("get-documents", new GetDocumentsDefinitionParser());
        registerBeanDefinitionParser("get-document", new GetDocumentDefinitionParser());
        registerBeanDefinitionParser("download-document", new DownloadDocumentDefinitionParser());
        registerBeanDefinitionParser("create-document", new CreateDocumentDefinitionParser());
        registerBeanDefinitionParser("delete-document", new DeleteDocumentDefinitionParser());
        registerBeanDefinitionParser("get-work-spaces", new GetWorkSpacesDefinitionParser());
        registerBeanDefinitionParser("get-workspace", new GetWorkspaceDefinitionParser());
        registerBeanDefinitionParser("get-check-list-items", new GetCheckListItemsDefinitionParser());
        registerBeanDefinitionParser("get-check-list-item", new GetCheckListItemDefinitionParser());
    }

}
