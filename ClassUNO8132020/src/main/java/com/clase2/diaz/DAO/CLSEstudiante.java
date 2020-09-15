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
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class CLSEstudiante {

    Conexionbd claseConexionbd = new Conexionbd();
    Connection conectar = claseConexionbd.retornarConexion();

    public boolean LoginEstudiante(String user, String Pass) {
        ArrayList<Estudiante> ListaUsePass = new ArrayList<>();
        ArrayList<Estudiante>ListarContra = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_LOGINEST(?,?)");
            Statement.setString("pusuario", user);
            Statement.setString("ppass", Pass);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Estudiante es = new Estudiante();
                es.setUsu(resultadoDeConsulta.getString("USU"));
                es.setPass(resultadoDeConsulta.getString("PASS"));
                ListaUsePass.add(es);
            }
            String usuariodebasedatos = null;
            String passdebasedatos = null;
            for (var iterador : ListaUsePass) {
                usuariodebasedatos = iterador.getUsu();
                passdebasedatos = iterador.getPass();
            }
            CallableStatement st2 = conectar.prepareCall("call SP_S_CRIP(?)");
            st2.setString("PcripPass", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {                
                Estudiante escrip = new Estudiante();
                
                escrip.setPass(rs2.getNString("crip"));
                ListarContra.add(escrip);
            }
            String passcrip =null;
            for(var iterador : ListarContra){
                passcrip = iterador.getPass();
                
                Pass = passcrip;
            }
            if(usuariodebasedatos!=null && passdebasedatos!=null){
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

    public ArrayList<Estudiante> MostraEstudiante() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_Estudiante()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Estudiante estu = new Estudiante();
                estu.setId(resultadoDeConsulta.getInt("idestudiante"));
                estu.setMatricula(resultadoDeConsulta.getInt("matricula"));
                estu.setIdPersona(resultadoDeConsulta.getInt("idPersona"));
                estu.setUsu(resultadoDeConsulta.getString("USU"));
                estu.setPass(resultadoDeConsulta.getString("PASS"));
                estu.setNIE(resultadoDeConsulta.getString("NIE"));
                estudiantes.add(estu);
            }
            conectar.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return estudiantes;
    }
    
    public void AgregarEstudiante(Estudiante Est){
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_I_Estudiante(?,?,?,?, ?)");
            Statement.setInt("Ematricula", Est.getMatricula());
            Statement.setInt("EidPersona", Est.getIdPersona());
            Statement.setString("EUSU", Est.getUsu());
            Statement.setString("EPASS", Est.getPass());
            Statement.setString("ENIE", Est.getNIE());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void ActualizarEstudiante(Estudiante Est) {
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_U_Estudiante(?,?,?,?,?,?)");
            Statement.setInt("Eidestudiante", Est.getId());
            Statement.setInt("Ematricula", Est.getMatricula());
            Statement.setInt("EidPersona", Est.getIdPersona());
            Statement.setString("EUSU", Est.getUsu());
            Statement.setString("EPASS", Est.getPass());
            Statement.setString("ENIE", Est.getNIE());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void BorrarEstudiante(Estudiante Est){
        try {
            CallableStatement Statement = conectar.prepareCall("call SP_D_Estudiante(?)");
            Statement.setInt("Eidestudiante", Est.getId());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
