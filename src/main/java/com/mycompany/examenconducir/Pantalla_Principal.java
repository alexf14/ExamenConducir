package com.mycompany.examenconducir;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Pantalla_Principal extends javax.swing.JFrame {

    public Pantalla_Principal() {
        initComponents();
        setSize(1000, 500);
        setLocationRelativeTo(null);
        fondo.setIcon(new ImageIcon("..\\ExamenConducir\\Imagenes\\Fondo.jpg"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttPermisoB = new javax.swing.JButton();
        txtBienvenida = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuConfiguracion = new javax.swing.JMenu();
        acercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        buttPermisoB.setText("Permiso B");
        buttPermisoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttPermisoBActionPerformed(evt);
            }
        });
        getContentPane().add(buttPermisoB);
        buttPermisoB.setBounds(360, 330, 300, 50);

        txtBienvenida.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtBienvenida.setForeground(new java.awt.Color(51, 51, 51));
        txtBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBienvenida.setText("<html>  Bienvenido a TeoricoTest, escoge el permiso del que te quieres examinnar <html>");
        txtBienvenida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtBienvenida);
        txtBienvenida.setBounds(170, 30, 710, 180);

        fondo.setIcon(new ImageIcon("..\\ExamenConducir\\Imagenes\\Fondo.jpg"));
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 1000, 480);

        menuConfiguracion.setText("Configuración");
        menuConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuConfiguracionMouseClicked(evt);
            }
        });
        barraMenu.add(menuConfiguracion);

        acercaDe.setText("Acerca de...");
        acercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acercaDeMouseClicked(evt);
            }
        });
        barraMenu.add(acercaDe);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttPermisoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttPermisoBActionPerformed
        Test test = new Test ();
        
        CargarDatos.cargarPreguntas();
        CargarDatos.cargarRespuestaCorrecta();
        CargarDatos.cargarRestpuestaErronea();
        
        test.setVisible(true);
        test.crearTest();
        this.setVisible(false);
    }//GEN-LAST:event_buttPermisoBActionPerformed

    private void menuConfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuConfiguracionMouseClicked
        Configuracion conf = new Configuracion();

        conf.setVisible(true);
    }//GEN-LAST:event_menuConfiguracionMouseClicked

    private void acercaDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acercaDeMouseClicked
        JOptionPane.showMessageDialog(null, "En confgiguración puedes escoger el número de \n"
                + " preguntas que queires hacer por cada test.\n"
                + "La dificultad dependera del número de preguntas que desees responder \n"
                + " por test, el número de fallos máximos para aprobar siempre sera 2");
    }//GEN-LAST:event_acercaDeMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Pantalla_Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu acercaDe;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton buttPermisoB;
    private javax.swing.JLabel fondo;
    private javax.swing.JMenu menuConfiguracion;
    private javax.swing.JLabel txtBienvenida;
    // End of variables declaration//GEN-END:variables
}
