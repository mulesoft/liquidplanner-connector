package org.mule.LiquidPlanner.client.core;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.services.MemberService;
import org.mule.LiquidPlanner.client.services.ProjectService;
import org.mule.LiquidPlanner.client.services.TimeSheetService;
import org.mule.LiquidPlanner.client.services.impl.MemberServiceClient;
import org.mule.LiquidPlanner.client.services.impl.ProjectServiceClient;
import org.mule.LiquidPlanner.client.services.impl.TimeSheetServiceClient;

/**
 * This is the entry point for the LiquidPlanner client.
 * 
 * @author damiansima
 * 
 */
public class LiquidPlannerClient implements ProjectService, TimeSheetService, MemberService {

    private ProjectService projectService;
    private TimeSheetService timeSheetService;
    private MemberService memberService;

    public LiquidPlannerClient(String user, String password) {
        Validate.notEmpty(user, "The user can not be null nor empty");
        Validate.notEmpty(password, "The password can not be null nor empty");

        this.projectService = new ProjectServiceClient(user, password);
        this.timeSheetService = new TimeSheetServiceClient(user, password);
        this.memberService = new MemberServiceClient(user, password);
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
    public String getMembers(String workspaceId) {
        return memberService.getMembers(workspaceId);
    }

    @Override
    public String getMember(String workspaceId, String memeberId) {
        return memberService.getMember(workspaceId, memeberId);
    }

}
