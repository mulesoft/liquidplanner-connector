package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Activity;
import org.mule.LiquidPlanner.client.services.ActivityService;
import org.mule.LiquidPlanner.client.services.impl.ActivityServiceClient;

public class ActivityServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String ACTIVITY_ID = "106347";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testActivities() throws JSONException {
        ActivityService service = new ActivityServiceClient(USER, PASSWORD);
        List<Activity> activities = service.getActivities(WORKSPACE_ID);

        printOutResponse(activities.toString());
    }

    @Test
    public void testGetActivity() throws JSONException {
        ActivityService service = new ActivityServiceClient(USER, PASSWORD);
        Activity activity = service.getActivity(WORKSPACE_ID, ACTIVITY_ID);

        printOutResponse(activity.toString());
    }

}
