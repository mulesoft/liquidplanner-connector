/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import junit.framework.Assert;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.services.LinkService;
import org.mule.LiquidPlanner.client.services.impl.LinkServiceClient;

public class LinkServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String LINK_ID = "89434";

    private Link aLink;

    @Before
    public void setUp() {
        aLink = new Link();
        aLink.setType(ServiceEntity.LINK.getName());
        aLink.setDescription("A test link to be deleted or updated");
        aLink.setItem_id(9034648);
        aLink.setUrl("http://www.fakesite.com");
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetLinks() throws JSONException {
        LinkService service = new LinkServiceClient(USER, PASSWORD);
        List<Link> links = service.getLinks(WORKSPACE_ID);

        printOutResponse(links.toString());
    }

    @Test
    public void testGetLink() throws JSONException {
        LinkService service = new LinkServiceClient(USER, PASSWORD);
        Link link = service.getLink(WORKSPACE_ID, LINK_ID);

        printOutResponse(link.toString());
    }

    @Test
    public void testCreateLink() throws JSONException {
        LinkService service = new LinkServiceClient(USER, PASSWORD);
        Link aLink = new Link();
        aLink.setType(ServiceEntity.LINK.getName());
        aLink.setDescription("A test link");
        aLink.setItem_id(9034648);
        aLink.setUrl("http://www.fakesite.com");

        Link link = service.createLink(WORKSPACE_ID, aLink);

        printOutResponse(link.toString());
    }

    @Test
    public void testUpdateLink() throws JSONException {
        LinkService service = new LinkServiceClient(USER, PASSWORD);

        Link newLink = service.createLink(WORKSPACE_ID, aLink);

        String newLinkdescription = newLink.getDescription() + "[UPDATED]";

        newLink.setDescription(newLinkdescription);

        Link link = service.updateLink(WORKSPACE_ID, newLink);

        printOutResponse(link.toString());

        try {
            Assert.assertEquals("The names should be the same", newLinkdescription, link.getDescription());
        } finally {
            service.deleteLink(WORKSPACE_ID, link.getId().toString());
        }

    }

    @Test(expected = LiquidPlannerException.class)
    public void testDeleteLink() throws JSONException {
        LinkService service = new LinkServiceClient(USER, PASSWORD);

        Link newLink = service.createLink(WORKSPACE_ID, aLink);

        service.deleteLink(WORKSPACE_ID, newLink.getId().toString());

        service.getLink(WORKSPACE_ID, newLink.getId().toString());

    }

}
