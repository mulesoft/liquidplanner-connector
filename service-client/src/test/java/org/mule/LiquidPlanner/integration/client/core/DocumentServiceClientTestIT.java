package org.mule.LiquidPlanner.integration.client.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.services.DocumentService;
import org.mule.LiquidPlanner.client.services.impl.DocumentServiceClient;

public class DocumentServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String DOCUMENT_ID = "658340";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetDocuments() throws JSONException {
        DocumentService service = new DocumentServiceClient(USER, PASSWORD);
        List<Document> documents = service.getDocuments(WORKSPACE_ID);

        printOutResponse(documents.toString());
    }

    @Test
    public void testGetDocument() throws JSONException {
        DocumentService service = new DocumentServiceClient(USER, PASSWORD);
        Document document = service.getDocument(WORKSPACE_ID, DOCUMENT_ID);

        printOutResponse(document.toString());
    }

    @Ignore
    @Test
    public void testdownloadDocument() throws JSONException, IOException {
        DocumentService service = new DocumentServiceClient(USER, PASSWORD);
        InputStream response = service.downloadDocument(WORKSPACE_ID, DOCUMENT_ID);

        File file = new File("/Users/damiansima/Documents/tmp/something.docx");
        FileOutputStream outStream = new FileOutputStream(file);
        int data = response.read();
        while (data != -1) {
            outStream.write(data);
            data = response.read();
        }
        outStream.flush();
        outStream.close();

        printOutResponse("file saved");
    }

}