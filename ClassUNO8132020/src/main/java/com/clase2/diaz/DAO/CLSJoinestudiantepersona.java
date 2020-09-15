/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clase2.diaz.DAO;

import com.clase2.diaz.conexionbd.Conexionbd;
import com.clase2.diaz.entidades.Estudiante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class CLSJoinestudiantepersona {

    Conexionbd cn = new Conexionbd();
    Connection con = cn.retornarConexion();

    public ArrayList<Estudiante> MostrarJoinEstudiantePersona() {
        ArrayList<Estudiante> lista = new ArrayList<>();

        try {
            CallableStatement st = con.prepareCall("call SP_S_JOINESTUDIANTEPERSONA ()");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Estudiante es = new Estudiante();
                es.setId(rs.getInt("idestudiante"));
                es.setMatricula(rs.getInt("matricula"));
                es.setIdPersona(rs.getInt("idPersona"));
                es.setNombre(rs.getString("Nombre"));
                es.setUsu(rs.getString("USU"));
                es.setPass(rs.getString("PASS"));

                lista.add(es);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e);
        }
        return lista;
    }
}
