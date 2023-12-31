/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package sisvac.gui;

import java.util.List;
import javax.swing.JLabel;
import sisvac.ManejadorDatos;
import sisvac.ManejadorSesion;
import sisvac.model.Vacacion;



/**
 *
 * @author frank
 */
public class BloqueInVacacionesGui extends javax.swing.JPanel {
    /**
     * Creates new form PanelLogin2
     */
    public BloqueInVacacionesGui() {
        
        initComponents();
        actualizarData();
    }

    public void actualizarData(){
        ManejadorSesion appSesion = ManejadorSesion.getInstance(); 
        
        ManejadorDatos datosGui = new ManejadorDatos();
        List<Vacacion> vacacionesList = datosGui.buscarVacaciones(appSesion.getDni());
        elementoVacacionItem  vacacionItem;
        for(Vacacion vac: vacacionesList){
            vacacionItem = new elementoVacacionItem();
            vacacionItem.setData(vac.getNum_dias(), vac.getFecha_inicio(), vac.getFecha_fin());
            misVacaciones.add(vacacionItem);
        }
        if(vacacionesList.isEmpty()){
            JLabel  noVacaciones = new JLabel ("Aun no tienes vacaciones programadas.");
            misVacaciones.add(noVacaciones);
        }
        
        
       
        
     
    }

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        misVacaciones = new javax.swing.JPanel();

        jLabel12.setText("jLabel12");

        setBackground(new java.awt.Color(243, 243, 243));
        setPreferredSize(new java.awt.Dimension(840, 400));

        jPanel2.setBackground(new java.awt.Color(252, 252, 252));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(93, 43, 255));
        jLabel2.setText("Programacion Vacaciones");

        jSeparator2.setForeground(new java.awt.Color(239, 239, 239));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/travel abroad travel tourism_3943357 (2).png"))); // NOI18N

        misVacaciones.setBackground(new java.awt.Color(252, 252, 252));
        misVacaciones.setPreferredSize(new java.awt.Dimension(500, 200));
        misVacaciones.setLayout(new javax.swing.BoxLayout(misVacaciones, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(misVacaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(misVacaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel misVacaciones;
    // End of variables declaration//GEN-END:variables
}
