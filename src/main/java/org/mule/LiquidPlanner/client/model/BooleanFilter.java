/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.model;

import org.apache.commons.lang.Validate;

public class BooleanFilter extends Filter {

    private static final String BOOLEAN_FILTER_OPERATOR = " is ";

    public static enum BooleanFilterType {
        has_alert, has_an_activity, has_comments, has_dependencies, has_documents, has_reference, is_done, is_in_a_project, is_on_hold, is_packaged, is_shared, needs_update;
    }

    public BooleanFilter(BooleanFilterType filterType, Boolean value) {
        Validate.notNull(filterType, "The filter type can not be null");
        Validate.notNull(value, "The value can not be empty");

        this.filterType = filterType.toString();
        this.operator = BOOLEAN_FILTER_OPERATOR;
        this.value = value.toString();
    }
}
