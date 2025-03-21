/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpack;

import config.dbConnectors;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import login.login;
import static register.register.eml;
import static register.register.usrname;
import userpack.userdashboard;

/**
 *
 * @author Gerald
 */
public class createUserForm extends javax.swing.JFrame {

    /**
     * Creates new form createUserForm
     */
    public createUserForm() {
        initComponents();
    }
    public static String email, usrname;
    
    public boolean duplicatedChecker() {
    dbConnectors dbc = new dbConnectors();
    try {
        String query = "SELECT u_email, u_username FROM tbl_users WHERE u_username = '" + uname.getText() + "' OR u_email = '" + eml.getText() + "'";
        ResultSet resultSet = dbc.getData(query);
        
        boolean duplicate = false; // Flag to track duplicates
        
        while (resultSet.next()) { // Loop through results (if any)
            email = resultSet.getString("u_email");
            usrname = resultSet.getString("u_username");
            
            if (email.equals(eml.getText())) {
                JOptionPane.showMessageDialog(null, "Email already used!");
                eml.setText("");
                duplicate = true;
            }
            
            if (usrname.equals(uname.getText())) {
                JOptionPane.showMessageDialog(null, "Username already used!");
                uname.setText("");
                duplicate = true;
            }
        }
        
        return duplicate;
    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex);
        return true; // Assume duplicate to avoid inserting problematic data
    }
}
    
     public boolean updateCheck() {
    dbConnectors dbc = new dbConnectors();
    
    String query = "SELECT u_email, u_username FROM tbl_users WHERE (u_username = '"+uname.getText()+"' OR u_email = '"+eml.getText()+"') AND u_id != '"+uid.getText()+"'";

    try {
        
        ResultSet resultSet = dbc.getData(query);

        while (resultSet.next()) {
            String existingEmail = resultSet.getString("u_email");
            String existingUsername = resultSet.getString("u_username");

            if (existingEmail.equals(eml.getText())) {
                JOptionPane.showMessageDialog(null, "Email is Already Used!");
                eml.setText("");
                return true;
            }
            if (existingUsername.equals(uname.getText())) {
                JOptionPane.showMessageDialog(null, "Username is Already Taken!");
                uname.setText("");
                return true;
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Print errors for debugging
    }
    return false;
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        uname = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        eml = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ps = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        us = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        addb = new javax.swing.JButton();
        upb = new javax.swing.JButton();
        delb = new javax.swing.JButton();
        ref = new javax.swing.JButton();
        canb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 207, 84));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 252, 239));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 230, 30));

        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 30));

        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 230, 30));

        jLabel2.setText("First Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel3.setText("Last Name:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        jLabel4.setText("Role");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, -1, -1));

        eml.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(eml, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 230, 30));

        jLabel5.setText("Email:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 20));

        ps.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 230, 30));

        jLabel6.setText("Username:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleActionPerformed(evt);
            }
        });
        jPanel2.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 230, 30));

        jLabel7.setText("Password:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel2.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 230, 30));

        jLabel8.setText("User Status");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, -1, -1));

        jLabel9.setText("User ID:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel2.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 230, 30));

        addb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addb.setText("Add");
        addb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addbMouseExited(evt);
            }
        });
        addb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbActionPerformed(evt);
            }
        });
        jPanel2.add(addb, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 100, 50));

        upb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        upb.setText("Update");
        upb.setEnabled(false);
        upb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                upbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                upbMouseExited(evt);
            }
        });
        upb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upbActionPerformed(evt);
            }
        });
        jPanel2.add(upb, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 100, 50));

        delb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delb.setText("Delete");
        delb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delbMouseExited(evt);
            }
        });
        delb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbActionPerformed(evt);
            }
        });
        jPanel2.add(delb, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 100, 50));

        ref.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ref.setText("Refresh");
        ref.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refMouseExited(evt);
            }
        });
        ref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refActionPerformed(evt);
            }
        });
        jPanel2.add(ref, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 100, 50));

        canb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        canb.setText("Cancel");
        canb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                canbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                canbMouseExited(evt);
            }
        });
        canb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canbActionPerformed(evt);
            }
        });
        jPanel2.add(canb, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 100, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 830, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 96, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleActionPerformed

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void addbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbActionPerformed
        
        if(fname.getText().isEmpty()||lname.getText().isEmpty()||eml.getText().isEmpty()||uname.getText().isEmpty()||ps.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All Feilds are required!");
            return;
        }
        
        if(ps.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Password must be 8 characters above!");
            ps.setText("");
            return;
        }
        
        if(duplicatedChecker()){
            System.out.println("Duplicate Exist");
            return;
        }
        dbConnectors dbc = new dbConnectors();
        if (dbc.insertData("INSERT INTO tbl_users (u_fname, u_lname, u_email, u_username, u_password, u_role, u_status) "
            + "VALUES ('" + fname.getText() + "','" + lname.getText() + "','" + eml.getText() + "','"
            + uname.getText() + "','" + ps.getText() + "','" + role.getSelectedItem()+ "','"+us.getSelectedItem()+ ")"))

        JOptionPane.showMessageDialog(null, "Inserted Successfully!");
        userdashboard udb = new userdashboard();
        udb.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_addbActionPerformed

    private void upbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upbActionPerformed
            
    }//GEN-LAST:event_upbActionPerformed

    private void delbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delbActionPerformed

    private void refActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refActionPerformed
        // TODO add your. handling code here:
    }//GEN-LAST:event_refActionPerformed

    private void canbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canbActionPerformed
        usersforms uf = new usersforms();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_canbActionPerformed

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void addbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbMouseExited
    addb.setBackground(new java.awt.Color(223,120,141));
    }//GEN-LAST:event_addbMouseExited

    private void addbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbMouseEntered
     addb.setBackground(new java.awt.Color(205, 13, 50));
    }//GEN-LAST:event_addbMouseEntered

    private void refMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refMouseEntered
         ref.setBackground(new java.awt.Color(205, 13, 50));
    }//GEN-LAST:event_refMouseEntered

    private void refMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refMouseExited
        ref.setBackground(new java.awt.Color(223,120,141));
    }//GEN-LAST:event_refMouseExited

    private void upbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upbMouseEntered
        upb.setBackground(new java.awt.Color(205, 13, 50));
    }//GEN-LAST:event_upbMouseEntered

    private void upbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upbMouseExited
        upb.setBackground(new java.awt.Color(223,120,141));
    }//GEN-LAST:event_upbMouseExited

    private void delbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delbMouseEntered
        delb.setBackground(new java.awt.Color(205, 13, 50));
    }//GEN-LAST:event_delbMouseEntered

    private void delbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delbMouseExited
        delb.setBackground(new java.awt.Color(223,120,141));
    }//GEN-LAST:event_delbMouseExited

    private void canbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canbMouseEntered
       canb.setBackground(new java.awt.Color(205, 13, 50));
    }//GEN-LAST:event_canbMouseEntered

    private void canbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canbMouseExited
        canb.setBackground(new java.awt.Color(223,120,141));
    }//GEN-LAST:event_canbMouseExited

        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addb;
    public javax.swing.JButton canb;
    public javax.swing.JButton delb;
    public javax.swing.JTextField eml;
    public javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField lname;
    public javax.swing.JPasswordField ps;
    public javax.swing.JButton ref;
    public javax.swing.JComboBox<String> role;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField uname;
    public javax.swing.JButton upb;
    public javax.swing.JComboBox<String> us;
    // End of variables declaration//GEN-END:variables
}
