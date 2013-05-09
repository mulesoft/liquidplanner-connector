package org.mule.LiquidPlanner.client.model;

import java.util.List;


public interface ActivityService {

    public List<Activity> getActivities(String workSpaceId);

    public Activity getActivity(String workSpaceId, String activityId);

}