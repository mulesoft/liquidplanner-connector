/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.client.model;

import org.apache.commons.lang.Validate;

public class IdFilter extends Filter {

    public static enum IdFilterType {
        client_id, created_by, owner_id, package_id, project_id, updated_by;
    }

    public static enum IdFilterOperator {
        EQUALS("="), NOT_EQUALS("!=");

        private String operator;

        private IdFilterOperator(String operator) {
            this.operator = operator;
        }

        public String value() {
            return operator;
        }

    }

    public IdFilter(IdFilterType filterType, IdFilterOperator operator, String value) {
        Validate.notNull(filterType, "The filter type can not be null");
        Validate.notNull(operator, "The operator can not be null");
        Validate.notEmpty(value, "The value can not be empty");

        this.filterType = filterType.toString();
        this.operator = operator.value();
        this.value = value;
    }
}
