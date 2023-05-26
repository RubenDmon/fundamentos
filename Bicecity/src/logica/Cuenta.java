/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author rdmon
 */
public class Cuenta {
    //private int codigo;
    private int saldoIN;
    private int saldoFN;
    private String estado;
    
    
    public Cuenta(){
     }
    public Cuenta(int SI){
         this.saldoIN=SI;
         this.saldoFN=0;
         this.estado="";
                 
     }
     public Cuenta(int SI,int SF,String E){
         this.saldoIN=SI;
         this.saldoFN=SF;
         this.estado=E;
     }
    public void setSaldoIN(int saldoIN) {
        this.saldoIN = saldoIN;
    }
    

  /*
    public void setSaldoIN(int saldoIN) {
        this.saldoIN = saldoIN;
    }*/

    public void setSaldoFN(int saldoFN) {
        this.saldoFN = saldoFN;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    //plan tambien aca

   /* public int getCodigo() {
        return codigo;
    }*/

    public int getSaldoIN() {
        return saldoIN;
    }

    public int getSaldoFN() {
        return saldoFN;
    }

    public String getEstado() {
        return estado;
    }
}
