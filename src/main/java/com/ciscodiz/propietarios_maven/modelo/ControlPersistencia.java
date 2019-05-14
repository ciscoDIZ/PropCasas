/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciscodiz.propietarios_maven.modelo;

/**
 *
 * @author Francisco de Asís Domínguez Iceta <toteskuu@gmail.com>
 */
public class ControlPersistencia {
    private Casa casa;
    private Propietario propietario;

    public ControlPersistencia(Casa casa, Propietario propietario) {
        this.casa = new Casa(casa);
        this.propietario = new Propietario(propietario);
    }
    
}
