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
public class Mod_table_rating extends AbstractTableModel{
    List <Mod_Rating> lmb;

    public Mod_table_rating(List<Mod_Rating> lmb) {
        this.lmb = lmb;
    }
    
    @Override
    public int getRowCount() {
        return lmb.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lmb.get(rowIndex).getId_rate();
            case 1:
                return lmb.get(rowIndex).getId_cafe();
            case 2:
                return lmb.get(rowIndex).getRate();
            default:
                return null;
        }
    }
        @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "id_rate";
            case 1:
                return "id_user";//sesuaikan dengan atribut di table database
            case 2:
                return "rate";       
            default:
                return null;
        }
        
        
    }
        //return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
}   

