/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Dependency;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Estimate;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.LPPackage;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.model.Note;
import org.mule.LiquidPlanner.client.services.PackageService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

public class PackageServiceClient extends AbstractServiceClient implements PackageService {

    private static final String API_MOVE_AFTER_PATH = "/move_after";
    private static final String API_MOVE_BEFORE_PATH = "/move_before";
    private static final String API_TRACK_TIME_PATH = "/track_time";
    private static final String API_SNAPSHOT_PATH = "/snapshots";

    public PackageServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.PackageService#getPackages
     * (java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<LPPackage> getPackages(String workSpaceId, List<Filter> filters) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, filterListToMap(filters));

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<LPPackage>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.PackageService#getPackage
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public LPPackage getPackage(String workSpaceId, String packageId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(packageId, "The package id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + packageId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return deserializeResponse(clientResponse, LPPackage.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.PackageService#getPackageComments
     * (java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<Comment> getPackageComments(String workSpaceId, String packageId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(packageId, "The package id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + packageId + ServiceEntity.COMMENT.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        Type type = new TypeToken<List<Comment>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * getPackageDependencies (java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public List<Dependency> getPackageDependencies(String workSpaceId, String packageId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(packageId, "The package id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + packageId + ServiceEntity.DEPENDENCY.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Dependency>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * getPackageDocuments (java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public List<Document> getPackageDocuments(String workSpaceId, String packageId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(packageId, "The package id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + packageId + ServiceEntity.DOCUMENT.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Document>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * getPackageEstimates (java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public List<Estimate> getPackageEstimates(String workSpaceId, String packageId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(packageId, "The package id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + packageId + ServiceEntity.ESTIMATE.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Estimate>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * getPackageLinks (java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<Link> getPackageLinks(String workSpaceId, String packageId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(packageId, "The package id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + packageId + ServiceEntity.LINK.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Link>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * getPackageNotes (java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<Note> getPackageNote(String workSpaceId, String packageId) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(packageId, "The package id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + packageId + ServiceEntity.NOTE.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Note>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * createPackage (java.lang.String, java.lang.String,
     * org.mule.LiquidPLanner.client.model.LPPackage)
     */
    @Override
    public LPPackage createPackage(String workSpaceId, LPPackage aPackage) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId);
        return this.createEntity(ServiceEntity.PACKAGE.getName(), aPackage, url);
    }
    
    
    public LPPackage updatePackage(String workSpaceId, LPPackage lpPackage) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + lpPackage.getId();
        return this.updateEntity(ServiceEntity.PACKAGE.getName(), lpPackage, url);
    }

    public LPPackage deletePackage(String workSpaceId, String id) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(id, "The id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + id;
        return this.deleteEntity(url, LPPackage.class);
    }
    

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + ServiceEntity.WORKSPACE.path();
    }

    @Override
    protected ClientConfig getJerseyClientConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    private String getURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.PACKAGE.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }

}
