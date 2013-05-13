package org.mule.LiquidPlanner.client.services.impl;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.core.ServicePath;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.LPPackage;
import org.mule.LiquidPlanner.client.services.DocumentService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

/**
 * Provide access to all the document's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class DocumentServiceClient extends AbstractServiceClient implements DocumentService {

    private static final String API_DOCUMENT_DOWNLOAD_PATH = "/download";
    private static final String API_DOCUMENT_THUMBNAIL_PATH = "/thumbnail";

    public DocumentServiceClient(String user, String password) {
        super(user, password);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.DocumentService#getDocuments
     * (java.lang.String)
     */
    @Override
    public List<Document> getDocuments(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getDocumentBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        Type type = new TypeToken<List<Document>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.DocumentService#getDocument
     * (java.lang.String, java.lang.String)
     */
    @Override
    public Document getDocument(String workSpaceId, String documentId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(documentId, "The document id should not be null nor empty");

        String url = getDocumentBaseURL(workSpaceId) + "/" + documentId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return deserializeResponse(clientResponse, Document.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.mule.LiquidPlanner.client.services.impl.DocumentService#downloadDocument
     * (java.lang.String, java.lang.String)
     */
    @Override
    public InputStream downloadDocument(String workSpaceId, String documentId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(documentId, "The document id should not be null nor empty");

        String url = getDocumentBaseURL(workSpaceId) + "/" + documentId + API_DOCUMENT_DOWNLOAD_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);
        validateHttpStatus(clientResponse);

        return clientResponse.getEntityInputStream();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * createPackage (java.lang.String, java.lang.String,
     * org.mule.createDocument.client.model.Document)
     */
    @Override
    public Document createDocument(String workSpaceId, Document document) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getDocumentBaseURL(workSpaceId);
        return this.createEntity(ServiceEntity.DOCUMENT.getName(), document, url);
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

    private String getDocumentBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + ServicePath.DOCUMENT.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }
}
