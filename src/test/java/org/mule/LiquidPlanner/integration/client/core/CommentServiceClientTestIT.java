package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import junit.framework.Assert;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.services.CommentService;
import org.mule.LiquidPlanner.client.services.impl.ClientServiceClient;
import org.mule.LiquidPlanner.client.services.impl.CommentServiceClient;

public class CommentServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String COMMENT_ID = "2147273";

    private Comment aComment;

    @Before
    public void setUp() {
        aComment = new Comment();
        aComment.setComment("Some Valid Comment to be deleted or updated");
        aComment.setType(ServiceEntity.COMMENT.getName());
        aComment.setPersonId(260403);
        aComment.setItemId(9034648);
        aComment.setMemberId(260403);

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetComments() throws JSONException {
        CommentService service = new CommentServiceClient(USER, PASSWORD);
        List<Comment> comments = service.getComments(WORKSPACE_ID);

        printOutResponse(comments.toString());
    }

    @Test
    public void testGetComment() throws JSONException {
        CommentService service = new CommentServiceClient(USER, PASSWORD);
        Comment comment = service.getComment(WORKSPACE_ID, COMMENT_ID);
        printOutResponse(comment.toString());
    }

    @Test
    public void testCreateComment() throws JSONException {
        CommentService service = new CommentServiceClient(USER, PASSWORD);

        Comment aComment = new Comment();
        aComment.setComment("Some Valid Comment");
        aComment.setType(ServiceEntity.COMMENT.getName());
        aComment.setPersonId(260403);
        aComment.setItemId(9034648);
        aComment.setMemberId(260403);

        Comment comment = service.createComment(WORKSPACE_ID, aComment);
        printOutResponse(comment.toString());
    }

    @Test
    public void testUpdateComment() throws JSONException {
        CommentService service = new CommentServiceClient(USER, PASSWORD);

        Comment newComment = service.createComment(WORKSPACE_ID, aComment);

        String newCommentText = newComment.getComment() + "[UPDATED]";

        newComment.setComment(newCommentText);

        Comment comment = service.updateComment(WORKSPACE_ID, newComment);

        printOutResponse(comment.toString());

        try {
            Assert.assertEquals("The comments should be the same", newCommentText, comment.getComment());
        } finally {
            service.deleteComment(WORKSPACE_ID, comment.getId().toString());
        }

    }

    @Test(expected = LiquidPlannerException.class)
    public void testDeleteComment() throws JSONException {
        CommentService service = new CommentServiceClient(USER, PASSWORD);

        Comment newComment = service.createComment(WORKSPACE_ID, aComment);

        Comment comment = service.deleteComment(WORKSPACE_ID, newComment.getId().toString());

        printOutResponse(comment.toString());

        service.getComment(WORKSPACE_ID, newComment.getId().toString());

    }

}
