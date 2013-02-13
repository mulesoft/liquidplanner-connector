package org.mule.LiquidPlanner.integration.client.core;

import junit.framework.Assert;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.services.AccountService;
import org.mule.LiquidPlanner.client.services.impl.AccountServiceClient;

public class AccountServiceClientTestIT extends AbstractServiceClientTestIT {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetAccountDetails() throws JSONException {
        AccountService service = new AccountServiceClient(USER, PASSWORD);
        String response = service.getAccountDetails();

        printOutResponse(response);

        JSONObject jsObject = new JSONObject(response);
        Assert.assertEquals("The account email is wrong.", "damian.sima@mulesoft.com", jsObject.get("email"));
        Assert.assertEquals("The account name is wrong.", "Damian", jsObject.get("user_name"));

        JSONObject workspace = new JSONObject(jsObject.getJSONArray("workspaces").get(0).toString());
        Assert.assertEquals("The workspace id is wrong.", "79456", workspace.get("id").toString());
        Assert.assertEquals("The workspace name is wrong.", "Mulesoft", workspace.get("name"));

    }

    @Test
    @Ignore
    public void testGetAccountDetailsFail() throws JSONException {
        AccountService service = new AccountServiceClient("fakeUser", PASSWORD);
        String response = service.getAccountDetails();

        printOutResponse(response);
        JSONObject jsObject = new JSONObject(response);

    }
}
