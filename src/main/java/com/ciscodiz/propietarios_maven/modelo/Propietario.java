/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciscodiz.propietarios_maven.modelo;

import java.util.ArrayList;
import javax.management.InvalidAttributeValueException;

/**
 *
 * @author noseq
 */
public class Propietario {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private Integer edad; //atributo nulable
    private DNI dni;
    private ArrayList<Casa> casasLista;

    /*
        implementar constructor de copia necesario para pasar objetos a ControlPersistencia
     */
    
    public Propietario(String nombre, String apellido1, String apellido2,
             char letra, int numero) {
        try {
            this.nombre = nombre;
            this.apellido1 = apellido1;
            this.apellido2 = apellido2;
            dni = new DNI(letra, numero);
            casasLista = new ArrayList<>();
        } catch (InvalidAttributeValueException e) {
            System.out.println(e);
        }
    }

    public Propietario(Propietario toCopy){
        this.nombre = toCopy.nombre;
        this.apellido1 = toCopy.apellido1;
        this.apellido2 = toCopy.apellido2;
        this.edad = toCopy.edad;
        this.dni = toCopy.dni;
        this.casasLista = toCopy.casasLista;
    }

   
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    
    
    public DNI getDni() {
        return dni;
    }

    public void setDni(DNI dni) {
        this.dni = dni;
    }

    public ArrayList<Casa> getCasasLista() {
        return casasLista;
    }

    public void setCasasLista(ArrayList<Casa> casasLista) {
        this.casasLista = casasLista;
    }
    
}
