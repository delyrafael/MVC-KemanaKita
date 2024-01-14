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
import DAOCafe.ImplementRating;
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
    ImplementRating implRate;
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

    public void Delete() {
        if (!mitra.getTxtNama().getText().trim().isEmpty()) {
            //jika data pada frame textfield  no tidak kosong maka

            int no = Integer.parseInt(mitra.getTxtNama().getText());
            //ambil data dari frame textfield simpan ke var no
            implCafe.delete(no);

            JOptionPane.showMessageDialog(null, "data terdelete");
        } else {
            JOptionPane.showMessageDialog(null, "data gagal didelete");

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
            String query = "SELECT c.nama_cafe, AVG(r.rate) as rata_rata_rating FROM table_cafe c JOIN rating r ON c.id_cafe = r.id_cafe WHERE c.nama_cafe =? GROUP BY c.nama_cafe;";
            String query1 = "SELECT id_cafe FROM table_cafe WHERE nama_cafe = ?";
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
}
