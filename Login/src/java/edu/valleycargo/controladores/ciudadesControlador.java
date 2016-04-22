/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleycargo.controladores;

import edu.valleycargo.entity.Ciudades;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author JoseLuis
 */
@Named(value = "ciudadesControlador")
@SessionScoped
public class ciudadesControlador implements Serializable {
@EJB 
private edu.valleycargo.facade.CiudadesFacade ciudadesFacade;
    /**
     * Creates a new instance of ciudadesControlador
     */
    public ciudadesControlador() {
    }
    
    public List <Ciudades> ciudadesOrdenadas(){
    
        return ciudadesFacade.ciudadesOrdenadas();
    
    }
    
    
    
}
