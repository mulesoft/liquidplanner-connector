package org.mule.LiquidPlanner.client.services;

import java.util.List;

import org.mule.LiquidPlanner.client.model.Filter;
import org.mule.LiquidPlanner.client.model.LPPackage;

/**
 * The interface describe operations to be performed over the Package resources
 * of the LiquidPlanner API.
 * 
 * @author damiansima
 * 
 */
public interface PackageService {

    /**
     * Retrieve all the packages related to a workspace
     * 
     * @param workSpaceId
     * @filter filter
     * @return
     */
    public List<LPPackage> getPackages(String workSpaceId, List<Filter> filters);

    /**
     * Retrieve a particular package
     * 
     * @param user
     * @param password
     * @param workSpaceId
     * @param packageId
     * @return
     */
    public LPPackage getPackage(String workSpaceId, String packageId);

}