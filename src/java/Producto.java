
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WallHero
 */
public class Producto implements Serializable{
    private int codigo=0, preciounit=0;
    private int cuotas;
    private float preciofin = 0;
    private String nombre;

    public Producto() {
    }

    public Producto(int codigo, int preciounit, String nombre, int cuotas) {
        this.codigo = codigo;
        this.preciounit = preciounit;
        this.nombre = nombre;
        this.cuotas = cuotas;
        this.preciofin = preciounit;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPreciounit() {
        return preciounit;
    }

    public void setPreciounit(int preciounit) {
        this.preciounit = preciounit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public float getPreciofin() {
        return preciofin;
    }

    public void setPreciofin(float preciofin) {
        this.preciofin = preciofin;
    }
}
