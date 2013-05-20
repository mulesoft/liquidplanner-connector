package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Milestone;

public interface MileStoneService {

    public List<Milestone> getMilestones(String workSpaceId);

    public Milestone getMilestone(String workSpaceId, String mileStoneId);

    public Milestone createMilestone(String workSpaceId, Milestone milestone);

    public Milestone updateMilestone(String workSpaceId, Milestone milestone);

    public Milestone deleteMilestone(String workSpaceId, String id);

}