/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

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