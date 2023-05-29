/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import conexion.Excepcion;
import conexion.Servidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Plan;

/**
 *
 * @author rdmon
 */
public class planDAO {
        public Plan obtenerPlan(int idCod) throws Excepcion {
        Plan plan = new Plan();
        try {

            String strSQL = "SELECT * FROM plan JOIN plan_cuenta ON plan_cuenta.k_idplan=plan.k_idplan WHERE k_codigo= ?";
            //se llama a tomar conccion de servidor

            Connection conexion = Servidor.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, idCod);

            ResultSet resultSet = prepStmt.executeQuery();

            if (resultSet.next()) {
                plan.setIdPlan(resultSet.getInt("k_idplan"));
                plan.setvMinAd(resultSet.getInt("v_minadicional"));
                plan.setvSacarB(resultSet.getInt("v_sacarbicicleta"));
                plan.setvCantV(resultSet.getInt("v_cantviajes"));
                plan.setvViajeAd(resultSet.getInt("v_viajead"));
                plan.setvBase(resultSet.getInt("v_base"));
                plan.settMax(resultSet.getInt("o_tiempomax"));
  
                // Procesar el valor entero
            }
            prepStmt.close();
        } catch (SQLException e) {
            Servidor.getInstance().rollback();
            throw new Excepcion("cuentaDAO", "No pudo obtener el id " + e.getMessage());
        } finally {
            Servidor.getInstance().liberarConexion();
        }

        //ponerle plan asociado a la cuenta
        
        
        return plan;
    }
}
