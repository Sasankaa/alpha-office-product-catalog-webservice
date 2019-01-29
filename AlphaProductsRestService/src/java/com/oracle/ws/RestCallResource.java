/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.oracle.db.ATPDBUtils;
import com.oracle.db.ATPDBUtils;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import com.oracle.cl.Product;

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
    
    @DELETE
    @Path("/{PRODUCT_ID}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteJson(@PathParam("PRODUCT_ID") int id){
         ATPDBUtils.deleteProducts(id);
         return "Successfully Deleted.";
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(Product p){
        ATPDBUtils.saveProducts(p.PRODUCT_NAME.toString(),
                Double.parseDouble(p.LIST_PRICE.toString()));
                
        return "Successfully Saved.";
    }
    /**
     * PUT method for updating or creating an instance of RestCallResource
     * @param content representation for the resource
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(Product p) {
        ATPDBUtils.updateProducts(Integer.parseInt(p.PRODUCT_ID.toString()), p.PRODUCT_NAME.toString(),
                Double.parseDouble(p.LIST_PRICE.toString()));
        return "Successfully Updated.";
    }
    
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String patchJson(Product p){
        ATPDBUtils.updateProducts(Integer.parseInt(p.PRODUCT_ID.toString()),
                Double.parseDouble(p.LIST_PRICE.toString()));
        return "Successfully Updated - Patch Operation.";
    }
    
}
