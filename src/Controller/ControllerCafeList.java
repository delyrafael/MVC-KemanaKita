/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOCafe.DAOCafe;
import Model.Mod_cafe;
import Model.Mod_tabel_cafe;
import View.*;
import java.util.List;
import javax.swing.JOptionPane;
import DAOCafe.ImplementCafe;
import Model.Mod_Rating;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
import javax.swing.table.TableModel;

/**
 *
 * @author S510
 */
public class ControllerCafeList {
    Login log;
    Regis reg;
    ListCafe main;
    Mainpage MaPa;
    MitraPage mitra;
    ImplementCafe implCafe;
    List<Mod_Rating> lmr;
    List<Mod_cafe> lmb;

    public ControllerCafeList(ListCafe main) {
        this.main = main;
        //this.implBarang = implBarang;
        implCafe = new DAOCafe();
        
        // this.lmb = lmb;
        lmb = implCafe.getAll();
    }

    //mereset nilai di textfield2 di frame
    public void resetSearch() {
        main.getTxtSearch().setText("Klik disini");
    }
    
    public void reset() {
        reg.getTxtUsername().setText("Username");
        reg.getTxtEmail().setText("Email");
        reg.getTxtsandi().setText("Sandi");
        reg.getTxtkonfirmasi().setText("Konfirmasi");
        
    }

    public void registrasi() {
        //semua isi data yang semua diambil dari DAO dan ditampung di lmb
        lmb = implCafe.getAll();

        //data dimasukkan ke tabel barang
        Mod_tabel_cafe mtb = new Mod_tabel_cafe(lmb);
        
    }

    public void isitextfield(int row) {
        main.getTxtNamaCafe().setText(String.valueOf(lmb.get(row).getNama_cafe()));
        main.getTxtAlamat().setText(String.valueOf(lmb.get(row).getAlamat_cafe()));
        main.getTxtFasilitas().setText(String.valueOf(lmb.get(row).getFasilitas_cafe()));
        main.getTxtDeskripsi().setText(String.valueOf(lmb.get(row).getDeskripsi()));
        main.getTxtDeskripsi().setLineWrap(true);
        main.getTxtDeskripsi().setWrapStyleWord(true);
        int barisTerpilih = main.getTableCafe().getSelectedRow();
        String namaCafe = (String) main.getTableCafe().getValueAt(barisTerpilih, 0);
        main.getTxtIdCafe().setText(namaCafe);
    }

    public void inserttabel() {
        //fungsi trim() berfungsi untuk memotong karakter-karakter spasi pada 
        //bagian awal dan akhir sehingga fungsi ini 
        //sangat cocok untuk diterapkan pada proses input data-data
        if (!mitra.getTxtNama().getText().trim().isEmpty() & !mitra.getTxtNama().getText().trim().isEmpty()) {
            Mod_cafe mb = new Mod_cafe();
            mb.setNama_cafe(mitra.getTxtNama().getText());
            mb.setEmail(mitra.getTxtEmail().getText());
            mb.setSandi(mitra.getTxtsandi().getText());
            mb.setAlamat_cafe(mitra.getTxtAlamat().getText());
            mb.setFasilitas_cafe(mitra.getTxtjam().getText());
            mb.setDeskripsi(mitra.getTxtDesk().getText());
            
            //knp dia double karena struktur data di table atribut Harga adalah double
            //dan kita mau memasukkan data dari frame yg string ke table atribut Harga yg double

            
            //knp dia Interger karena struktur data di table Stok adalah Integer
            //dan kita mau memasukkan data dari frame yg string ke table Stok yg Inteer

            implCafe.insert(mb);
            JOptionPane.showMessageDialog(null, "data disimpan");

        } else {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");

        }
    }

    public void Update() {
        if (!mitra.getTxtNama().getText().trim().isEmpty()) {
            //jika data pada frame textfield  no tidak kosong maka
            Mod_cafe mb = new Mod_cafe();
            mb.setNama_cafe(mitra.getTxtNama().getText());
            mb.setAlamat_cafe(mitra.getTxtAlamat().getText());
            mb.setFasilitas_cafe(mitra.getTxtjam().getText());
            mb.setDeskripsi(mitra.getTxtDesk().getText());
            mb.setEmail(mitra.getTxtEmail().getText());
            mb.setSandi(mitra.getTxtsandi().getText());                   

            implCafe.update(mb);
            
            JOptionPane.showMessageDialog(null, "data diperbaharui");
        } else {
            JOptionPane.showMessageDialog(null, "data gagal diperbaharui");

        }

    }

    public void isitable_cari_nama() {
        lmb = implCafe.getCarinama(main.getTxtSearch().getText());
        Mod_tabel_cafe mtb = new Mod_tabel_cafe(lmb);
        main.getTableCafe().setModel(mtb);
        /*
       public void setModel(TableModel dataModel)
        Sets the data model for this table to newModel and 
        registers with it for listener notifications from the new data model.
        Parameters:
        dataModel - the new data source for this table
         */

    }

    public void cari_nama() {
        if (!main.getTxtSearch().getText().trim().isEmpty()) {
            implCafe.getCarinama(main.getTxtSearch().getText());
            isitable_cari_nama();
            
        }else{
        
             JOptionPane.showMessageDialog(null, "data tidak ditemukan");
        
        }

    }
    
    
    public void getrate(){
        try {
            Connection koneksi = DriverManager.getConnection("jdbc:MySQL://localhost:3306/dbkemanakita","root","");
            int baris = main.getTableCafe().getSelectedRow();

                // Dapatkan nilai nama cafe
            String namaCafe = (String) main.getTableCafe().getValueAt(baris, 0);

                    // Query untuk mendapatkan id_cafe berdasarkan nama cafe
            String query = "SELECT c.nama_cafe, ROUND(AVG(r.rate), 1) as rata_rata_rating FROM table_cafe c JOIN rating r ON c.id_cafe = r.id_cafe WHERE c.nama_cafe =? GROUP BY c.nama_cafe;";
                    // Buat statement untuk query
            PreparedStatement statement2 = koneksi.prepareStatement(query);

                    // Isi nilai placeholder
            statement2.setString(1, namaCafe);

                    // Eksekusi query
            ResultSet hasil2 = statement2.executeQuery();

                    // Dapatkan nilai id_cafe
            if (hasil2.next()) {
                String idCafe = hasil2.getString(2);

                        // Print nilai id_cafe
                main.getTxtRatinig().setText(String.valueOf(idCafe));
                //main.getTxtIdCafe().setText(String.valueOf(idCafe));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ListCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertWish(){
        String emailUser = Login.txtEmail.getText();
        String namaCafe = ListCafe.txtIdCafe.getText();
        try {
            Connection conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/dbkemanakita","root","");
            
            
            // Dapatkan id_user dari email
            String sql = "SELECT id_user FROM user WHERE email_user = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, emailUser);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int idUser = rs.getInt("id_user");

                // Dapatkan id_cafe dari nama_cafe
                sql = "SELECT id_cafe FROM table_cafe WHERE nama_cafe = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, namaCafe);
                rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    int idCafe = rs.getInt("id_cafe");

                    // Tambahkan id_user dan id_cafe ke table_wishlist
                    sql = "INSERT INTO table_wishlist (id_user, id_cafe) VALUES (?, ?)";
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1, idUser);
                    preparedStatement.setInt(2, idCafe);
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "cafe berhasil dimasukan");
                } else {
                    System.out.println("Cafe dengan nama " + namaCafe + " tidak ditemukan.");
                }
            } else {
                System.out.println("Pengguna dengan email " + emailUser + " tidak ditemukan.");
            }

            rs.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Cafe sudah sudah ada di wishlist"); 
        }
    }
        
}
