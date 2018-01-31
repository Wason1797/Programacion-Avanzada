/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.employeesconsult;

/**
 *
 * @author wason
 */
public class Employee {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    private int id;
    private String name;
    private String address;
    private String phone;
    private String date;
    
       @Override
    public String toString() {
        return "{\"EmployeeData\":{"
                + "\"ID\":\""+this.id+"\","
                + "\"Name\":\""+this.name+"\","
                + "\"Address\":\""+this.address+"\","
                + "\"Phone\":\""+this.phone+"\","
                + "\"BirthDate\":\""+this.date+"\""
                +"}"
                + "}";
    }
}
