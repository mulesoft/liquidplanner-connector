package org.mule.LiquidPlanner.client.serializer;

import java.lang.reflect.Type;

import org.mule.LiquidPlanner.client.model.Alert;
import org.mule.LiquidPlanner.client.model.Comment;
import org.mule.LiquidPlanner.client.model.Folder;
import org.mule.LiquidPlanner.client.model.Milestone;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.model.Task;
import org.mule.LiquidPlanner.client.model.TreeItem;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class CustomDeserializer implements JsonDeserializer {

    private static final Gson GSON = new Gson();

    private static final String ALERT_TYPE = "Alert";
    private static final String COMMENT_TYPE = "Comment";
    private static final String FOLDER_TYPE = "Folder";
    private static final String MILESTONE_TYPE = "Milestone";
    private static final String PROJECT_TYPE = "Project";
    private static final String TASK_TYPE = "Task";

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        JsonElement childrens = json.getAsJsonObject().remove("children");

        String objectType = json.getAsJsonObject().get("type").getAsString();
        TreeItem object = (TreeItem) deserializeObject(json.toString(), objectType);

        if (childrens != null) {
            JsonArray childrenArray = childrens.getAsJsonArray();
            for (JsonElement jsonElement : childrenArray) {
                Class jsonElementClazz = getTypeClass(jsonElement.getAsJsonObject().get("type").getAsString());
                TreeItem children = (TreeItem) deserialize(jsonElement, jsonElementClazz, context);

                object.getChildren().add(children);
            }
        }

        return object;
    }

    private Object deserializeObject(String json, String type) {
        return GSON.fromJson(json.toString(), getTypeClass(type));
    }

    private Class getTypeClass(String type) {

        if (type.equals(ALERT_TYPE)) {
            return Alert.class;
        }

        if (type.equals(COMMENT_TYPE)) {
            return Comment.class;
        }

        if (type.equals(FOLDER_TYPE)) {
            return Folder.class;
        }

        if (type.equals(MILESTONE_TYPE)) {
            return Milestone.class;
        }

        if (type.equals(PROJECT_TYPE)) {
            return Project.class;
        }

        if (type.equals(TASK_TYPE)) {
            return Task.class;
        }

        return TreeItem.class;
    }
}
