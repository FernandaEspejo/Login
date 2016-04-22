/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.valleycargo.controladores;

import edu.valleycargo.entity.Ciudades;
import edu.valleycargo.entity.Perfil;
import edu.valleycargo.entity.PerfilUsuario;
import edu.valleycargo.entity.Usuarios;
import edu.valleycargo.modelo.Mailer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author PRACTICAS
 */
@Named(value = "usuariocontrolador")
@SessionScoped
public class usuariocontrolador implements Serializable {
    @EJB
    private edu.valleycargo.facade.UsuariosFacade usuarioFacade;
    private edu.valleycargo.facade.PerfilUsuarioFacade perfilUsuariosFacade;

    private String fcnombre;
    private String frapellido;
    private String frtipoDocumento;
    private String frdocumento;
    private String frnombreUsuario;
    private String frcontraseña;
    private String frciudad;
    private String frdireccion;
    private String fccelular;
    private String frfechaNacimiento;
    private String fccorreo;
    private String fcempresa;
    private String fctelefono;
    private String fcmensaje;
    private Usuarios usuarioRegistrado;

    private int estados = 0;
    /**
     * Creates a new instance of usuariocontrolador
     */
    public usuariocontrolador() {
    }

    /**
     * @return the fcnombre
     */
    public String getFcnombre() {
        return fcnombre;
    }

    /**
     * @param fcnombre the fcnombre to set
     */
    public void setFcnombre(String fcnombre) {
        this.fcnombre = fcnombre;
    }

    /**
     * @return the frapellido
     */
    public String getFrapellido() {
        return frapellido;
    }

    /**
     * @param frapellido the frapellido to set
     */
    public void setFrapellido(String frapellido) {
        this.frapellido = frapellido;
    }

    /**
     * @return the frtipoDocumento
     */
    public String getFrtipoDocumento() {
        return frtipoDocumento;
    }

    /**
     * @param frtipoDocumento the frtipoDocumento to set
     */
    public void setFrtipoDocumento(String frtipoDocumento) {
        this.frtipoDocumento = frtipoDocumento;
    }

    /**
     * @return the frdocumento
     */
    public String getFrdocumento() {
        return frdocumento;
    }

    /**
     * @param frdocumento the frdocumento to set
     */
    public void setFrdocumento(String frdocumento) {
        this.frdocumento = frdocumento;
    }

    /**
     * @return the frnombreUsuario
     */
    public String getFrnombreUsuario() {
        return frnombreUsuario;
    }

    /**
     * @param frnombreUsuario the frnombreUsuario to set
     */
    public void setFrnombreUsuario(String frnombreUsuario) {
        this.frnombreUsuario = frnombreUsuario;
    }

    /**
     * @return the frcontraseña
     */
    public String getFrcontraseña() {
        return frcontraseña;
    }

    /**
     * @param frcontraseña the frcontraseña to set
     */
    public void setFrcontraseña(String frcontraseña) {
        this.frcontraseña = frcontraseña;
    }

    /**
     * @return the frciudad
     */
    public String getFrciudad() {
        return frciudad;
    }

    /**
     * @param frciudad the frciudad to set
     */
    public void setFrciudad(String frciudad) {
        this.frciudad = frciudad;
    }

    /**
     * @return the frdireccion
     */
    public String getFrdireccion() {
        return frdireccion;
    }

    /**
     * @param frdireccion the frdireccion to set
     */
    public void setFrdireccion(String frdireccion) {
        this.frdireccion = frdireccion;
    }

    /**
     * @return the fccelular
     */
    public String getFccelular() {
        return fccelular;
    }

    /**
     * @param fccelular the fccelular to set
     */
    public void setFccelular(String fccelular) {
        this.fccelular = fccelular;
    }

    /**
     * @return the frfechaNacimiento
     */
    public String getFrfechaNacimiento() {
        return frfechaNacimiento;
    }

    /**
     * @param frfechaNacimiento the frfechaNacimiento to set
     */
    public void setFrfechaNacimiento(String frfechaNacimiento) {
        this.frfechaNacimiento = frfechaNacimiento;
    }

    /**
     * @return the fccorreo
     */
    public String getFccorreo() {
        return fccorreo;
    }

    /**
     * @param fccorreo the fccorreo to set
     */
    public void setFccorreo(String fccorreo) {
        this.fccorreo = fccorreo;
    }

    /**
     * @return the fcempresa
     */
    public String getFcempresa() {
        return fcempresa;
    }

    /**
     * @param fcempresa the fcempresa to set
     */
    public void setFcempresa(String fcempresa) {
        this.fcempresa = fcempresa;
    }

    /**
     * @return the fctelefono
     */
    public String getFctelefono() {
        return fctelefono;
    }

    /**
     * @param fctelefono the fctelefono to set
     */
    public void setFctelefono(String fctelefono) {
        this.fctelefono = fctelefono;
    }

    /**
     * @return the fcmensaje
     */
    public String getFcmensaje() {
        return fcmensaje;
    }

    /**
     * @param fcmensaje the fcmensaje to set
     */
    public void setFcmensaje(String fcmensaje) {
        this.fcmensaje = fcmensaje;
    }

    /**
     * @return the usuarioRegistrado
     */
    public Usuarios getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    /**
     * @param usuarioRegistrado the usuarioRegistrado to set
     */
    public void setUsuarioRegistrado(Usuarios usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
    }

    /**
     * @return the estados
     */
    public int getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(int estados) {
        this.estados = estados;
    }
     public String enviarmensajecontacto(){
        String mensaje= "nombre: "+getFcnombre()+" mensaje : "+getFcmensaje()+" telefono : "+getFctelefono()+" : correo "+getFccorreo();
        
       
        try {
            Mailer.send("lfespejo18@gmail.com", "Mensaje de contacto",mensaje);
        } catch (Exception e) {
            setEstados(2);
        }
        
         setFcnombre("");
        setFccorreo("");
        setFctelefono("");
        setFcmensaje("");

        
       return "contactenos";
  
}
     public String registrarUsuario() throws ParseException {
        Usuarios usuarioRegistro = new Usuarios();
        usuarioRegistro.setNombre(fcnombre);
        usuarioRegistro.setApellido(frapellido);
        usuarioRegistro.setTipoDocumento(frtipoDocumento);
        usuarioRegistro.setCedula(Long.parseLong(frdocumento));
        usuarioRegistro.setTelefono(fctelefono);
        usuarioRegistro.setCorreo(fccorreo);
        usuarioRegistro.setDireccion(frdireccion);
        usuarioRegistro.setCelular(fccelular);
        usuarioRegistro.setClave(frcontraseña);
        Ciudades miCiudad = new Ciudades();
        miCiudad.setCiudadID(Integer.parseInt(frciudad));
        usuarioRegistro.setCiudadID(miCiudad);

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(frfechaNacimiento);
        usuarioRegistro.setFechaNacimiento(date);

        try {
            usuarioFacade.create(usuarioRegistro);
            PerfilUsuario usuarioCliente = new PerfilUsuario();
            usuarioCliente.setCedula(usuarioRegistro);
            
            Perfil perfilCliente = new Perfil();
            perfilCliente.setPerfilID(1);
            usuarioCliente.setPerfilID(perfilCliente);
                       
            
            perfilUsuariosFacade.create(usuarioCliente);
            
            Mailer.send(fccorreo, "Bienvenido a Valley Cargo", "Registro Exitoso !!!");
            estados = 1;
        } catch (Exception e) {
            estados = 2;
        }
        fcnombre = "";
        frapellido = "";
        frtipoDocumento = "";
        frdocumento = "";
        fctelefono = "";
        fccorreo = "";
        frdireccion = "";
        fccelular = "";
        frcontraseña = "";
        frciudad = "";
        frfechaNacimiento = "";
        return "registro";

    }
       public String inicioSesion() {
        List<Usuarios> usuLog = usuarioFacade.validarUsuario(Integer.parseInt(frdocumento), frcontraseña);
        String ruta;
        if (usuLog.isEmpty()) {

//            FacesContext facesContext = FacesContext.getCurrentInstance();
//            ExternalContext externalContext = facesContext.getExternalContext();
//            HttpServletRequest miSession = (HttpServletRequest) facesContext.getExternalContext().getRequest();
//            miSession.setAttribute("usuariol", usuLog);
            ruta = "index";
            estados = 3;

        } else {
            usuarioRegistrado = usuLog.get(0);
            ruta = "index.xhtml";
            estados = 4;
        }
        return ruta;
    }
}