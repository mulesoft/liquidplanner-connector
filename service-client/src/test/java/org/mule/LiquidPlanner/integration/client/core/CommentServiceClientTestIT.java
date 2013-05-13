package org.mule.LiquidPlanner.integration.client.core;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.LiquidPlanner.client.core.ServiceEntity;
import org.mule.LiquidPlanner.client.model.Client;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.services.CommentService;
import org.mule.LiquidPlanner.client.services.impl.ClientServiceClient;
import org.mule.LiquidPlanner.client.services.impl.CommentServiceClient;

public class CommentServiceClientTestIT extends AbstractServiceClientTestIT {
    private static final String WORKSPACE_ID = "79456";
    private static final String COMMENT_ID = "2147273";

    @Before
    public void setUp() {

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

    @Ignore
    @Test
    public void testCreateComment() throws JSONException {
        CommentService service = new CommentServiceClient(USER, PASSWORD);

        Comment aComment = new Comment();
        aComment.setComment("Some Valid Comment");
        aComment.setType(ServiceEntity.COMMENT.getName());
        aComment.setPersonId(260403);

        Comment comment = service.createComment(WORKSPACE_ID, aComment);
        printOutResponse(comment.toString());
    }

}
