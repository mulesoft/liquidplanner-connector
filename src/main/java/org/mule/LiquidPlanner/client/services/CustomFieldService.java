/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.services;

import java.util.List;

public interface CustomFieldService {

    public List<CustomField> getCustomFields(String workSpaceId);

    public CustomField getCustomField(String workSpaceId, String customFieldId);
}