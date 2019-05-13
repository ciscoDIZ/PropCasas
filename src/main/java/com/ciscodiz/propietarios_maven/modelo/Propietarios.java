/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciscodiz.propietarios_maven.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author noseq
 */
@Entity
@Table(name = "propietarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietarios.findAll", query = "SELECT p FROM Propietarios p")
    , @NamedQuery(name = "Propietarios.findByNombre", query = "SELECT p FROM Propietarios p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Propietarios.findByApellido1", query = "SELECT p FROM Propietarios p WHERE p.apellido1 = :apellido1")
    , @NamedQuery(name = "Propietarios.findByApellido2", query = "SELECT p FROM Propietarios p WHERE p.apellido2 = :apellido2")
    , @NamedQuery(name = "Propietarios.findByEdad", query = "SELECT p FROM Propietarios p WHERE p.edad = :edad")
    , @NamedQuery(name = "Propietarios.findByDni", query = "SELECT p FROM Propietarios p WHERE p.dni = :dni")})
public class Propietarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido1")
    private String apellido1;
    @Basic(optional = false)
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "edad")
    private Integer edad;
    @Id
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @JoinTable(name = "casas_propietarios", joinColumns = {
        @JoinColumn(name = "dni", referencedColumnName = "dni")}, inverseJoinColumns = {
        @JoinColumn(name = "casaId", referencedColumnName = "casaId")})
    @ManyToMany
    private Collection<Casas> casasCollection;

    public Propietarios() {
    }

    public Propietarios(String dni) {
        this.dni = dni;
    }

    public Propietarios(String dni, String nombre, String apellido1, String apellido2) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @XmlTransient
    public Collection<Casas> getCasasCollection() {
        return casasCollection;
    }

    public void setCasasCollection(Collection<Casas> casasCollection) {
        this.casasCollection = casasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietarios)) {
            return false;
        }
        Propietarios other = (Propietarios) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ciscodiz.propietarios_maven.modelo.Propietarios[ dni=" + dni + " ]";
    }
    
}
