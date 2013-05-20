/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Dependency;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Estimate;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.LPPackage;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.model.Note;

/**
 * The interface describe operations to be performed over the Package resources
 * of the LiquidPlanner API.
 * 
 * @author damiansima
 * 
 */
public interface PackageService {

    /**
     * Retrieve all the packages related to a workspace
     * 
     * @param workSpaceId
     * @filter filter
     * @return
     */
    public List<LPPackage> getPackages(String workSpaceId, List<Filter> filters);

    /**
     * Retrieve a particular package
     * 
     * @param user
     * @param password
     * @param workSpaceId
     * @param packageId
     * @return
     */
    public LPPackage getPackage(String workSpaceId, String packageId);

    /**
     * 
     * @param workSpaceId
     * @param packageId
     * @return
     */
    public List<Comment> getPackageComments(String workSpaceId, String packageId);

    /**
     * 
     * @param workSpaceId
     * @param packageId
     * @return
     */
    public List<Dependency> getPackageDependencies(String workSpaceId, String packageId);

    /**
     * 
     * @param workSpaceId
     * @param packageId
     * @return
     */
    public List<Document> getPackageDocuments(String workSpaceId, String packageId);

    /**
     * 
     * @param workSpaceId
     * @param packageId
     * @return
     */
    public List<Estimate> getPackageEstimates(String workSpaceId, String packageId);

    /**
     * 
     * @param workSpaceId
     * @param packageId
     * @return
     */
    public List<Link> getPackageLinks(String workSpaceId, String packageId);

    /**
     * 
     * @param workSpaceId
     * @param packageId
     * @return
     */
    public List<Note> getPackageNote(String workSpaceId, String packageId);

    /**
     * 
     * @param workSpaceId
     * @param aPackage
     * @return
     */
    public LPPackage createPackage(String workSpaceId, LPPackage aPackage);

    public LPPackage updatePackage(String workSpaceId, LPPackage lpPackage);

    public LPPackage deletePackage(String workSpaceId, String id);

}