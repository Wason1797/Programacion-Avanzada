/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.taller3avanzada;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author wason
 */
@Path("gps_data")
public class Gps_dataResource {

    @Context
    private UriInfo context;
    private static ArrayList<String>jsonStrings;

    /**
     * Creates a new instance of Gps_dataResource
     */
    public Gps_dataResource() {
        jsonStrings= new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            jsonStrings.add("{\"gps_data\":{"
                + "\"gps_id\":\""+i+"\","
                + "\"gps_coord\":\""+(i*10)+";"+(i*100)+"\","
                + "\"gps_time\":\""+i+":00\"}"
                + "}");
        }
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.taller3avanzada.Gps_dataResource
     * @return an instance of java.lang.String
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{gps_id}")
    public String getJson(@PathParam("gps_id") String codigo) {
        
        return jsonStrings.get(Integer.parseInt(codigo));
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)    
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        jsonStrings.add(content);
        System.out.println("this is the put content: "+content);
        return content;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)    
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{gps_id}")
    public String postJson(@PathParam("gps_id") String codigo,String content) {
        int i= Integer.parseInt(codigo);
     
        jsonStrings.set(i, content);
        System.out.println("this is the post content: "+content);
        return content;
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{gps_id}")    
     public String deleteJson(@PathParam("gps_id") String codigo) {
        String json =jsonStrings.get(Integer.parseInt(codigo));
        jsonStrings.remove(Integer.parseInt(codigo));
        System.out.println("Datos a Borrar: "+json);
        return json ;
    }
    
    
    
    
    
}
