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
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String edad;
    private String dni;
    private String casaId;
    private String metros;
    private String tipoVia;
    private String tipoVivienda;
    private String planta;
    private String piso;
    private String numero;
    private String via;

    public ControlPersistencia(Casa casa, Propietario propietario) {
        this.casa = new Casa(casa);
        this.propietario = new Propietario(propietario);
        tablaPropietarios = "propietarios";
        tablaCasas = "casas";
        tablaIntermedia = "casas_propietarios";
        nombre = "nombre";
        apellido1 = "apellido1";
        apellido2 = "apellido2";
        edad = "edad";
        dni = "dni";
        casaId = "casaId";
        metros = "metros";
        tipoVia = "tipoVia";
        tipoVivienda = "tipoVivienda";
        planta = "planta";
        piso = "piso";
        numero = "numero";
        via = "via";
    }

    public ControlPersistencia() {
    }

    public void insertarPropietario(Propietario p) {
        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.162:3306/propietariosBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
                Statement statement;
                String sql;

                statement = connection.createStatement();
                sql = "insert into propietariosBD." + tablaPropietarios + " ("
                        + nombre
                        + ", " + apellido1
                        + ", " + apellido2
                        + ", " + edad
                        + ", " + dni
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

    public void insertarCasa(Casa c) {
        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.162:3306/propietariosBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
                Statement statement;
                String sql;

                statement = connection.createStatement();
                sql = "insert into propietariosBD." + tablaCasas + " ("
                        + casaId
                        + ", " + metros
                        + ", " + tipoVia
                        + ", " + tipoVivienda
                        + ", " + planta
                        + ", " + piso
                        + ", " + numero
                        + ", " + via
                        + ") values ("
                        + "\'" + c.getIdCasaInstance() + "\'"
                        + ", \'" + c.getMetrosCuadrados() + "\'"
                        + ", \'" + c.getTipoVia() + "\'"
                        + ", \'" + c.getTipoVivienda()+"\'"
                        + ", \'" + c.getPlanta() + "\'"
                        + ", \'" + c.getPiso() + "\'"
                        + ", \'" + c.getNumero() + "\'"
                        + ", \'" + c.getVia() + "\'";
                statement.executeUpdate(sql);
                statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void relacionarCasaPropietario(Casa c, Propietario p) {
        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.162:3306/propietariosBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
                Statement statement;
                String sql;

                statement = connection.createStatement();
                sql = "insert into propietariosBD." + tablaIntermedia + " ("
                        + casaId
                        + ", " + dni
                        + ") values ("
                        + ", " + String.valueOf(c.getIdCasaInstance())
                        + ", \'" + p.getDni().toString() + "\'";
                statement.executeUpdate(sql);
                statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearTablas() {
        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.162:3306/propietariosBD?serverTimezone=UTC", "root", "1q2w3e4r");) {
                Statement statement;
                String sql;

                statement = connection.createStatement();
                sql = "create table propietariosBD." + tablaPropietarios + " ("
                        + "  " + nombre + " varchar(100) not null,"
                        + "  " + apellido1 + " varchar(100) not null,"
                        + "  " + apellido2 + " varchar(100) not null,"
                        + "  " + edad + " integer,"
                        + "  " + dni + " varchar(12) not null,"
                        + "  primary key(" + dni + ")"
                        + ");";
                statement.executeUpdate(sql);
                statement.close();

                statement = connection.createStatement();
                sql = "create table propietariosBD." + tablaCasas + " ("
                        + "  " + casaId + " integer auto_increment not null,"
                        + "  " + metros + " integer not null,"
                        + "  " + tipoVia + " enum ('calle', 'plaza', 'av', 'callejon') not null,"
                        + "  " + tipoVivienda + " enum('casa','piso') not null,"
                        + "  " + planta + " integer,"
                        + "  " + piso + " integer,"
                        + "  " + numero + " integer not null,"
                        + "  " + via + " varchar(255) not null,"
                        + "  primary key(" + casaId + ")"
                        + ");";
                statement.executeUpdate(sql);
                statement.close();

                statement = connection.createStatement();
                sql = "create table propietariosBD." + tablaIntermedia + "("
                        + " " + casaId + " integer not null,"
                        + " " + dni + " varchar(12) not null,"
                        + "primary key(" + casaId + ", dni),"
                        + "foreign key (" + dni + ") references propietariosBD.propietarios(" + dni + "),"
                        + "foreign key (" + casaId + ") references propietariosBD.casas(" + casaId + ")"
                        + ")";
                statement.executeUpdate(sql);
                statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getTablaPropietarios() {
        return tablaPropietarios;
    }

    public void setTablaPropietarios(String tablaPropietarios) {
        this.tablaPropietarios = tablaPropietarios;
    }

    public String getTablaCasas() {
        return tablaCasas;
    }

    public void setTablaCasas(String tablaCasas) {
        this.tablaCasas = tablaCasas;
    }

    public String getTablaIntermedia() {
        return tablaIntermedia;
    }

    public void setTablaIntermedia(String tablaIntermedia) {
        this.tablaIntermedia = tablaIntermedia;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCasaId() {
        return casaId;
    }

    public void setCasaId(String casaId) {
        this.casaId = casaId;
    }

    public String getMetros() {
        return metros;
    }

    public void setMetros(String metros) {
        this.metros = metros;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }
}
