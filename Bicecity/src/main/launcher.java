/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import conexion.Excepcion;
import logica.Gestor;

/**
 *
 * @author rdmon
 */
public class launcher {

    public static void creoUsuario(Gestor ges, String id) throws Excepcion {
        if (ges.getFunciona()) {
            System.out.println("el usuario se creo correctamente");
            ges.iniciar(id);
        } else {
            System.out.println("Error: el usuario ya existe");
        }
    }

    public static void inicioUsuario(Gestor ges, String id) throws Excepcion {
        ges.iniciar(id);
        if (ges.getFunciona()) {
            System.out.println("el usuario inicio correctamente");
        } else {
            System.out.println("Error: el usuario no existe o no fue encontrado");
        }
    }

    public static void main(String[] args) throws Excepcion {

        //SE crea un tipo gestor que es el que opera la logica y tiene una conexion con la capa logica es nuestro controlador
        Gestor ges = new Gestor();
        String idUser = "102266";
        //pruebas para añadir ciudad
        //ges.incluirCiudad(0, "bogota", "10:00:00", "12:22:55");  

        //modulo de creacion de usurio
        ges.incluirUser(idUser, "CC", "rube@gmail.com", "ruben", "", "Montoya", "", "Colombiana", "2023-05-25", "EPS", "m", 313145, 1000000);
        ges.asociarPlan(3);
        creoUsuario(ges, idUser);
        //hasta aca van cuendo un usuario crea su cuenta se inicia en creoUsuario o se puede despues sin problema

        //siempre se debe iniciar al user para las demas operaciones
        //hasta este punto va el modulo de resgistro de usuarioss
        //aca empieza el modulo de inicio de seccion
        inicioUsuario(ges, idUser);
        //para usar este primero hay que iniciar

        ///para iniciar un viaje
        ges.incluirViajeDes();
        if (ges.getUserViajeI()) {
            System.out.println("el usuario viajo correctamente");

            // y aca el metodo de bloqueo
        } else {
            System.out.println("lo siento no puedes viajar");
        }

        //siempre despues de un bloqueo se refrescan los datos de lo cuenta
        ges.iniciar(idUser);
        //para acabar un viaje y recibir el dinero el condicional es para que verificque que si comenzo un viaje

        if (ges.getUserViajeI()) {
            ges.incluirViajeBloq();
        }

        if (ges.getUserViajeF()) {
            System.out.println("el usuario termino su viaje correctamente");
        } else {
            System.out.println("lo siento debes empezar un viaje");
        }
        //siempre despues de un bloqueo se refrescan los datos de lo cuenta
        ges.iniciar(idUser);
        ges.modificarUser("daniel", "", "Garzon", "Valvuena", "nueva", 313544);
        if (ges.getUserModified()) {
            System.out.println("usuario corregido correctamente");
        } else {
            System.out.println("Error nose pudo actualizar el user");
        }
        ges.iniciar(idUser);
        ges.historialViajes();
    }

}
