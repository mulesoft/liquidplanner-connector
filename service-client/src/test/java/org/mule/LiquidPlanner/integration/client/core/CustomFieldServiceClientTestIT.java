package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import junit.framework.Assert;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.services.CustomField;
import org.mule.LiquidPlanner.client.services.CustomFieldService;
import org.mule.LiquidPlanner.client.services.impl.CustomFieldServiceClient;

public class CustomFieldServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String CUSTOM_FIELD_ID = "5517";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetCustomFields() throws JSONException {
        CustomFieldService service = new CustomFieldServiceClient(USER, PASSWORD);
        List<CustomField> checklistItems = service.getCustomFields(WORKSPACE_ID);

        printOutResponse(checklistItems.toString());
    }

    @Test
    public void testGetCustomField() throws JSONException {
        CustomFieldService service = new CustomFieldServiceClient(USER, PASSWORD);
        CustomField customField = service.getCustomField(WORKSPACE_ID, CUSTOM_FIELD_ID);

        printOutResponse(customField.toString());
    }

}
