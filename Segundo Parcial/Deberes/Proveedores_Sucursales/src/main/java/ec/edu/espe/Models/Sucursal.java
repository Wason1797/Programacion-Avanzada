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
class Sucursal
{
    private String codigo;
    private String ruc;
    private String direccion;
    private String ciudad;
    private String telefono;

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getRuc()
    {
        return ruc;
    }

    public void setRuc(String ruc)
    {
        this.ruc = ruc;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getCiudad()
    {
        return ciudad;
    }

    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
}
