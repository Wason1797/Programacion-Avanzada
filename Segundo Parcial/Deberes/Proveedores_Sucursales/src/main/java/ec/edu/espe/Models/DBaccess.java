/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Models;

import com.google.gson.Gson;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wason
 */
public class DBaccess
{
    private MysqlDataSource dataSource;
    private static DBaccess uniqueInstance;
    private DBaccess() {
        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("ROOT");
        dataSource.setServerName("ec2-54-191-196-154.us-west-2.compute.amazonaws.com");
    }
    public static DBaccess GetInstance()
    {
        if(uniqueInstance==null)
            uniqueInstance= new DBaccess();
        return uniqueInstance;
    }
    public String getProveedorById(String id) throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM proyecto.proveedor where PRO_RUC='"+id+"';");
        Proveedor ObjResult = new Proveedor();
        while(rs.next())
        {
            ObjResult.setRuc(rs.getString("PRO_RUC"));
            ObjResult.setNombre(rs.getString("PRO_NOMBRE"));
            ObjResult.setCorreo(rs.getString("PRO_CORREO"));
            ObjResult.setTelefono(rs.getString("PRO_TELEFONO"));
            ObjResult.setDireccion(rs.getString("PRO_DIRECCION"));
        }
        Gson parser = new Gson();
        return parser.toJson(ObjResult, Proveedor.class);                
    }
    public String getProveedores() throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM proyecto.proveedor;");
        ArrayList<Proveedor>dataSet= new ArrayList<Proveedor>();
       
        while(rs.next())
        {
            Proveedor ObjResult = new Proveedor();
            ObjResult.setRuc(rs.getString("PRO_RUC"));
            ObjResult.setNombre(rs.getString("PRO_NOMBRE"));
            ObjResult.setCorreo(rs.getString("PRO_CORREO"));
            ObjResult.setTelefono(rs.getString("PRO_TELEFONO"));
            ObjResult.setDireccion(rs.getString("PRO_DIRECCION"));
            dataSet.add(ObjResult);
        }
        Gson parser = new Gson();
        return parser.toJson(dataSet,dataSet.getClass());
    }
    public String getBestProvider() throws SQLException
    {
        Proveedor ObjResult=new Proveedor();
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("select * from proyecto.proveedor where PRO_RUC= (select PRO_RUC from(select count(PRO_RUC)as cuenta,PRO_RUC FROM" +
        " proyecto_avanzada.producto group by PRO_RUC order by cuenta desc" +" limit 1) as t);");
        while(rs.next())
        {
            ObjResult.setRuc(rs.getString("PRO_RUC"));
            ObjResult.setNombre(rs.getString("PRO_NOMBRE"));
            ObjResult.setCorreo(rs.getString("PRO_CORREO"));
            ObjResult.setTelefono(rs.getString("PRO_TELEFONO"));
            ObjResult.setDireccion(rs.getString("PRO_DIRECCION"));
        }
        Gson parser = new Gson();
        return parser.toJson(ObjResult, Proveedor.class); 
        
    }
    public String getSucursalById(String id) throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM proyecto.sucursal where SUC_CODIGO='"+id+"';");
        Sucursal ObjResult = new Sucursal();
        while(rs.next())
        {
            ObjResult.setRuc(rs.getString("EMP_RUC"));
            ObjResult.setCodigo(rs.getString("SUC_CODIGO"));
            ObjResult.setCiudad(rs.getString("SUC_CUIDAD"));
            ObjResult.setTelefono(rs.getString("SUC_TELEFONO"));
            ObjResult.setDireccion(rs.getString("SUC_DIRECCION"));
        }
        Gson parser = new Gson();
        return parser.toJson(ObjResult, Sucursal.class);                
    }
    public String getSucursales() throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM proyecto.sucursal;");
        ArrayList<Sucursal>dataSet= new ArrayList<Sucursal>();
        
        while(rs.next())
        {
            Sucursal ObjResult = new Sucursal();
            ObjResult.setRuc(rs.getString("EMP_RUC"));
            ObjResult.setCodigo(rs.getString("SUC_CODIGO"));
            ObjResult.setCiudad(rs.getString("SUC_CUIDAD"));
            ObjResult.setTelefono(rs.getString("SUC_TELEFONO"));
            ObjResult.setDireccion(rs.getString("SUC_DIRECCION"));
            dataSet.add(ObjResult);
        }
        Gson parser = new Gson();
        return parser.toJson(dataSet,dataSet.getClass());
    }
    public String getBestSucursal() throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("select * from proyecto.sucursal where SUC_CODIGO= (select SUC_CODIGO from( select count(SUC_CODIGO) as cuenta,SUC_CODIGO FROM" +
        " proyecto_avanzada.empleado group by SUC_CODIGO order by cuenta desc limit 1) as t);");
        Sucursal ObjResult = new Sucursal();
        while(rs.next())
        {
            ObjResult.setRuc(rs.getString("EMP_RUC"));
            ObjResult.setCodigo(rs.getString("SUC_CODIGO"));
            ObjResult.setCiudad(rs.getString("SUC_CUIDAD"));
            ObjResult.setTelefono(rs.getString("SUC_TELEFONO"));
            ObjResult.setDireccion(rs.getString("SUC_DIRECCION"));
        }
        Gson parser = new Gson();
        return parser.toJson(ObjResult, Sucursal.class);
    }
    public void setSucursal(String data) throws SQLException
    {
        Gson parser = new Gson();
        Sucursal obj=parser.fromJson(data, Sucursal.class);
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        stmt.executeUpdate("INSERT INTO proyecto.sucursal (SUC_CODIGO, EMP_RUC, SUC_DIRECCION, SUC_CUIDAD, SUC_TELEFONO) VALUES ('"+obj.getCodigo()+"','"+obj.getRuc()+"','"+obj.getDireccion()
              +"','"+obj.getCiudad()+"','"+obj.getTelefono()+"');");   
        conn.close();
    }
    public void setProveedor(String data) throws SQLException
    {
        Gson parser = new Gson();
        Proveedor obj=parser.fromJson(data, Proveedor.class);
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        stmt.executeUpdate("INSERT INTO proyecto.proveedor (PRO_RUC, PRO_NOMBRE, PRO_DIRECCION, PRO_TELEFONO, PRO_CORREO) VALUES ('"+obj.getRuc()+"','"+obj.getNombre()+"','"+obj.getDireccion()
              +"','"+obj.getTelefono()+"','"+obj.getCorreo()+"');");   
        conn.close();
    }
    public  void deleteProvider(String id) throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        stmt.executeUpdate("delete from proyecto.proveedor where PRO_RUC='"+id+"';");
        conn.close();
        
    }
     public  void deleteSucursal(String id) throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        stmt.executeUpdate("delete from proyecto.sucursal where SUC_CODIGO='"+id+"';");
        conn.close();
        
    }
     public String updateSucursal(String id,String in) throws SQLException
     {
         Gson parser = new Gson();
         Sucursal obj= new Sucursal();
         obj=parser.fromJson(in,obj.getClass());
         Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        stmt.executeUpdate("UPDATE `proyecto`.`sucursal` SET" +
        "`SUC_DIRECCION`='"+obj.getDireccion()+"', `SUC_CUIDAD`='"+obj.getCiudad()+"', "
        + "`SUC_TELEFONO`='"+obj.getTelefono()+"'"+"WHERE `SUC_CODIGO`='"+id+"';");   
        return in;
     }
     public String updateProvider(String id,String in) throws SQLException
     {
          Gson parser = new Gson();
         Proveedor obj= new Proveedor();
         obj=parser.fromJson(in,obj.getClass());
         Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        stmt.executeUpdate("UPDATE `proyecto`.`proveedor` SET "
        + "`PRO_NOMBRE`='"+obj.getNombre()+"'," +"`PRO_DIRECCION`='"+obj.getDireccion()+"', `PRO_TELEFONO`='"+obj.getTelefono()+"'," +
        "`PRO_CORREO`='"+obj.getCorreo()+"' WHERE `PRO_RUC`='"+id+"';");   
        return in;
     }
     
}
