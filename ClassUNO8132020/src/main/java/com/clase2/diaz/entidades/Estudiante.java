/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clase2.diaz.entidades;

import lombok.*;

/**
 *
 * @author PREDATOR
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Estudiante extends Persona{
    protected int Id;
    protected int matricula;
    protected String Usu;
    protected String pass;
}
