package org.mule.LiquidPlanner.utest.client.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.LiquidPlanner.client.core.LiquidPlannerClient;

public class LiquidPlannerClientTest {
    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testConstruction() throws InterruptedException {

        List<Callable<Void>> callables = new ArrayList<Callable<Void>>();

        for (int i = 0; i < 10; i++) {
            Callable creator = new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    new LiquidPlannerClient("user", "password");
                    return null;
                }

            };
            callables.add(creator);
        }
        ExecutorService es = Executors.newCachedThreadPool();
        es.invokeAll(callables);

    }
}
