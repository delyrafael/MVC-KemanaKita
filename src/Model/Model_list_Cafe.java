/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Dely
 */
public class Model_list_Cafe extends AbstractListModel{
    List <Mod_cafe> lmb;
    
    public Model_list_Cafe(List<Mod_cafe> lmb) {
        this.lmb = lmb;
    }
    
    @Override
    public int getSize() {
        return lmb.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lmb.get(index);
    }
    
}
