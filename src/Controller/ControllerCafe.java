/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOCafe.DAOCafe;
import Model.*;
import Model.Model_list_Cafe;
import View.*;
import java.util.List;
import javax.swing.JOptionPane;
import DAOCafe.ImplementCafe;
import javax.swing.ListModel;
import javax.swing.table.TableModel;

/**
 *
 * @author S510
 */
public class ControllerCafe {
    Login log;
    Regis reg;
    Review main;
    Mainpage MaPa;
    MitraPage mitra;
    ImplementCafe implCafe;
    List<Mod_cafe> lmb;
    List<Mod_Rating> lmr;

    public ControllerCafe(Review main) {
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
        Model_list_Cafe mtb = new Model_list_Cafe(lmb);
        
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

//    public void isitable_cari_nama() {
//        lmb = implCafe.getCarinama(main.get);
//        Model_list_Cafe mtb = new Model_list_Cafe(lmb);
//        main.getTableReview().setModel((TableModel) mtb);
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
//            implCafe.getCarinama(main.getTxtSearch().getText());
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
