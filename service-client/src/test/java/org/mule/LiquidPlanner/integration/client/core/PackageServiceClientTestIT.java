package org.mule.LiquidPlanner.integration.client.core;

import java.util.ArrayList;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.services.PackageService;
import org.mule.LiquidPlanner.client.services.impl.PackageServiceClient;

public class PackageServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String PACKAGE_ID = "6875321";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetPackages() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);
        String response = service.getPackages(WORKSPACE_ID, new ArrayList<Filter>());

        printOutResponse(response);

    }

    @Test
    public void testGetPackage() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);
        String response = service.getPackage(WORKSPACE_ID, PACKAGE_ID);

        printOutResponse(response);
    }

}
