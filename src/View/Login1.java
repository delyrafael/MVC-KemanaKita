/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Dely
 */
public class Login1 extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login1() {
        initComponents();
        login.setFocusable(true);
        
    }
    public void addregis(JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }
    public void removeregis(JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN);
        textField.setFont(font);
        textField.setForeground(Color.black);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        txtSandi = new javax.swing.JPasswordField();
        login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setOpaque(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 415, 140, 30));

        txtEmail.setBackground(new java.awt.Color(242, 242, 242));
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtEmail.setText("Alamat Email");
        txtEmail.setBorder(null);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 350, 50));

        txtSandi.setBackground(new java.awt.Color(242, 242, 242));
        txtSandi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtSandi.setText("Password");
        txtSandi.setBorder(null);
        txtSandi.setEchoChar('\u0000');
        txtSandi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSandiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSandiFocusLost(evt);
            }
        });
        getContentPane().add(txtSandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 350, 50));

        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Dialog Box Login (1).png"))); // NOI18N
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt){
//       dispose();
//       new Mainpage().setVisible(true); 

    

        
//        String Email, Password, query, fname = null, passDb = null;
//        String SUrl, SUser, SPass;
//        SUrl = "jdbc:MySQL://localhost:3306/dbkemanakita";
//        SUser = "root";
//        SPass = "";
//        int notFound = 0;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
//            Statement st = con.createStatement();
//            if("".equals(txtEmail.getText())){
//                JOptionPane.showMessageDialog(new JFrame(), "Email Address is require", "Error",
//                        JOptionPane.ERROR_MESSAGE);
//            }else if("".equals(txtSandi.getText())){
//                JOptionPane.showMessageDialog(new JFrame(), "Password is require", "Error",
//                        JOptionPane.ERROR_MESSAGE);
//            }else {
//            Email    = txtEmail.getText();
//            Password = txtSandi.getText();
//            
//            query = "SELECT * FROM user WHERE email_user= '"+Email+"'";
//       
//            ResultSet rs = st.executeQuery(query);
//            while(rs.next()){
//                passDb = rs.getString("password_user");
//                fname = rs.getString("nama_user");
//                int id_user = rs.getInt("id_user");
//                notFound = 1;
//            }
//            if(notFound == 1 && Password.equals(passDb)){
//                Mainpage HomeFrame = new Mainpage();
//                HomeFrame.setName(fname);
//                HomeFrame.setVisible(true);
//                HomeFrame.pack();
//                HomeFrame.setLocationRelativeTo(null); 
//                this.dispose();
//            }else{
//               JOptionPane.showMessageDialog(new JFrame(), "Incorrect email or password", "Error",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//            txtSandi.setText("");
//            
//            }
//        }catch(Exception e){
//           System.out.println("Error!" + e.getMessage()); 
//        }
    }                                         

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        if(txtEmail.getText().equals("Alamat Email")){     
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        if(txtEmail.getText().equalsIgnoreCase("")){
            addregis(txtEmail);
           txtEmail.setText("Alamat Email");
       }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtSandiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSandiFocusGained
        // TODO add your handling code here:
        if(txtSandi.getText().equals("Password")){
            txtSandi.setText(null);
            txtSandi.requestFocus();
            txtSandi.setEchoChar('*');
                
        }
    }//GEN-LAST:event_txtSandiFocusGained

    private void txtSandiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSandiFocusLost
        // TODO add your handling code here:
        if(txtSandi.getText().length()==0){
           addregis(txtSandi);
           txtSandi.setText("Password");
       }
    }//GEN-LAST:event_txtSandiFocusLost

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

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
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel login;
    public static javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtSandi;
    // End of variables declaration//GEN-END:variables

    
    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(JButton btnLogin) {
        this.btnLogin = btnLogin;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JPasswordField getTxtSandi() {
        return txtSandi;
    }

    public void setTxtSandi(JPasswordField txtSandi) {
        this.txtSandi = txtSandi;
    }

    
}
