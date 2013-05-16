package org.mule.LiquidPlanner.client.services;

import java.util.List;

public interface CustomFieldService {

    public List<CustomField> getCustomFields(String workSpaceId);

    public CustomField getCustomField(String workSpaceId, String customFieldId);

    public CustomField updateCustomField(String workSpaceId, CustomField customField);

    public CustomField deleteCustomField(String workSpaceId, String id);
}