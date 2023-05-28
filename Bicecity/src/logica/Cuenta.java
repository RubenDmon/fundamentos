/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.ArrayList;

/**
 *
 * @author rdmon
 */

public class Cuenta {

    private int codigo;
    private int saldo;
    private String estado;
    private Plan plan;
    private Viaje viaje;
    
    private ArrayList<Viaje> viajes = new ArrayList<>();
    
    
    public Cuenta() {
        plan = new Plan();
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    
    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }


    /*
    public void setSaldoIN(int saldoIN) {
        this.saldoIN = saldoIN;
    }*/

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //plan tambien aca

    /* public int getCodigo() {
        return codigo;
    }*/
    public int getSaldo() {
        return saldo;
    }


    public String getEstado() {
        return estado;
    }
}
