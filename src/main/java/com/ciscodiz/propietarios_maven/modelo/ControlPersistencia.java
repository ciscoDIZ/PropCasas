/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciscodiz.propietarios_maven.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco de Asís Domínguez Iceta <toteskuu@gmail.com>
 */
public class ControlPersistencia {

    private Casa casa;
    private Propietario propietario;
    private String tablaPropietarios;
    private String tablaCasas;
    private String tablaIntermedia;
    
    public ControlPersistencia(Casa casa, Propietario propietario) {
        this.casa = new Casa(casa);
        this.propietario = new Propietario(propietario);
        tablaPropietarios = "propietarios";
        tablaCasas = "casas";
        tablaIntermedia = "casas_propietarios";
    }
    
    public ControlPersistencia() {}

    public void crearPropietario(Propietario p) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.162:3306/propietariosBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement statement;
            String sql;

            statement = connection.createStatement();
            sql = "insert into propietariosBD."+tablaPropietarios+" ("
                    + "nombre"
                    + ", apellido1"
                    + ", apellido2"
                    + ", edad"
                    + ", dni"
                    + ") values ("
                    + "\'" + p.getNombre() + "\'"
                    + ", \'" + p.getApellido1() + "\'"
                    + ", \'" + p.getApellido2() + "\'"
                    + ", " + String.valueOf(p.getEdad())
                    + ", \'" + p.getDni().toString() + "\'";
            statement.executeUpdate(sql);
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void crearCasa(Casa c){
        
    }
    public void relacionarCasaPropietario(Casa c, Propietario p){
        
        
    }
    public void crearTablas() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.162:3306/propietariosBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
            Statement statement;
            String sql;

            statement = connection.createStatement();
            sql = "create table propietariosBD."+tablaPropietarios+" ("
                    + "  nombre varchar(100) not null,"
                    + "  apellido1 varchar(100) not null,"
                    + "  apellido2 varchar(100) not null,"
                    + "  edad integer,"
                    + "  dni varchar(12) not null,"
                    + "  primary key(dni)"
                    + ");";
            statement.executeUpdate(sql);
            statement.close();

            statement = connection.createStatement();
            sql = "create table propietariosBD."+tablaCasas+" ("
                    + "  casaId integer auto_increment not null,"
                    + "  metros integer not null,"
                    + "  tipoVia enum ('calle', 'plaza', 'av', 'callejon') not null,"
                    + "  tipoVicienda enum('casa','piso') not null,"
                    + "  planta integer,"
                    + "  piso integer,"
                    + "  numero integer not null,"
                    + "  via varchar(255) not null,"
                    + "  primary key(casaId)"
                    + ");";
            statement.executeUpdate(sql);
            statement.close();

            statement = connection.createStatement();
            sql = "create table propietariosBD."+tablaIntermedia+"("
                    + "casaId integer not null,"
                    + "dni varchar(12) not null,"
                    + "primary key(casaId, dni),"
                    + "foreign key (dni) references propietariosBD.propietarios(dni),"
                    + "foreign key (casaId) references propietariosBD.casas(casaId)"
                    + ")";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
