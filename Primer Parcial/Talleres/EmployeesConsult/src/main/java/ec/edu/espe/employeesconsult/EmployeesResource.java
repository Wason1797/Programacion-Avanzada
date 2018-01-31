/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.employeesconsult;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author wason
 */
@Path("Employees")
public class EmployeesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmployeesResource
     */
    public EmployeesResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.employeesconsult.EmployeesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getEmployee(@PathParam("id") String codigo) throws SQLException {
        //TODO return proper representation object
     Employee obj= DBConnection.GetInstance().getEmployee(codigo);    
            return obj.toString();
    }

    /**
     * PUT method for updating or creating an instance of EmployeesResource
     * @param content representation for the resource
     */
      @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Relatives/Birthdays/{month}")
    public String getRelative(@PathParam("month") String mes) throws SQLException {
        //TODO return proper representation object
     ArrayList<Relative> obj= DBConnection.GetInstance().getRelative(mes);    
     String resultb="", results="",resulta="";
     for(Relative item:obj)
     {
         resultb+=item.toString()+",";
     }
         resulta=resultb.substring(0, resultb.length()-2);
     results="["+resulta+"]";
      return results;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
