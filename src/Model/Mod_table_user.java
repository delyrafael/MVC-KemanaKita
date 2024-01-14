/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dely
 */
public class Mod_table_user extends AbstractTableModel{
    List <Mod_user> lmb;

    public Mod_table_user(List<Mod_user> lmb) {
        this.lmb = lmb;
    }
    
    @Override
    public int getRowCount() {
        return lmb.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lmb.get(rowIndex).getId_user();
            case 1:
                return lmb.get(rowIndex).getNama_user();
            case 2:
                return lmb.get(rowIndex).getEmail_user();
            case 3:
                return lmb.get(rowIndex).getPassword_user();   
            default:
                return null;
        }
    }
        @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "id_user";//sesuaikan dengan atribut di table database
            case 1:
                return "nama_user";//sesuaikan dengan atribut di table database
            case 2:
                return "email_user";//sesuaikan dengan atribut di table database
            case 3:
                return "password_user";//sesuaikan dengan atribut di table database          
            default:
                return null;
        }
        
        
    }
        //return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
}   

