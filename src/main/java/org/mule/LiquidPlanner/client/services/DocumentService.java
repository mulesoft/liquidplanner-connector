/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services;

import java.io.InputStream;
import java.util.List;

import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Document;

public interface DocumentService {

    public List<Document> getDocuments(String workSpaceId);

    public Document getDocument(String workSpaceId, String documentId);

    public InputStream downloadDocument(String workSpaceId, String documentId);

    public String createDocument(String workSpaceId, ServiceEntity entity, String entityId, String fileName,
            String fileDescription, InputStream fileInputStream);

    public Document updateDocument(String workSpaceId, Document document);

    public Document deleteDocument(String workSpaceId, String id);

}