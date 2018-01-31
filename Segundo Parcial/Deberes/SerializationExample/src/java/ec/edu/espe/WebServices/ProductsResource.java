/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.WebServices;

import com.google.gson.Gson;
import ec.edu.espe.Models.Product;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author wason
 */
@Path("products")
public class ProductsResource
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductsResource
     */
    public ProductsResource()
    {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.WebServices.ProductsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson()
    {
        Product obj = new Product();
        Gson parser = new Gson();        
        obj.setId(1);
        obj.setName("Aspirin");
        obj.setAmmount(100);
        obj.setPrice((float) 0.57);
        obj.setTags(new String[]
        {
            "Headache", "Ache"
        });
        return parser.toJson(obj);
    }

    /**
     * PUT method for updating or creating an instance of ProductsResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content)
    {
    }
}
