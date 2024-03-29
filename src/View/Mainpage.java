package View;

import Controller.ControllerCafeMain;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Controller.ControllerCafeAnon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dely
 */
public class Mainpage extends javax.swing.JFrame {

    /**
     * Creates new form Mainpage
     */
    
    ControllerCafeMain cb;
    public Mainpage() {
        initComponents();
        cb = new ControllerCafeMain(this);
        cb.registrasi();
        cb.isitable_cari_nama();
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
        TableRec = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnViewWishlist = new javax.swing.JButton();
        txtProfil = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableRec.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        TableRec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama", "alamat", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableRec.setRowHeight(25);
        jScrollPane1.setViewportView(TableRec);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 1250, 160));

        btnSearch.setOpaque(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 980, 200));

        btnViewWishlist.setOpaque(false);
        btnViewWishlist.setContentAreaFilled(false);
        btnViewWishlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewWishlistActionPerformed(evt);
            }
        });
        getContentPane().add(btnViewWishlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 15, 60, 60));

        txtProfil.setOpaque(false);
        txtProfil.setContentAreaFilled(false);
        txtProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfilActionPerformed(evt);
            }
        });
        getContentPane().add(txtProfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 10, 70, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Navbar.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Main page - user -4.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        dispose();
        new ListCafe().setVisible(true);
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewWishlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewWishlistActionPerformed
        // TODO add your handling code here:
        dispose();
        new ListCafeWishlist().setVisible(true);
    }//GEN-LAST:event_btnViewWishlistActionPerformed

    private void txtProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfilActionPerformed
        // TODO add your handling code here:
        dispose();
        new Profil().setVisible(true);
    }//GEN-LAST:event_txtProfilActionPerformed

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
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableRec;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewWishlist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton txtProfil;
    // End of variables declaration//GEN-END:variables

    public JTable getTableRec() {
        return TableRec;
    }

    public void setTableRec(JTable TableRec) {
        this.TableRec = TableRec;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    
    
    

}
