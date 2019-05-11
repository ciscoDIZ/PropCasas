/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciscodiz.propietarios_maven.modelo;

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

    public Casa(int metrosCuadrados, int numero, TipoVia tipoVia
            , TipoVivienda tipoVivienda, Integer planta, Integer piso) {
        idCasaInstance = idCasaStatic++;
        this.metrosCuadrados = metrosCuadrados;
        this.numero = numero;
        this.tipoVia = tipoVia;
        this.tipoVivienda = tipoVivienda;
        this.planta = planta;
        this.piso = piso;
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
