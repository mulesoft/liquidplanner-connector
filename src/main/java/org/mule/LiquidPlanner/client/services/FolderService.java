/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Folder;

public interface FolderService {

    public List<Folder> getFolders(String workSpaceId);

    public Folder getFolder(String workSpaceId, String folderId);

    public Folder createFolder(String workSpaceId, Folder folder);

    public Folder updateFolder(String workSpaceId, Folder folder);

    public Folder deleteFolder(String workSpaceId, String id);

}