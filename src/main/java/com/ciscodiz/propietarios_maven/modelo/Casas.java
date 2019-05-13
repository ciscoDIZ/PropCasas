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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "casas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casas.findAll", query = "SELECT c FROM Casas c")
    , @NamedQuery(name = "Casas.findByCasaId", query = "SELECT c FROM Casas c WHERE c.casaId = :casaId")
    , @NamedQuery(name = "Casas.findByMetros", query = "SELECT c FROM Casas c WHERE c.metros = :metros")
    , @NamedQuery(name = "Casas.findByTipoVia", query = "SELECT c FROM Casas c WHERE c.tipoVia = :tipoVia")
    , @NamedQuery(name = "Casas.findByTipoVicienda", query = "SELECT c FROM Casas c WHERE c.tipoVicienda = :tipoVicienda")
    , @NamedQuery(name = "Casas.findByPlanta", query = "SELECT c FROM Casas c WHERE c.planta = :planta")
    , @NamedQuery(name = "Casas.findByPiso", query = "SELECT c FROM Casas c WHERE c.piso = :piso")
    , @NamedQuery(name = "Casas.findByNumero", query = "SELECT c FROM Casas c WHERE c.numero = :numero")
    , @NamedQuery(name = "Casas.findByVia", query = "SELECT c FROM Casas c WHERE c.via = :via")})
public class Casas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "casaId")
    private Integer casaId;
    @Basic(optional = false)
    @Column(name = "metros")
    private int metros;
    @Basic(optional = false)
    @Column(name = "tipoVia")
    private String tipoVia;
    @Basic(optional = false)
    @Column(name = "tipoVicienda")
    private String tipoVicienda;
    @Column(name = "planta")
    private Integer planta;
    @Column(name = "piso")
    private Integer piso;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "via")
    private String via;
    @ManyToMany(mappedBy = "casasCollection")
    private Collection<Propietarios> propietariosCollection;

    public Casas() {
    }

    public Casas(Integer casaId) {
        this.casaId = casaId;
    }

    public Casas(Integer casaId, int metros, String tipoVia, String tipoVicienda, int numero, String via) {
        this.casaId = casaId;
        this.metros = metros;
        this.tipoVia = tipoVia;
        this.tipoVicienda = tipoVicienda;
        this.numero = numero;
        this.via = via;
    }

    public Integer getCasaId() {
        return casaId;
    }

    public void setCasaId(Integer casaId) {
        this.casaId = casaId;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getTipoVicienda() {
        return tipoVicienda;
    }

    public void setTipoVicienda(String tipoVicienda) {
        this.tipoVicienda = tipoVicienda;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    @XmlTransient
    public Collection<Propietarios> getPropietariosCollection() {
        return propietariosCollection;
    }

    public void setPropietariosCollection(Collection<Propietarios> propietariosCollection) {
        this.propietariosCollection = propietariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (casaId != null ? casaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casas)) {
            return false;
        }
        Casas other = (Casas) object;
        if ((this.casaId == null && other.casaId != null) || (this.casaId != null && !this.casaId.equals(other.casaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ciscodiz.propietarios_maven.modelo.Casas[ casaId=" + casaId + " ]";
    }
    
}
