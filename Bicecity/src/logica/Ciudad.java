/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author rdmon
 */
public class Ciudad {
    private int idCiudad;
    private String nCiudad;
    private String horaInicialServ;
    private String horaFinalServ;

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public void setnCiudad(String nCiudad) {
        this.nCiudad = nCiudad;
    }

    public void setHoraInicialServ(String horaInicialServ) {
        this.horaInicialServ = horaInicialServ;
    }

    public void setHoraFinalServ(String horaFinalServ) {
        this.horaFinalServ = horaFinalServ;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public String getnCiudad() {
        return nCiudad;
    }

    public String getHoraInicialServ() {
        return horaInicialServ;
    }

    public String getHoraFinalServ() {
        return horaFinalServ;
    }
    
}
