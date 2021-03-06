/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Document;
import org.mule.LiquidPlanner.client.model.Estimate;
import org.mule.LiquidPlanner.client.model.Link;
import org.mule.LiquidPlanner.client.model.Note;

public interface ClientService {

    public List<Client> getClients(String workSpaceId);

    public Client getClient(String workSpaceId, String clientId);

    public List<Comment> getClientComments(String workSpaceId, String clientId);

    public List<Document> getClientDocuments(String workSpaceId, String clientId);

    public List<Estimate> getClientEstimates(String workSpaceId, String clientId);

    public Estimate getClientEstimate(String workSpaceId, String clientId, String estimateId);

    public List<Link> getClientLinks(String workSpaceId, String clientId);

    public Note getClientNote(String workSpaceId, String clientId);

    public Client createClient(String workSpaceId, Client client);

    public Client updateClient(String workSpaceId, Client client);

    public Client deleteClient(String workSpaceId, String id);

}