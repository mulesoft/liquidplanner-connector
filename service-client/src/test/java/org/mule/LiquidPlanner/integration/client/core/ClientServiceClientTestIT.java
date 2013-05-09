package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Estimate;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.services.ClientService;
import org.mule.LiquidPlanner.client.services.impl.ClientServiceClient;

public class ClientServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String CLIENT_ID = "6870590";
    // private static final String CLIENT_ID = "6874968";

    private static final String ESTIMATE_ID = "28380425";

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetClients() throws JSONException {
        ClientService service = new ClientServiceClient(USER, PASSWORD);
        List<Client> clients = service.getClients(WORKSPACE_ID);

        printOutResponse(clients.toString());
    }

    @Test
    public void testGetClient() throws JSONException {
        ClientService service = new ClientServiceClient(USER, PASSWORD);
        Client client = service.getClient(WORKSPACE_ID, CLIENT_ID);
        printOutResponse(client.toString());
    }

    @Test
    public void testGetClientComments() throws JSONException {
        ClientService service = new ClientServiceClient(USER, PASSWORD);
        List<Comment> comments = service.getClientComments(WORKSPACE_ID, CLIENT_ID);
        printOutResponse(comments.toString());
    }

    @Test
    public void testGetDocuments() throws JSONException {
        ClientService service = new ClientServiceClient(USER, PASSWORD);
        List<Document> documents = service.getClientDocuments(WORKSPACE_ID, CLIENT_ID);
        printOutResponse(documents.toString());
    }

    @Test
    public void testGetClientEstimates() throws JSONException {
        ClientService service = new ClientServiceClient(USER, PASSWORD);
        List<Estimate> estimates = service.getClientEstimates(WORKSPACE_ID, CLIENT_ID);
        printOutResponse(estimates.toString());
    }

    @Test
    public void testGetClientEstimate() throws JSONException {
        ClientService service = new ClientServiceClient(USER, PASSWORD);
        Estimate estimate = service.getClientEstimate(WORKSPACE_ID, CLIENT_ID, ESTIMATE_ID);
        printOutResponse(estimate.toString());
    }

    @Test
    public void testGetClientLinks() throws JSONException {
        ClientService service = new ClientServiceClient(USER, PASSWORD);
        List<Link> links = service.getClientLinks(WORKSPACE_ID, CLIENT_ID);
        printOutResponse(links.toString());
    }

    @Test
    public void testGetClientNote() throws JSONException {
        ClientService service = new ClientServiceClient(USER, PASSWORD);
        String note = service.getClientNote(WORKSPACE_ID, CLIENT_ID);
        printOutResponse(note.toString());
    }

}
