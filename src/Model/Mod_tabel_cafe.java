/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import static java.util.Collections.list;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author S510
 */

public class Mod_tabel_cafe extends AbstractTableModel{
    List <Mod_cafe> lmb;

    public Mod_tabel_cafe(List<Mod_cafe> lmb) {
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
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return lmb.get(row).getNama_cafe();
            case 1:
                return lmb.get(row).getAlamat_cafe();
            case 2:
                return lmb.get(row).getFasilitas_cafe();  
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "nama cafe";//sesuaikan dengan atribut di table database
            case 1:
                return "alamat cafe";//sesuaikan dengan atribut di table database
            case 2:
                return "fasilitas cafe";//sesuaikan dengan atribut di table database          
            default:
                return null;
        }
        
        
        }
        //return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    

