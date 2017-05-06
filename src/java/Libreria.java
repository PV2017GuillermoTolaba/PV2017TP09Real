/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.javafx.logging.PulseLogger.addMessage;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author WallHero
 */
@ManagedBean
@SessionScoped
public class Libreria {

    private int ISBN = 0;
    private String titulo = "";
    private String autor = "";
    private int precio = 0;
    private boolean comp = false;
    private ArrayList<LibreriaLib> libros = new ArrayList<LibreriaLib>(){};
    private String titulobusq = "";
    private boolean busquedaCategoria = false;
    private String categoria ="", categoriaing = "";
    private LibreriaLib libro;
    private ArrayList<SelectItem> devuel = new ArrayList<SelectItem>();

    public Libreria() {
        devuel.add(new SelectItem("Novela"));
        devuel.add(new SelectItem("Política"));
        libros.add(new LibreriaLib(1, "Pedrito", "Pedro López", 150, "Novela"));
        libros.add(new LibreriaLib(2, "Pedrito", "Pedro Alejandro", 150, "Novela"));
        libros.add(new LibreriaLib(3, "Pedrote", "Pedro Alejando", 25, "Novela"));
        libros.add(new LibreriaLib(4, "Historiador", "Historiadores", 25, "Política"));

    }
    public ArrayList<LibreriaLib> busqueda(){
        ArrayList<LibreriaLib> listarev = new ArrayList<LibreriaLib>(){};
        if(isBusquedaCategoria())
        {
            for(LibreriaLib a : libros) if(a.getTitulo().equals(titulobusq) && a.getCategoria().equals(categoria)) listarev.add(a);
        }
        else for(LibreriaLib a : libros) if(a.getTitulo() == titulobusq) listarev.add(a);     
        return listarev;
    }

    public void agregarLibro()
    {
        comp = false;
        libro = new LibreriaLib(ISBN, titulo, autor, precio, categoriaing);
//        libro.agregarLibro();
        if(comprobarISBN(ISBN) == 0)
        {    
            libros.add(libro);
            comp = true;
        }  
        else addMessage("El ISBN introducido está en uso");
    }
    public int comprobarISBN(int nuevo){
        for(int i = 0; i < libros.size(); i++)
        {
            if(libros.get(i).getISBN() == nuevo) return 1;
        }
        return 0;
    }   
         
    public int getISBN() {
        return ISBN;
    }
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the libros
     */
    public ArrayList<LibreriaLib> getLibros() {
        return libros;
    }

    /**
     * @param libros the libros to set
     */
    public void setLibros(ArrayList<LibreriaLib> libros) {
        this.libros = libros;
    }

    /**
     * @return the comp
     */
    public boolean isComp() {
        return comp;
    }

    /**
     * @param comp the comp to set
     */
    public void setComp(boolean comp) {
        this.comp = comp;
    }

    public String getTitulobusq() {
        return titulobusq;
    }

    public void setTitulobusq(String titulobusq) {
        this.titulobusq = titulobusq;
    }

    public boolean isBusquedaCategoria() {
        return busquedaCategoria;
    }

    public void setBusquedaCategoria(boolean busquedaCategoria) {
        this.busquedaCategoria = busquedaCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<SelectItem> getDevuel() {
        return devuel;
    }

    public void setDevuel(ArrayList<SelectItem> devuel) {
        this.devuel = devuel;
    }

    public String getCategoriaing() {
        return categoriaing;
    }

    public void setCategoriaing(String categoriaing) {
        this.categoriaing = categoriaing;
    }
}
