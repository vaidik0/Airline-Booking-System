/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.newairlines;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Vinee
 */

public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        pword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        adduser = new javax.swing.JButton();
        login = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Login");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(160, 20, 80, 28);

        Password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Password.setForeground(new java.awt.Color(0, 102, 102));
        Password.setText("Password");
        jPanel1.add(Password);
        Password.setBounds(86, 137, 95, 22);
        jPanel1.add(pword);
        pword.setBounds(222, 140, 124, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("User Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(84, 83, 91, 22);
        jPanel1.add(uname);
        uname.setBounds(222, 83, 124, 22);

        adduser.setBackground(new java.awt.Color(153, 153, 255));
        adduser.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        adduser.setForeground(new java.awt.Color(0, 102, 102));
        adduser.setText("new user");
        adduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adduserActionPerformed(evt);
            }
        });
        jPanel1.add(adduser);
        adduser.setBounds(86, 227, 105, 31);

        login.setBackground(new java.awt.Color(153, 153, 255));
        login.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        login.setForeground(new java.awt.Color(0, 102, 102));
        login.setText("login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(249, 227, 71, 31);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        connect con = new connect();
        String usrname = uname.getText();
        String psword = pword.getText();
        
        if(usrname.isEmpty() ||  psword.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "UserName or Password Blank");
        } else {
            try {
                String str = "select * from user where username = '"+usrname+"' and password = '"+psword+"'";
                ResultSet rs = con.s.executeQuery(str);  
                
                if(rs.next()){
                    if(Integer.parseInt(rs.getString("id")) == 0) {
                        System.out.println("Integer.MAX_VALUE = ");
                        home H = new home(usrname);
                        H.setVisible(true);
                    }
                    else {
                        System.out.println("_VALUE = ");
                        userhome H = new userhome(usrname);
                        H.setVisible(true);
                    }
                    
//                    
                    setVisible(false);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    setVisible(false); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }//GEN-LAST:event_loginActionPerformed

    private void adduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adduserActionPerformed
        // TODO add your handling code here:
        newuser n = new newuser();
        
        n.setVisible(true);
    }//GEN-LAST:event_adduserActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Password;
    private javax.swing.JButton adduser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JTextField pword;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
