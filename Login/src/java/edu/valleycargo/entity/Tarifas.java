/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleycargo.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "tarifas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifas.findAll", query = "SELECT t FROM Tarifas t"),
    @NamedQuery(name = "Tarifas.findByTarifaID", query = "SELECT t FROM Tarifas t WHERE t.tarifaID = :tarifaID"),
    @NamedQuery(name = "Tarifas.findByRutaID", query = "SELECT t FROM Tarifas t WHERE t.rutaID = :rutaID"),
    @NamedQuery(name = "Tarifas.findByPesoMin", query = "SELECT t FROM Tarifas t WHERE t.pesoMin = :pesoMin"),
    @NamedQuery(name = "Tarifas.findByValor", query = "SELECT t FROM Tarifas t WHERE t.valor = :valor"),
    @NamedQuery(name = "Tarifas.findByPesoMax", query = "SELECT t FROM Tarifas t WHERE t.pesoMax = :pesoMax"),
    @NamedQuery(name = "Tarifas.findByDimensionMin", query = "SELECT t FROM Tarifas t WHERE t.dimensionMin = :dimensionMin"),
    @NamedQuery(name = "Tarifas.findByDimensionMax", query = "SELECT t FROM Tarifas t WHERE t.dimensionMax = :dimensionMax")})
public class Tarifas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tarifaID")
    private Integer tarifaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rutaID")
    private int rutaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_min")
    private int pesoMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_max")
    private int pesoMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dimension_min")
    private int dimensionMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dimension_max")
    private int dimensionMax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarifaID")
    private Collection<Factura> facturaCollection;

    public Tarifas() {
    }

    public Tarifas(Integer tarifaID) {
        this.tarifaID = tarifaID;
    }

    public Tarifas(Integer tarifaID, int rutaID, int pesoMin, int valor, int pesoMax, int dimensionMin, int dimensionMax) {
        this.tarifaID = tarifaID;
        this.rutaID = rutaID;
        this.pesoMin = pesoMin;
        this.valor = valor;
        this.pesoMax = pesoMax;
        this.dimensionMin = dimensionMin;
        this.dimensionMax = dimensionMax;
    }

    public Integer getTarifaID() {
        return tarifaID;
    }

    public void setTarifaID(Integer tarifaID) {
        this.tarifaID = tarifaID;
    }

    public int getRutaID() {
        return rutaID;
    }

    public void setRutaID(int rutaID) {
        this.rutaID = rutaID;
    }

    public int getPesoMin() {
        return pesoMin;
    }

    public void setPesoMin(int pesoMin) {
        this.pesoMin = pesoMin;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(int pesoMax) {
        this.pesoMax = pesoMax;
    }

    public int getDimensionMin() {
        return dimensionMin;
    }

    public void setDimensionMin(int dimensionMin) {
        this.dimensionMin = dimensionMin;
    }

    public int getDimensionMax() {
        return dimensionMax;
    }

    public void setDimensionMax(int dimensionMax) {
        this.dimensionMax = dimensionMax;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarifaID != null ? tarifaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifas)) {
            return false;
        }
        Tarifas other = (Tarifas) object;
        if ((this.tarifaID == null && other.tarifaID != null) || (this.tarifaID != null && !this.tarifaID.equals(other.tarifaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleycargo.entity.Tarifas[ tarifaID=" + tarifaID + " ]";
    }
    
}
