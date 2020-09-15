/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clase2.diaz.DAO;

import com.clase2.diaz.conexionbd.Conexionbd;
import com.clase2.diaz.entidades.Estudiante;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class CLSjoinpersonaestudiante {

    Conexionbd cn = new Conexionbd();
    Connection con = cn.retornarConexion();

    public ArrayList<Estudiante> MostrarJoinEstudiantePersona() {
        ArrayList<Estudiante> lista = new ArrayList<>();

        try {
            CallableStatement st = con.prepareCall("call SP_S_JOINPERSONAESTUDIANTE ()");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Estudiante es = new Estudiante();
                es.setNombre(rs.getString("Nombre"));
                es.setApellido(rs.getString("Apellido"));
                es.setMatricula(rs.getInt("matricula"));

                lista.add(es);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
        return lista;
    }
}
