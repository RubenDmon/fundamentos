/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.ciudadDAO;
import datos.usuarioDAO;
import conexion.Excepcion;

/**
 *
 * @author rdmon
 */

public class Gestor {
    private ciudadDAO ciudadDAO;
    private usuarioDAO usuarioDAO;
    
    private Ciudad ciudad;
    private Usuario usuario;
    private Cuenta cuenta;
    
    public Gestor() {
       ciudadDAO = new ciudadDAO();
       usuarioDAO = new usuarioDAO();
    }
    public void incluirCiudad(int id, String nombre,String hi, String hf) throws Excepcion {
      ciudad = new Ciudad();
      ciudad.setIdCiudad(id);
      ciudad.setnCiudad(nombre);
      ciudad.setHoraInicialServ(hi);
      ciudad.setHoraFinalServ(hf);
      ciudadDAO.incluirCiudad(ciudad);
    }
        public void incluirUser(String k_idusuario, String i_tipoid,String n_correo,String n_nombre1,String n_nombre2,String n_apellido1,String n_apellido2,String n_nacionalidad,String f_nacimiento,String n_eps,String i_sexo,int v_celular,int saldoI) throws Excepcion {
      usuario = new Usuario();
      
      usuario.getCuenta().setSaldo(saldoI); 
      usuario.getCuenta().setEstado("ACTV");
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
      usuarioDAO.incluirUsuario(usuario);
    }
        public int countUser() throws Excepcion {
      return usuarioDAO.contarUsuarios();
    }
        
     //si se hace de inmediato
     public void asociarPlan(int Plan) throws Excepcion {
             usuario.getCuenta().setCodigo(usuarioDAO.obtenerIdCuenta(usuario.getIdUsuario()));
             usuarioDAO.asociarPlan(usuario.getCuenta().getCodigo() , Plan);
    }
        
    public void iniciar(String idUser) throws Excepcion {
             usuario=usuarioDAO.obtenerUsuario(idUser);
             System.out.println(usuario.getApellido1());
    }
        
      
}
