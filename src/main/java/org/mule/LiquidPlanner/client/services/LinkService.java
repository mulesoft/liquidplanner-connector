package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Link;

public interface LinkService {

    public List<Link> getLinks(String workSpaceId);

    public Link getLink(String workSpaceId, String linkId);

    public Link createLink(String workSpaceId, Link link);

    public Link updateLink(String workSpaceId, Link link);

    public Link deleteLink(String workSpaceId, String id);

}