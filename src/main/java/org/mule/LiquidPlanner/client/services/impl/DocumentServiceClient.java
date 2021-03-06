/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services.impl;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Folder;
import org.mule.LiquidPlanner.client.services.DocumentService;

import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.StreamDataBodyPart;

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

        String url = getURL(workSpaceId);
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

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

        String url = getURL(workSpaceId) + "/" + documentId;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

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

        String url = getURL(workSpaceId) + "/" + documentId + API_DOCUMENT_DOWNLOAD_PATH;
        WebResource.Builder builder = getBuilder(user, password, url, null);

        ClientResponse clientResponse = builder.get(ClientResponse.class);

        return clientResponse.getEntityInputStream();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.mule.LiquidPlanner.client.services.impl.PackageService#
     * createDocument (java.lang.String, java.lang.String,
     * org.mule.createDocument.client.model.Document)
     */
    @Override
    public String createDocument(String workSpaceId, ServiceEntity entity, String entityId, String fileName,
            String fileDescription, InputStream fileInputStream) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getBaseURL() + "/" + workSpaceId + entity.path() + "/" + entityId + ServiceEntity.DOCUMENT.path();

        WebResource.Builder builder = getBuilder(user, password, url, null);

        // Add headers
        builder = builder.type(MediaType.MULTIPART_FORM_DATA);

        FormDataMultiPart form = new FormDataMultiPart();
        form.field("document[file_name]", fileName);
        form.field("document[description]", fileDescription);
        form.bodyPart(new StreamDataBodyPart("document[attached_file]", fileInputStream));

        ClientResponse clientResponse = builder.post(ClientResponse.class, form);

        validateHttpStatus(clientResponse);
        String response = clientResponse.getEntity(String.class);
        return response;

        // return deserializeResponse(clientResponse, Document.class);
    }
    
    @Override
    public Document updateDocument(String workSpaceId, Document document) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + document.getId();
        return this.updateEntity(ServiceEntity.DOCUMENT.getName(), document, url);
    }
    
    @Override
    public Document deleteDocument(String workSpaceId, String id) {
        Validate.notEmpty(workSpaceId, "The workspace id can not be null nor empty.");
        Validate.notEmpty(id, "The id can not be null nor empty.");

        String url = getURL(workSpaceId) + "/" + id;
        return this.deleteEntity(url, Document.class);
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
        return getBaseURL() + "/" + workSpaceId + ServiceEntity.DOCUMENT.path();
    }

    @Override
    protected List<ClientFilter> getJerseyClientFilters() {
        List<ClientFilter> clientFilters = new ArrayList<ClientFilter>();
        clientFilters.add(new GZIPContentEncodingFilter(false));
        return clientFilters;
    }
}
