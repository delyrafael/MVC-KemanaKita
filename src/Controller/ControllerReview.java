/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOCafe.DAOReview;
import Model.Mod_tabel_cafe;
import View.*;
import java.util.List;
import javax.swing.JOptionPane;
import DAOCafe.ImplementReview;
import Model.Mod_review;
import Model.Mod_tabel_review;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.TableModel;

/**
 *
 * @author S510
 */
public class ControllerReview {
    Login log;
    Regis reg;
    Review main;
    ListCafe lst;;
    MitraPage mitra;
    ImplementReview implRev;
    List<Mod_review> lmb;

    public ControllerReview(Review main) {
        this.main = main;
        String namacafe = ListCafe.txtIdCafe.getText();
        //this.implBarang = implBarang;
        implRev = new DAOReview();
        // this.lmb = lmb;
        lmb = implRev.getAll(namacafe);
    }

    //mereset nilai di textfield2 di frame
    public void reset() {
        main.getTxtReview().setText("");
        main.getTxtNamaUser().setText("");
        
    }
    public void isiTabel() {
        //semua isi data yang semua diambil dari DAO dan ditampung di lmb
        String namacafe = ListCafe.txtIdCafe.getText();
        lmb = implRev.getAll(namacafe);

        //data dimasukkan ke tabel barang
        Mod_tabel_review mtb = new Mod_tabel_review(lmb);
        main.getTableReview().setModel(mtb);
    }
    public void isitext() {
        String namacafe = ListCafe.txtIdCafe.getText();
        //semua isi data yang semua diambil dari DAO dan ditampung di lmb
        lmb = implRev.getAll(namacafe);

        //data dimasukkan ke tabel barang
        Mod_tabel_review mtb = new Mod_tabel_review(lmb);
        
    }

    public void isitextfield(int row) {
        main.getTxtNamaUser().setText(String.valueOf(lmb.get(row).getNamacafe()));
        main.getTxtReview().setText(String.valueOf(lmb.get(row).getReview()));
    }

    //txtEmail.setText(Login.txtEmail.getText());
    
    public void getNamaCafe(JTable jtabelcafe) {
        int row = jtabelcafe.getSelectedRow();
        TableModel tableModel = jtabelcafe.getModel();
        String namaCafe = tableModel.getValueAt(row, 0).toString();
    }
    
    public void isitable_cari_nama() {
        String v = main.getTxtNamaCafe().getText();
        lmb = implRev.getCarinama(v);
        Mod_tabel_review mtb = new Mod_tabel_review(lmb);
        main.getTableReview().setModel(mtb);
       /* 
       public void setModel(TableModel dataModel)
        Sets the data model for this table to newModel and 
        registers with it for listener notifications from the new data model.
        Parameters:
        dataModel - the new data source for this table
         */

    }
    
    public void addreview() {
        String emailUser = Login.txtEmail.getText();
        String namacafe = ListCafe.txtIdCafe.getText();
        String review = main.getTxtReview().getText();

        Mod_review mb = new Mod_review();
        // Set other fields of mb as needed, e.g., mb.setId_user(getUserIdFromEmail(emailUser));

        implRev.insert(mb);
        main.getTableReview().setModel(new Mod_tabel_review(implRev.getAll(namacafe))); // Update table model
        reset(); // Clear text fields
    }

    public void cari_nama() {
        implRev.getCarinama(main.getTxtNamaCafe().getText());
        isitable_cari_nama();

    }
    
//    public void getrate(){
//        try {
//            Connection koneksi = DriverManager.getConnection("jdbc:MySQL://localhost:3306/dbkemanakita","root","");
//            int baris = main.getTableCafe().getSelectedRow();
//
//                // Dapatkan nilai nama cafe
//            String namaCafe = (String) main.getTableCafe().getValueAt(baris, 0);
//
//                    // Query untuk mendapatkan id_cafe berdasarkan nama cafe
//            String query = "SELECT user.nama_user, review.review FROM review INNER JOIN table_cafe ON review.id_cafe = table_cafe.id_cafe INNER JOIN user ON review.id_user = user.id_user WHERE table_cafe.id_cafe = 100010;";
//            String query1 = "SELECT id_cafe FROM table_cafe WHERE nama_cafe = ?";
//                    // Buat statement untuk query
//            PreparedStatement statement2 = koneksi.prepareStatement(query);
//
//                    // Isi nilai placeholder
//            statement2.setString(1, namaCafe);
//
//                    // Eksekusi query
//            ResultSet hasil2 = statement2.executeQuery();
//
//                    // Dapatkan nilai id_cafe
//            if (hasil2.next()) {
//                String idCafe = hasil2.getString(2);
//
//                        // Print nilai id_cafe
//                Mod_tabel_review mtb = new Mod_tabel_review(lmb);
//                main.getTableReview().setModel(mtb);
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ListCafe.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
