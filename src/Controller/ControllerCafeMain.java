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
import Koneksi.koneksi_db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author S510
 */
public class ControllerCafeMain {
    Login log;
    Regis reg;
    Mainpage main;
    MitraPage mitra;
    ImplementCafe implCafe;
    List<Mod_cafe> lmb;
    Connection connection;

    public ControllerCafeMain(Mainpage main) {
        this.main = main;
        //this.implBarang = implBarang;
        implCafe = new DAOCafe();
        // this.lmb = lmb;
        lmb = implCafe.getAll();
    }

    
    

    public void registrasi() {
        //semua isi data yang semua diambil dari DAO dan ditampung di lmb
        lmb = implCafe.getAll();

        //data dimasukkan ke tabel barang
        Mod_tabel_cafe mtb = new Mod_tabel_cafe(lmb);
        
    }

    public void isitextfield(int row) {
        reg.getTxtUsername().setText(String.valueOf(lmb.get(row).getNama_cafe()));
        reg.getTxtEmail().setText(lmb.get(row).getEmail());
        reg.getTxtsandi().setText(String.valueOf(lmb.get(row).getSandi()));
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
        List<Mod_cafe> lmb = implCafe.getCafeRandom(); // Panggil method getCafeRandom() untuk mendapatkan data cafe secara random
        Mod_tabel_cafe mtb = new Mod_tabel_cafe(lmb);
        main.getTableRec().setModel(mtb);
    }
    
    public void showdata(){
        try {
            connection=koneksi_db.connection();
        

            // Buat query
            String query = "SELECT id_cafe, nama_cafe, fasilitas FROM table_cafe ORDER BY RAND() LIMIT 5;";

            // Eksekusi query
            ResultSet rs = connection.createStatement().executeQuery(query);

            // Buat model tabel
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Cafe");
            model.addColumn("Nama Cafe");
            model.addColumn("Fasilitas");

            // Isi data ke model tabel
            while (rs.next()) {
                int idCafe = rs.getInt("id_cafe");
                String namaCafe = rs.getString("nama_cafe");
                String fasilitas = rs.getString("fasilitas");

                model.addRow(new Object[]{idCafe, namaCafe, fasilitas});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListCafe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
