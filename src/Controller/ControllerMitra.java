/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOCafe.DAOCafe;
import DAOCafe.DAOReview;
import Model.Mod_cafe;
import Model.Model_list_Cafe;
import View.*;
import java.util.List;
import javax.swing.JOptionPane;
import DAOCafe.ImplementCafe;
import DAOCafe.ImplementReview;
import Model.Mod_review;
import Model.Mod_tabel_cafe;
import Model.Mod_tabel_review;
import javax.swing.ListModel;
import javax.swing.table.TableModel;
import Koneksi.koneksi_db;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;


/**
 *
 * @author S510
 */
public class ControllerMitra {
    LoginMitra log;

    Mainpage MaPa;
    MitraPage main;
    ImplementCafe implCafe;
    List<Mod_cafe> lmb;
    ImplementReview implRev;
    List<Mod_review> lmr;
    koneksi_db conn;

    public ControllerMitra(MitraPage main) {
        this.main = main;
        //this.implBarang = implBarang;
        String namacafe = main.getTxtNama().getText();
        implRev = new DAOReview();
        implCafe = new DAOCafe();
        // this.lmb = lmb;
        lmb = implCafe.getAll();
        lmr = implRev.getAll(namacafe);
    }

    

    public void registrasi() {
        //semua isi data yang semua diambil dari DAO dan ditampung di lmb
        lmb = implCafe.getAll();

        //data dimasukkan ke tabel barang
        Model_list_Cafe mtb = new Model_list_Cafe(lmb);
        String namacafe = main.getTxtNama().getText();
        //this.implBarang = implBarang;
        implRev = new DAOReview();
        // this.lmb = lmb;
        lmr = implRev.getAll(namacafe);
        
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

    public void reset() {
        main.getTxtNama().setText("Nama Cafe");
        main.getTxtAlamat().setText("Alamat");
        main.getTxtjam().setText("Fasilitas");
        main.getTxtDesk().setText("Deskripsi");
        main.getTxtsandi().setEchoChar('\u0000');
        main.getTxtsandi().setText("Sandi");
    }
    
    public void tampildata() {
        DAOCafe dao = new DAOCafe();  // Buat objek DAOCafe

        Mod_cafe mc = dao.findnama(LoginMitra.txtEmail.getText());// Cari data cafe

        // Tampilkan data cafe (jika ditemukan)
        if (mc != null) {
            main.getTxtNamaCafe().setText(mc.getNama_cafe());
            main.getTxtNama().setText(mc.getNama_cafe());
            main.getTxtAlamat().setText(mc.getAlamat_cafe());
            main.getTxtjam().setText(mc.getFasilitas_cafe());
            main.getTxtDesk().setText(mc.getDeskripsi());
            main.getTxtEmail().setText(mc.getEmail());
            main.getTxtsandi().setText(mc.getSandi());
            main.getTxtsandi().setEchoChar('\u25cf');

            main.getTxtNamaCafe().setEditable(false);
            main.getTxtNama().setEditable(false);
            main.getTxtAlamat().setEditable(false);
            main.getTxtjam().setEditable(false);
            main.getTxtDesk().setEditable(false);
            main.getTxtEmail().setEditable(false);
            main.getTxtsandi().setEditable(false);
            
            //Tampilkan data Review Cafe
             String namacafe = main.getTxtNamaCafe().getText();
             List<Mod_review> lmr = implRev.getAll(namacafe);
             main.getTableReview().setModel(new Mod_tabel_review(lmr));

        } else {
            // Tampilkan pesan error jika data cafe tidak ditemukan
            JOptionPane.showMessageDialog(null, "Data cafe tidak ditemukan.");
        }
    }

    public void isiTabel() {
        //semua isi data yang semua diambil dari DAO dan ditampung di lmb
        String namacafe = main.getTxtNama().getText();
        lmr = implRev.getAll(namacafe);

        //data dimasukkan ke tabel barang
        Mod_tabel_review mtb = new Mod_tabel_review(lmr);
        main.getTableReview().setModel(mtb);
    }
//    public void isiTableReview() {
//        String namacafe = main.getTxtNama().getText();
//        List<Mod_review> lmr = implRev.getAll(namacafe);
//        main.getTableReview().setModel(new Mod_tabel_review(lmr));
//    }


    public void inserttabel() {
        //fungsi trim() berfungsi untuk memotong karakter-karakter spasi pada 
        //bagian awal dan akhir sehingga fungsi ini 
        //sangat cocok untuk diterapkan pada proses input data-data
        
        
            Mod_cafe mb = new Mod_cafe();
            mb.setNama_cafe(main.getTxtNama().getText());
            mb.setEmail(main.getTxtEmail().getText());
            mb.setSandi(main.getTxtsandi().getText());
            mb.setAlamat_cafe(main.getTxtAlamat().getText());
            mb.setFasilitas_cafe(main.getTxtjam().getText());
            mb.setDeskripsi(main.getTxtDesk().getText());
            
            //knp dia double karena struktur data di table atribut Harga adalah double
            //dan kita mau memasukkan data dari frame yg string ke table atribut Harga yg double

            
            //knp dia Interger karena struktur data di table Stok adalah Integer
            //dan kita mau memasukkan data dari frame yg string ke table Stok yg Inteer

            implCafe.insert(mb);
            JOptionPane.showMessageDialog(null, "data disimpan");

        
    }

//    public void Delete() {
//        if (!main.getTxtNama().getText().trim().isEmpty()) {
//            //jika data pada frame textfield  no tidak kosong maka
//
//            int no = Integer.parseInt(main.getTxtNama().getText());
//            //ambil data dari frame textfield simpan ke var no
//            implCafe.delete(no);
//
//            JOptionPane.showMessageDialog(null, "data terdelete");
//        } else {
//            JOptionPane.showMessageDialog(null, "data gagal didelete");
//
//        }
//
//    }

    public void Update() {
        if (!main.getTxtNamaCafe().getText().trim().isEmpty()) {
            //jika data pada frame textfield  no tidak kosong maka
            Mod_cafe mb = new Mod_cafe();
            mb.setNama_cafe(main.getTxtNama().getText());
            mb.setAlamat_cafe(main.getTxtAlamat().getText());
            mb.setFasilitas_cafe(main.getTxtjam().getText());
            mb.setDeskripsi(main.getTxtDesk().getText());
            mb.setSandi(main.getTxtsandi().getText());                   

            implCafe.update(mb);
            
            JOptionPane.showMessageDialog(null, "data diperbaharui");
        } else {
            JOptionPane.showMessageDialog(null, "data gagal diperbaharui");

        }
    }



}
