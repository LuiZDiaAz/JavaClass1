/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clase2.diaz.operacionesbd;

import com.clase2.diaz.DAO.CLSEstudiante;
import com.clase2.diaz.DAO.CLSJoinestudiantepersona;
import com.clase2.diaz.DAO.CLSPersona;
import com.clase2.diaz.entidades.Estudiante;
import com.clase2.diaz.entidades.Persona;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PREDATOR
 */
public class crudEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form crudEstudiante
     */
    public crudEstudiante() {
        initComponents();
        String Titulos [] = {"IDESTUDIANTE","MATRICULA","IDPERSONA", "NOMBRE", "USUARIO", "CONTRASEÑA"};
        DefaultTableModel df = new DefaultTableModel(null, Titulos);
        CLSJoinestudiantepersona CLSJOINES = new CLSJoinestudiantepersona();
        var  MostrarJoinEstudiantePersona = CLSJOINES.MostrarJoinEstudiantePersona();
        String filas [] = new String[6];
        
        for(var iterador:MostrarJoinEstudiantePersona){
        filas[0] = String.valueOf(iterador.getId());
        filas[1] = String.valueOf(iterador.getMatricula());
        filas[2] = String.valueOf(iterador.getIdPersona());
        filas[3] = iterador.getNombre();
        filas[4] = iterador.getUsu();
        filas[5] = iterador.getPass();
        df.addRow(filas);
        
        
        
        }
        Tb_Joinpersonaestudiante.setModel(df);
    }
    
    void MostrarTablaEstudiante() {
        String TITULOS[] = {"IDESTUDIANTE", "MATRICULA", "IDPERSONA", "USUARIO", "CONTRASEÑA"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        CLSEstudiante ClaseEstudiante = new CLSEstudiante();
        ArrayList<Estudiante> estudiantes = ClaseEstudiante.MostraEstudiante();
        String filas [] = new String[5];
        for (var IterarDatosEstudiante : estudiantes){
        filas[0] = String.valueOf(IterarDatosEstudiante.getId());
        filas[1] = String.valueOf(IterarDatosEstudiante.getMatricula());
        filas[2] = String.valueOf(IterarDatosEstudiante.getIdPersona());
        filas[3] = IterarDatosEstudiante.getUsu();
        filas[4] = IterarDatosEstudiante.getPass();
        ModeloTabla.addRow(filas);
        }
        Tb_Joinpersonaestudiante.setModel(ModeloTabla);
    }
    
    void MostrarTablaPersona() {
        String TITULOS[] = {"ID", "NOMBRE", "APELLIDO", "EDAD", "SEXO"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        CLSPersona ClasePersona = new CLSPersona();
        ArrayList<Persona> Personas = ClasePersona.MostrarPersona();
        String filas [] = new String[5];
        for (var IterarDatosPersona : Personas){
        filas[0] = String.valueOf(IterarDatosPersona.getIdPersona());
        filas[1] = IterarDatosPersona.getNombre();
        filas[2] = IterarDatosPersona.getApellido();
        filas[3] = String.valueOf(IterarDatosPersona.getEdad());
        filas[4] = IterarDatosPersona.getSexo();
        ModeloTabla.addRow(filas);
        }
        Tb_Personas.setModel(ModeloTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpEstudiante = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdEstudiante = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtIdPersona = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tb_Personas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tb_Joinpersonaestudiante = new javax.swing.JTable();

        jLabel1.setText("ID Estudiante");

        jLabel2.setText("Matricula");

        jLabel3.setText("ID Persona");

        jLabel4.setText("Usuario");

        jLabel5.setText("Contraseña");

        Tb_Personas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tb_Personas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_PersonasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tb_Personas);

        jLabel6.setText("DATOS");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMatricula)
                                    .addComponent(txtIdPersona)
                                    .addComponent(txtUsuario)
                                    .addComponent(txtContraseña))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(txtIdEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2))
                                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addComponent(txtIdPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpEstudiante.addTab("DATOS", jPanel1);

        Tb_Joinpersonaestudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tb_Joinpersonaestudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_JoinpersonaestudianteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tb_Joinpersonaestudiante);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpEstudiante.addTab("VENTA DE DATOS", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpEstudiante)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpEstudiante)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CLSEstudiante estudiantes = new CLSEstudiante();
        Estudiante estudiante = new Estudiante();
        estudiante.setMatricula(Integer.parseInt(txtMatricula.getText()));
        estudiante.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
        estudiante.setUsu(txtUsuario.getText());
        estudiante.setPass(txtContraseña.getText());
        estudiantes.AgregarEstudiante(estudiante);
        MostrarTablaEstudiante();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CLSEstudiante estudiantes = new CLSEstudiante();
        Estudiante estudiante = new Estudiante();
        estudiante.setId(Integer.parseInt(txtIdEstudiante.getText()));
        estudiante.setMatricula(Integer.parseInt(txtMatricula.getText()));
        estudiante.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
        estudiante.setUsu(txtUsuario.getText());
        estudiante.setPass(txtContraseña.getText());
        estudiantes.ActualizarEstudiante(estudiante);
        MostrarTablaEstudiante();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CLSEstudiante estudiantes = new CLSEstudiante();
        Estudiante estudiante = new Estudiante();
        estudiante.setId(Integer.parseInt(txtIdEstudiante.getText()));
        estudiantes.BorrarEstudiante(estudiante);
        MostrarTablaEstudiante();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Tb_JoinpersonaestudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_JoinpersonaestudianteMouseClicked
        tpEstudiante.setSelectedIndex(tpEstudiante.indexOfComponent(jPanel1));
        
        int fila = Tb_Joinpersonaestudiante.getSelectedRow();
        
        String IDEstudiante = String.valueOf(Tb_Joinpersonaestudiante.getValueAt(fila, 0));
        String Matricula = String.valueOf(Tb_Joinpersonaestudiante.getValueAt(fila, 1));
        String IDPersona = String.valueOf(Tb_Joinpersonaestudiante.getValueAt(fila, 2));
        String Usu = String.valueOf(Tb_Joinpersonaestudiante.getValueAt(fila, 4));
        String Pass = String.valueOf(Tb_Joinpersonaestudiante.getValueAt(fila, 5));
        
        txtIdEstudiante.setText(IDEstudiante);
        txtMatricula.setText(Matricula);
        txtIdPersona.setText(IDPersona);
        txtUsuario.setText(Usu);
        txtContraseña.setText(Pass);
    }//GEN-LAST:event_Tb_JoinpersonaestudianteMouseClicked

    private void Tb_PersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_PersonasMouseClicked
        
    }//GEN-LAST:event_Tb_PersonasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tb_Joinpersonaestudiante;
    private javax.swing.JTable Tb_Personas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tpEstudiante;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtIdPersona;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}