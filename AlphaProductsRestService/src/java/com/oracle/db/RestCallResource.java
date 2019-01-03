/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.db;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.oracle.db.ATPDBUtils;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author sasanka
 */
@Path("restCall")
public class RestCallResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestCallResource
     */
    public RestCallResource() {
    }

    /**
     * Retrieves representation of an instance of com.oracle.db.RestCallResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return ATPDBUtils.getProducts().toJSONString();
    }
    @GET
    @Path("/{PRODUCT_ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("PRODUCT_ID") int id){
        return ATPDBUtils.getProducts(id).toJSONString();
    }
    

    /**
     * PUT method for updating or creating an instance of RestCallResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
