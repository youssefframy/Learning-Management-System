/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import Classes.Course;
import Classes.RegisteredCourse;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tamer A.Yassen
 */
public class RegCourse_ListPanel extends javax.swing.JPanel {

    /**
     * Creates new form Prof_AddPanel
     */
    public RegCourse_ListPanel() {
        initComponents();
        addRowsTojTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextFieldSearchKey = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Course name", "Credit Hours", "Dept"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnSearch.setBackground(new java.awt.Color(102, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loupe.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextFieldSearchKey, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(91, 91, 91)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(jTextFieldSearchKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
//        if (!jTextFieldSearchKey.getText().equals("")) {
//            RegisteredCourse x = new RegisteredCourse();
//
//
//            RegisteredCourse returned = x.searchRegCByStudentId(Integer.parseInt(jTextFieldSearchKey.getText()));
//            if (returned.getStudentID() > 0) {
//
//            } else {
//                jLabelSucessOrFail.setText("Not Found ...!");
//            }
//        } else {
//            jLabelSucessOrFail.setText("Missing required Fields ... !  Please, Search By ID before submit ...!");
//        }
    }//GEN-LAST:event_btnSearchActionPerformed

    public void addRowsTojTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[4];

        Course c = new Course();
        ArrayList<Course> courses =new ArrayList<Course>();

        courses = c.listCourses();

        for (Course x : courses){
            rowData[0] = x.getCId();
            rowData[1] = x.getCName();
            rowData[2] = x.getCreditHours();
            rowData[3] = x.dept.getDeptName();

            model.addRow(rowData);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldSearchKey;
    // End of variables declaration//GEN-END:variables
}
