/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.rest;

import ec.edu.espe.models.DBAccess;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author wason
 */
@Path("Edad")
public class EdadResource
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EdadResource
     */
    public EdadResource()
    {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.rest.EdadResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml() throws SQLException
    {
        return DBAccess.GetInstance().getPerson();
    }

    /**
     * PUT method for updating or creating an instance of EdadResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putXml(String content) throws SQLException
    {
        DBAccess.GetInstance().setPerson(content);
    }
}
