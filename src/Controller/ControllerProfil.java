/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOUser.DAOUser;
import Model.Mod_user;
import Model.Mod_table_user;
import View.*;
import java.util.List;
import javax.swing.JOptionPane;
import DAOCafe.ImplementCafe;
import DAOUser.ImplementUser;
import Koneksi.koneksi_db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ListModel;
import javax.swing.table.TableModel;

/**
 *
 * @author S510
 */
public class ControllerProfil {
    Login log;
    ListCafe frame;
    Profil main;
    Mainpage MaPa;
    ImplementUser implUser;
    List<Mod_user> lmb;
    Connection connection;

    public ControllerProfil(Profil main) {
        this.main = main;
        //this.implUser = implUser;
        implUser = new DAOUser();
        // this.lmb = lmb;
        lmb = implUser.getAll();
       
    }

    //mereset nilai di textfield2 di frame
    public void resetSearch() {
        frame.getTxtSearch().setText("Klik disini");
    }
    
    public void reset() {
        main.getTxtNama().setText("Username");
        main.getTxtEmail().setText("Email");
        main.getTxtSandi().setText("Sandi");
        main.getTxtKoSandi().setText("Konfirmasi");
        
    }

    public void registrasi() {
        //semua isi data yang semua diambil dari DAO dan ditampung di lmb
        lmb = implUser.getAll();

        //data dimasukkan ke tabel barang
        Mod_table_user mtb = new Mod_table_user(lmb);
        
    }

    public void isitextfield() {
        String email = Login.txtEmail.getText();
        try{

                    // Buat koneksi ke database
            
            String query = "SELECT nama_user FROM user WHERE email_user = ?";
                    // Buat statement untuk query login
            PreparedStatement statement = connection.prepareStatement(query);

                    // Set parameter query
            statement.setString(1, email);  
 

                    // Eksekusi query
            PreparedStatement ps = connection.prepareStatement(query);

                    // Cek apakah email dan password valid
            // Set parameter email_user
            ps.setString(1, email);

            // Eksekusi query
            ResultSet rs = ps.executeQuery();

            // Jika ada hasil
            if (rs.next()) {
                // Set nama_user ke jtextfield
                main.getTxtNama().setText(rs.getString("nama_user"));
            }else{
                        // Tampilkan pesan error
                JOptionPane.showMessageDialog(null, "Email atau password salah!");
            }
        }catch(Exception e){
           System.out.println("Error!" + e.getMessage()); 
        }
        //mb.setNama_user(main.getTxtNama().getText());    
        
        
    }

    public void inserttabel() {
        //fungsi trim() berfungsi untuk memotong karakter-karakter spasi pada 
        //bagian awal dan akhir sehingga fungsi ini 
        //sangat cocok untuk diterapkan pada proses input data-data
        if (!main.getTxtNama().getText().trim().isEmpty() & !main.getTxtNama().getText().trim().isEmpty()) {
            Mod_user mb = new Mod_user();
            mb.setNama_user(main.getTxtNama().getText());
            mb.setEmail_user(main.getTxtEmail().getText());
            mb.setPassword_user(main.getTxtSandi().getText());
            
            
            //knp dia double karena struktur data di table atribut Harga adalah double
            //dan kita mau memasukkan data dari frame yg string ke table atribut Harga yg double

            
            //knp dia Interger karena struktur data di table Stok adalah Integer
            //dan kita mau memasukkan data dari frame yg string ke table Stok yg Inteer

            implUser.insert(mb);
            JOptionPane.showMessageDialog(null, "data disimpan");

        } else {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");

        }
    }

    public void Delete() {
        if (!main.getTxtNama().getText().trim().isEmpty()) {
            //jika data pada frame textfield  no tidak kosong maka

            int no = Integer.parseInt(main.getTxtNama().getText());
            //ambil data dari frame textfield simpan ke var no
            implUser.delete(no);

            JOptionPane.showMessageDialog(null, "data terdelete");
        } else {
            JOptionPane.showMessageDialog(null, "data gagal didelete");

        }

    }

    public void Update() {
        if (!main.getTxtNama().getText().trim().isEmpty()) {
            //jika data pada frame textfield  no tidak kosong maka
            Mod_user mb = new Mod_user();
            mb.setNama_user(main.getTxtNama().getText());
            mb.setEmail_user(main.getTxtEmail().getText());
            mb.setPassword_user(main.getTxtKoSandi().getText());                   

            implUser.update(mb);
            
            JOptionPane.showMessageDialog(null, "data diperbaharui");
        } else {
            JOptionPane.showMessageDialog(null, "data gagal diperbaharui");

        }

    }
    
    public void updatenama(){
        String email = Login.txtEmail.getText();
       

        // Buat query untuk mencari nama berdasarkan email_user
        
        try{
            // Buat koneksi ke database
            connection=koneksi_db.connection();
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbkemanakita", "root", "");
     
 

            // Dapatkan nilai password baru dari textfield
            String nama = main.getTxtNama().getText();
            String passwordBaru = main.getTxtSandi().getText();

            // Buat prepared statement
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET nama_user = ? ,password_user = ? WHERE email_user = ?");


            // Set parameter password baru
            ps.setString(1, nama);
            ps.setString(2, passwordBaru);

            // Set parameter id_user
            ps.setString(3, email);

            // Eksekusi query
            int rowsAffected = ps.executeUpdate();

            // Jika berhasil
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "berhasil diupdate");
            } else {
                JOptionPane.showMessageDialog(null, "gagal diupdate");
            }

        }catch(Exception e){
           System.out.println("Error!" + e.getMessage()); 
        }
    }

//    public void isitable_cari_nama() {
//        lmb = implUser.getCarinama(main.getTxtSearch().getText());
//        Mod_table_user mtb = new Mod_table_user(lmb);
//        main.getTableRec().setModel(mtb);
//        /*
//       public void setModel(TableModel dataModel)
//        Sets the data model for this table to newModel and 
//        registers with it for listener notifications from the new data model.
//        Parameters:
//        dataModel - the new data source for this table
//         */
//
//    }
//
//    public void cari_nama() {
//        if (!main.getTxtSearch().getText().trim().isEmpty()) {
//            implUser.getCarinama(main.getTxtSearch().getText());
//            isitable_cari_nama();
//            
//        }else{
//        
//             JOptionPane.showMessageDialog(null, "data tidak ditemukan");
//        
//        }
//
//    }
}
