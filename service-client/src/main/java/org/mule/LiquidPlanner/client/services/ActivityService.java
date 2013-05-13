package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Activity;

public interface ActivityService {

    public List<Activity> getActivities(String workSpaceId);

    public Activity getActivity(String workSpaceId, String activityId);

    public Activity createActivity(String workSpaceId, Activity activity);

}