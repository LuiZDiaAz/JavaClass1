/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clase2.diaz.DAO;

import com.clase2.diaz.conexionbd.Conexionbd;
import com.clase2.diaz.entidades.Profesor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class CLSProfesor {

    Conexionbd claseConexionbd = new Conexionbd();
    Connection conectar = claseConexionbd.retornarConexion();

    public boolean LoginProfesor(String user, String Pass) {
        ArrayList<Profesor> ListaUsePass = new ArrayList<>();
        ArrayList<Profesor> ListarContra = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_LOGINPRO(?,?)");
            Statement.setString("pusuario", user);
            Statement.setString("ppass", Pass);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Profesor pr = new Profesor();
                pr.setUsua(resultadoDeConsulta.getString("USU"));
                pr.setPassw(resultadoDeConsulta.getString("PASS"));
                ListaUsePass.add(pr);
            }
            String usuariodebasedatos = null;
            String passdebasedatos = null;
            for (var iterador : ListaUsePass) {
                usuariodebasedatos = iterador.getUsua();
                passdebasedatos = iterador.getPassw();
            }
            CallableStatement st2 = conectar.prepareCall("call SP_S_CRIPPRO(?)");
            st2.setString("PcripPass", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Profesor prcrip = new Profesor();

                prcrip.setPassw(rs2.getNString("crip"));
                ListarContra.add(prcrip);
            }
            String passcrip = null;
            for (var iterador : ListarContra) {
                passcrip = iterador.getPassw();

                Pass = passcrip;
            }
            if (usuariodebasedatos != null && passdebasedatos != null) {
                if (usuariodebasedatos.equals(user) && passdebasedatos.equals(Pass)) {
                    return true;
                }
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return false;
    }
}
