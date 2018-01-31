/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.personapi;

import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
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
@Path("consultapi")
public class PersonResource {

    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.personapi.PersonResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("persona/{persona_id}")
    
    public String getJson(@PathParam("persona_id") String id) throws SQLException {
           
            Person obj= DBConnection.GetInstance().getPerson(id);    
            return obj.toString();
    }
   @POST
    @Consumes(MediaType.APPLICATION_JSON)    
    @Path("newperson")
    public void postJson(String content)  throws SQLException{
        String aux = content.replace('{', '!');
        aux = aux.replace('}', ' ');
        //aux=aux.replace(',', ' ');
        aux = aux.replace(']', ' ');
        aux = aux.replace('[', ' ');
        aux = aux.replace('"', ' ');
        aux = aux.replace(" ", "");
        String[] contenido = aux.split("!");
        String name,lastname,birthdate;
        String[] contenido1 = contenido[2].split(",");
        String[] contenido2 = contenido1[0].split(":");
        name=contenido2[1];
        contenido2 = contenido1[1].split(":");
        lastname=contenido2[1];
        contenido2 = contenido1[2].split(":");
        birthdate=contenido2[1];
        
        Person persona=new Person();
        persona.setName(name);
        persona.setLastName(lastname);
        persona.setDate(birthdate);
        
       DBConnection.GetInstance().setPerson(persona);        
    }    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)   
    @Path("updateperson/{persona_id}")
    public void putJson(String content,@PathParam("persona_id") String id)  throws SQLException{
        String aux = content.replace('{', '!');
        aux = aux.replace('}', ' ');
        //aux=aux.replace(',', ' ');
        aux = aux.replace(']', ' ');
        aux = aux.replace('[', ' ');
        aux = aux.replace('"', ' ');
        aux = aux.replace(" ", "");
        String[] contenido = aux.split("!");
        String name,lastname,birthdate;
        String[] contenido1 = contenido[2].split(",");
        String[] contenido2 = contenido1[0].split(":");
        name=contenido2[1];
        contenido2 = contenido1[1].split(":");
        lastname=contenido2[1];
        contenido2 = contenido1[2].split(":");
        birthdate=contenido2[1];        
        Person persona=new Person();
        persona.setName(name);
        persona.setLastName(lastname);
        persona.setDate(birthdate);        
       DBConnection.GetInstance().UPerson(persona,id);       
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deletepersona/{persona_id}")    
    public String deleteJson(@PathParam("persona_id") String id) throws SQLException {
           
            Person obj= DBConnection.GetInstance().deletePerson(id);    
            return obj.toString();
    }

}
