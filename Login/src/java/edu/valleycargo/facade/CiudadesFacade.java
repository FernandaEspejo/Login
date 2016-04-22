/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleycargo.facade;

import edu.valleycargo.entity.Ciudades;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DELL
 */
@Stateless
public class CiudadesFacade extends AbstractFacade<Ciudades> {

    @PersistenceContext(unitName = "proyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadesFacade() {
        super(Ciudades.class);
    }
     public List<Ciudades> ciudadesOrdenadas() {
        List<Ciudades> misCiudades = new ArrayList<>();
        try {
            Query j = em.createQuery("SELECT x FROM Ciudades x ORDER BY x.nombre");
            misCiudades = j.getResultList();
        } catch (Exception e) {
        }
        return misCiudades;
    }
    
}
