/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.gooddriverincentiveprogram;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mcsk8
 */
public class LoginGUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginGUI
     */
    public LoginGUI() {
        initComponents();
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
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Good Driver Incentive Program - Login");
        setBackground(new java.awt.Color(45, 49, 66));

        jPanel1.setBackground(new java.awt.Color(45, 49, 66));

        jPanel2.setBackground(new java.awt.Color(191, 192, 192));

        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username:");

        jLabel3.setText("Password:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setText("Forgot Password?");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(jTextField1))
                    .addComponent(jButton3)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(45, 49, 66));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Good Driver Incentive Program");

        jButton1.setText("Create Account");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    //https://1bestcsharp.blogspot.com/2018/05/java-login-and-register-form-with-mysql-database.html
    //https://howtodoinjava.com/java/jdbc/jdbc-sql-insert-query-example/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            //Get user input
            String uname = jTextField1.getText();
            String pass = String.valueOf(jPasswordField1.getPassword());

            //Check for valid username using regex (email)
            //https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
            String usernameRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            Pattern usernamePattern = Pattern.compile(usernameRegex);
            Matcher usernameMatcher = usernamePattern.matcher(uname);

            //Setup login recording query
            PreparedStatement loginRecordingPreparedStatement = MyConnection.getConnection().prepareStatement("INSERT INTO LoginAttempts (LoginAttemptsDate, Success, Username) VALUES (CURRENT_TIMESTAMP, ?, ?)");
            
            //Check if username matches criteria for email
            if(!usernameMatcher.matches()) {
                //Record login attempt
                loginRecordingPreparedStatement.setBoolean(1, false);
                loginRecordingPreparedStatement.setString(2, uname);
                loginRecordingPreparedStatement.executeUpdate();
                //Inform user that username entered not valid
                JOptionPane.showMessageDialog(null, "Please enter a valid username.", "Username Invalid", 2);
            } else {
                //Prepare user login check query
                PreparedStatement loginPS;
                ResultSet loginRS;
                String loginQuery = "SELECT * FROM Users WHERE Username=? AND UserPassword=?";

                loginPS = MyConnection.getConnection().prepareStatement(loginQuery);
                loginPS.setString(1, uname);
                loginPS.setString(2, pass);

                loginRS = loginPS.executeQuery();

                //If a user with password was found
                if(loginRS.next()) {
                    //Record login attempt
                    loginRecordingPreparedStatement.setBoolean(1, true);
                    loginRecordingPreparedStatement.setString(2, uname);
                    loginRecordingPreparedStatement.executeUpdate();
                    //Find type of user (driver, sponsor, or admin)
                    String userType = loginRS.getString("UserType");
                    //User is a driver
                    if(userType.equals("D")) {
                        DriverGUI driverGUI = new DriverGUI();
                        driverGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        driverGUI.setTitle("Good Driver Incentive Program - Driver");
                        driverGUI.switchPanels(driverGUI.getProfilePanel());
                        driverGUI.setUserID(loginRS.getInt("UserID"));
                        String fullName = loginRS.getString("FirstName") + " " + loginRS.getString("MiddleName") + " " + loginRS.getString("LastName");
                        driverGUI.setDriverName(fullName);
                        driverGUI.setDriverUsername(uname);
                        String preferredName = loginRS.getString("PreferredName");
                        driverGUI.setDriverPreferredName(preferredName);
                        driverGUI.setDriverPassword(pass);
                        driverGUI.setVisible(true);
                    //User is a sponsor
                    } else if(userType.equals("S")) {
                        SponsorGUI sponsorGUI = new SponsorGUI();
                        sponsorGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        sponsorGUI.setTitle("Good Driver Incentive Program - Sponsor");
                        sponsorGUI.setUserID(loginRS.getInt("UserID"));
                        String fullName = loginRS.getString("FirstName") + " " + loginRS.getString("MiddleName") + " " + loginRS.getString("LastName");
                        sponsorGUI.setSponsorName(fullName);
                        sponsorGUI.setSponsorUsername(uname);
                        String preferredName = loginRS.getString("PreferredName");
                        sponsorGUI.setSponsorPreferredName(preferredName);
                        sponsorGUI.setSponsorPassword(pass);
                        sponsorGUI.setVisible(true);
                    //User is an admin
                    } else if(userType.equals("A")) {
                        AdminGUI adminGUI = new AdminGUI();
                        adminGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        adminGUI.setTitle("Good Driver Incentive Program - Admin");
                        adminGUI.setUserID(loginRS.getInt("UserID"));
                        String fullName = loginRS.getString("FirstName") + " " + loginRS.getString("MiddleName") + " " + loginRS.getString("LastName");
                        adminGUI.setAdminName(fullName);
                        adminGUI.setAdminUsername(uname);
                        String preferredName = loginRS.getString("PreferredName");
                        adminGUI.setAdminPreferredName(preferredName);
                        adminGUI.setAdminPassword(pass);
                        adminGUI.setVisible(true);
                    }
                    this.dispose();
                } else {
                    //Record login attempt
                    loginRecordingPreparedStatement.setBoolean(1, false);
                    loginRecordingPreparedStatement.setString(2, uname);
                    loginRecordingPreparedStatement.executeUpdate();
                    //Inform user that username or password was not found
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password.", "Login Failed", 2);
                }
            }
        } catch(SQLException e) {
                Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //Forgot Password button
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ForgotPasswordEmail forgotPasswordFrame = new ForgotPasswordEmail();
        forgotPasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        forgotPasswordFrame.setTitle("Good Driver Incentive Program - Forgot Password");
        forgotPasswordFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
