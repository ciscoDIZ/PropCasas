/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciscodiz.propietarios_maven.modelo;

import java.util.ArrayList;

/**
 *
 * @author noseq
 */
public class Casa {
     public enum TipoVia{
         CALLE
         ,PLAZA
         ,AV
         ,CALLEJON
     }
     public enum TipoVivienda{
         CASA
         ,PISO
     }
     
     private static int idCasaStatic = 0;
     private final int idCasaInstance;
     private int metrosCuadrados;
     private int numero;
     private TipoVia tipoVia;
     private TipoVivienda tipoVivienda;
     private Integer planta;
     private Integer piso;
     private String via;
     private ArrayList<Propietario> propietariosList;
     private final String nombreTabla; 
    /*
        implementar constructor de copia necesario para pasar objetos a ControlPersistencia
     */
    public Casa(int metrosCuadrados, int numero, TipoVia tipoVia
            , TipoVivienda tipoVivienda, Integer planta, Integer piso, String via) {
        idCasaInstance = idCasaStatic++;
        this.metrosCuadrados = metrosCuadrados;
        this.numero = numero;
        this.tipoVia = tipoVia;
        this.tipoVivienda = tipoVivienda;
        this.planta = planta;
        this.piso = piso;
        this.via = via;
        propietariosList = new ArrayList<>();
        nombreTabla = "casas";
    }
    
    public Casa(Casa toCopy){
        idCasaInstance = idCasaStatic;
        this.metrosCuadrados = toCopy.metrosCuadrados;
        this.numero = toCopy.metrosCuadrados;
        this.numero = toCopy.numero;
        this.tipoVia = toCopy.tipoVia;
        this.tipoVivienda = toCopy.tipoVivienda;
        this.planta = toCopy.planta;
        this.piso = toCopy.piso;
        this.via = toCopy.via;
        propietariosList = new ArrayList<>();
        nombreTabla = toCopy.nombreTabla;
    }
   /* 
    public String insertData(){
        return "INSERT INTO "+nombreTabla+" "
    }
    */

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }
    
    public int getIdCasaInstance() {
        return idCasaInstance;
    }

    public ArrayList<Propietario> getPropietariosList() {
        return propietariosList;
    }
    
    public boolean addPropietario(Propietario p){
        return propietariosList.add(p);
    }
    
    public static int getIdCasaStatic() {
        return idCasaStatic;
    }

    public static void setIdCasaStatic(int idCasaStatic) {
        Casa.idCasaStatic = idCasaStatic;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoVia getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(TipoVia tipoVia) {
        this.tipoVia = tipoVia;
    }

    public TipoVivienda getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(TipoVivienda tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public Integer getPlanta() {
        return planta;
    }

    public void setPlanta(Integer planta) {
        this.planta = planta;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    } 
}
