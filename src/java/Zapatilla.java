
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
public class Zapatilla implements Serializable{
    private String Marca, Modelo;
    private int talla;
    private boolean original;
    private String origin;
    public Zapatilla() {
    }

    public Zapatilla(String Marca, String Modelo, int talla, boolean original) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.talla = talla;
        this.original = original;
        if(this.original) origin = "Zapatilla original";
        else origin = "Zapatilla copia";
    }

    
    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public boolean isOriginal() {
        return original;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
