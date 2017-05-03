/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author WallHero
 */
@ManagedBean
@ApplicationScoped
public class Zapato implements Serializable{
    private String modeloZapatilla = "";
    private int talle; 
    private ArrayList<Zapatilla> zapatillas = new ArrayList<Zapatilla>();
    private ArrayList<SelectItem> devuel = new ArrayList<SelectItem>();
    private String datodevuelto = "";
    private boolean origin;
    public Zapato() {
        devuel.add(new SelectItem("Adidas"));
        devuel.add(new SelectItem("Nike"));
        devuel.add(new SelectItem("Puma"));
        devuel.add(new SelectItem("Newbalance"));
    }

    public ArrayList<SelectItem> getDevuel() {
        return devuel;
    }
    public void ingresarZapato()
    {
        Zapatilla zapatillita = new Zapatilla(datodevuelto, modeloZapatilla, talle, isOrigin());
        getZapatillas().add(zapatillita);
    }
    public void setDevuel(ArrayList<SelectItem> devuel) {
        this.devuel = devuel;
    }

    public String getModeloZapatilla() {
        return modeloZapatilla;
    }

    public void setModeloZapatilla(String modeloZapatilla) {
        this.modeloZapatilla = modeloZapatilla;
    }

    public int getTalle() {
        return talle;
    }

    public void setTalle(int talle) {
        this.talle = talle;
    }

    public String getDatodevuelto() {
        return datodevuelto;
    }

    public void setDatodevuelto(String datodevuelto) {
        this.datodevuelto = datodevuelto;
    }

    public boolean isOrigin() {
        return origin;
    }

    public void setOrigin(boolean origin) {
        this.origin = origin;
    }

    public ArrayList<Zapatilla> getZapatillas() {
        return zapatillas;
    }

    public void setZapatillas(ArrayList<Zapatilla> zapatillas) {
        this.zapatillas = zapatillas;
    }
    
}
