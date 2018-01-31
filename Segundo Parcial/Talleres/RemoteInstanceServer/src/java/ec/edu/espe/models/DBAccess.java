/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.models;

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
public class DBAccess
{
    private MysqlDataSource dataSource;
    private static DBAccess uniqueInstance;
    private DBAccess() {
        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("ROOT");
        dataSource.setServerName("ec2-52-38-103-201.us-west-2.compute.amazonaws.com");
    }
    public static DBAccess GetInstance()
    {
        if(uniqueInstance==null)
            uniqueInstance= new DBAccess();
        return uniqueInstance;
    }
    public String getPerson() throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM edad.persona;");       
       int year=0;
       
        ArrayList<Persona>dataSet= new ArrayList<Persona>();
       
        while(rs.next())
        {
           Persona ObjResult = new Persona();
           ObjResult.setCode(rs.getInt("ID"));
            ObjResult.setName(rs.getString("NOMBRE"));
            ObjResult.setDate(rs.getString("FECHA"));     
            ObjResult.setEdad(age(ObjResult.getDate()));
            dataSet.add(ObjResult);
        }
        Gson parser = new Gson();
        return parser.toJson(dataSet,dataSet.getClass());
    }
      
    public int age(String date){
        
        String[] edad= date.split("-");                
                 
                 
         String dateN= edad[2]+"/"+edad[1]+"/"+edad[0];        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(dateN.toString(), fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
            return periodo.getYears();
    }

  
    public void setPerson(String data) throws SQLException
    {
        Gson parser = new Gson();
        Persona obj=parser.fromJson(data, Persona.class);
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        stmt.executeUpdate("INSERT INTO edad.persona (NOMBRE,FECHA) VALUES ('"+obj.getName()+"','"+obj.getDate()+"');");   
        conn.close();
    }
}
