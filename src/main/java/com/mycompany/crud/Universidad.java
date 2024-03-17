package com.mycompany.crud;

/**
 *
 * @author ronca
 */
public class Universidad {

    private int IdUniversidad;
    private String NombreUniversidad;
    private String Direccion;
    private String Ciudad;
    
    public Universidad(int IdUniversidad, String NombreUniversidad, String Direccion, String Ciudad) {
    this.IdUniversidad = IdUniversidad;
    this.NombreUniversidad = NombreUniversidad;
    this.Direccion = Direccion;
    this.Ciudad = Ciudad;
    }
    
     public int getIdUniversidad() {
        return IdUniversidad;
    }

    public void setIdUniversidad(int IdUniversidad) {
        this.IdUniversidad = IdUniversidad;
    }

    public String getNombreUniversidad() {
        return NombreUniversidad;
    }

    public void setNombreUniversidad(String NombreUniversidad) {
        this.NombreUniversidad = NombreUniversidad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }   
    

}
