/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.utest.client.model;

import org.junit.Assert;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.IdFilter;
import org.mule.LiquidPlanner.client.model.IdFilter.IdFilterOperator;
import org.mule.LiquidPlanner.client.model.IdFilter.IdFilterType;

public class IdFilterTest {

    @Test
    public void testConstruction() {
        Filter filter = new IdFilter(IdFilterType.project_id, IdFilterOperator.EQUALS, "666");
        Assert.assertEquals("The String representation of the filter is wrong", "project_id=666", filter.toString());
    }
}
