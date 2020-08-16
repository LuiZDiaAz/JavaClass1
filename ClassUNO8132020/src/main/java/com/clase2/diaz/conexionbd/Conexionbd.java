/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clase2.diaz.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PREDATOR
 */
public class Conexionbd {
    
    private Connection conexion;
    public Conexionbd(){
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/clase01","root","root");
            
            System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            System.out.println("Conexion Fallida" + e);
        }
        
        
    }
    public Connection retornarConexion(){
    return conexion;
    }
}
