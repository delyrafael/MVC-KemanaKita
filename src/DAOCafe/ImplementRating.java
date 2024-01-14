/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOCafe;

import Model.Mod_Rating;
import java.util.List;

/**
 *
 * @author S510
 */
public interface ImplementRating {

    public void insert(Mod_Rating mb);
    public void average(int id_cafe);
    public void delete(int id_cafe);
    public void update(Mod_Rating mb);

    public List<Mod_Rating> getAll();//dapatkan semua data

    public List<Mod_Rating> getCarinama(int id_cafe);//mendapatkan data nama
    
    

}
