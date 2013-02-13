package org.mule.LiquidPlanner.client.services;

/**
 * The interface describe operations to be performed over the Project resources
 * of the LiquidPlanner API.
 * 
 * @author damiansima
 * 
 */
public interface ProjectService {

    /**
     * Retrieve List of projects.
     * 
     * @param workSpaceId
     * @return
     */
    public String getProjects(String workSpaceId);

    /**
     * Retrieve a particular project.
     * 
     * @param workSpaceId
     * @param projectId
     * @return
     */
    public String getProject(String workSpaceId, String projectId);

}