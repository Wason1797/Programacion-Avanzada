/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.proveedores_sucursales;

import ec.edu.espe.Models.DBaccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author wason
 */
@Path("proveedor")
public class ProveedoresResource
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProveedoresResource
     */
    public ProveedoresResource()
    {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.proveedores_sucursales.ProveedoresResource
     * @return an instance of java.lang.String
     */
    
      @GET
    @Produces(MediaType.APPLICATION_JSON)
      @Path("All")
    public String getProveedores() throws SQLException
    {
       return DBaccess.GetInstance().getProveedores();
    }

    /**
     * PUT method for updating or creating an instance of ProveedoresResource
     * @param content representation for the resource
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     @Path("{id}")
    public String getProveedor(@PathParam("id") String id) throws SQLException
    {
       return DBaccess.GetInstance().getProveedorById(id);
    }
     @GET
    @Produces(MediaType.APPLICATION_JSON)
     @Path("Best")
    public String getMejorProveedor() throws SQLException
    {
       return DBaccess.GetInstance().getBestProvider();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Update/{id}")
    public String updateProvider(@PathParam("id") String id, String content) throws SQLException
    {
       return DBaccess.GetInstance().updateProvider(id, content);
    }
    @POST    
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Create")
    public void createProvider(String content)
    {
        try
        {
            DBaccess.GetInstance().setProveedor(content);
        } catch (SQLException ex)
        {
            Logger.getLogger(ProveedoresResource.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Delete/{id}")
    public void deleteProvider(@PathParam("id") String id)
    {
        try
        {
            DBaccess.GetInstance().deleteProvider(id);
        } catch (SQLException ex)
        {
            Logger.getLogger(ProveedoresResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
