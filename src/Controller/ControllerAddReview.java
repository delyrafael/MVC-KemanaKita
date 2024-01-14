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
public class ControllerAddReview {
    Login log;
    Regis reg;
    AddReview main;
    ListCafe lst;;
    MitraPage mitra;
    ImplementReview implRev;
    List<Mod_review> lmb;

    public ControllerAddReview(AddReview main) {
        this.main = main;
        //this.implBarang = implBarang;
        String namacafe = ListCafe.txtIdCafe.getText();
        implRev = new DAOReview();
        // this.lmb = lmb;
        lmb = implRev.getAll(namacafe);
        
    }
    

    //mereset nilai di textfield2 di frame
    public void reset() {
        main.getTxtReview().setText("");
        
    }

    public void registrasi() {
        //semua isi data yang semua diambil dari DAO dan ditampung di lmb
        String namacafe = ListCafe.txtIdCafe.getText();
        lmb = implRev.getAll(namacafe);

        //data dimasukkan ke tabel barang
        Mod_tabel_review mtb = new Mod_tabel_review(lmb);
        
    }

    public void isitextfield(int row) {
        main.getTxtReview().setText(String.valueOf(lmb.get(row).getReview()));
    }

    //txtEmail.setText(Login.txtEmail.getText());
    
    public void getNamaCafe(JTable jtabelcafe) {
        int row = jtabelcafe.getSelectedRow();
        TableModel tableModel = jtabelcafe.getModel();
        String namaCafe = tableModel.getValueAt(row, 0).toString();
    }
    public void addReview() {
        String emailUser = Login.txtEmail.getText();
        String namacafe = ListCafe.txtIdCafe.getText();
        System.out.println(namacafe);
        String SUrl, SUser, SPass;
        SUrl = "jdbc:MySQL://localhost:3306/dbkemanakita";
        SUser = "root";
        SPass = "";
        try {
            Connection conn = DriverManager.getConnection(SUrl, SUser, SPass);

            String review = main.getTxtReview().getText();
            String rate = main.getTxtRate().getText();

             //Query untuk insert data ke tabel review
            String insertReviewQuery = "INSERT INTO review (id_review, id_cafe, id_user, review) VALUES (NULL, (SELECT id_cafe FROM table_cafe WHERE nama_cafe = ?), (SELECT id_user FROM user WHERE email_user = ?), ?);";
            PreparedStatement reviewStmt = conn.prepareStatement(insertReviewQuery);
            reviewStmt.setString(1, namacafe);
            reviewStmt.setString(2, emailUser);
            reviewStmt.setString(3, review);
            reviewStmt.executeUpdate();

            String insertRatingQuery = "INSERT INTO rating (id_rate, id_cafe, rate) VALUES (NULL, (SELECT id_cafe FROM table_cafe WHERE nama_cafe = ?), ?);";
            PreparedStatement ratingStmt = conn.prepareStatement(insertRatingQuery);
            ratingStmt.setString(1, namacafe);
            ratingStmt.setString(2, rate);
            ratingStmt.executeUpdate();

            System.out.println("Data has been inserted successfully.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
//    public void addreview() {
//        String emailUser = Login.txtEmail.getText();
//        String namacafe = ListCafe.txtIdCafe.getText();
//        String review = main.getTxtReview().getText();
//
//        Mod_review mb = new Mod_review();
//        // Set other fields of mb as needed, e.g., mb.setId_user(getUserIdFromEmail(emailUser));
//
//        implRev.insert(mb);
//        reset(); // Clear text fields
//    }

//    public void cari_nama() {
//        if (!main.getTableReview().getSelectedRow()) {
//            implCafe.getCarinama(main.getTxtSearch().getText());
//            isitable_cari_nama();
//            
//        }else{
//            
//            JOptionPane.showMessageDialog(null, "data tidak ditemukan");
//            
//        }
//
//    }
    
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
