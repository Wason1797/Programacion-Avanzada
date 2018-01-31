/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.employeesconsult;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public Employee getEmployee(String id) throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM familiares.empleado where id="+id+";");   
        Employee objReult= new Employee();
        while(rs.next())
        {
            objReult.setId(rs.getInt("ID"));
            objReult.setName(rs.getString("NOMBRE"));
            objReult.setAddress(rs.getString("DIRECCION"));
            objReult.setPhone(rs.getString("TELEFONO"));
            objReult.setDate(rs.getDate("FEC_NAC").toString());
        }       
        conn.close();
        return objReult;
    }
        public ArrayList<Relative> getRelative(String month) throws SQLException
    {
        Connection conn = dataSource.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM familiares.familiar where MONTH(FEC_NAC_FAMILIAR)="+month+";");   
        Relative objReult= new Relative();
        ArrayList<Relative> arrayList = new ArrayList<Relative>();
        while(rs.next())
        {
            objReult.setId_fam(rs.getInt("ID_FAMILIAR"));
            objReult.setName(rs.getString("NOM_FAMILIAR"));
            objReult.setSchoolAge(rs.getString("EDAD_ESCOLAR"));            
            objReult.setDate(rs.getDate("FEC_NAC_FAMILIAR").toString());
            objReult.setLikings(rs.getString("GUSTOS").toString());
            arrayList.add(objReult);
        }       
        conn.close();
        return arrayList;
    }   
}
