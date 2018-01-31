/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.taller2avanzada;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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

    /**
     * Creates a new instance of Gps_dataResource
     */
    public Gps_dataResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.taller2avanzada.Gps_dataResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    
    public String getXml() {
        
        return "<gps_data>"
                + "<gps_id>1</gps_id>"
                + "<gps_coord>107,-40</gps_coord>"
                + "<gps_time>12:00</gps_time>"
                + "</gps_data>";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{gps_id}")
    public String getJson(@PathParam("gps_id") String codigo) {
        
        return "{\"gps_data\":{"
                + "\"gps_id\":\""+codigo+"\","
                + "\"gps_coord\":\"40,7;-70\","
                + "\"gps_time\":\"10:00\"}"
                + "}";
    }
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("sin(x)xcos(y)/{num1}/{num2}")
    public String getJson(@PathParam("num1") String nom1,@PathParam("num2") String nom2) {
        double num1=Double.parseDouble(nom1);
        double num2=Double.parseDouble(nom2);
        double result=Math.cos(num2)*Math.sin(num1);
        return "{\"sinxcos\":{"
                + "\"numero1\":\""+num1+"\","
                + "\"numero2\":\""+num2+"\","
                + "\"resultado\":\""+result+"\"}"
                + "}";
    }

    /**
     * PUT method for updating or creating an instance of Gps_dataResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)    
    public void putXml(String content) {
        System.out.println("this is the content: "+content);
    }
    @POST
    @Consumes(MediaType.APPLICATION_XML)    
    public void postXml(String content) {
        System.out.println("this is the content: "+content);
    }
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)  
    @Path("{distancia}")
    public String postJson(String content,@PathParam("distancia") String distancia) {
        String []data= content.split("@");        
        return "{\"sinxcos\":{"
                + "\"id\":\""+data[0]+"\","
                + "\"coordenada\":\""+data[1]+"\","
                + "\"distancia\":\""+distancia+"\","
                + "\"hora\":\""+data[2]+"\"}"
                + "}";
    }
}
