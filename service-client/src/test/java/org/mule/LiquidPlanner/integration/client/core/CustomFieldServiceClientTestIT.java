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

    // @Ignore
    // @Test
    // public void testCreateCustomField() throws JSONException {
    // CustomFieldService service = new CustomFieldServiceClient(USER,
    // PASSWORD);
    //
    // CustomField aCustomField = new CustomField();
    // aCustomField.setCategory("project");
    // aCustomField.setName("Sima NEW custom field");
    // aCustomField.setType(ServiceEntity.CUSTOM_FIELD.getName());
    //
    // CustomField customField = service.createCuatomField(WORKSPACE_ID,
    // aCustomField);
    //
    // printOutResponse(customField.toString());
    // }

    @Test
    public void testUpdateCustomField() throws JSONException {
        CustomFieldService service = new CustomFieldServiceClient(USER, PASSWORD);
        CustomField customField = service.getCustomField(WORKSPACE_ID, CUSTOM_FIELD_ID);

        String originalName = customField.getName();
        String updatedName = originalName + "[UPDATED]";
        customField.setName(updatedName);

        CustomField updatedCustomField = service.updateCustomField(WORKSPACE_ID, customField);

        Assert.assertEquals("The name of the custom field should be the same", updatedName,
                updatedCustomField.getName());

        customField.setName(originalName);
        service.updateCustomField(WORKSPACE_ID, customField);

        // printOutResponse(customField.toString());
    }

}
