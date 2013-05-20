/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.LiquidPlanner.integration.client.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractServiceClientTestIT {
    private static final String LP_USER_KEY = "lp.user";
    private static final String LP_PASSWORD_KEY = "lp.password";

    protected static String USER;
    protected static String PASSWORD;

    public AbstractServiceClientTestIT() {
        Properties properties = new Properties();
        InputStream stream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("test_credentials.properties");

        try {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        USER = properties.getProperty(LP_USER_KEY);
        PASSWORD = properties.getProperty(LP_PASSWORD_KEY);
    }

    protected void printOutResponse(String response) {
        System.out.println(response);
    }

}
