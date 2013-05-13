package org.mule.LiquidPlanner.client.services.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServicePath;
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

public class PackageServiceClient extends AbstractServiceClient implements PackageService {
    // private static final String API_WORKSPACE_PATH = "/workspaces";
    // private static final String API_PACKAGE_PATH = "/packages";

    private static final String API_MOVE_AFTER_PATH = "/move_after";
    private static final String API_MOVE_BEFORE_PATH = "/move_before";
    private static final String API_TRACK_TIME_PATH = "/track_time";
    // private static final String API_DEPENDENCY_PATH = "/dependencies";
    // private static final String API_COMMENT_PATH = "/comments";
    private static final String API_DOCUMENT_PATH = "/documents";
    private static final String API_ESTIMATE_PATH = "/estimates";
    private static final String API_LINK_PATH = "/links";
    private static final String API_NOTE_PATH = "/note";
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

        String url = getTimesheetBaseURL(workSpaceId);
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

        String url = getTimesheetBaseURL(workSpaceId) + "/" + packageId;
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

        String url = getTimesheetBaseURL(workSpaceId) + "/" + packageId + ServicePath.COMMENT.path();
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

        String url = getTimesheetBaseURL(workSpaceId) + "/" + packageId + ServicePath.DEPENDENCY.path();
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

        String url = getTimesheetBaseURL(workSpaceId) + "/" + packageId + ServicePath.DOCUMENT.path();
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

        String url = getTimesheetBaseURL(workSpaceId) + "/" + packageId + ServicePath.ESTIMATE.path();
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

        String url = getTimesheetBaseURL(workSpaceId) + "/" + packageId + ServicePath.LINK.path();
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

        String url = getTimesheetBaseURL(workSpaceId) + "/" + packageId + ServicePath.NOTE.path();
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Note>>() {
        }.getType();
        return deserializeResponse(clientResponse, type);
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + ServicePath.WORKSPACE.path();
    }

    @Override
    protected ClientConfig getJerseyClientConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    private String getTimesheetBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServicePath.PACKAGE.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        // TODO Auto-generated method stub
        return null;
    }

}
