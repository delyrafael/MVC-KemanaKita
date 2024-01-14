/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOCafe;

import Model.Mod_review;
import java.util.List;

/**
 *
 * @author S510
 */
public interface ImplementReview {

    public void insert(Mod_review mb);

    public void delete(int id_cafe);
    public void update(Mod_review mb);
    

    public List<Mod_review> getAll(String nama);//dapatkan semua data

    public List<Mod_review> getCarinama(String nama);//mendapatkan data nama
    
    

}
