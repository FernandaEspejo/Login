/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleycargo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "perfil_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilUsuario.findAll", query = "SELECT p FROM PerfilUsuario p"),
    @NamedQuery(name = "PerfilUsuario.findByPerfilusuarioID", query = "SELECT p FROM PerfilUsuario p WHERE p.perfilusuarioID = :perfilusuarioID")})
public class PerfilUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "perfil_usuarioID")
    private Integer perfilusuarioID;
    @JoinColumn(name = "perfilID", referencedColumnName = "perfilID")
    @ManyToOne(optional = false)
    private Perfil perfilID;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Usuarios cedula;

    public PerfilUsuario() {
    }

    public PerfilUsuario(Integer perfilusuarioID) {
        this.perfilusuarioID = perfilusuarioID;
    }

    public Integer getPerfilusuarioID() {
        return perfilusuarioID;
    }

    public void setPerfilusuarioID(Integer perfilusuarioID) {
        this.perfilusuarioID = perfilusuarioID;
    }

    public Perfil getPerfilID() {
        return perfilID;
    }

    public void setPerfilID(Perfil perfilID) {
        this.perfilID = perfilID;
    }

    public Usuarios getCedula() {
        return cedula;
    }

    public void setCedula(Usuarios cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilusuarioID != null ? perfilusuarioID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilUsuario)) {
            return false;
        }
        PerfilUsuario other = (PerfilUsuario) object;
        if ((this.perfilusuarioID == null && other.perfilusuarioID != null) || (this.perfilusuarioID != null && !this.perfilusuarioID.equals(other.perfilusuarioID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.valleycargo.entity.PerfilUsuario[ perfilusuarioID=" + perfilusuarioID + " ]";
    }
    
}
