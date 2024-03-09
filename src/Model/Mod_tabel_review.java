/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import static java.util.Collections.list;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author S510
 */

public class Mod_tabel_review extends AbstractTableModel{
    List<Mod_review> lmb;
    List<String> myColumnNames;

    public Mod_tabel_review(List<Mod_review> lmb) {
        this.lmb = lmb;

        // Inisialisasi objek myColumnNames
        myColumnNames = new ArrayList<>();

        // Tambahkan kolom nama_user
        myColumnNames.add("nama_user");
    }
    
    @Override
    public int getRowCount() {
        return lmb.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return lmb.get(row).getNamacafe();
            case 1:
                return lmb.get(row).getReview();
            case 2:
                return lmb.get(row).getNama_user(); // Tambahkan baris ini
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "nama_user";//sesuaikan dengan atribut di table database
            case 1:
                return "review";//sesuaikan dengan atribut di table database    
            default:
                return null;
        }
        
        
        }
        //return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    

