package org.mule.LiquidPlanner.client.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.security.KeyStore.Builder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.mule.LiquidPlanner.client.exception.LiquidPlannerException;
import org.mule.LiquidPlanner.client.model.ErrorMessage;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.Folder;
import org.mule.LiquidPlanner.client.model.LPPackage;
import org.mule.LiquidPlanner.client.model.Milestone;
import org.mule.LiquidPlanner.client.model.Project;
import org.mule.LiquidPlanner.client.model.Task;
import org.mule.LiquidPlanner.client.model.TreeItem;
import org.mule.LiquidPlanner.client.serializer.CustomDeserializer;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * Base class for all the service client in this project. The class handles:
 * 
 * <b> base URL creation, creation of the Jersey client, set up of basic
 * authentication headers, read of files from input streams, string
 * serialization of the responses</b>
 * 
 * @author damiansima
 * 
 */
public abstract class AbstractServiceClient {

    private static final String DEFAULT_BASE_URL = "https://app.liquidplanner.com/api";
    // protected static final ObjectMapper MAPPER = new ObjectMapper();

    protected String user;
    protected String password;
    private String baseUrl = "";

    protected Gson mapper;

    public AbstractServiceClient(String user, String password) {
        Validate.notEmpty(user, "The user can not be null nor empty");
        Validate.notEmpty(password, "The password can not be null nor empty");

        this.user = user;
        this.password = password;

        GsonBuilder gsonBuilder = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .serializeNulls();

        CustomDeserializer deserializer = new CustomDeserializer();
        gsonBuilder.registerTypeAdapter(TreeItem.class, deserializer);
        gsonBuilder.registerTypeAdapter(Folder.class, deserializer);
        gsonBuilder.registerTypeAdapter(Milestone.class, deserializer);
        gsonBuilder.registerTypeAdapter(LPPackage.class, deserializer);
        gsonBuilder.registerTypeAdapter(Project.class, deserializer);
        gsonBuilder.registerTypeAdapter(Task.class, deserializer);
        mapper = gsonBuilder.create();
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Builds the base URL for this service.
     * 
     * @return the base URL with no final "/".
     */
    protected String getBaseURL() {
        StringBuilder baseUrlBuilder = new StringBuilder(100);

        if (StringUtils.isNotEmpty(baseUrl)) {
            baseUrlBuilder.append(this.baseUrl);
        } else {
            baseUrlBuilder.append(DEFAULT_BASE_URL);
        }

        return extendGetBaseUrl(baseUrlBuilder.toString());
    }

    /**
     * This method is called by getBaseURL for the user to extend the base URL
     * of its ServiceClient implementation.
     * 
     * @param baseUrl
     *            the URL created by getBaseURL
     * @return the enhanced base URL
     */
    protected abstract String extendGetBaseUrl(String baseUrl);

    /**
     * Creates a {@link Builder}
     * 
     * @param url
     *            the URL to be hit by the client
     * @param queryParameters
     *            a map containing all the query parameters
     * @return the builder.
     */
    protected WebResource.Builder getBuilder(String user, String password, String url,
            Map<String, String> queryParameters) {

        ClientConfig clientConfig = getJerseyClientConfiguration();

        Client client = null;
        if (clientConfig == null) {
            client = Client.create();
        } else {
            client = Client.create(clientConfig);
        }

        client.addFilter(getBasicAuthenticationFilter(user, password));

        List<ClientFilter> clientFilters = getJerseyClientFilters();
        if (clientFilters != null) {
            for (ClientFilter clientFilter : clientFilters) {
                client.addFilter(clientFilter);
            }
        }

        WebResource wr = client.resource(url);

        MultivaluedMap<String, String> actualQueryParameters = mapToMultivaluedMap(queryParameters);

        if (actualQueryParameters.isEmpty()) {
            return wr.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);
        } else {
            return wr.queryParams(actualQueryParameters).type(MediaType.APPLICATION_JSON_TYPE)
                    .accept(MediaType.APPLICATION_JSON_TYPE);
        }
    }

    /**
     * This method is called by getBuilder before the creation of the
     * {@link Client}. The {@link ClientConfig} is used to create the
     * {@link Client}.
     * 
     * @return null if there are {@link ClientConfig} to be added.
     */
    protected abstract ClientConfig getJerseyClientConfiguration();

    /**
     * This method is called by getBuilder before the creation of the
     * {@link Client}. The {@link ClientFilter} is used to create the
     * {@link Client}. If there are no {@link ClientFilter} to be added just
     * return null.
     * 
     * @return null if there are no {@link ClientFilter} to be added.
     */
    protected abstract List<ClientFilter> getJerseyClientFilters();

    /**
     * Creates a {@link HTTPBasicAuthFilter} for HTTP basic authentication.
     * 
     * @param user
     * @param password
     * @return a {@link HTTPBasicAuthFilter} to be added to the {@link Client}
     */
    private HTTPBasicAuthFilter getBasicAuthenticationFilter(String user, String password) {
        return new HTTPBasicAuthFilter(user, password);
    }

    /**
     * Transform a map in a {@link MultivaluedMap} which is needed by Jersey to
     * send query parameters. It also validate that not empty parameters are
     * being send.
     * 
     * @param map
     *            the map of query parameters
     * @return the same map in an {@link MultivaluedMap} object.
     */
    protected MultivaluedMap<String, String> mapToMultivaluedMap(Map<String, String> map) {
        MultivaluedMap<String, String> multivaluedMap = new MultivaluedMapImpl();

        if (map != null && !map.isEmpty()) {
            for (String key : map.keySet()) {
                multivaluedMap.add(key, map.get(key));
            }
        }

        return multivaluedMap;
    }

    protected String readResponseFromClientResponse(ClientResponse clientResponse) {

        return readInputStreamToString(clientResponse.getEntityInputStream());
    }

    protected String getFileContentInBase64(InputStream inputStream) {
        return new String(Base64.encodeBase64(readInputStreamToString(inputStream).getBytes()));
    }

    protected String readInputStreamToString(InputStream inputStream) {
        try {
            return IOUtils.toString(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Wraps the filter into a map that can be use as a parameter map for the
     * request.
     * 
     * @param filters
     * @return null if the filter is null
     */
    protected Map<String, String> filterListToMap(List<Filter> filters) {

        String filter_id_patter = "<filter_id>";
        String filter_param_key = "filter[" + filter_id_patter + "]";

        Map<String, String> filterMap = new HashMap<String, String>();

        for (Filter filter : filters) {
            String key = filter_param_key.replaceAll(filter_id_patter, filter.getFilterType());
            filterMap.put(key, filter.toString());
        }

        return filterMap.isEmpty() ? null : filterMap;
    }

    protected <T extends TreeItem> T deserializeResponse(ClientResponse clientResponse, Class<T> clazz) {
        validateHttpStatus(clientResponse);
        String response = clientResponse.getEntity(String.class);

        try {
            return mapper.fromJson(response, clazz);
        } catch (Exception e) {
            throw new LiquidPlannerException("There has been an error when de deseralizing the response: " + response,
                    e);
        }
    }

    protected <T> T deserializeResponse(ClientResponse clientResponse, Type type) {
        validateHttpStatus(clientResponse);
        String response = clientResponse.getEntity(String.class);

        try {
            return mapper.fromJson(response, type);
        } catch (Exception e) {
            throw new LiquidPlannerException("There has been an error when de deseralizing the response: " + response,
                    e);
        }
    }

    protected <T extends TreeItem> T createEntity(String entityType, T entity, String url) {
        Map<String, Object> payloadMap = new HashMap<String, Object>();
        payloadMap.put(entityType, entity);

        String payload;
        try {
            payload = mapper.toJson(payloadMap);
        } catch (Exception e) {
            throw new LiquidPlannerException("There has been an error when serializing the project to json", e);
        }

        WebResource.Builder builder = getBuilder(user, password, url, null);
        ClientResponse clientResponse = builder.post(ClientResponse.class, payload);

        return (T) this.deserializeResponse(clientResponse, entity.getClass());
    }

    /**
     * Throws exception when the status is greater than 400. It knows how to
     * build the error and deserialize the status response.
     * 
     * @param clientResponse
     */
    protected void validateHttpStatus(ClientResponse clientResponse) {
        if (clientResponse.getStatus() >= 400) {
            String response = clientResponse.getEntity(String.class);
            try {
                ErrorMessage errorMessage = mapper.fromJson(response, ErrorMessage.class);
                throw new LiquidPlannerException("There has been an error when invoking the API: "
                        + errorMessage.getType() + ":" + errorMessage.getMessage());
            } catch (JsonSyntaxException e) {
                throw new LiquidPlannerException("There has been an error when de deseralizing the response: "
                        + response, e);
            }

        }
    }
}
