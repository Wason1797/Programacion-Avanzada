/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.Models;

import java.util.ArrayList;

/**
 *
 * @author wason
 */
public class ProductArray
{
    ArrayList<Product>pArray;

    public ArrayList<Product> getpArray()
    {
        return pArray;
    }

    public ProductArray()
    {
        pArray= new ArrayList<Product>();
        pArray.add(new Product(1,"Aspirina",50,(float)6.4,new String[]{"Headache","Ache"}));
        pArray.add(new Product(2,"Ibuprofeno",80,(float)8.5,new String[]{"Headache","Ache"}));
        pArray.add(new Product(3,"Advil",150,(float)1.5,new String[]{"Headache","Ache"}));
    }
  
    
}
