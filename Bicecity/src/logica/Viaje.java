/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author rdmon
 */
public class Viaje {
    private int idViaje,minAd,costo,duracion;
    private String horaF,horaI;
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public void setHoraF(String horaF) {
        this.horaF = horaF;
    }

    public void setHoraI(String horaI) {
        this.horaI = horaI;
    }

    public void setMinAd(int minAd) {
        this.minAd = minAd;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public String getHoraF() {
        return horaF;
    }

    public String getHoraI() {
        return horaI;
    }

    public int getMinAd() {
        return minAd;
    }

    public int getCosto() {
        return costo;
    }

    public int getDuracion() {
        return duracion;
    }
    
    
}
