/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAOCafe.DAOCafe;
import View.*;
import java.util.List;
import javax.swing.JOptionPane;
import DAOCafe.ImplementCafe;
import Model.Mod_cafe;
import javax.swing.ListModel;
import javax.swing.table.TableModel;
import Model.Mod_tabel_cafe;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author S510
 */
public class ControllerMitraRegis {
    Login log;
    RegisMitra reg;
    ListCafe frame;
    MainpageAnon main;
    Mainpage MaPa;
    ImplementCafe implCafe;
    List<Mod_cafe> lmb;

    public ControllerMitraRegis(RegisMitra reg) {
        this.reg = reg;
        //this.implUser = implUser;
        implCafe = new DAOCafe();
        // this.lmb = lmb;
        lmb = implCafe.getAll();
       
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
        try{
        if("Username".equals(reg.getTxtUsername().getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Full Name is require", "Error",
                JOptionPane.ERROR_MESSAGE);
        }else if("Alamat Email".equals(reg.getTxtEmail().getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Email Address is require", "Error",
                JOptionPane.ERROR_MESSAGE);
        }else if("Password".equals(reg.getTxtsandi().getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Password is require", "Error",
                JOptionPane.ERROR_MESSAGE);
        }else if (!reg.getTxtUsername().getText().trim().isEmpty() & !reg.getTxtUsername().getText().trim().isEmpty()) {
            Mod_cafe mb = new Mod_cafe();
            mb.setNama_cafe(reg.getTxtUsername().getText());
            mb.setNama_cafe(reg.getTxtUsername().getText());
            mb.setEmail(reg.getTxtEmail().getText());
            mb.setSandi(reg.getTxtsandi().getText());
            
            
            //knp dia double karena struktur data di table atribut Harga adalah double
            //dan kita mau memasukkan data dari frame yg string ke table atribut Harga yg double

            
            //knp dia Interger karena struktur data di table Stok adalah Integer
            //dan kita mau memasukkan data dari frame yg string ke table Stok yg Inteer

            implCafe.insert(mb);
            JOptionPane.showMessageDialog(null, "data disimpan");
            reg.dispose();
            new MitraPage().setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");

        }
        }catch(Exception e){
             System.out.println("Error!" + e.getMessage()); 
      }
    }

//    public void Delete() {
//        if (!reg.getTxtUsername().getText().trim().isEmpty()) {
//            //jika data pada frame textfield  no tidak kosong maka
//
//            int no = Integer.parseInt(reg.getTxtUsername().getText());
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
        if (!reg.getTxtUsername().getText().trim().isEmpty()) {
            //jika data pada frame textfield  no tidak kosong maka
            Mod_cafe mb = new Mod_cafe();
            mb.setNama_cafe(reg.getTxtUsername().getText());
            mb.setEmail(reg.getTxtEmail().getText());
            mb.setSandi(reg.getTxtsandi().getText());                   

            implCafe.update(mb);
            
            JOptionPane.showMessageDialog(null, "data diperbaharui");
        } else {
            JOptionPane.showMessageDialog(null, "data gagal diperbaharui");

        }

    }

    public void isitable_cari_nama() {
        lmb = implCafe.getCarinama(main.getTxtSearch().getText());
        Mod_tabel_cafe mtb = new Mod_tabel_cafe(lmb);
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
            implCafe.getCarinama(main.getTxtSearch().getText());
            isitable_cari_nama();
            
        }else{
        
             JOptionPane.showMessageDialog(null, "data tidak ditemukan");
        
        }

    }
    public void getUserById(){
        lmb = implCafe.getCarinama(main.getTxtSearch().getText());
        Mod_tabel_cafe mtb = new Mod_tabel_cafe(lmb);
    }
}
