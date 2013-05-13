package org.mule.LiquidPlanner.client.services;

import java.io.InputStream;
import java.util.List;

import org.mule.LiquidPlanner.client.model.Document;

public interface DocumentService {

    public List<Document> getDocuments(String workSpaceId);

    public Document getDocument(String workSpaceId, String documentId);

    public InputStream downloadDocument(String workSpaceId, String documentId);

    public Document createDocument(String workSpaceId, Document document);

}