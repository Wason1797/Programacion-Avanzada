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
public class Relative {
    private int id_fam;
    private String name;
    private String schoolAge;
    private String date;
    private String likings;

    public String getLikings() {
        return likings;
    }

    public void setLikings(String likings) {
        this.likings = likings;
    }

    public int getId_fam() {
        return id_fam;
    }

    public void setId_fam(int id_fam) {
        this.id_fam = id_fam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolAge() {
        return schoolAge;
    }

    public void setSchoolAge(String schoolAge) {
        this.schoolAge = schoolAge;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
        public String toString() {
        return "{\"RelativeData\":{"
                + "\"ID\":\""+this.id_fam+"\","
                + "\"Name\":\""+this.name+"\","
                + "\"School Age\":\""+this.schoolAge+"\","
                + "\"Likings\":\""+this.likings+"\","
                + "\"BirthDate\":\""+this.date+"\""
                +"}"
                + "}";
    }
}
