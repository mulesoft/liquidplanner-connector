package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Folder;

public interface FolderService {

    public List<Folder> getFolders(String workSpaceId);

    public Folder getFolder(String workSpaceId, String folderId);

    public Folder createFolder(String workSpaceId, Folder folder);

}