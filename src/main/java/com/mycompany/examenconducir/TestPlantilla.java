package com.mycompany.examenconducir;

import java.awt.Color;
import javax.swing.JLabel;

public class TestPlantilla extends javax.swing.JPanel {

    public TestPlantilla() {
        initComponents();
    }                                                              

    public String getTxtPregunta() {
        return txtPregunta.getText().toString();
    }

    public void setTxtPregunta(String txtPregunta) {
        this.txtPregunta.setText("<html>"+txtPregunta+"<html>");
        System.out.println(this.txtPregunta.getText());

    }

    public String getTxtRespuesta1() {
        return txtRespuesta1.getText().toString();
    }

    public void setTxtRespuesta1(String respuesta) {
        this.txtRespuesta1.setText(respuesta);
    }

    public String getTxtRespuesta2() {
        return txtRespuesta2.getText().toString();
    }

    public void setTxtRespuesta2(String respuesta) {
        this.txtRespuesta2.setText(respuesta);
    }

    public String getTxtRespuesta3() {
        return txtRespuesta3.getText().toString();
    }

    public void setTxtRespuesta3(String respuesta) {
        this.txtRespuesta3.setText(respuesta);
    }
    
    public String getRespuestaSeleccionada (){
       if(txtRespuesta1.isSelected()){
           return txtRespuesta1.getText();
       }else if(txtRespuesta2.isSelected()){
           return txtRespuesta2.getText();
       }else if(txtRespuesta3.isSelected()){
           return txtRespuesta3.getText();
       }else{
           return null;
       }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtPregunta = new javax.swing.JLabel();
        txtRespuesta1 = new javax.swing.JRadioButton();
        txtRespuesta2 = new javax.swing.JRadioButton();
        txtRespuesta3 = new javax.swing.JRadioButton();

        txtPregunta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtPregunta.setForeground(new java.awt.Color(0, 0, 0));
        txtPregunta.setText("jLabel1");

        radioGroup.add(txtRespuesta1);
        txtRespuesta1.setText("jRadioButton1");
        txtRespuesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuesta1ActionPerformed(evt);
            }
        });

        radioGroup.add(txtRespuesta2);
        txtRespuesta2.setText("jRadioButton2");

        radioGroup.add(txtRespuesta3);
        txtRespuesta3.setText("jRadioButton3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRespuesta1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(txtRespuesta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRespuesta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(txtPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(txtPregunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(txtRespuesta1)
                .addGap(30, 30, 30)
                .addComponent(txtRespuesta2)
                .addGap(30, 30, 30)
                .addComponent(txtRespuesta3)
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtRespuesta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespuesta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespuesta1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JLabel txtPregunta;
    private javax.swing.JRadioButton txtRespuesta1;
    private javax.swing.JRadioButton txtRespuesta2;
    private javax.swing.JRadioButton txtRespuesta3;
    // End of variables declaration//GEN-END:variables
}
