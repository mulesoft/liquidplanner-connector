package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Comment;

public interface CommentService {

    public List<Comment> getComments(String workSpaceId);

    public Comment getComment(String workSpaceId, String commentId);

    public Comment createComment(String workSpaceId, Comment comment);
}