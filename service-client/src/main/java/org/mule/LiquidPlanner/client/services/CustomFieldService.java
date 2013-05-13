package org.mule.LiquidPlanner.client.services;

import java.util.List;

public interface CustomFieldService {

    public List<CustomField> getCustomFields(String workSpaceId);

    public CustomField getCustomField(String workSpaceId, String customFieldId);

    public CustomField createCuatomField(String workSpaceId, CustomField customField);

}