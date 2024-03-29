/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerAddReview;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Dely
 */
public class AddReview extends javax.swing.JFrame {

    /**
     * Creates new form AddReview
     */
    ControllerAddReview cr;
    public AddReview() {
        initComponents();
        cr = new ControllerAddReview(this);
        txtNamaCafe.setText(ListCafe.txtIdCafe.getText());
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
        jLabel2 = new javax.swing.JLabel();
        txtNamaCafe = new javax.swing.JTextField();
        txtRate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDeskripsi1 = new javax.swing.JScrollPane();
        txtReview = new javax.swing.JTextArea();
        btnMain = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 640, 170, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Bagaimana Pengalaman Anda Ketika di");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        txtNamaCafe.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtNamaCafe.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNamaCafe.setBorder(null);
        txtNamaCafe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaCafeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNamaCafe, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 410, 40));

        txtRate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtRate.setText("Rating 1 sampai 5");
        txtRate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRateFocusLost(evt);
            }
        });
        txtRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRateActionPerformed(evt);
            }
        });
        getContentPane().add(txtRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 690, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Rating");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Review");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        txtReview.setColumns(20);
        txtReview.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtReview.setRows(5);
        txtReview.setText("Masukan pengalamanmu disini!");
        txtReview.setBorder(null);
        txtReview.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtReviewFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtReviewFocusLost(evt);
            }
        });
        txtDeskripsi1.setViewportView(txtReview);

        getContentPane().add(txtDeskripsi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 690, 220));

        btnMain.setOpaque(false);
        btnMain.setContentAreaFilled(false);
        btnMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainActionPerformed(evt);
            }
        });
        getContentPane().add(btnMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 60));

        btnExit.setOpaque(false);
        btnExit.setContentAreaFilled(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 80, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Navbar.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Review.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRateActionPerformed

    private void txtNamaCafeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaCafeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaCafeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cr.addReview();
        new Review().setVisible(true);
        dispose();
        
  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnMainActionPerformed

    private void txtRateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRateFocusGained
        // TODO add your handling code here:
        if(txtRate.getText().equals("Rating 1 sampai 5")){
            txtRate.setText(null);
            txtRate.requestFocus();
                
        }
    }//GEN-LAST:event_txtRateFocusGained

    private void txtRateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRateFocusLost
        // TODO add your handling code here:
        if(txtRate.getText().length()==0){
           txtRate.setText("Rating 1 sampai 5");
       }
    }//GEN-LAST:event_txtRateFocusLost

    private void txtReviewFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtReviewFocusGained
        // TODO add your handling code here:
        if(txtReview.getText().equals("Masukan pengalamanmu disini!")){
            txtReview.setText(null);
            txtReview.requestFocus();

                
        }
    }//GEN-LAST:event_txtReviewFocusGained

    private void txtReviewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtReviewFocusLost
        // TODO add your handling code here:
        if(txtReview.getText().length()==0){
           txtReview.setText("Masukan pengalamanmu disini!");
       }
    }//GEN-LAST:event_txtReviewFocusLost

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        dispose();
        new ListCafeWishlist().setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(AddReview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMain;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane txtDeskripsi1;
    private javax.swing.JTextField txtNamaCafe;
    private javax.swing.JTextField txtRate;
    private javax.swing.JTextArea txtReview;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtRate() {
        return txtRate;
    }

    public void setTxtRate(JTextField txtRate) {
        this.txtRate = txtRate;
    }

    public JTextArea getTxtReview() {
        return txtReview;
    }

    public void setTxtReview(JTextArea txtReview) {
        this.txtReview = txtReview;
    }

    
}
