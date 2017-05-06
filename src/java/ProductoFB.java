/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
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
public class ProductoFB implements Serializable{
    private int codigo, preciounit, cuotascarga;
    private String nombreproducto;
    private String selectitem = "";
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private ArrayList<SelectItem> devuel = new ArrayList<SelectItem>();
    private Compra comprauser = new Compra();
//    private ArrayList
    public ProductoFB() {
        devuel.add(new SelectItem("1"));
        devuel.add(new SelectItem("3"));
        devuel.add(new SelectItem("6"));
        devuel.add(new SelectItem("9"));
        devuel.add(new SelectItem("12"));      
    }
    public void quitarProducto(Producto aborrar)
    {
        productos.remove(aborrar);
    }
    public void comprarProducto(Producto acargar)
    {
        Producto cargando = new Producto(acargar.getCodigo(), acargar.getPreciounit(), acargar.getNombre(), 1); //int codigo, int preciounit, String nombre, int cuotas
        comprauser.productos.add(cargando);
    }
    
    /* Nuevo tipo objeto */
    public class Compra implements Serializable{
        private int producto, precio, indexmod = 0;
        private String selectitem = "1";
        private int cuotacargada = 0;
        boolean ingreso = false;
        private Producto[] comprados = new Producto[30];
        private int compraocup = 0;
        private ArrayList<SelectItem> devuel = new ArrayList<SelectItem>();
        private ArrayList<Producto> productos = new ArrayList<Producto>();
        public Compra() {
            devuel.add(new SelectItem("1"));
            devuel.add(new SelectItem("3"));
            devuel.add(new SelectItem("6"));
            devuel.add(new SelectItem("9"));
            devuel.add(new SelectItem("12"));    
            ingreso = false;
        }
        public void volcarDato(Producto avolcar)
        {
            getComprados()[getCompraocup()] = avolcar;
            setCompraocup(getCompraocup() + 1);
        }
        public Producto[] obtenerLista()
        {
            Producto[] listadev = new Producto[compraocup];
            for(int i = 0; i < compraocup; i++) listadev[i] = comprados[i];
            return listadev;
        }
        public void convertirSelected()
        {
            setCuotacargada(Integer.parseInt(selectitem));
            ingreso = true;
        }
        public float obtenerSumatoria()
        {
            float sumas = 0;
            for(Producto a : productos){
                sumas += a.getPreciofin();
            }
            return sumas;
        }
        public float obtenerNuevoPrecios()
        {
            if(productos.isEmpty()) return 0;
            if(cuotacargada == 0) return 0;
            float cuotaant = productos.get(indexmod).getPreciounit()/cuotacargada;
            float nuevoprecio = productos.get(indexmod).getPreciounit()/cuotacargada;
            for(int i = 1; i < cuotacargada;i++){
                cuotaant *=1.015;
                nuevoprecio += cuotaant;
            }
            return nuevoprecio;
        }
        public String obtenerNuevoPrecio()
        {
           // if(!ingreso) return "";
            if(productos.isEmpty()) return "";
            int cuotanueva = getCuotacargada(), nuevoprecio = productos.get(indexmod).getPreciounit();
            int cuotaant = productos.get(indexmod).getPreciounit();
            for(int i = 1; i <= cuotanueva+1; i++)
            {
                nuevoprecio += cuotaant;
                cuotaant *= 1.015;
            }
            return ""+nuevoprecio;
        }
        public String obtenerNuevasCuotas()
        {
            //if(!ingreso) return "";
            String cuotasdev = "";
            if(productos.isEmpty()) return "";
            int cuotanueva = getCuotacargada();
            int cuotaant = productos.get(indexmod).getPreciounit();
            for(int i = 0; 0 < cuotanueva; i++)
            {
                cuotaant *= 1.015;
                cuotasdev = cuotasdev + ";" + cuotaant;
            }
            return cuotasdev;
        }
        public void obtenerCosas()
        {
            if(productos.isEmpty()) return ;
            productos.get(indexmod).setPreciofin(obtenerNuevoPrecios());
            productos.get(indexmod).setCuotas(cuotacargada);
        }
        public float obtenerPreciofinal()
        {
            if(productos.isEmpty()) return 0;
            return productos.get(indexmod).getPreciofin();
        }
        public int obtenerCuotas()
        {
            return productos.get(indexmod).getCuotas();
        }
        public int obtenerPrecio()
        {
            return productos.get(indexmod).getPreciounit();
        }
        public void modificandoCompra(Producto mod)
        {
            for(int i = 0; i < productos.size(); i++){
                if(productos.get(i) == mod){
                    indexmod = i;
                    break;
                }
            }
        }
        public void quitarProducto(Producto borrado)
        {
            productos.remove(borrado);
        }
        public void modificandoCompraArray(Producto mod)
        {
            for(int i = 0; i < productos.size(); i++){
                if(productos.get(i) == mod){
                    indexmod = i;
                    break;
                }
            }
        }
        public void obtenerCosasArray()
        {
            if(productos.isEmpty()) return ;
            comprados[indexmod].setPreciofin(obtenerNuevoPrecios());
            comprados[indexmod].setCuotas(cuotacargada);
        }
        public void quitarProductoArray()
        {
            comprados[indexmod] = new Producto();
            for(int i = indexmod; i < compraocup;i++) comprados[i] = comprados[i+1];
            compraocup--;
            
        }
//Los gestores gráficos de aplicación, estos gestores de aplicaciones, nos permiten gestionar graficamente los paquetes, ejecutando nuestra linea de comandos
        
        public int getProducto() {
            return producto;
        }

        public void setProducto(int producto) {
            this.producto = producto;
        }

        public int getPrecio() {
            return precio;
        }

        public void setPrecio(int precio) {
            this.precio = precio;
        }

        public ArrayList<Producto> getProductos() {
            return productos;
        }

        public ArrayList<Producto> getProduct() {
            return productos;
        }

        
        public void setProductos(ArrayList<Producto> productos) {
            this.productos = productos;
        }

        public int getIndexmod() {
            return indexmod;
        }

        public void setIndexmod(int indexmod) {
            this.indexmod = indexmod;
        }

        public String getSelectitem() {
            return selectitem;
        }

        public void setSelectitem(String selectitem) {
            this.selectitem = selectitem;
        }

        public ArrayList<SelectItem> getDevuel() {
            return devuel;
        }

        public void setDevuel(ArrayList<SelectItem> devuel) {
            this.devuel = devuel;
        }

        public int getCuotacargada() {
            return cuotacargada;
        }

        public void setCuotacargada(int cuotacargada) {
            this.cuotacargada = cuotacargada;
        }

        public Producto[] getComprados() {
            return comprados;
        }

        public void setComprados(Producto[] comprados) {
            this.comprados = comprados;
        }

        public int getCompraocup() {
            return compraocup;
        }

        public void setCompraocup(int compraocup) {
            this.compraocup = compraocup;
        }
        
    }
    
    public void agregarProducto()
    {
        if(comprobarCodigoNuevo())
        {
            cuotascarga = Integer.parseInt(selectitem);
            Producto productonuevo = new Producto(codigo, preciounit, nombreproducto, cuotascarga);
            productos.add(productonuevo);
        }
    }
    public boolean comprobarCodigoNuevo()
    {
        for (Producto producto : productos) {
            if (producto.getCodigo() == this.codigo) {
                return false; 
            }
        }
        return true;
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

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public int getCuotascarga() {
        return cuotascarga;
    }

    public void setCuotascarga(int cuotascarga) {
        this.cuotascarga = cuotascarga;
    }

    public String getSelectitem() {
        return selectitem;
    }

    public void setSelectitem(String selectitem) {
        this.selectitem = selectitem;
    }

    public ArrayList<SelectItem> getDevuel() {
        return devuel;
    }

    public void setDevuel(ArrayList<SelectItem> devuel) {
        this.devuel = devuel;
    }
    public Compra getComprauser() {
        return comprauser;
    }

    public void setComprauser(Compra comprauser) {
        this.comprauser = comprauser;
    }

  
}
