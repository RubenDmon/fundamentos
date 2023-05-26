/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;


/**
 *
 * @author rdmon
 */
public class Usuario {

    public Usuario(){
    cuenta=new Cuenta();
    }
    
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getEps() {
        return eps;
    }

    public int getCelular() {
        return celular;
    }
    private String idUsuario;
    private String tipoId;
    private String correo;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String nacionalidad;
    private String sexo;
    private String nacimiento;
    private String eps;
    private int celular;
    private Cuenta cuenta;

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
