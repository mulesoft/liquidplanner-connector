package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Estimate;
import org.mule.LiquidPlanner.client.model.Link;

public interface ClientService {

    public List<Client> getClients(String workSpaceId);

    public Client getClient(String workSpaceId, String clientId);

    public List<Comment> getClientComments(String workSpaceId, String clientId);

    public List<Document> getClientDocuments(String workSpaceId, String clientId);

    public List<Estimate> getClientEstimates(String workSpaceId, String clientId);

    public Estimate getClientEstimate(String workSpaceId, String clientId, String estimateId);

    public List<Link> getClientLinks(String workSpaceId, String clientId);

    public String getClientNote(String workSpaceId, String clientId);

}