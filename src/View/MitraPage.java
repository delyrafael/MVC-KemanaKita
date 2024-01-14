/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerMitra;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Dely
 */
public class MitraPage extends javax.swing.JFrame {

    /**
     * Creates new form MitraPage
     */
    ControllerMitra cb;
    public MitraPage() {
        initComponents();
        cb = new ControllerMitra(this);
        //cb.registrasi();
        cb.isiTabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JButton();
        txtNama = new javax.swing.JTextField();
        txtsandi = new javax.swing.JTextField();
        txtjam = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDesk = new javax.swing.JTextField();
        txtEdit = new javax.swing.JButton();
        txtSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableReview = new javax.swing.JTable();
        txtExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 30, 130, 30));

        txtNama.setBackground(new java.awt.Color(242, 242, 242));
        txtNama.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtNama.setText("Nama Cafe");
        txtNama.setBorder(null);
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 350, 60));

        txtsandi.setBackground(new java.awt.Color(242, 242, 242));
        txtsandi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtsandi.setText("Sandi");
        txtsandi.setBorder(null);
        getContentPane().add(txtsandi, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 350, 60));

        txtjam.setBackground(new java.awt.Color(242, 242, 242));
        txtjam.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtjam.setText("Fasilitas");
        txtjam.setBorder(null);
        getContentPane().add(txtjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 350, 60));

        txtAlamat.setBackground(new java.awt.Color(242, 242, 242));
        txtAlamat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtAlamat.setText("Alamat");
        txtAlamat.setBorder(null);
        txtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatActionPerformed(evt);
            }
        });
        getContentPane().add(txtAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 350, 60));

        txtEmail.setBackground(new java.awt.Color(242, 242, 242));
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtEmail.setText("Email");
        txtEmail.setBorder(null);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 360, 60));

        txtDesk.setBackground(new java.awt.Color(242, 242, 242));
        txtDesk.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtDesk.setText("Deskripsi");
        txtDesk.setBorder(null);
        txtDesk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeskActionPerformed(evt);
            }
        });
        getContentPane().add(txtDesk, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 350, 60));

        txtEdit.setOpaque(false);
        txtEdit.setContentAreaFilled(false);
        txtEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditActionPerformed(evt);
            }
        });
        getContentPane().add(txtEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 620, 140, 30));

        txtSave.setOpaque(false);
        txtSave.setContentAreaFilled(false);
        txtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaveActionPerformed(evt);
            }
        });
        getContentPane().add(txtSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 620, 130, 30));

        TableReview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Pengguna", "Review"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableReview);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, 400, 550));

        txtExit.setOpaque(false);
        txtExit.setContentAreaFilled(false);
        txtExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExitActionPerformed(evt);
            }
        });
        getContentPane().add(txtExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 150, 160));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/MitraKemanaKita -14.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatActionPerformed

    private void txtDeskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeskActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeskActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaveActionPerformed
        // TODO add your handling code here:
        cb.inserttabel();
        
    }//GEN-LAST:event_txtSaveActionPerformed

    private void txtExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_txtExitActionPerformed

    private void txtEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditActionPerformed
        // TODO add your handling code here:
        cb.Update();
    }//GEN-LAST:event_txtEditActionPerformed

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
            java.util.logging.Logger.getLogger(MitraPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MitraPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MitraPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MitraPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MitraPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableReview;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtDesk;
    private javax.swing.JButton txtEdit;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JButton txtExit;
    private javax.swing.JTextField txtNama;
    private javax.swing.JButton txtSave;
    private javax.swing.JTextField txtjam;
    private javax.swing.JTextField txtsandi;
    // End of variables declaration//GEN-END:variables

    public JButton getExit() {
        return exit;
    }

    public void setExit(JButton exit) {
        this.exit = exit;
    }

    public JTable getjTable1() {
        return TableReview;
    }

    public void setjTable1(JTable jTable1) {
        this.TableReview = jTable1;
    }

    public JTextField getTxtAlamat() {
        return txtAlamat;
    }

    public void setTxtAlamat(JTextField txtAlamat) {
        this.txtAlamat = txtAlamat;
    }

    public JTextField getTxtDesk() {
        return txtDesk;
    }

    public void setTxtDesk(JTextField txtDesk) {
        this.txtDesk = txtDesk;
    }

    public JButton getTxtEdit() {
        return txtEdit;
    }

    public void setTxtEdit(JButton txtEdit) {
        this.txtEdit = txtEdit;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JTextField getTxtNama() {
        return txtNama;
    }

    public void setTxtNama(JTextField txtNama) {
        this.txtNama = txtNama;
    }

    public JButton getTxtSave() {
        return txtSave;
    }

    public void setTxtSave(JButton txtSave) {
        this.txtSave = txtSave;
    }

    public JTextField getTxtjam() {
        return txtjam;
    }

    public void setTxtjam(JTextField txtjam) {
        this.txtjam = txtjam;
    }

    public JTextField getTxtsandi() {
        return txtsandi;
    }

    public void setTxtsandi(JTextField txtsandi) {
        this.txtsandi = txtsandi;
    }

    public JTable getTableReview() {
        return TableReview;
    }

    public void setTableReview(JTable TableReview) {
        this.TableReview = TableReview;
    }
    

    

    
}