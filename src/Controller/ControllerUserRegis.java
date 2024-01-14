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
import javax.swing.ListModel;
import javax.swing.table.TableModel;

/**
 *
 * @author S510
 */
public class ControllerUserRegis {
    Login log;
    Regis reg;
    ListCafe frame;
    MainpageAnon main;
    Mainpage MaPa;
    ImplementUser implUser;
    List<Mod_user> lmb;

    public ControllerUserRegis(Regis reg) {
        this.reg = reg;
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
        reg.getTxtUsername().setText("Username");
        reg.getTxtEmail().setText("Email");
        reg.getTxtsandi().setText("Sandi");
        reg.getTxtkonfirmasi().setText("Konfirmasi");
        
    }

    public void registrasi() {
        //semua isi data yang semua diambil dari DAO dan ditampung di lmb
        lmb = implUser.getAll();

        //data dimasukkan ke tabel barang
        Mod_table_user mtb = new Mod_table_user(lmb);
        
    }

    public void isitextfield(int row) {
        
        reg.getTxtUsername().setText(String.valueOf(lmb.get(row).getNama_user()));
        reg.getTxtEmail().setText(lmb.get(row).getEmail_user());
        reg.getTxtsandi().setText(String.valueOf(lmb.get(row).getPassword_user()));
    }

    public void inserttabel() {
        //fungsi trim() berfungsi untuk memotong karakter-karakter spasi pada 
        //bagian awal dan akhir sehingga fungsi ini 
        //sangat cocok untuk diterapkan pada proses input data-data
        if (!reg.getTxtUsername().getText().trim().isEmpty() & !reg.getTxtUsername().getText().trim().isEmpty()) {
            Mod_user mb = new Mod_user();
            mb.setNama_user(reg.getTxtUsername().getText());
            mb.setEmail_user(reg.getTxtEmail().getText());
            mb.setPassword_user(reg.getTxtsandi().getText());
            
            
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
        if (!reg.getTxtUsername().getText().trim().isEmpty()) {
            //jika data pada frame textfield  no tidak kosong maka

            int no = Integer.parseInt(reg.getTxtUsername().getText());
            //ambil data dari frame textfield simpan ke var no
            implUser.delete(no);

            JOptionPane.showMessageDialog(null, "data terdelete");
        } else {
            JOptionPane.showMessageDialog(null, "data gagal didelete");

        }

    }

    public void Update() {
        if (!reg.getTxtUsername().getText().trim().isEmpty()) {
            //jika data pada frame textfield  no tidak kosong maka
            Mod_user mb = new Mod_user();
            mb.setNama_user(reg.getTxtUsername().getText());
            mb.setEmail_user(reg.getTxtEmail().getText());
            mb.setPassword_user(reg.getTxtsandi().getText());                   

            implUser.update(mb);
            
            JOptionPane.showMessageDialog(null, "data diperbaharui");
        } else {
            JOptionPane.showMessageDialog(null, "data gagal diperbaharui");

        }

    }

    public void isitable_cari_nama() {
        lmb = implUser.getCarinama(main.getTxtSearch().getText());
        Mod_table_user mtb = new Mod_table_user(lmb);
        main.getTableRec().setModel(mtb);
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
            implUser.getCarinama(main.getTxtSearch().getText());
            isitable_cari_nama();
            
        }else{
        
             JOptionPane.showMessageDialog(null, "data tidak ditemukan");
        
        }

    }
    public void getUserById(){
        lmb = implUser.getCarinama(main.getTxtSearch().getText());
        Mod_table_user mtb = new Mod_table_user(lmb);
    }
}
