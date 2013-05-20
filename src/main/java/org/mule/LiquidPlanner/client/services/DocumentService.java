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

    public Document deleteDocument(String workSpaceId, String id);

}