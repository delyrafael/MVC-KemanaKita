/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOCafe.*;
import Model.*;
import View.*;
import java.util.List;
import javax.swing.JOptionPane;
import DAOCafe.*;
import javax.swing.ListModel;
import javax.swing.table.TableModel;

/**
 *
 * @author S510
 */
public class ControllerRate {
    Login log;
    Regis reg;
    ListCafe main;
    ImplementRating implRat;
    List<Mod_Rating> lmb;

    public ControllerRate(ListCafe main) {
        this.main = main;
        //this.implBarang = implBarang;
        implRat = new DAORating();
        // this.lmb = lmb;
        lmb = implRat.getAll();
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
        lmb = implRat.getAll();

        //data dimasukkan ke tabel barang
        Mod_table_rating mtb = new Mod_table_rating(lmb);
        
    }
       
    public void isitextfield(int row) {
        main.getTxtRatinig().setText(String.valueOf(lmb.get(row).getRate()));
    }
//    public void isitextfield(int row) {
//        reg.getTxtUsername().setText(String.valueOf(lmb.get(row).getNama_cafe()));
//        reg.getTxtEmail().setText(lmb.get(row).getEmail());
//        reg.getTxtsandi().setText(String.valueOf(lmb.get(row).getSandi()));
//    }

//    public void inserttabel() {
//        //fungsi trim() berfungsi untuk memotong karakter-karakter spasi pada 
//        //bagian awal dan akhir sehingga fungsi ini 
//        //sangat cocok untuk diterapkan pada proses input data-data
//        if (!main.getTxtNama().getText().trim().isEmpty() & !mitra.getTxtNama().getText().trim().isEmpty()) {
//            Mod_Rating mb = new Mod_Rating();
//            mb.setNama_cafe(mitra.getTxtNama().getText());
//            mb.setEmail(mitra.getTxtEmail().getText());
//            mb.setSandi(mitra.getTxtsandi().getText());
//            mb.setAlamat_cafe(mitra.getTxtAlamat().getText());
//            mb.setFasilitas_cafe(mitra.getTxtjam().getText());
//            mb.setDeskripsi(mitra.getTxtDesk().getText());
//            
//            //knp dia double karena struktur data di table atribut Harga adalah double
//            //dan kita mau memasukkan data dari frame yg string ke table atribut Harga yg double
//
//            
//            //knp dia Interger karena struktur data di table Stok adalah Integer
//            //dan kita mau memasukkan data dari frame yg string ke table Stok yg Inteer
//
//            implRat.insert(mb);
//            JOptionPane.showMessageDialog(null, "data disimpan");
//
//        } else {
//            JOptionPane.showMessageDialog(null, "data gagal disimpan");
//
//        }
//    }

//    public void Delete() {
//        if (!mitra.getTxtNama().getText().trim().isEmpty()) {
//            //jika data pada frame textfield  no tidak kosong maka
//
//            int no = Integer.parseInt(mitra.getTxtNama().getText());
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
//
//    public void Update() {
//        if (!mitra.getTxtNama().getText().trim().isEmpty()) {
//            //jika data pada frame textfield  no tidak kosong maka
//            Mod_cafe mb = new Mod_cafe();
//            mb.setNama_cafe(mitra.getTxtNama().getText());
//            mb.setAlamat_cafe(mitra.getTxtAlamat().getText());
//            mb.setFasilitas_cafe(mitra.getTxtjam().getText());
//            mb.setDeskripsi(mitra.getTxtDesk().getText());
//            mb.setEmail(mitra.getTxtEmail().getText());
//            mb.setSandi(mitra.getTxtsandi().getText());                   
//
//            implCafe.update(mb);
//            
//            JOptionPane.showMessageDialog(null, "data diperbaharui");
//        } else {
//            JOptionPane.showMessageDialog(null, "data gagal diperbaharui");
//
//        }
//
//    }
//
//    public void isitable_cari_nama() {
//        lmb = implCafe.getCarinama(main.getTxtSearch().getText());
//        Mod_tabel_cafe mtb = new Mod_tabel_cafe(lmb);
//        main.getTableCafe().setModel(mtb);
//        /*
//       public void setModel(TableModel dataModel)
//        Sets the data model for this table to newModel and 
//        registers with it for listener notifications from the new data model.
//        Parameters:
//        dataModel - the new data source for this table
//         */
//
//
//
//    }



}
