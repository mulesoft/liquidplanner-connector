package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Workspace;

public interface WorkspaceService {

    public List<Workspace> getWorkSpaces();

    public Workspace getComment(String workSpaceId);

}