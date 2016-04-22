/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleycargo.facade;

import edu.valleycargo.entity.Usuarios;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "proyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    public List <Usuarios> validarUsuario (int cedula, String clave) {
        List <Usuarios> Login = new ArrayList <> ();
        try {
            Query q=em.createQuery("SELECT c FROM   Usuarios c  WHERE  c.cedula =:ced and c.clave=:cla");
            q.setParameter("ced",cedula);
            q.setParameter("cla", clave);
            Login=q.getResultList();
        } catch (Exception e) {
        }
        return Login;
}
    
}
