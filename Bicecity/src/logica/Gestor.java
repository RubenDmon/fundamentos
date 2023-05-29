/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
//este paquete comunica los DAO con la capa de presentacion

import datos.ciudadDAO;
import datos.usuarioDAO;
import datos.viajeDAO;
import conexion.Excepcion;

/**
 *
 * @author rdmon
 */
public class Gestor {

    private boolean userFunciona;
    private boolean userViajeI;
    private boolean userViajeF;
    private boolean userModified;

    public boolean getUserModified() {
        return userModified;
    }

    
    public boolean getFunciona() {
        return userFunciona;
    }

    public boolean getUserViajeI() {
        return userViajeI;
    }

    public boolean getUserViajeF() {
        return userViajeF;
    }

    //inicianos los DAOS que se conectaran con la capa de vista
    private ciudadDAO ciudadDAO;
    private usuarioDAO usuarioDAO;
    private viajeDAO viajeDAO;

    //declaramos e inicializamos los modelos con los que trabajaremos
    private Ciudad ciudad;
    private Usuario usuario;
    private Cuenta cuenta;
    private Viaje viaje;

    public Gestor() {
        ciudadDAO = new ciudadDAO();
        usuarioDAO = new usuarioDAO();
        viajeDAO = new viajeDAO();
    }

    //operacion para incluir una ciudad al sistema
    public void incluirCiudad(int id, String nombre, String hi, String hf) throws Excepcion {
        ciudad = new Ciudad();
        ciudad.setIdCiudad(id);
        ciudad.setnCiudad(nombre);
        ciudad.setHoraInicialServ(hi);
        ciudad.setHoraFinalServ(hf);
        ciudadDAO.incluirCiudad(ciudad);
    }

    //metodos del usuario------------------------------------------------------------------------------------------------------
    //metodo para incluir un nuevo usuario
    public void incluirUser(String k_idusuario, String i_tipoid, String n_correo, String n_nombre1, String n_nombre2, String n_apellido1, String n_apellido2, String n_nacionalidad, String f_nacimiento, String n_eps, String i_sexo, int v_celular, int saldoI) throws Excepcion {
        usuario = new Usuario();
        usuario.getCuenta().setSaldo(saldoI);
        usuario.getCuenta().setEstado("ACTI");
        usuario.setIdUsuario(k_idusuario);
        usuario.setTipoId(i_tipoid);
        usuario.setCorreo(n_correo);
        usuario.setNombre1(n_nombre1);
        usuario.setNombre2(n_nombre2);
        usuario.setApellido1(n_apellido1);
        usuario.setApellido2(n_apellido2);
        usuario.setNacionalidad(n_nacionalidad);
        usuario.setNacimiento(f_nacimiento);
        usuario.setEps(n_eps);
        usuario.setSexo(i_sexo);
        usuario.setCelular(v_celular);
        //manejo de la creacion o no del usuario
        try {
            usuarioDAO.incluirUsuario(usuario);
            userFunciona = true;
        } catch (Exception e) {
            userFunciona = false;
        }
    }

    //se hace de inmediato de la creacion ademas que si no se crea correctamente esta operacion no se da
    public void asociarPlan(int Plan) throws Excepcion {

        if (userFunciona) {
            usuario.setCuenta(usuarioDAO.obtenerCuenta(usuario.getIdUsuario()));
            usuarioDAO.asociarPlan(usuario.getCuenta().getCodigo(), Plan);
            usuarioDAO.actualizarCuentaBloqueo(usuario.getCuenta(),usuarioDAO.obtenerVPlan(usuario.getCuenta().getCodigo()));
        }
    }
//operacion para el inicio de seccion utiliza tambien la variable para saber si el user funiona o no o refrescar variables

    public void iniciar(String idUser) throws Excepcion {
        usuario = usuarioDAO.obtenerUsuario(idUser);
        if (usuario.getNombre1() == null) {
            userFunciona = false;
        } else {
            userFunciona = true;
        }
    }
    
public void modificarUser(String nombre1,String nombre2,String apellido1,String apellido2,String eps,int cel) throws Excepcion {
            
    try {
            usuarioDAO.modificarCuenta(usuario, nombre1, nombre2, apellido1, apellido2, eps, cel);
            userModified = true;
        } catch (Exception e) {
            userModified = false;
        }    
    }

//metodos del viaje-----------------------------------------------------------------------------------------------------------------
    //en estos metodos ya el usuario inicio
    //viaje de desbloqueo es el primer viaje que hace el usaurio
    public void incluirViajeDes() throws Excepcion {

///mirar el estado del viaje si el usuario puede o no viajar*************************************************************
        if (usuario.getCuenta().getEstado().equals("ACTI")) {
            viaje = viajeDAO.obtenerViaje(viajeDAO.incluirViajeDesbloqueo(usuario.getCuenta()));
            usuario.getCuenta().setViaje(viaje);
            userViajeI = true;
        } else {
            userViajeI = false;
        }
        //usuario.getCuenta().setSaldo(usuario.getCuenta().getSaldo()-usuario.getCuenta().getPlan().getvSacarB());
        // System.out.println(usuario.getCuenta().getPlan().getIdPlan());
    }

    public void incluirViajeBloq() throws Excepcion {
        ///mirar el estado del viaje si el usuario puede o no viajar*************************************************************
        if (usuario.getCuenta().getEstado().equals("DESA")) {
            viaje = viajeDAO.obtenerViaje(viajeDAO.contarViajes() - 1);
            usuario.getCuenta().setViaje(viaje);
            
            //saber si se le suma o no la cant de viajes que hace 
            int cantViajes=viajeDAO.contarViajescuenta(usuario.getCuenta().getCodigo());
            int valorSacarB=0;
            if(cantViajes>usuario.getCuenta().getPlan().getvCantV()){
            valorSacarB=usuario.getCuenta().getPlan().getvSacarB();
            }

            viajeDAO.incluirViajeBloqueo(usuario.getCuenta(),valorSacarB );
            
            userViajeF = true;
        } else {
            userViajeF = false;
        }

        // System.out.println(usuario.getCuenta().getPlan().getIdPlan());
    }
    //para mira el historial inicializar como siempre
public void historialViajes() throws Excepcion {

///mirar el estado del viaje si el usuario puede o no viajar*************************************************************
    usuario.getCuenta().setViajes(viajeDAO.obtenerListaViajes(usuario.getCuenta()));
    for(int i=0;i<usuario.getCuenta().getViajes().size();i++){
        System.out.println("id: "+usuario.getCuenta().getViajes().get(i).getIdViaje() +" hora I: "+usuario.getCuenta().getViajes().get(i).getHoraI());
    }
    if(usuario.getCuenta().getViajes().size()==0){
        System.out.println("no hay viajes registrados");
    }
        //usuario.getCuenta().setSaldo(usuario.getCuenta().getSaldo()-usuario.getCuenta().getPlan().getvSacarB());
        // System.out.println(usuario.getCuenta().getPlan().getIdPlan());
    }

}
