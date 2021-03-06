
package Frames.Panels;

import Classes.Exam;
import Classes.Main;
import Classes.Course;


public class Exam_UpdatePanel extends javax.swing.JPanel {

    /**
     * Creates new form Prof_AddPanel
     */
    public Exam_UpdatePanel() {
        initComponents();
        jTextFieldID.setEditable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldExamName = new javax.swing.JTextField();
        jLabelSucessOrFail = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxDept = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jTextFieldSearchKey = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCourseName = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Exam ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText(" Exam Name");

        jLabelSucessOrFail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSucessOrFail.setText("Enter Exam ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Date");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Department");

        jComboBoxDept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CS", "IS", "IT", "SW" }));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loupe.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Course Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldSearchKey)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnSearch)
                                                .addGap(116, 116, 116))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelSucessOrFail, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextFieldCourseName))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel3)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jTextFieldDate))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel2)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jTextFieldExamName, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel1)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(93, 93, 93)
                                                                .addComponent(btnUpdate)))
                                                .addGap(43, 43, 43)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnDelete)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel9)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jComboBoxDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSearch)
                                        .addComponent(jTextFieldSearchKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSucessOrFail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextFieldExamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jComboBoxDept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextFieldCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnDelete))
                                .addGap(201, 201, 201))
        );
    }// </editor-fold>

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (!jTextFieldID.getText().equals("") && !jTextFieldExamName.getText().equals("") && !jTextFieldDate.getText().equals("") && !jTextFieldCourseName.getText().equals("")) {

            Exam x = new Exam();
            x.setEId(jTextFieldID.getText());
            x.setEName(jTextFieldExamName.getText());
            x.setEDate(Integer.parseInt(jTextFieldDate.getText()));
            x.setCourse(jTextFieldCourseName.getText());

            if (jComboBoxDept.getSelectedItem().equals("CS")) {
                x.setDept(Main.cs);
            } else if (jComboBoxDept.getSelectedItem().equals("IS")) {
                x.setDept(Main.is);
            } else if (jComboBoxDept.getSelectedItem().equals("IT")) {
                x.setDept(Main.it);
            } else if (jComboBoxDept.getSelectedItem().equals("SW")) {
                x.setDept(Main.sw);
            }

            if (x.addExam()) {
                jLabelSucessOrFail.setText("Added the new exam successfully");
                resetPanelData();
            } else {
                jLabelSucessOrFail.setText("Somethin went wrong. Please Try again!");
            }
        } else {
            jLabelSucessOrFail.setText("Missing required Fields. Please, complete them before submit.");
        }

    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (!jTextFieldSearchKey.getText().equals("")) {
            Exam x = new Exam();
            Exam returned = x.searchExamById(jTextFieldSearchKey.getText());
            if (!returned.getEId().isEmpty()) {
                setPanelData(returned);
            } else {
                jLabelSucessOrFail.setText("Not Found");
            }
        } else {
            jLabelSucessOrFail.setText("Missing required Fields ");
        }

    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (!jTextFieldSearchKey.getText().equals("")) {
            Course x = new Course();
            if (x.deleteCourse(jTextFieldSearchKey.getText())) {
                jLabelSucessOrFail.setText("Deleted Successfully");
                resetPanelData();
            } else {
                jLabelSucessOrFail.setText("Failed to delete");
            }
        } else {
            jLabelSucessOrFail.setText("Missing required Fields !");
        }
    }

    protected void resetPanelData() {
        jTextFieldID.setText("");
        jTextFieldExamName.setText("");
        jTextFieldDate.setText("");

        jComboBoxDept.setSelectedIndex(0);

    }

    protected void setPanelData(Exam x) {
        jTextFieldID.setText("" + x.getEId());
        jTextFieldExamName.setText("" + x.getEName());
        jTextFieldDate.setText("" + x.getEDate());
        jTextFieldCourseName.setText("" + x.getCourse());


        if (x.dept.getDeptName().equals("CS")) {
            jComboBoxDept.setSelectedIndex(0);
        } else if (x.dept.getDeptName().equals("IS")) {
            jComboBoxDept.setSelectedIndex(1);
        } else if (x.dept.getDeptName().equals("IT")) {
            jComboBoxDept.setSelectedIndex(2);
        } else if (x.dept.getDeptName().equals("SW")) {
            jComboBoxDept.setSelectedIndex(3);
        }

    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> jComboBoxDept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSucessOrFail;
    private javax.swing.JTextField jTextFieldCourseName;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldExamName;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldSearchKey;
    // End of variables declaration
}
