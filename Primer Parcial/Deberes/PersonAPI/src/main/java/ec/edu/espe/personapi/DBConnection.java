/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.personapi;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author wason
 */
public class DBConnection {
    
    private MysqlDataSource dataSource;
    private static DBConnection uniqueInstance;
    private DBConnection() {
        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("ROOT");
        dataSource.setServerName("localhost");
    }
    public static DBConnection GetInstance()
    {
        if(uniqueInstance==null)
            uniqueInstance= new DBConnection();
        return uniqueInstance;
    }
    public Person getPerson(String id) throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("select * from persona_db.persona where id="+id+";");   
        Person objReult= new Person();
        while(rs.next())
        {
            objReult.setId(rs.getInt("id"));
            objReult.setName(rs.getString("NOM_PERSONA"));
            objReult.setLastName(rs.getString("APE_PERSONA"));
            objReult.setDate(rs.getDate("FEC_NAC_PERSONA").toString());
        }       
        conn.close();
        return objReult;
    }
    public Person deletePerson(String id) throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("select * from persona_db.persona where id="+id+";");   
        Person objReult= new Person();
        while(rs.next())
        {
            objReult.setId(rs.getInt("id"));
            objReult.setName(rs.getString("NOM_PERSONA"));
            objReult.setLastName(rs.getString("APE_PERSONA"));
            objReult.setDate(rs.getDate("FEC_NAC_PERSONA").toString());
        }      
        stmt.execute("delete from persona_db.persona where id="+id+";");
        conn.close();
        return objReult;
    }
    public void setPerson(Person res) throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        stmt.executeUpdate("INSERT INTO `persona_db`.`persona` (`NOM_PERSONA`, `APE_PERSONA`, `FEC_NAC_PERSONA`) VALUES ('"+res.getName()+"', '"+res.getLastName()+"', '"+res.getDate()+"');");   
        conn.close();        
    }    
    public void UPerson(Person res,String content) throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        stmt.executeUpdate("UPDATE `persona_db`.`persona` SET `NOM_PERSONA`='"+res.getName()+"', `APE_PERSONA`='"+res.getLastName()+"', `FEC_NAC_PERSONA`='"+res.getDate()+"' WHERE `id`='"+content+"';");   
        conn.close();        
    }     
}
