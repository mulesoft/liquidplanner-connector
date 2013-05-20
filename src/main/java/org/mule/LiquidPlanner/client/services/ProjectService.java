/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

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

    public Project updateProject(String workSpaceId, Project project);

    public Project deleteProject(String workSpaceId, String id);

}