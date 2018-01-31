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
@Path("sucursal")
public class SucursalesResource
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SucursalesResource
     */
    public SucursalesResource()
    {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.proveedores_sucursales.SucursalesResource
     * @return an instance of java.lang.String
    @GET
    @Produces(MediaType.APPLICATION_JSON)
      @Path("all")
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
    public String getSucursal(@PathParam("id") String id) throws SQLException
    {
       return DBaccess.GetInstance().getSucursalById(id);
    }
     @GET
    @Produces(MediaType.APPLICATION_JSON)
      @Path("All")
    public String getProveedores() throws SQLException
    {
       return DBaccess.GetInstance().getSucursales();
    }
      @GET
    @Produces(MediaType.APPLICATION_JSON)
      @Path("Best")
    public String getBestSucursal() throws SQLException
    {
       return DBaccess.GetInstance().getBestSucursal();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Update/{id}")
    public String updateSucursal(@PathParam("id") String id, String content)
    {
        try
        {
            return DBaccess.GetInstance().updateSucursal(id, content);
        } catch (SQLException ex)
        {
            Logger.getLogger(ProveedoresResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @POST    
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Create")
    public void createSucursal(String content)
    {
        try
        {
            DBaccess.GetInstance().setSucursal(content);
        } catch (SQLException ex)
        {
            Logger.getLogger(ProveedoresResource.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Delete/{id}")
    public void deleteSucursal(@PathParam("id") String id)
    {
        try
        {
            DBaccess.GetInstance().deleteSucursal(id);
        } catch (SQLException ex)
        {
            Logger.getLogger(ProveedoresResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
