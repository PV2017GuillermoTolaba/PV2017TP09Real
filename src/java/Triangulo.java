/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author WallHero
 */
@ManagedBean
@RequestScoped
public class Triangulo {
    private Puntos A, B, C;
    private int X1, X2, X3, Y1, Y2, Y3;
    private boolean ingresado = false;
    private String mensajeMostrado = "";
    public Triangulo() {
    }

    public void ingresarPuntos()
    {
        A = new Puntos(X1, Y1);
        B = new Puntos(X2, Y2);
        C = new Puntos(X3, Y3);
        setIngresado(true);
        setMensajeMostrado(mostrarMensaje());
    }
    
    public float obtenerDistanciaPuntos(Puntos D, Puntos E){
        return (float) (Math.sqrt(((D.getX() - E.getX())*(D.getX() - E.getX())) +(D.getY() - E.getY())*(D.getY() - E.getY())));
    }
          
    public String mostrarMensaje()
    {
        String test = ""; 
        if(comprobarTriangulo())
        {
            test = "El perímetro del triángulo es de " +  (obtenerDistanciaPuntos(A, B) + obtenerDistanciaPuntos(B, C) + (obtenerDistanciaPuntos(A, C)));
            ingresado = false;
            return test;
        }
        test = "No se ha podido formar el triángulo. Los puntos son colineales.";
        return test;
    }
    public boolean comprobarTriangulo()
    {
        float[] pend = new float[2];
        if(!isIngresado()) return false;
        pend[0] = (B.getX()-A.getX())/(C.getX()-B.getX());
        pend[1] = (B.getY()-A.getY())/(C.getY()-B.getY());
        //return true;
        /*        pend[0] = (B.getY()-A.getY()) / (B.getX()-A.getX());
        pend[1] = (C.getY()-A.getY())/ (C.getX()-A.getX()) ;*/
        // pend[2] = (C.getY()-B.getY()) / (C.getX()-B.getX());
        if(pend[0] != pend[1]) return true;
        else return false;
//        return pend[0] != pend[1];
//        return (pend[0] == pend[1]);
    }
    
    
    public Puntos getA() {
        return A;
    }

    public void setA(Puntos A) {
        this.A = A;
    }

    public Puntos getB() {
        return B;
    }

    public void setB(Puntos B) {
        this.B = B;
    }

    public Puntos getC() {
        return C;
    }

    public void setC(Puntos C) {
        this.C = C;
    }

    public boolean isIngresado() {
        return ingresado;
    }

    public void setIngresado(boolean ingresado) {
        this.ingresado = ingresado;
    }

    public int getX1() {
        return X1;
    }

    public void setX1(int X1) {
        this.X1 = X1;
    }

    public int getX2() {
        return X2;
    }

    public void setX2(int X2) {
        this.X2 = X2;
    }

    public int getX3() {
        return X3;
    }

    public void setX3(int X3) {
        this.X3 = X3;
    }

    public int getY1() {
        return Y1;
    }

    public void setY1(int Y1) {
        this.Y1 = Y1;
    }

    public int getY2() {
        return Y2;
    }

    public void setY2(int Y2) {
        this.Y2 = Y2;
    }

    public int getY3() {
        return Y3;
    }

    public void setY3(int Y3) {
        this.Y3 = Y3;
    }

    public String getMensajeMostrado() {
        return mensajeMostrado;
    }

    public void setMensajeMostrado(String MensajeMostrado) {
        this.mensajeMostrado = MensajeMostrado;
    }
    
}
