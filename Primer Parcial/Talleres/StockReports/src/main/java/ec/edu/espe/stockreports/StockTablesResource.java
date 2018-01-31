/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.stockreports;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author wason
 */
@Path("StockTables")
public class StockTablesResource {

    @Context
    private UriInfo context;
 
    public StockTablesResource() {
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("BrokerReport/{broker_id}")
    public String BrokerReport(@PathParam("broker_id") String codigo) {
        
        return "{\"Stock Data\":{"
                + "\"Analist_Id\":\""+codigo+"\","
                + "\"Symbol\":\""+"AMZN"+"\","
                + "\"Quantity\":\""+"10"+"\","
                + "\"Purchase Date\":\""+"5306400"+"\","
                + "\"Purchase Price\":\""+"510"+"\","
                + "\"Purchase Trans Fee\":\""+"9.95"+"\","
                + "\"Sale Date\":\""+"5306400"+"\","
                + "\"Sale Price\":\""+"630"+"\","
                + "\"Sale Trasn Fee\":\""+9.95+"\"}"
                + "}";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("BrokerReportDates/{broker_id}/{date1}/{date2}")
    public String BrokerReportDates(@PathParam("broker_id") String codigo,@PathParam("date1") String date1,@PathParam("date2") String date2) {
        
        return "[{\"Stock Data\":{"
                + "\"Analist_Id\":\""+codigo+"\","
                + "\"Symbol\":\""+"AMZN"+"\","
                + "\"Quantity\":\""+"10"+"\","
                + "\"Purchase Date\":\""+date1+"\","
                + "\"Purchase Price\":\""+"510"+"\","
                + "\"Purchase Trans Fee\":\""+"9.95"+"\","
                + "\"Sale Date\":\""+"5306400"+"\","
                + "\"Sale Price\":\""+"630"+"\","
                + "\"Sale Trasn Fee\":\""+9.95+"\"}"
                + "},"
                + "{\"Stock Data\":{"
                + "\"Analist_Id\":\""+codigo+"\","
                + "\"Symbol\":\""+"AMZN"+"\","
                + "\"Quantity\":\""+"10"+"\","
                + "\"Purchase Date\":\""+date2+"\","
                + "\"Purchase Price\":\""+"510"+"\","
                + "\"Purchase Trans Fee\":\""+"9.95"+"\","
                + "\"Sale Date\":\""+"5306400"+"\","
                + "\"Sale Price\":\""+"630"+"\","
                + "\"Sale Trasn Fee\":\""+9.95+"\"}"
                + "}]";
    }   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("InvestorReport/{broker_id}")
    public String IvestorReport(@PathParam("broker_id") String codigo) {
        
        return "{\"Stock Data\":{"
                + "\"Analist_Id\":\""+codigo+"\","
                + "\"Symbol\":\""+"AMZN"+"\","
                + "\"Quantity\":\""+"10"+"\","
                + "\"Purchase Date\":\""+"5306400"+"\","
                + "\"Purchase Price\":\""+"510"+"\","
                + "\"Purchase Trans Fee\":\""+"9.95"+"\","
                + "\"Sale Date\":\""+"5306400"+"\","
                + "\"Sale Price\":\""+"630"+"\","
                + "\"Sale Trasn Fee\":\""+9.95+"\"}"
                + "}";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("InvestorDates/{broker_id}/{date1}/{date2}")
    public String InvestorReportDates(@PathParam("broker_id") String codigo,@PathParam("date1") String date1,@PathParam("date2") String date2) {
        
        return "[{\"Stock Data\":{"
                + "\"Analist_Id\":\""+codigo+"\","
                + "\"Symbol\":\""+"AMZN"+"\","
                + "\"Quantity\":\""+"10"+"\","
                + "\"Purchase Date\":\""+date1+"\","
                + "\"Purchase Price\":\""+"510"+"\","
                + "\"Purchase Trans Fee\":\""+"9.95"+"\","
                + "\"Sale Date\":\""+"5306400"+"\","
                + "\"Sale Price\":\""+"630"+"\","
                + "\"Sale Trasn Fee\":\""+9.95+"\"}"
                + "},"
                + "{\"Stock Data\":{"
                + "\"Analist_Id\":\""+codigo+"\","
                + "\"Symbol\":\""+"AMZN"+"\","
                + "\"Quantity\":\""+"10"+"\","
                + "\"Purchase Date\":\""+date2+"\","
                + "\"Purchase Price\":\""+"510"+"\","
                + "\"Purchase Trans Fee\":\""+"9.95"+"\","
                + "\"Sale Date\":\""+"5306400"+"\","
                + "\"Sale Price\":\""+"630"+"\","
                + "\"Sale Trasn Fee\":\""+9.95+"\"}"
                + "}]";
    }   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Sale")
    public String Sale(String content) {
        
        System.out.println("Transaccion exitosa\n");
        return content;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Purchase")
    public String Purchase(String content) {
        
        System.out.println("Transaccion exitosa\n");
        return content;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("AddInvestor")
    public String AddInvestor(String content) {
        
        System.out.println("Transaccion exitosa\n");
        return content;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("AddBroker")
    public String AddBroker(String content) {
        
        System.out.println("Transaccion exitosa\n");
        return content;
    }    
}
