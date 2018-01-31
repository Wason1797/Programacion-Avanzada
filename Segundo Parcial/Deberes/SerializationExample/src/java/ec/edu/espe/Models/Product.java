/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Models;

/**
 *
 * @author wason
 */
public class Product 
{
   private int id;
   private String name;
   private int ammount;
   private float price;
   private String []tags;
   
   public Product()
   {
       tags=new String[2];
   }

    public Product(int id, String name, int ammount, float price, String[] tags)
    {
        this.id = id;
        this.name = name;
        this.ammount = ammount;
        this.price = price;
        this.tags = tags;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the ammount
     */
    public int getAmmount()
    {
        return ammount;
    }

    /**
     * @param ammount the ammount to set
     */
    public void setAmmount(int ammount)
    {
        this.ammount = ammount;
    }

    /**
     * @return the price
     */
    public float getPrice()
    {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price)
    {
        this.price = price;
    }

    /**
     * @return the tags
     */
    public String[] getTags()
    {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String[] tags)
    {
        this.tags = tags;
    }
    
            
}
