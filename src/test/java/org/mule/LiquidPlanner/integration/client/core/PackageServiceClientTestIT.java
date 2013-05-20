/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.integration.client.core;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Dependency;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Estimate;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.LPPackage;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.model.Note;
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
        List<LPPackage> packages = service.getPackages(WORKSPACE_ID, new ArrayList<Filter>());
        printOutResponse(packages.toString());
    }

    @Test
    public void testGetPackage() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);
        LPPackage thePackage = service.getPackage(WORKSPACE_ID, PACKAGE_ID);
        printOutResponse(thePackage.toString());
    }

    @Test(expected = LiquidPlannerException.class)
    public void testGetPackageFail() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);
        service.getPackage(WORKSPACE_ID, "79456");
    }

    @Test
    public void testGetPackageComments() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);
        List<Comment> comments = service.getPackageComments(WORKSPACE_ID, PACKAGE_ID);
        printOutResponse(comments.toString());
    }

    @Test
    public void testGetPackageDependencies() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);
        List<Dependency> dependencies = service.getPackageDependencies(WORKSPACE_ID, "9034648");
        printOutResponse(dependencies.toString());
    }

    @Test
    public void testGetPackageDocuments() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);
        List<Document> documents = service.getPackageDocuments(WORKSPACE_ID, PACKAGE_ID);
        printOutResponse(documents.toString());
    }

    @Test
    public void testGetPackageEstimates() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);
        List<Estimate> estimates = service.getPackageEstimates(WORKSPACE_ID, PACKAGE_ID);
        printOutResponse(estimates.toString());
    }

    @Test
    public void testGetPackageLinks() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);
        List<Link> links = service.getPackageLinks(WORKSPACE_ID, PACKAGE_ID);
        printOutResponse(links.toString());
    }

    @Test(expected = LiquidPlannerException.class)
    public void testGetPackageNote() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);
        List<Note> notes = service.getPackageNote(WORKSPACE_ID, PACKAGE_ID);
        printOutResponse(notes.toString());
    }

    @Test
    public void testCreatePackage() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);

        LPPackage aPackage = new LPPackage();
        aPackage.setName("newTestPackage");
        LPPackage newPackage = service.createPackage(WORKSPACE_ID, aPackage);

        printOutResponse(newPackage.toString());
    }

    @Test
    public void testUpdatePackage() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);

        LPPackage aPackage = new LPPackage();
        aPackage.setName("newTestPackageToBeUpdated");
        aPackage = service.createPackage(WORKSPACE_ID, aPackage);

        String originalName = aPackage.getName();
        String updatedName = originalName + "[UPDATED]";

        aPackage.setName(updatedName);
        LPPackage updatedPackage = service.updatePackage(WORKSPACE_ID, aPackage);

        try {
            Assert.assertEquals("The package names should be the same", updatedName, updatedPackage.getName());
        } finally {
            service.deletePackage(WORKSPACE_ID, updatedPackage.getId().toString());

        }
    }

    @Test(expected = LiquidPlannerException.class)
    public void testDeletePackage() throws JSONException {
        PackageService service = new PackageServiceClient(USER, PASSWORD);

        LPPackage aPackage = new LPPackage();
        aPackage.setName("newTestPackageToBeDeleted");
        aPackage = service.createPackage(WORKSPACE_ID, aPackage);

        service.deletePackage(WORKSPACE_ID, aPackage.getId().toString());

        service.getPackage(WORKSPACE_ID, aPackage.getId().toString());
    }

}
