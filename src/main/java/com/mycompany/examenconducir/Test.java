package com.mycompany.examenconducir;

import javax.swing.JOptionPane;

public class Test extends javax.swing.JFrame {
    
    CargarDatos cargarDatos = new CargarDatos ();
    
    String pregunta;
    static int fallos = 0;
    
    public Test() {
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttSiguiente = new javax.swing.JButton();
        testPlantilla = new com.mycompany.examenconducir.TestPlantilla();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        buttSiguiente.setText("Siguiente Pregunta");
        buttSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addComponent(testPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(testPlantilla, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(buttSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttSiguienteActionPerformed
       crearTest();       
    }//GEN-LAST:event_buttSiguienteActionPerformed

    public void crearTest () {// Este método establece todos los elementos necesarios para realizar el test
       pregunta = cargarDatos.getPregunta();
        if (pregunta != null) {
            
            testPlantilla.setTxtPregunta(pregunta);

            int correcta = cargarDatos.posPreguntaCorrecta();
            String respuestaCorrecta = cargarDatos.getRespuestaCorrecta(pregunta);
            String respuestaErronea = cargarDatos.getRespuestaErronea(pregunta);
            String respuestaErronea2 = cargarDatos.getRespuestaErronea(pregunta);

            switch (correcta) {
                case 1 -> {
                    testPlantilla.setTxtRespuesta1(respuestaCorrecta);
                    testPlantilla.setTxtRespuesta2(respuestaErronea);
                    testPlantilla.setTxtRespuesta3(respuestaErronea2);
                }
                case 2 -> {
                    testPlantilla.setTxtRespuesta2(respuestaCorrecta);
                    testPlantilla.setTxtRespuesta1(respuestaErronea);
                    testPlantilla.setTxtRespuesta3(respuestaErronea2);
                }
                default -> {
                    testPlantilla.setTxtRespuesta3(respuestaCorrecta);
                    testPlantilla.setTxtRespuesta1(respuestaErronea);
                    testPlantilla.setTxtRespuesta2(respuestaErronea2);
                }
            }
        } else {
            if(fallos > 2){
                JOptionPane.showMessageDialog(null, "Has suspendido el test con "+fallos+" fallos");
            }else{
                JOptionPane.showMessageDialog(null, "Felicicdades!!!, has aprobado el test con tan solo "+fallos+" fallos");
            }
       }
        
       String respuesta = testPlantilla.getRespuestaSeleccionada();      
       
       boolean respuestaCorrecto = cargarDatos.esCorrecta(respuesta);
       
       if(!respuestaCorrecto){
           fallos ++;
       }
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Test().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttSiguiente;
    private com.mycompany.examenconducir.TestPlantilla testPlantilla;
    // End of variables declaration//GEN-END:variables
}
