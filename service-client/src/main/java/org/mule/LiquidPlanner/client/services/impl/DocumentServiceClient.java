package org.mule.LiquidPlanner.client.services.impl;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.services.DocumentService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;

/**
 * Provide access to all the document's related operations in LiquidPlanner.
 * 
 * @author damiansima
 * 
 */
public class DocumentServiceClient extends AbstractServiceClient implements DocumentService {
    private static final String API_WORKSPACE_PATH = "/workspaces";
    private static final String API_DOCUMENT_PATH = "/documents";

    private static final String API_DOCUMENT_DOWNLOAD_PATH = "/download";
    private static final String API_DOCUMENT_THUMBNAIL_PATH = "/thumbnail";

    public DocumentServiceClient(String user, String password) {
        super(user, password);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.DocumentService#getDocuments(java.lang.String)
     */
    @Override
    public List<Document> getDocuments(String workSpaceId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        Type type = new TypeToken<List<Document>>() {
        }.getType();

        return deserializeResponse(clientResponse, type);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.DocumentService#getDocument(java.lang.String, java.lang.String)
     */
    @Override
    public Document getDocument(String workSpaceId, String documentId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(documentId, "The document id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + documentId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return deserializeResponse(clientResponse, Document.class);
    }

    /* (non-Javadoc)
     * @see org.mule.LiquidPlanner.client.services.impl.DocumentService#downloadDocument(java.lang.String, java.lang.String)
     */
    @Override
    public InputStream downloadDocument(String workSpaceId, String documentId) {
        Validate.notEmpty(workSpaceId, "The workspace id should not be null nor empty");
        Validate.notEmpty(documentId, "The document id should not be null nor empty");

        String url = getMemeberBaseURL(workSpaceId) + "/" + documentId + API_DOCUMENT_DOWNLOAD_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return clientResponse.getEntityInputStream();
    }

    @Override
    protected String extendGetBaseUrl(String baseUrl) {
        return baseUrl + API_WORKSPACE_PATH;
    }

    @Override
    protected ClientConfig getJerseyClientConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    private String getMemeberBaseURL(String workSpaceId) {
        return getBaseURL() + "/" + workSpaceId + API_DOCUMENT_PATH;
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        // TODO Auto-generated method stub
        return null;
    }
}
