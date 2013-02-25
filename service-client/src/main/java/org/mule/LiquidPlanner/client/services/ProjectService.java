package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Project;

/**
 * The interface describe operations to be performed over the Project resources
 * of the LiquidPlanner API.
 * 
 * @author damiansima
 * 
 */
public interface ProjectService {

    /**
     * Retrieve List of {@link Project}.
     * 
     * @param workSpaceId
     * @return
     */
    public List<Project> getProjects(String workSpaceId);

    /**
     * Retrieve a particular {@link Project}.
     * 
     * @param workSpaceId
     * @param projectId
     * @return
     */
    public Project getProject(String workSpaceId, String projectId);

    /**
     * Retrieve the comments related to a particular ProjectId.
     * 
     * @param workSpaceId
     * @param projectId
     * @return
     */
    public List<Comment> getProjectComments(String workSpaceId, String projectId);

    /**
     * Create a new Project.
     * 
     * @param workSpaceId
     * @return
     */
    public Project createProject(String workSpaceId, Project project);

}