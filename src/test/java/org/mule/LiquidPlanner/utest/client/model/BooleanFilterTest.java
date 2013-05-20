package org.mule.LiquidPlanner.utest.client.model;

import org.junit.Assert;
import org.junit.Test;
import org.mule.LiquidPlanner.client.model.BooleanFilter;
import org.mule.LiquidPlanner.client.model.BooleanFilter.BooleanFilterType;
import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.IdFilter;
import org.mule.LiquidPlanner.client.model.IdFilter.IdFilterOperator;
import org.mule.LiquidPlanner.client.model.IdFilter.IdFilterType;

public class BooleanFilterTest {

    @Test
    public void testConstruction() {
        Filter filter = new BooleanFilter(BooleanFilterType.has_comments, true);
        System.out.println(filter.toString());
        Assert.assertEquals("The String representation of the filter is wrong", "has_comments is true",
                filter.toString());
    }
}
