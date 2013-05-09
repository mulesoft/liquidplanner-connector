package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.services.impl.LinkServiceClient;

public class LinkServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String LINK_ID = "89434";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetLinks() throws JSONException {
        LinkServiceClient service = new LinkServiceClient(USER, PASSWORD);
        List<Link> links = service.getLinks(WORKSPACE_ID);

        printOutResponse(links.toString());
    }

    @Test
    public void testGetLink() throws JSONException {
        LinkServiceClient service = new LinkServiceClient(USER, PASSWORD);
        Link link = service.getLink(WORKSPACE_ID, LINK_ID);

        printOutResponse(link.toString());
    }

}