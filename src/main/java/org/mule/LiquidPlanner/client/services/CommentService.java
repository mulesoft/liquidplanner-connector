/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Comment;

public interface CommentService {

    public List<Comment> getComments(String workSpaceId);

    public Comment getComment(String workSpaceId, String commentId);

    public Comment createComment(String workSpaceId, Comment comment);

    public Comment updateComment(String workSpaceId, Comment comment);

    public Comment deleteComment(String workSpaceId, String commentId);

}